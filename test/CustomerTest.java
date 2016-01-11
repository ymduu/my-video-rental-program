import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    Customer c;

    @Before
    public void init() {
        c = new Customer("Shinpei Hayashi");
        Movie m1 = new Movie("Star Wars Ep. 7", Movie.NEW_RELEASE);
        c.addRental(new Rental(m1, 1));
        Movie m2 = new Movie("Yokai Watch", Movie.CHILDRENS);   
        c.addRental(new Rental(m2, 3));
        Movie m3 = new Movie("Baymax", Movie.REGULAR);
        c.addRental(new Rental(m3, 3));
    }
    
    @Test
    public void testStatement() {
        String expected = "";
        expected += "Rental Record for Shinpei Hayashi\n";
        expected += "\tStar Wars Ep. 7\t3.0\n";
        expected += "\tYokai Watch\t1.5\n"; 
        expected += "\tBaymax\t3.5\n";
        expected += "Amount owed is 8.0\n";
        expected += "You earned 3 frequent renter points";
        assertEquals(expected, c.statement());
    }
}
