package App;

public abstract class Bank {
	
	public final double govtAtmCharge = 5.00;
	
	public abstract double calculateInterest(int year);
	public abstract boolean isEligibleForLoan();
	public abstract void balanceCheck();
	
	public double calculateAtmCharge(int year) {
		double ans = govtAtmCharge*year;
		return ans;
	}

}
