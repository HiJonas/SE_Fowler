package Application;
public class Movie {
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
        	
    public double getCharge(int daysRented) {
    	return priceCode.getCharge(daysRented);
    }
}