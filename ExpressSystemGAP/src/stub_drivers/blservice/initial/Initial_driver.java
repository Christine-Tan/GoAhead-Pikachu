package stub_drivers.blservice.initial;

import client.blservice.initialblservice.InitialService;
import client.vo.InitialVO;

public class Initial_driver {

	public void drive(InitialService stub){
		InitialVO vo = stub.getInitialList();
		System.out.println("get initial list");
		
		stub.submitInitialList(vo);
		System.out.println("set initialVO");
		
		stub.getInitialHistory();
		System.out.println("get the History");
		
		
	}
	
	public static void main(String[] args) {
		new Initial_driver().drive(new Initial_stub());
	}
	
}
