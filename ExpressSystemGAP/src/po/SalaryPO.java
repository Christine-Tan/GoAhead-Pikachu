package po;

import java.io.Serializable;

public class SalaryPO implements Serializable {
	// 薪水类型
	String type;
	// 薪水值
	double salary;

	public SalaryPO() {

	}

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
