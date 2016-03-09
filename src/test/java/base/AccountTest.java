package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Exception.InsufficientFundsException;
import java.util.Date;

public class AccountTest {
	
	Account oneAccount;
	
	@Before
	public void setUp() throws Exception{
		oneAccount = new Account(1122,20000,0.045,new Date());
	}
	
	@After
	public void tearDown() throws Exception{
		oneAccount = null;
	}
	
	@Test
	public void testGetId() {
		assertEquals(oneAccount.getId(),1122);
	}
	
	@Test
	public void testAnnualInterestRate() {
		assertEquals((long)oneAccount.getAnnualInterestRate(),(long)0.045);
	}
	
	//Test on MonthlyInterestRate() method
	@Test
	public void testMonthlyInterestRate() {
		assertEquals((long)oneAccount.getMonthlyInterestRate(),(long)0.00375);
	}
	
	//Test on withdraw() method
	@Test
	public void testWithdraw() {
		oneAccount.deposit(3000);
		assertEquals((long)oneAccount.getBalance(),(long)23000);
	}
	
	//Test on deposit() method
	@Test
	public void testDeposit() throws InsufficientFundsException {
		oneAccount.withdraw(2500);
		assertEquals((long)oneAccount.getBalance(),(long)17500);
	}
	
	@Test
	public void testDateCreated() {
		assertEquals(oneAccount.getDateCreated(),new Date());
	
	System.out.println("The balance in the account is $ " + oneAccount.getBalance());
	System.out.println("The monthly interest rate is " + oneAccount.getMonthlyInterestRate() * oneAccount.getBalance());
	System.out.println("The date the account was created: " + oneAccount.getDateCreated());
	}
	
}
