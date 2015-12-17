package gap.client.ui.BaseComponents;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigateButton extends GAPButton {
	MainFrame mainFrame;
	MainPanel mainPanel;
	NavigateBar bar;
	String name;
	boolean isSelect;

	public NavigateButton(MainFrame mainFrame, MainPanel mainPanel,
			NavigateBar bar, String name) {
		super();
		setText(name);
		setFont(ComponentStyle.plainFont);
		this.mainFrame = mainFrame;
		this.mainPanel = mainPanel;
		this.bar = bar;
		this.name = name;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (!isSelect)
					NavigateButton.this.bar.setSelect(NavigateButton.this);
			}
		});
	}

	/**
	 * 设置被选择
	 */
	void select() {
		isSelect = true;
		mainFrame.load(new Runnable() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				setDefautBackGroundColor(ColorAndFonts.blue);
				setDefautFontColor(Color.white);
				setEnterFontColor(Color.white);
				setPressFontColor(Color.white);
				setBackground(ColorAndFonts.blue);
				setForeground(Color.white);
				repaint();
				mainPanel.refresh();
				mainFrame.setMainPanel(mainPanel);
				mainFrame.repaint();
			}
		});

	}

	/**
	 * 设置未被选择
	 */
	void deSelect() {
		isSelect = false;
		setDefautBackGroundColor(Color.white);
		setDefautFontColor(Color.BLACK);
		setEnterFontColor(ColorAndFonts.blue.darker());
		setPressFontColor(ColorAndFonts.otherDarkBulue);
		setBackground(Color.white);
		setForeground(Color.BLACK);
		repaint();
		mainFrame.validate();
	}
}
