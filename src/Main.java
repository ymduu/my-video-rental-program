public class Main {
    public static void main(String arg[]) {
        Customer c = new Customer("Shinpei Hayashi");
        Movie m1 = new Movie("Star Wars Ep. 7", Movie.NEW_RELEASE);
        c.addRental(new Rental(m1, 1));
        Movie m2 = new Movie("Yokai Watch", Movie.CHILDRENS);
        c.addRental(new Rental(m2, 3));
        Movie m3 = new Movie("Baymax", Movie.REGULAR);
        c.addRental(new Rental(m3, 3));
        
        System.out.println(c.statement());
    }
}
