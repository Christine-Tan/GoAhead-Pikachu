package gap.server.data.managedata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import gap.common.dataservice.managedataservice.InstitutionDataService;
import gap.common.po.InstitutionPO;
import gap.server.initial.NetInitial;

public class InstitutionDataServiceImplTest {
	
	@Before
	public void setup() throws  Exception{
			NetInitial.initial();
	}

	@Test
	public void test() throws RemoteException {
		InstitutionDataService institutiondata = new InstitutionDataServiceImpl();
		InstitutionPO po1 = new InstitutionPO("0010002", "南京市栖霞区营业厅", "南京市", 53);
		InstitutionPO po2 = new InstitutionPO("0011001", "南京市栖霞区中转中心", "南京市", 28);
		InstitutionPO po3 = new InstitutionPO("0021002", "上海市静安区中转中心", "上海市", 45);
        System.out.println(institutiondata.add(po1).getMessage());
        System.out.println(institutiondata.add(po2).getMessage());
        System.out.println(institutiondata.add(po3).getMessage());
        InstitutionPO ins=institutiondata.findById("0010002");
        System.out.println(ins.getInsId()+ins.getInsCity()+ins.getInsName()+ins.getInsMember()+ins.getInsType());
        InstitutionPO po4=new InstitutionPO("0010003", "南京市玄武区营业厅", "南京市", 65);
        System.out.println(institutiondata.modify(po3).getMessage());
        System.out.println("GET BY CITY");
        for(InstitutionPO get:institutiondata.findByCity("南京市")){
        	System.out.println(get.getInsId()+get.getInsCity()+ins.getInsName()+get.getInsMember()+get.getInsType());
        }

        System.out.println("GET ALL");
        for(InstitutionPO get:institutiondata.getAll()){
        	System.out.println(get.getInsId()+get.getInsCity()+ins.getInsName()+get.getInsMember()+get.getInsType());
        }

        System.out.println(institutiondata.delete("0011001").getMessage());
        System.out.println(institutiondata.delete("0010002").getMessage());
	}

}
