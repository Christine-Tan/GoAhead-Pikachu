package gap.common.po;

import java.util.Date;

public class RentPO {

	private int money;
	private Date lastPaidDate;
    private String institution;
   
	public RentPO(int money, Date lastPaidDate,String institution) {
		this.setMoney(money);
		this.setLastPaidDate(lastPaidDate);
		this.setInstitution(institution);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

		public Date getLastPaidDate() {
			return lastPaidDate;
		}

		public void setLastPaidDate(Date lastPaidDate) {
			this.lastPaidDate = lastPaidDate;
		}

		public String getInstitution() {
			return institution;
		}

		public void setInstitution(String institution) {
			this.institution = institution;
		}

}
