package gap.common.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InstitutionPO implements Serializable {

	// 机构编号
	private String insId;
	// 机构名称
	private String insName;
	// 机构所在城市
	private String insCity;
	// 机构人员数目
	private int insMember;

	public InstitutionPO(String id, String name, String city, int member) {
		insId = id;

		insName = name;
		insCity = city;
		insMember = member;
	}

	public InstitutionPO() {

	}

	/**
	 * @return insId
	 */
	public String getInsId() {
		return insId;
	}

	/**
	 * @param insId Ҫ���õ� insId
	 */
	public void setInsId(String insId) {
		this.insId = insId;
	}

	/**
	 * @return insName
	 */
	public String getInsName() {
		return insName;
	}

	/**
	 * @param insName Ҫ���õ� insName
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
	 * @param insCity Ҫ���õ� insCity
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
	 * @param insMember Ҫ���õ� insMember
	 */
	public void setInsMember(int insMember) {
		this.insMember = insMember;
	}

	public List<InstitutionPO> getAll() {
		// TODO 自动生成的方法存根
		List<InstitutionPO> insList = new ArrayList<InstitutionPO>();
		return insList;
	}

}
