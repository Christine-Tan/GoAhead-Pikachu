package gap.client.datacontroller;

import gap.client.ui.gapcomponents.GAPDialog;
import gap.common.dataservice.Contactor;
import gap.common.dataservice.ServiceName;
import gap.common.netconfig.RMIConfig;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;

public class NetModule {

	private static Contactor contactor;
	public static GAPDialog dialog;

	public static void initial(JFrame jf) {
		dialog = new GAPDialog(jf, "错误提示", false);
	}

	static void connect() {
		int connect_time = 0;
		boolean reconnect = false;
		while (true) {
			try {
				if (!reconnect)
					showMessage("连接中");
				contactor = (Contactor) Naming.lookup(RMIConfig.url
						+ ServiceName.CONTACTOR);
				showMessage("连接成功");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO 自动生成的 catch 块
//					e.printStackTrace();
//				}
////				hideMessage();
				new Thread(new CheckRunnable()).start();
				break;
			} catch (MalformedURLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				showMessage("连接错误");
				break;
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				reconnect = true;
				if (connect_time > 10) {
					showMessage("程序已结束");
					break;
				} else {
					showMessage("连接错误!!正在尝试重新连接，重连次数：" + (connect_time++) + "次");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			} catch (NotBoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				showMessage("服务器错误！！！");
				break;
			}
		}
	}

	private static void showMessage(String message) {
		dialog.showMessage(message);
	}

	private static void hideMessage() {
		dialog.setVisible(false);
	}

	static class CheckRunnable implements Runnable {

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			try {
				while (contactor.getInfo())
					Thread.sleep(5000);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				showMessage("网络连接错误！！");
				connect();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setBounds(500, 500, 200, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		initial(jf);
		connect();
	}
}
