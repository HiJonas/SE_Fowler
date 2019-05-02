package Test;

import static org.junit.Assert.*;

import Application.Customer;
import Application.Movie;
import Application.Price;
import Application.Rental;

public class Test {

	@org.junit.Test
	public void TestAmountFor5DaysRegular(){
		Movie mov = new Movie("Titel1", Price.REGULAR);
		Rental rentalMov = new Rental(mov, 5);
		assertEquals(6.5, rentalMov.amountFor(), 0.0001);
	}
	
	@org.junit.Test
	public void TestCustomerStatementNoRentals(){;
		Customer cust = new Customer("Name1");
		String expectedStatement = "Rental Record for Name1\n" + 
				"	Title		Days	Amount\n" + 
				"Amount owed is 0.0\n" + 
				"You earned 0 frequent renter points";
		
		assertEquals(expectedStatement, cust.statement());
	}
	
	@org.junit.Test
	public void TestCustomerStatementOneRentals(){;
		Movie mov = new Movie("Titel1", Price.REGULAR);
		Rental rentalMov = new Rental(mov, 5);
		Customer cust = new Customer("Name1");
		cust.addRental(rentalMov);
		String expectedStatement="Rental Record for Name1\n"+
				"	Title		Days	Amount\n"+
				"	Titel1		5	6.5\n"+
			"Amount owed is 6.5\n"+
			"You earned 1 frequent renter points";
				
		assertEquals(expectedStatement, cust.statement());
	}

}
