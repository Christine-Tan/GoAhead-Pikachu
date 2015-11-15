package gap.common.util;

public class PeopleInfo {
	private String name, address, depart, cellphone;

	public PeopleInfo(String name, String address, String depart,
			String cellphone) {
		super();
		this.name = name;
		this.address = address;
		this.depart = depart;
		this.cellphone = cellphone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}
