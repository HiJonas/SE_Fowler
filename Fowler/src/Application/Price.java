package Application;

import java.util.function.Function;

public enum Price {
		
	REGULAR {
		@Override
        public double getCharge(int daysRented) {
			double sum = 0;
			sum += 2;
            if (daysRented > 2) sum += (daysRented - 2) * 1.5;
            return sum;
        }
	},
	NEW_RELEASE {
		@Override
        public double getCharge(int daysRented) {
			return daysRented * 3;
        }
	},
	CHILDRENS {
		@Override
        public double getCharge(int daysRented) {
			double sum = 0;
			sum += 1.5;
            if (daysRented> 3)sum += (daysRented- 3) * 1.5;
            return sum;
        }
	};

	public abstract double getCharge(int daysRented);
}


