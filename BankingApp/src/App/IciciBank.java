package App;

public class IciciBank extends Bank implements changeable<IciciBank, HdfcBank>{
	public final int IciciInterestRate = 11;
	public final double IciciMinimumBalance = 30000.00;
	
	private String name;
	private double amount;
	
	IciciBank(String name, double amount){
		
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public double calculateInterest(int year) {
		double ans = (amount*year*IciciInterestRate)/100;
		return ans;
	}

	@Override
	public boolean isEligibleForLoan() {
		if(IciciMinimumBalance < (amount*20)/100) 
			return true;
		else 
			return false;
	}

	@Override
	public HdfcBank changeFrom(IciciBank icicibank) {
		HdfcBank customer = new HdfcBank(icicibank.getName(), icicibank.getAmount());
		return customer;
	}

	@Override
	public void balanceCheck() {
		System.out.println("current amount in Icici Account: "+getAmount());
		
	}

}
