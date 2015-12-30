package gap.client.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于导出Excel表格的辅助类
 * @author YangYanfei
 *
 */
public class ExcelOutput {
	// xls的默认字符集
	private String charSet = "gb2312";

	private String numberRegex = "\\d+";

	// 表头
	String[] titles;

	List<String[]> datas;
	// 列数
	int column;

	/**
	 *
	 * @param titles 表头
	 * @throws UnsupportedEncodingException
	 */
	public ExcelOutput(String... titles) throws UnsupportedEncodingException {
		this.titles = titles;
		column = titles.length;
		datas = new ArrayList<>();

	}

	/**
	 * 返回字符集
	 * @return
	 */
	public String getCharSet() {
		return charSet;
	}

	/**
	 * 设置字符集
	 * @param charSet
	 */
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}

	/**
	 *添加一列
	 * @param items 一列的数据
	 * @throws Exception
	 */
	public void appendRow(Object... items) throws Exception {
		if (items.length != column)
			throw new Exception("所传数据小于列数");
		String[] row = new String[items.length];
		for (int i = 0; i < row.length; i++) {
			row[i] = items[i].toString();
			if (row[i].matches(numberRegex))
				row[i] = "'" + row[i];
		}
		datas.add(row);
	}

	/**
	 * 导出表格
	 * @param filePath 路径名
	 * @param fileName 文件名
	 * @throws UnsupportedEncodingException
	 */
	public void export(String filePath, String fileName) {
		try {
			// 换行符
			byte[] newLine = "\n".getBytes(charSet);
			// 制表符
			byte[] tableChar = "\t".getBytes(charSet);

			FileOutputStream fileout = new FileOutputStream(new File(filePath
					+ "\\" + fileName));
			for (String str : titles) {
				fileout.write(str.getBytes(charSet));
				fileout.write(tableChar);
			}
			fileout.write(newLine);

			for (String[] row : datas) {
				for (String item : row) {
					fileout.write(item.getBytes(charSet));
					fileout.write(tableChar);
				}
				fileout.write(newLine);
			}
			fileout.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			ExcelOutput excel = new ExcelOutput("表头1", "表头2", "表头3");
			excel.appendRow("0000000001", 2, "test1");
			excel.appendRow("txy", 5, "test2");
			excel.export("D:\\", "test1.xlsx");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
