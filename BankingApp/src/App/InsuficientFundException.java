package App;

public class InsuficientFundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public double fund;
	
	InsuficientFundException(double withdrawMoney){
		fund = withdrawMoney;
	}
	
	public String toString() {
		return "Insuficient Fund("+fund+")try again";
	}

}
