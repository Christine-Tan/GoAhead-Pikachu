package gap.common.po;

public class TradePO {
	private String accountName;
	private int tradeNum = 0;

	public TradePO(String accountName, int tradeNum) {
		this.setAccountName(accountName);
		this.setTradeNum(tradeNum);
	}

	public int getTradeNum() {
		return tradeNum;
	}

	public void setTradeNum(int tradeNum) {
		this.tradeNum = tradeNum;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
