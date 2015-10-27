package gap.common.po;

public class InitialPO {

	private InstitutionPO institutionPO;
	private UserPO userPO;
	private CarPO carPO;
	private InventoryPO inventoryPO;
	private AccountPO accountPO;

	public InitialPO(InstitutionPO institutionPO, UserPO userPO, CarPO carPO,
			InventoryPO inventoryPO, AccountPO accountPO) {
		this.setInstitutionPO(institutionPO);
		this.setUserPO(userPO);
		this.setCarPO(carPO);
		this.setInventoryPO(inventoryPO);
		this.setAccountPO(accountPO);

	}

	public UserPO getUserPO() {
		return userPO;
	}

	public void setUserPO(UserPO userPO) {
		this.userPO = userPO;
	}

	public InstitutionPO getInstitutionPO() {
		return institutionPO;
	}

	public void setInstitutionPO(InstitutionPO institutionPO) {
		this.institutionPO = institutionPO;
	}

	public CarPO getCarPO() {
		return carPO;
	}

	public void setCarPO(CarPO carPO) {
		this.carPO = carPO;
	}

	public AccountPO getAccountPO() {
		return accountPO;
	}

	public void setAccountPO(AccountPO accountPO) {
		this.accountPO = accountPO;
	}

	public InventoryPO getInventoryPO() {
		return inventoryPO;
	}

	public void setInventoryPO(InventoryPO inventoryPO) {
		this.inventoryPO = inventoryPO;
	}

}
