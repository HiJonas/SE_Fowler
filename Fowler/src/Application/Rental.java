package Application;
public class Rental {
    private Movie movie;
    private int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }
    
    public int getFrequentPoints(int frequentRenterPoints) {
		// add frequent renter points
		frequentRenterPoints ++;
		// add bonus for a two day new release rental
		if ((movie.getPriceCode() == Price.NEW_RELEASE) && daysRented> 1) 
		    frequentRenterPoints ++;
		return frequentRenterPoints;
	}
    
	public double amountFor() {
		return movie.getCharge(daysRented);
	}
}