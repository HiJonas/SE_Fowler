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
        double totalSum = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();	    
        String statement = "Rental Record for " + this.getName() + "\n";
        statement += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental currentRental = enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = currentRental.amountFor();
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((currentRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && currentRental.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            statement += "\t" + currentRental.getMovie().getTitle()+ "\t" + "\t" + currentRental.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalSum += thisAmount;
        }
        //add footer lines
        statement += "Amount owed is " + String.valueOf(totalSum) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return statement;
    }

    

}
    