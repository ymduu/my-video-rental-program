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
        int frequentRenterPoints = 0;

        while (rentals.hasNext()) {
            Rental each = rentals.next();

            frequentRenterPoints += each.getFrequentRenterPoints();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }
    
    public String htmlStatement() {
        Iterator<Rental> rentals = _rentals.iterator();
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>\n";
        int frequentRenterPoints = 0;
        result += "<ul>\n";
        while (rentals.hasNext()) {
            Rental each = rentals.next();

            frequentRenterPoints += each.getFrequentRenterPoints();
            // show figures for this rental
            result += "<li>" + each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "</li>\n";
        }
        result += "</ul>\n";

        // add footer lines
        result += "<p>Amount owed is <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "<p>You earned <em>" + String.valueOf(frequentRenterPoints) + "</em> frequent renter points</p>";

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

}