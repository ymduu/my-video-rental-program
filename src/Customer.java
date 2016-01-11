import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    private String _name;

    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Iterator<Rental> rentals = _rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasNext()) {
            Rental each = rentals.next();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";

        return result;
    }
    
    public double getTotalCharge() {
        double result = 0;
        Iterator<Rental> rentals = _rentals.iterator();
        while (rentals.hasNext()) {
            Rental each = rentals.next();
            result += each.getCharge();
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        int result = 0;
        Iterator<Rental> rentals = _rentals.iterator();
        while (rentals.hasNext()) {
            Rental each = rentals.next();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}