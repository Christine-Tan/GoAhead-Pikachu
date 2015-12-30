package gap.client.ui.UITools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.chart.PieChart.Data;

public class ConvertString {
	public static String getString(Calendar calendar){
		Date date = calendar.getTime();
		return getString(date);
	}
	
	public static String getString(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String result = dateFormat.format(date);
		return result;
	}
	
	public static String getString(double aNum){
		String result = String.format("%.2f", aNum);
		return result;
	}
}