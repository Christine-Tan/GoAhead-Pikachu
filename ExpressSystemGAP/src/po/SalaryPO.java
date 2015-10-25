package po;

import java.io.Serializable;

public class SalaryPO implements Serializable {
	String type;
	double salary;

	public SalaryPO(String type, double salary) {
		this.type = type;
		this.salary = salary;
	}

	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type Ҫ���õ� type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary Ҫ���õ� salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
