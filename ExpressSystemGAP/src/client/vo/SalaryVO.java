package client.vo;

import util.UserType;

public class SalaryVO {
	    // 薪水类型 
		UserType type;
		// 薪水值
		double salary;

		public SalaryVO() {

		}

		public SalaryVO(UserType type, double salary) {
			this.type = type;
			this.salary = salary;
		}

		/**
		 * @return type
		 */
		public UserType getType() {
			return type;
		}

		/**
		 * @param type 要设置的 type
		 */
		public void setType(UserType type) {
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
