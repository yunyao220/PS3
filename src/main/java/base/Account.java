package base;
import java.util.Date;

import Exception.InsufficientFundsException;

public class Account {
	
	//Create necessary variables
	private int id = 0;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private Date dateCreated;
	
	//Constructor
	public Account(int id, double balance, double annualInterestRate, Date dateCreated){
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = new Date();
	}
	
	//Accessor and mutator methods for id
	public int getId(){
		return id;
	}
	public void setId(int newId){
		this.id = newId;
	}
	
	//Accessor and mutator methods for balance
	public double getBalance(){
		return balance;
	}
	public void setBalance(double newBalance){
		this.balance = newBalance;
	}
	
	//Accessor and mutator methods for annualInterestRate
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double newAnnualInterestRate){
		this.annualInterestRate = newAnnualInterestRate;
	}
	
	//Accessor method for dateCreated
	public Date getDateCreated(){
		return dateCreated;
	}
	
	
	//A method that returns the monthly interest rate
	double getMonthlyInterestRate(){
		return annualInterestRate / 12;
	}
	
	//A method that withdraws a specified amount from the account
	double withdraw(double amount) throws InsufficientFundsException{
		if (amount <= balance){
			balance -= amount;
		}
		else {
			double needs = amount - balance;
			throw new InsufficientFundsException(needs);
		}
		return balance;
	}
	
	//A method that deposits a specified amount to the account
	double deposit(double amount){
		balance += amount;
		return balance;
	}
	
	

}
