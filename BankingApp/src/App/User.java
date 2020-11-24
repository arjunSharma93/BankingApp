package App;

public class User extends UserService{
	
	private String name;
	private String BankName;
	private double wallateAmount;
	private double creditAmount;
	public int noOfCredit;
	

	User(String name, String BankName){
		this.name = name;
		this.wallateAmount = 0;
		this.BankName = BankName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWallateAmount() {
		return wallateAmount;
	}

	public void setWallateAmount(double wallateAmount) {
		this.wallateAmount = wallateAmount;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}
	
	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}
	
	
}
