package Test;

import static org.junit.Assert.*;

import Application.Customer;
import Application.Movie;
import Application.Rental;

public class Test {

	@org.junit.Test
	public void TestAmountFor5DaysRegular(){
		Movie mov = new Movie("Titel1", 0);
		Rental rentalMov = new Rental(mov, 5);
		Customer cust = new Customer("Name1");
		cust.addRental(rentalMov);
		
		assertEquals(6.5, cust.amountFor(rentalMov), 0.0001);
	}

}
