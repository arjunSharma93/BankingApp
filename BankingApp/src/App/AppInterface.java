package App;

import java.util.Scanner;

public class AppInterface {

	public static void main(String[] args) {
		
		String name;
		int bankChoice, serviceChoice, otherServiceChoice, year;
		double amount, toWallate, fromWallate, loanFromWallate, payCredit;
		User user = null;
		IciciBank icicibankCustomer = null;
		HdfcBank hdfcbankCustomer = null;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your name:");
		name = s.nextLine();
		
		System.out.println("Hi, "+name+" Welcome to our portal\n");
		System.out.println("Choose a bank from the list: ");
		
		while(true) {
			try {
				System.out.println(" for HDFC press 1 \n for ICICI press 2 \n for exit press 0");
				bankChoice = s.nextInt();
				if(bankChoice>=0 && bankChoice<3)
					break;
				else {
					System.out.println("Enter correct choice, try again");
				}
			}catch(Exception e) {
				System.out.println("Enter only number associated with banks, try again");
				s.nextLine();
			}
		}

		if (bankChoice == 1) {
			
			while(true) {
				try {
					System.out.println("Enter amount: ");
					amount = s.nextDouble();
					break;
				}catch(Exception e) {
					System.out.println("Enter amount correctly, try again");
					s.nextLine();
				}
			}
			hdfcbankCustomer = new HdfcBank(name, amount);
			user = new User(name, "HdfcBank");
		}
		
		if (bankChoice == 2) {
			
			while(true) {
				try {
					System.out.println("Enter amount: ");
					amount = s.nextDouble();
					break;
				}catch(Exception e) {
					System.out.println("Enter amount correctly, try again");
					s.nextLine();
				}
			}
			icicibankCustomer = new IciciBank(name, amount);
			user = new User(name, "IciciBank");
		}
		
		if (bankChoice == 0) {
			s.close();
			return;
		}
		
		System.out.println(user.getName()+", Wallate created with amount: "+ user.getWallateAmount());
		
		System.out.println(user.getName()+" Choose our service");
		
		while(true) {
			while(true) {
				try {
					System.out.println(" for pay from wallate press 1\n for add money to wallate press 2\n"
							+ " for wallate Check press 3\n for take credit press 4\n for pay credit press 5\n for others press 6\n for exit press 0");
					serviceChoice = s.nextInt();
					if(serviceChoice>=0 && serviceChoice<7) break;
					else System.out.println("enter choice correctly, try again");
				}catch(Exception e) {
					System.out.println("enter the correct number, try again");
					s.nextLine();
				}
			}
			if(serviceChoice == 1) {
				System.out.println("enter amount to pay: ");
				fromWallate = s.nextDouble();
				try {
					if(user.getBankName() == "HdfcBank") {
						user.payFromWallate(fromWallate, user.getWallateAmount());
						hdfcbankCustomer.setAmount(hdfcbankCustomer.getAmount() + fromWallate);
						user.setWallateAmount(user.getWallateAmount() - fromWallate);
					}
					else if(user.getBankName() == "IciciBank") {
						user.payFromWallate(fromWallate, user.getWallateAmount());
						icicibankCustomer.setAmount(icicibankCustomer.getAmount() + fromWallate);
						user.setWallateAmount(user.getWallateAmount() - fromWallate);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			
			
			
			if(serviceChoice == 2) {
				System.out.println("enter amount to add: ");
				toWallate = s.nextDouble();
				try {
					if(user.getBankName() == "HdfcBank") {
						user.payToWallate(toWallate, user.getWallateAmount(), hdfcbankCustomer.getAmount());
						hdfcbankCustomer.setAmount(hdfcbankCustomer.getAmount() - toWallate);
						user.setWallateAmount(user.getWallateAmount() + toWallate);
					}
					else if(user.getBankName() == "IciciBank") {
						user.payToWallate(toWallate, user.getWallateAmount(), icicibankCustomer.getAmount());
						icicibankCustomer.setAmount(icicibankCustomer.getAmount() - toWallate);
						user.setWallateAmount(user.getWallateAmount() + toWallate);
					}	
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
			
			
			if(serviceChoice == 3) {
				user.wallateCheck(user.getWallateAmount(), user.getCreditAmount());
			}
			
			
			
			if(serviceChoice == 4) {
				System.out.println("enter amount to credit(maximum amount:" +user.getWallateAmount()*50/100+" ): ");
				loanFromWallate = s.nextDouble();
				try {
					user.takeCredit(user.getWallateAmount(), loanFromWallate, user.noOfCredit);
					user.setWallateAmount(user.getWallateAmount() + loanFromWallate);
					user.setCreditAmount(user.getCreditAmount()+loanFromWallate);
					user.noOfCredit = 1;
					
				} catch (InsuficientFundException e) {
					System.out.println(e);
				}
			}
			
			
			if(serviceChoice == 5) {
				System.out.println("enter amount to pay for credit: ");
				payCredit = s.nextDouble();
				if(user.getBankName() == "HdfcBank")
					try {
						user.payCredit(payCredit, user.getCreditAmount(), hdfcbankCustomer.getAmount());
						user.setCreditAmount(user.getCreditAmount() - payCredit);
						hdfcbankCustomer.setAmount(hdfcbankCustomer.getAmount() - payCredit);
						if(user.getCreditAmount() == 0) {
							user.noOfCredit = 0;
						}
					} catch (InsuficientFundException e) {
						System.out.println(e);
					}
				
				
			}
			
			
			if(serviceChoice == 6) {
			while(true) {
				while(true) {
					try {
						System.out.println(" for Calculate Interest press 1\n for Loan Eligibility Check press 2\n "
								+ "for atm charge press 3\n for change bank press 4\n for balance check press 5\n for previous menu press 0");
						otherServiceChoice = s.nextInt();
						if(otherServiceChoice>=0 && otherServiceChoice<6) break;
						else System.out.println("enter choice correctly, try again");
					}catch(Exception e) {
						System.out.println("enter the correct number, try again");
						s.nextInt();
					}
				}
				
				if(otherServiceChoice == 1) {
					System.out.println("enter year");
					year = s.nextInt();
					if(user.getBankName() == "HdfcBank")
						System.out.println(hdfcbankCustomer.calculateInterest(year));
					else if(user.getBankName() == "IciciBank")
						System.out.println(icicibankCustomer.calculateInterest(year));
				}
				
				if(otherServiceChoice == 2) {
					if(user.getBankName() == "HdfcBank")
						System.out.println(hdfcbankCustomer.isEligibleForLoan());
					else if(user.getBankName() == "IciciBank")
						System.out.println(icicibankCustomer.isEligibleForLoan());
				}
				
				if(otherServiceChoice == 3) {
					System.out.println("enter year");
					year = s.nextInt();
					if(user.getBankName() == "HdfcBank")
						System.out.println(hdfcbankCustomer.calculateAtmCharge(year));
					else if(user.getBankName() == "IciciBank")
						System.out.println(icicibankCustomer.calculateAtmCharge(year));
				}
				
				if(otherServiceChoice == 4) {
					if(user.getBankName() == "HdfcBank") {
						icicibankCustomer = hdfcbankCustomer.changeFrom(hdfcbankCustomer);
						user.setBankName("IciciBank");
						hdfcbankCustomer = null;
						System.out.println("You change your account from Hdfc Bank to Icici Bank");
					}
					else if(user.getBankName() == "IciciBank"){
						hdfcbankCustomer = icicibankCustomer.changeFrom(icicibankCustomer);
						user.setBankName("HdfcBank");
						icicibankCustomer = null;
						System.out.println("You change your account from Icici Bank to Hdfc Bank");
					}
				}
				
				if(otherServiceChoice == 5) {
					if(user.getBankName() == "HdfcBank")
						hdfcbankCustomer.balanceCheck();
					else if(user.getBankName() == "IciciBank")
						icicibankCustomer.balanceCheck();
				}
				
				if(otherServiceChoice == 0)
					break;	
			}
			}
			
			
			
			if(serviceChoice == 0)
				break;	
		}
		
		
		s.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
