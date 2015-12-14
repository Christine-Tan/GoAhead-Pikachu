package gap.client.ui.bussinessui.deliveryorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gap.client.blcontroller.ExpressorderController;
import gap.client.datacontroller.NetModule;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.bussinessui.loadorder.LoadOrderPanel;
import gap.client.util.LocalInfo;
import gap.client.util.User;
import gap.common.util.CurrentOrderType;
import gap.common.util.Gender;
import gap.common.util.UserType;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tester {
	public static void main(String[] args) {
		User user = new User("000000005", UserType.BUSSINESSCLERK, "xiaoming",
				"123456", "0010001", "小红", Gender.FEMALE);
		LocalInfo.localuser = user;
		LocalInfo.ins_id = "0010001";
		MainFrame mainFrame = new MainFrame();
		NetModule.initial(mainFrame);
		NetModule.connect();
		JPanel jp=new JPanel();
		final OrderSelectPanel pa1=new OrderSelectPanel();
		final OrderSelectPanel pa2=new OrderSelectPanel();
		JButton jb1=new JButton("jp1");
		JButton jb2=new JButton("jp2");
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				pa1.transreFresh();
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				pa2.transreFresh();
			}
		});
		jp.add(pa1);
		jp.add(pa2);
		jp.add(jb1);
		jp.add(jb2);
		
		mainFrame.setContentPane(jp);
		mainFrame.validate();
	}
}
