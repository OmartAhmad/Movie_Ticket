//Cameron’s part

public class PurchasedSeasonPass extends Customer {
    public PurchasedSeasonPass(String name, int age, int numPasses) {
        super(name, age, numPasses, true); // Season pass holders always have a 10% discount
    }

    @Override
    public double calculateTotalCost(double passPrice) {
        double totalCost = super.calculateTotalCost(passPrice); // Calculate the total cost as a regular customer

        // Apply an additional 10% discount for Season Pass holders
        totalCost *= 0.9;

        return totalCost;
    }
}
