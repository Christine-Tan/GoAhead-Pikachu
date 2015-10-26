package stub_drivers.blservice.log;

import client.blservice.logblservice.LogService;

public class Log_driver {

	public void drive(LogService stub){
		stub.getLog();
		System.out.println("get log list");
		
	}
	
	public static void main(String[] args) {
		new Log_driver().drive(new Log_stub());
	}
	
}
