package App;

public class HdfcBank extends Bank implements changeable<HdfcBank, IciciBank>{
	public final double HdfcInterestRate = 9;
	public final double HdfcMinimumBalance = 50000.00;
	
	private String name;
	private double amount;
	
	HdfcBank(String name, double amount){
		
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
		double ans = (amount*year*HdfcInterestRate)/100;
		return ans;
	}

	@Override
	public boolean isEligibleForLoan() {
		if(HdfcMinimumBalance < (amount*20)/100) 
			return true;
		else 
			return false;
	}

	@Override
	public IciciBank changeFrom(HdfcBank hdfcbank) {
		IciciBank customer = new IciciBank(hdfcbank.getName(), hdfcbank.getAmount());
		return customer;
	}

	@Override
	public void balanceCheck() {
		System.out.println("current amount in Hdfc Account: "+getAmount());
		
	}

}
