package App;

public class UserService {
	
	public void payFromWallate(double fromWallate, double wallateAmount) throws Exception {
		if(wallateAmount<fromWallate) {
				throw new InsuficientFundException(fromWallate);
		}
		wallateAmount -= fromWallate;
		System.out.println("current amount in wallete: "+wallateAmount);
	}
	public void payToWallate(double towallate, double wallateAmount, double amount) throws InsuficientFundException {
		if(amount<towallate) {
			throw new InsuficientFundException(towallate);
	}
		wallateAmount += towallate;
		System.out.println("current amount in wallete: "+wallateAmount);
	}
	
	public void takeCredit(double wallateAmount, double loanFromWallate, int noOfCredit) throws InsuficientFundException {
		if(wallateAmount*50/100 >= loanFromWallate && noOfCredit == 0) {
			wallateAmount += loanFromWallate;
			System.out.println("current amount in wallete: "+wallateAmount);
		}
		else {
			System.out.println("something wrong, either your amount out of limit("+wallateAmount*50/100+") as credit or you are already in credit");
			throw new InsuficientFundException(loanFromWallate);
		}
		
	}
	public void payCredit(double paycredit, double creditAmount, double amount) throws InsuficientFundException {
			if(paycredit>amount) {
				throw new InsuficientFundException(paycredit);
			}
			creditAmount -= paycredit;
			System.out.println("Remaining balance to pay: "+creditAmount);
	}
	
	
	public void wallateCheck(double wallateAmount, double creditAmount) {
		if(creditAmount>0) {
			System.out.println("current amount in App Wallete: "+wallateAmount);
			System.out.println(" ***You credit balance "+creditAmount+"has to pay ***");
		}
		else {
			System.out.println("current amount in App Wallete: "+wallateAmount);
		}
		
	}

}
