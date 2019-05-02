package Application;
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private Price priceCode;
    public Movie(String newtitle, Price newPriceCode) {
        title = newtitle;
        setPriceCode(newPriceCode);
    }
    public Price getPriceCode() {
        return priceCode;
    }
    public void setPriceCode(Price arg) {
    	priceCode = arg;
    }
    public String getTitle (){
        return title;
    }
    
    public double amountFor(int daysRented) {
        double sum = 0;
        switch (priceCode) {
            case REGULAR:
                sum += 2;
                if (daysRented > 2)
                    sum += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                sum += daysRented * 3;
                break;
            case CHILDRENS:
                sum += 1.5;
                if (daysRented> 3)
                    sum += (daysRented- 3) * 1.5;
                break;
        }
        return sum;
    }
}