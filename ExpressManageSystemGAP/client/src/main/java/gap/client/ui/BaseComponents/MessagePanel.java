package gap.client.ui.BaseComponents;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.util.MessageType;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JPanel;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class MessagePanel extends JPanel {
	private MainFrame mainFrame;
	
	private MessageType type = MessageType.normal;
	String message = "";
	HashMap<MessageType, Color> colorMap;
	float alpha = 0.95f;
	Font font = ColorAndFonts.getChinese(20);
	MessageThread thread;
	
	Object lockObject = new Object();
	
	
	//为了防止并发的变量，enable是false的时候,新来的消息不能播放
	boolean enable = true;

	public MessagePanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setLayout(null);
		setBackground(ColorAndFonts.blue);
		colorMap = new HashMap<>();
		colorMap.put(MessageType.alram, new Color(251, 141, 158));
		colorMap.put(MessageType.normal,ColorAndFonts.blue);
		colorMap.put(MessageType.succeed,Color.green.brighter());
	}
	
	/**
	 * 设置消息，
	 * @param message 消息内容
	 * @param type  消息种类
	 * @param time  消息显示时间
	 */
	public void setMessage(String message,MessageType type,long time){
		if(thread!=null){
			thread.setStop();
		}
		
		
		//保证已经回复正常状态
		synchronized (this) {
			System.out.println("get");
			try {
				while(!enable){
					System.out.println("wait");
					this.wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		thread = new MessageThread(time);
		this.message = message;
		this.type = type;
		thread.start();
		
	}
	

	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = RenderSetter.OpenRender(g.create());
		
		
		AlphaComposite composite = AlphaComposite.getInstance
									(AlphaComposite.SRC_OVER, alpha);
		graphics2d.setComposite(composite);
		graphics2d.setColor(colorMap.get(type));
		graphics2d.fillRect(0, 0, this.getWidth(),this.getHeight());
		
		composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
		graphics2d.setComposite(composite);
		graphics2d.setColor(Color.black);
		graphics2d.setFont(font);
		graphics2d.drawString(message, 5, 23);		
	}
	

	
	private class MessageThread extends Thread{
		private boolean isStop = false;
		private long time = 0;
		private int step = 30;
		public MessageThread(long time){
			this.time = time;
			alpha = 0.15f;
			enable = false;
		}
		
		public void setStop(){
			isStop = true;
		}
		
		public void run() {
			
			synchronized (MessagePanel.this) {
				
			
				for(long currentTime = 0; currentTime<time && !isStop ; currentTime+=step){
				
					repaint();
					mainFrame.validate();
					try {
						Thread.sleep(step);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
	
				type = MessageType.normal;
				message = "";
				for(long currentTime = 0; currentTime<500 && !isStop; currentTime+=step){
					
					repaint();
					mainFrame.validate();
					try {
						Thread.sleep(step);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
					
				}
				
				alpha = 1.0f;
				MessagePanel.this.notifyAll();
				enable = true;
			}
		}
		
	}
	
	
}
