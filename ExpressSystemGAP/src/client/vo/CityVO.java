package client.vo;

import java.util.List;

import po.InstitutionPO;

public class CityVO {
	String cityName;
	
	public CityVO(String cityName){
		this.cityName=cityName;
	}
	
	public List<InstitutionPO> getInstitution(){
		InstitutionPO ins= new InstitutionPO();
		return ins.getAll();
	}
}
