package stub_drivers.dataservice.institution;

import po.InstitutionPO;
import util.ResultMessage;

public class InstitutionDataService_driver {
	public static void main(String[] args) {
		InstitutionDataService_stub stub = new InstitutionDataService_stub();
		InstitutionPO ins1 = new InstitutionPO("0011000", "WestNo1", "Beijing", 50);
		InstitutionPO ins2 = new InstitutionPO("0011001", "EastNo2", "Beijing",50);
		if (stub.add(ins1).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(ins2).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed");
		}
		if (stub.add(ins1).equals(ResultMessage.EXITED)) {
			System.out.println("add failed,institution exited");
		}
		InstitutionPO get = stub.find("0011000");
		if (get != null)
			System.out.println("find:id=" + get.getInsId() + ",name="
					+ get.getInsName() +"city=" + get.getInsCity()+",member="+get.getInsMember());
		get = stub.find("0011002");
		if (get == null)
			System.out.println("find failed,not found");
		ins1.setInsId("0011003");
		if (stub.modify(ins1).equals(ResultMessage.SUCCEED))
			System.out.println("modify succeed");
		if (stub.delete("0011001").equals(ResultMessage.SUCCEED))
			System.out.println("delete succeed");
		if (stub.delete("0011004").equals(ResultMessage.NOTFOUND))
			System.out.println("delete failed,not found");
	}
}
