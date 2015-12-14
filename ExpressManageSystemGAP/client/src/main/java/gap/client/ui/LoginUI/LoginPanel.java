package gap.client.ui.LoginUI;

import gap.client.blcontroller.LoginController;
import gap.client.datacontroller.NetModule;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.WhiteExitButton;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.deliveryui.expressorderinput.ExpressorderInputPanel;
import gap.client.util.LocalInfo;
import gap.client.util.User;
import gap.client.vo.LogVO;
import gap.common.util.Gender;
import gap.common.util.UserType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	private JTextField userName = new LoginTextField("people");
	private LoginButton signInButton = new LoginButton("signIn");
	private JPasswordField passwordField;
	// private LoginButton goBackButton = new LoginButton("goBack");
	private WhiteExitButton exitButton = new WhiteExitButton();
	private LoginAnimation animation;
	private LogoPanel logoPanel;
	private LoginFrame frame;
	// 渐变
	LinearGradientPaint paint;

	Image background = new ImageIcon("images/login/loginForm.png").getImage();

	public LoginPanel(LoginFrame frame) {
		setLayout(null);
		setBounds(0, 0, 430, 330);
		this.frame = frame;
		animation = new LoginAnimation(frame);
		logoPanel = new LogoPanel(frame);

		passwordField = new LoginPassword(signInButton,this);
		
		JLayeredPane layer = new JLayeredPane();
		layer.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(layer);
		layer.add(userName);
		layer.add(passwordField);
		layer.add(animation, Integer.valueOf(10));
		animation.startAnimation();

		layer.add(logoPanel, Integer.valueOf(15));
		logoPanel.startAnimation();

		signInButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				LocalInfo.ins_id = "0010001";
				User user = new User("000000005", UserType.DELIVERY,
						"xiaoming", "123456", "0010001", "小明", Gender.MALE);
				LocalInfo.localuser = user;
				MainFrame mainFrame = new MainFrame();
				NetModule.connect();
				String username_text = userName.getText();
				String password_text = new String(passwordField.getPassword());
				LogVO log = LoginController.login(username_text, password_text);
				if (log.isSucceed()) {
					ExpressorderInputPanel panel = new ExpressorderInputPanel(
							mainFrame);
					mainFrame.setMainPanel(panel);
				}
			}
		});

		int signInX = getWidth() / 2 - 200 / 2;
		signInButton.setBounds(signInX, 280, 200, 35);
		// goBackButton.setBounds(20, 225, 100, 40);
		exitButton.setBounds(400, 15, 15, 15);

		layer.add(signInButton);
		layer.add(exitButton, new Integer(20));

	}

	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = RenderSetter.OpenRender(g);

		g2d.setColor(ColorAndFonts.darkBlue);
		g2d.fillRect(0, 0, this.getWidth(), 60);
		g2d.setColor(Color.white);
		g2d.setFont(ColorAndFonts.Chinese);
		g2d.drawString("GAP 快�?�物流系�?", 20, 40);

	}

	public void closeEye() {
		// TODO Auto-generated method stub
		logoPanel.closeEye();
	}

	public void openEye() {
		// TODO Auto-generated method stub
		logoPanel.openEye();
	}


}
