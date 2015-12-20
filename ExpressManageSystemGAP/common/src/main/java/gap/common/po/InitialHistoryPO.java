package gap.common.po;

import java.util.Calendar;

public class InitialHistoryPO {
	private Calendar date;
	private int totalBusinessHall;
	private int totalCenter;
	private int totalCourier;
	private int totalBusinessClerk;
	private int totalCenterClerk;
	private int totalStockman;
	private int totalWarehouse;
	private int totalStock;
	private int totalAccount;
	private double totalBalance;
	
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public int getTotalBusinessHall() {
		return totalBusinessHall;
	}
	public void setTotalBusinessHall(int totalBusinessHall) {
		this.totalBusinessHall = totalBusinessHall;
	}
	public int getTotalCenter() {
		return totalCenter;
	}
	public void setTotalCenter(int totalCenter) {
		this.totalCenter = totalCenter;
	}
	public int getTotalCourier() {
		return totalCourier;
	}
	public void setTotalCourier(int totalCourier) {
		this.totalCourier = totalCourier;
	}
	public int getTotalBusinessClerk() {
		return totalBusinessClerk;
	}
	public void setTotalBusinessClerk(int totalBusinessClerk) {
		this.totalBusinessClerk = totalBusinessClerk;
	}
	public int getTotalCenterClerk() {
		return totalCenterClerk;
	}
	public void setTotalCenterClerk(int totalCenterClerk) {
		this.totalCenterClerk = totalCenterClerk;
	}
	public int getTotalStockman() {
		return totalStockman;
	}
	public void setTotalStockman(int totalStockman) {
		this.totalStockman = totalStockman;
	}
	public int getTotalWarehouse() {
		return totalWarehouse;
	}
	public void setTotalWarehouse(int totalWarehouse) {
		this.totalWarehouse = totalWarehouse;
	}
	public int getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}
	public int getTotalAccount() {
		return totalAccount;
	}
	public void setTotalAccount(int totalAccount) {
		this.totalAccount = totalAccount;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	
	public int getTotalPeopleNum(){
		return totalCourier+totalBusinessClerk+totalCenterClerk+totalStockman;
	}
	
	public int getTotalInstitution(){
		return totalBusinessHall+totalCenter;
	}
	
}
