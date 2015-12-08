package gap.client.ui.managerui.institutionui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gap.client.blcontroller.InstitutionController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.gapcomponents.GAPJScrollPane;
import gap.client.vo.InstitutionVO;

/**
 * 总经理机构管理界面
 * 
 * @author seven
 */
public class InstitutionPanel extends MainPanel {
	String city = null;
	String id = null;
	QueryPanel queryPanel;
	TitlePanel titlePanel;
	ListItemPanel listItemPanel;
	ButtonArea buttonArea;
	final GridBagLayout gb;
	final GridBagConstraints gcons;

	public InstitutionPanel(final MainFrame frame) {
		super(frame);
		titlePanel = new TitlePanel();
		queryPanel = new QueryPanel();
		// 城市搜索按钮添加监听
		QueryPanel.searchCity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				city = QueryPanel.city_list.getSelectedItem().toString();
				InstitutionPanel.this.remove(listItemPanel);
				listItemPanel = new ListItemPanel(frame, city, id);
				SwingConsole.addComponent(gb, gcons, InstitutionPanel.this, listItemPanel, 0, 2, 1, 1, 1, 0);
				frame.validate();
				city=id=null;
			}

		});

		// ID搜索按钮添加监听
		QueryPanel.searchID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				id = QueryPanel.id.getText();
				InstitutionPanel.this.remove(listItemPanel);
				listItemPanel = new ListItemPanel(frame, city, id);
				SwingConsole.addComponent(gb, gcons, InstitutionPanel.this, listItemPanel, 0, 2, 1, 1, 1, 0);
				frame.validate();
				city=id=null;
			}
		});
		
		listItemPanel = new ListItemPanel(frame, city, id);
		buttonArea = new ButtonArea();
		buttonArea.submit.setText("提交修改");
		// 修改按钮添加监听
		buttonArea.submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				InstitutionController.flush();
			}

		});

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		JPanel jp = new JPanel();
		jp.setOpaque(false);
		SwingConsole.addComponent(gb, gcons, this, queryPanel, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, titlePanel, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, listItemPanel, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, jp, 0, 3, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, buttonArea, 0, 4, 1, 1, 1, 0);

	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		InstitutionPanel ip = new InstitutionPanel(null);
		JScrollPane js = new GAPJScrollPane(ip);

		jf.setContentPane(js);
		jf.setSize(1024, 768);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
