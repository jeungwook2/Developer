package bank;

public class BankVo {
	
	private int accountNo;
	private String accountName;
	private int money;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	@Override
	public String toString() {
		return "BankVo [ " + accountNo + ". 계좌명 = " + accountName + ", 자산 = " + money + "원 ]";
	}
	
	public BankVo(String accountName, int money, int accountNo) {
		this.accountName = accountName;
		this.money = money;
		this.accountNo = accountNo;
	} 
	
	
}
