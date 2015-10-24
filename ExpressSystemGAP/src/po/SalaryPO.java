package po;

import java.io.Serializable;

public class SalaryPO implements Serializable {
     String type;
	double salary;
	public SalaryPO (String type, double salary){
        	   this. type=type;
        	   this.salary=salary;
          }
    /**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type 要设置的 type
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
	 * @param salary 要设置的 salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
