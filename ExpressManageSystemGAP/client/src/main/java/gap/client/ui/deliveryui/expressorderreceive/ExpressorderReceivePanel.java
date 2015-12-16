package gap.client.ui.deliveryui.expressorderreceive;

import gap.client.blcontroller.ExpressorderController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.gapcomponents.GAPJScrollPane;
import gap.client.util.MessageType;
import gap.common.util.ReceiveInfo;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ExpressorderReceivePanel extends MainPanel {
	TitlePanel titlePanel;
	ListItemPanel listItemPanel;
	ButtonArea buttonArea;

	public ExpressorderReceivePanel(MainFrame frame) {
		super(frame);
		// TODO 自动生成的构造函数存根
		titlePanel = new TitlePanel();
		listItemPanel = new ListItemPanel(frame);
		buttonArea = new ButtonArea();
		buttonArea.submit.addActionListener(new SubmitListener());

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		JPanel jp = new JPanel();
		jp.setBackground(Color.white);

		SwingConsole
				.addComponent(gb, gcons, this, titlePanel, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, listItemPanel, 0, 1, 1, 1,
				1, 0);
		SwingConsole.addComponent(gb, gcons, this, jp, 0, 2, 1, 1, 1, 1);
		SwingConsole
				.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);

	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		ExpressorderReceivePanel pa = new ExpressorderReceivePanel(null);
		JScrollPane js = new GAPJScrollPane(pa);

		jf.setContentPane(js);
		// jf.getContentPane().add(pa);
		jf.setSize(1024, 768);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class SubmitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					List<ReceiveInfo> infos = listItemPanel.getReceiveInfos();
					if (infos != null && infos.size() != 0)
						for (ReceiveInfo info : infos) {
							ExpressorderController.receiveOrder(info);
						}
					else {
						MainFrame
								.setMessage("请输入收件信息", MessageType.alram, 2000);
					}
				}
			}).start();
		}

	}

}
