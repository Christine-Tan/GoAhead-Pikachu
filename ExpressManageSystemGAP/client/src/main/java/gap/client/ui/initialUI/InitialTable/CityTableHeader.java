package gap.client.ui.initialUI.InitialTable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import org.junit.validator.PublicClassValidator;

import com.sun.xml.internal.ws.handler.ClientLogicalHandlerTube;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.paymentUI.PanelWithGrid;

public class CityTableHeader extends PanelWithGrid{
	public static final int classIdle = 150;
	public static final int itemIdle = 100;
	public static final int labelWidth = 100;
	
	public static final Color normalColor;
	public static final Color totalColor;

	static{
		normalColor = Color.darkGray;
		totalColor = Color.BLACK;
	}
	
	
	public static int vGap = 50;
	public static int hGap = 50;
	
	public static final int height = 50;
	
	private GAPLabel[] labels;
	private GAPLabel totalLable;
	
	public CityTableHeader(String[] cityNames){
		Font font = ColorAndFonts.getChinese(18);
		
		JLabel leftLabel = new JLabel();
		leftLabel.setPreferredSize(new Dimension(classIdle+itemIdle, height));

		
		JLabel rightLabel = new JLabel(); 
		
		
		SwingConsole.addComponent
		(gridBagLayout, gridBagConstraints, this, leftLabel, 0, 0, 1, 1, 0, 0);
		
		labels = new GAPLabel[cityNames.length+1];
		int i;
		for(i=0;i<cityNames.length;i++){
			String oneName = cityNames[i];
			labels[i] = new GAPLabel(oneName);
			labels[i].setPreferredSize(new Dimension(labelWidth, height));
			labels[i].setFont(font);
			
			labels[i].setHorizontalAlignment(JLabel.CENTER);
			labels[i].setForeground(normalColor);
			
			SwingConsole.addComponent
				(gridBagLayout, gridBagConstraints, this, labels[i], i+1, 0, 1, 1, 0, 0);
			
		}
		
		totalLable = new GAPLabel("总计");
		totalLable.setPreferredSize(new Dimension(labelWidth, height));
		totalLable.setFont(font);
		totalLable.setHorizontalAlignment(JLabel.CENTER);
		totalLable.setForeground(totalColor);
		
		SwingConsole.addComponent
		(gridBagLayout, gridBagConstraints, this, totalLable, i+1, 0, 1, 1, 0, 0);
		
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, rightLabel, i+2, 0, 1, 1, 1, 0);
		
	}
}