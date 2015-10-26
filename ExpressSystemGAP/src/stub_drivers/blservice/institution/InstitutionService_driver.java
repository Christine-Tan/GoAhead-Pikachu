package stub_drivers.blservice.institution;

import client.blservice.manageblservice.InstitutionService;
import client.vo.InstitutionVO;
import stub_drivers.dataservice.institution.InstitutionDataService_driver;
import stub_drivers.dataservice.institution.InstitutionDataService_stub;
import util.ResultMessage;
import dataservice.managedataservice.InstitutionDataService;

public class InstitutionService_driver {
	public void driver(InstitutionService institution) {
		InstitutionVO ins1 = new InstitutionVO("0011000", "WestNo1", "Beijing", 50);
		InstitutionVO ins2 = new InstitutionVO("0011001", "EastNo2", "Beijing",50);
		if (institution.add(ins1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (institution.add(ins2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (institution.add(ins1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,institution exited");
		}
		InstitutionVO get = institution.getSingle("0011000");
		if (get != null)
			System.out.println("find:id=" + get.getInsId() + ",name="
					+ get.getInsName() +"city=" + get.getInsCity()+",member="+get.getInsMember());
		get = institution.getSingle("0011002");
		if (get == null)
			System.out.println("find failed,not found");
		ins1.setInsId("0011003");
		if (institution.modify(ins1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
		if (institution.delete("0011001").equals(ResultMessage.SUCCEED))
			System.out.println("delete succeed");
		if (institution.delete("0011004").equals(ResultMessage.NOTFOUND))
			System.out.println("delete failed,not found");
	}
	
	public static void main(String[] args) {
		InstitutionDataService institutionData = new InstitutionDataService_stub();
		InstitutionDataService_driver driver = new InstitutionDataService_driver();
		driver.driver(institutionData);
	}
}
