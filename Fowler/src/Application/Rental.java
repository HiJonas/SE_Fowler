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
    
    public double amountFor() {
        double sum = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                sum += 2;
                if (daysRented > 2)
                    sum += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                sum += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                sum += 1.5;
                if (daysRented> 3)
                    sum += (daysRented- 3) * 1.5;
                break;
        }
        return sum;
    }
}