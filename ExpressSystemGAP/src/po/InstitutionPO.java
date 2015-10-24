package po;

import java.io.Serializable;

public class InstitutionPO implements Serializable {
    int insId;
    String insType;
    String insName;
    String insCity;
    int insMember;
    
    public InstitutionPO(int id,String type, String name,String city,int member){
    	   insId=id;
    	   insType=type;
    	   insName=name;
    	   insCity=city;
    	   insMember=member;
    }

	/**
	 * @return insId
	 */
	public int getInsId() {
		return insId;
	}

	/**
	 * @param insId 要设置的 insId
	 */
	public void setInsId(int insId) {
		this.insId = insId;
	}

	/**
	 * @return insType
	 */
	public String getInsType() {
		return insType;
	}

	/**
	 * @param insType 要设置的 insType
	 */
	public void setInsType(String insType) {
		this.insType = insType;
	}

	/**
	 * @return insName
	 */
	public String getInsName() {
		return insName;
	}

	/**
	 * @param insName 要设置的 insName
	 */
	public void setInsName(String insName) {
		this.insName = insName;
	}

	/**
	 * @return insCity
	 */
	public String getInsCity() {
		return insCity;
	}

	/**
	 * @param insCity 要设置的 insCity
	 */
	public void setInsCity(String insCity) {
		this.insCity = insCity;
	}

	/**
	 * @return insMember
	 */
	public int getInsMember() {
		return insMember;
	}

	/**
	 * @param insMember 要设置的 insMember
	 */
	public void setInsMember(int insMember) {
		this.insMember = insMember;
	}

}
