package stub_drivers.dataservice.institution;

import dataservice.managedataservice.InstitutionDataService;
import dataservice.strategydataservice.DistanceDataService;
import po.InstitutionPO;
import stub_drivers.dataservice.distancedata.DistanceDataService_driver;
import stub_drivers.dataservice.distancedata.DistanceDataService_stub;
import util.ResultMessage;

public class InstitutionDataService_driver {
	public void driver(InstitutionDataService institutionData) {
		InstitutionPO ins1 = new InstitutionPO("0011000", "WestNo1", "Beijing", 50);
		InstitutionPO ins2 = new InstitutionPO("0011001", "EastNo2", "Beijing",50);
		if (institutionData.add(ins1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (institutionData.add(ins2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (institutionData.add(ins1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,institution exited");
		}
		InstitutionPO get = institutionData.find("0011000");
		if (get != null)
			System.out.println("find:id=" + get.getInsId() + ",name="
					+ get.getInsName() +"city=" + get.getInsCity()+",member="+get.getInsMember());
		get = institutionData.find("0011002");
		if (get == null)
			System.out.println("find failed,not found");
		ins1.setInsId("0011003");
		if (institutionData.modify(ins1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
		if (institutionData.delete("0011001").equals(ResultMessage.SUCCEED))
			System.out.println("delete succeed");
		if (institutionData.delete("0011004").equals(ResultMessage.NOTFOUND))
			System.out.println("delete failed,not found");
	}
	
	public static void main(String[] args) {
		InstitutionDataService institutionData = new InstitutionDataService_stub();
		InstitutionDataService_driver driver = new InstitutionDataService_driver();
		driver.driver(institutionData);
	}
}
