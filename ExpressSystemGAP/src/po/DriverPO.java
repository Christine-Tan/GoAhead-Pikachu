package po;

import java.io.Serializable;
import static po.Gender.*;

public class DriverPO implements Serializable {
	private String id, ins_id, name, birth, identity_number, phone,
			driving_license_due;
	private Gender gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getIdentity_number() {
		return identity_number;
	}

	public void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIns_id() {
		return ins_id;
	}

	public void setIns_id(String ins_id) {
		this.ins_id = ins_id;
	}

	public String getDriving_license_due() {
		return driving_license_due;
	}

	public void setDriving_license_due(String driving_license_due) {
		this.driving_license_due = driving_license_due;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
