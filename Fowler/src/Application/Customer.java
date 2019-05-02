package Application;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();
    public Customer (String newName){
        name = newName;
    };
    public void addRental(Rental newRental) {
        rentals.addElement(newRental);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();	    
        String statement = "Rental Record for " + this.getName() + "\n";
        statement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental currentRental = enum_rentals.nextElement();           
            frequentRenterPoints += currentRental.getFrequentPoints(frequentRenterPoints);            
            //show figures for this rental
            statement += "\t" + currentRental.getMovie().getTitle()+ "\t" + "\t" + currentRental.getDaysRented() + "\t" + currentRental.amountFor() + "\n";
        }
        //add footer lines
        statement += "Amount owed is " + calcOwedAmount() + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return statement;
    }
    
	private double calcOwedAmount() {
		double totalSum = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
        	Rental currentRental = enum_rentals.nextElement();
            totalSum += currentRental.amountFor();
        }
        return totalSum;
		
	}

}
    