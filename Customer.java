//Cameron’s part

public class Customer {
    // instance variables to store customer information
    private String name;
    private int age;
    private int numPasses;
    private boolean isSeasonPassHolder;

    // constructors to initialize Customer object 
    public Customer(String name, int age, int numPasses, boolean isSeasonPassHolder) {
        this.name = name;
        this.age = age;
        this.numPasses = numPasses;
        this.isSeasonPassHolder = isSeasonPassHolder;
    }

    // this method is to calculate the total cost based on the number of passes and pass price
    public double calculateTotalCost(double passPrice) {
        double totalCost = numPasses * passPrice;



        return totalCost;
    }

    // method to check age restriction
    public boolean isAboveMovieRating(MoviePass movie) {
        return age >= Integer.parseInt(movie.getMovieRating());
    }

    // getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumPasses() {
        return numPasses;
    }

    public boolean isSeasonPassHolder() {
        return isSeasonPassHolder;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumPasses(int numPasses) {
        this.numPasses = numPasses;
    }

    public void setSeasonPassHolder(boolean isSeasonPassHolder) {
        this.isSeasonPassHolder = isSeasonPassHolder;
    }
}
