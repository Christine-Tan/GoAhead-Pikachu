

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*
 * 小结一下流操作
 * fileReader和writer的mark和reset是不能用的
 * 可以用一个char[]读取文件内容，但是假如直接写回去，会写很多'\0'
 * 这时候要计算一下'\0'的位置，然后写回去。尤其是代码这种不能错的，一个'\0'都不能多写
 * 
 */

public class packageAdder {
	
	ArrayList<String> strings;
	
	public static void main(String[] args) {
		
		new packageAdder().go();
	
	}

	public void go() {
		
		strings = new ArrayList<>(110);
		for (int i = 1; i <= 100; i++) {
			String s = "";
			if (i < 10) {
				s = "0" + i;
			} else {
				s = i + "";
			}
			strings.add("No"+s);
		}
		
		search(new File("src"));
		
	}
	
	void search(File f){
		
		File[] files = f.listFiles(); 
		
		if( strings.contains(f.getName()) ){
			
			
			for(File oneFile:files){
				
				if(oneFile.getName().contains(".java")){
					add(oneFile);
				}
				
			}
			
			return;
		}
		else{
 
			for(File oneFile:files){
				search(oneFile);		
			}
			
			
		}
		
	}
	
	void add(File f){
		
		FileReader fileReader;
 
		char[] buffer = new char[1024*1024];
		try {
			fileReader = new FileReader(f);	
			char[] test = new char[20];
			fileReader.read(test);
			fileReader.close();
			String s = new String(test, 0, 20);
				
			fileReader = new FileReader(f);
			fileReader.read(buffer);
			fileReader.close();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		FileWriter fileWriter;
		String[] strings = f.getParent().split("\\\\");
		//String addedString = "package "+strings[1]+"."+strings[2]+"."+strings[3]+";\n";
		StringBuilder builder = new StringBuilder("package ");
		builder.append(strings[0]);
		for(int i=1;i<strings.length;i++){
			builder.append('.');
			builder.append(strings[i]);
		}
		builder.append(";\n");
		String addedString = builder.toString();

		
		
		try {
			
			int i=0;
			while (buffer[i]!='\0') {
				i++;
			}
			

			fileWriter = new FileWriter(f);
			fileWriter.write(addedString);
			fileWriter.write(buffer, 0, i);
			fileWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
}
