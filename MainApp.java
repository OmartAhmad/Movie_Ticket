//Omar's Part

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Movie Pass System!");

        // Array of Objects
        List<Customer> users = new ArrayList<>();

        // loop that gathers information from users
        while (true) {
        String name = "";
         while(name.equals("")){
             name = JOptionPane.showInputDialog("Enter your name:");
               if(name.equals("")){
                  JOptionPane.showMessageDialog(null, "Sorry, name must be provided");
               }
            }
            int age = getValidAge();
            String movieName = "";
            while(movieName.equals("")){
             movieName = JOptionPane.showInputDialog("Enter the movie name:");
               if(movieName.equals("")){
                  JOptionPane.showMessageDialog(null, "Sorry, movie name must be provided");
               }
            }



            String[] movieRatings = {"PG", "PG-13", "R"};
            String movieRating = (String) JOptionPane.showInputDialog(
                null,
                "Select the movie rating:",
                "Movie Rating",
                JOptionPane.QUESTION_MESSAGE,
                null,
                movieRatings,
                movieRatings[0]
            );

            // this create a MoviePass object from user input
            MoviePass movie = new MoviePass(movieName, movieRating);

            if (age < getMinimumAge(movie.getMovieRating())) {
                JOptionPane.showMessageDialog(null, "Sorry, you are not within the appropriate age range for this movie.");
            } else {
                // creates a Customer object and add it to the list
                Customer customer = createCustomer(name, age);
                users.add(customer);
            }

            // asks if there is another customer
            String moreUsersInput = JOptionPane.showInputDialog("Is there another customer? (Yes/No):");
            if (!moreUsersInput.equalsIgnoreCase("Yes")) {
                break;
            }
        }

        // this displays information for all users
        StringBuilder allUsersInfo = new StringBuilder("All Users Information:\n");
        for (Customer user : users) {
            double passPrice = 20.0; // the price of a single pass
            double totalCost = user.calculateTotalCost(passPrice);

            allUsersInfo.append("\nName: " + user.getName() + "\n");
            allUsersInfo.append("Number of Passes: " + user.getNumPasses() + "\n");
            allUsersInfo.append("Total Cost: $" + totalCost + "\n");
            if (user.isSeasonPassHolder()) {
                allUsersInfo.append("Season Pass Holder: Yes\n");
            } else {
                allUsersInfo.append("Season Pass Holder: No\n");
            }
        }

        // displays the information using a JOptionPane dialog
        JOptionPane.showMessageDialog(null, allUsersInfo.toString());
    }

    // method to get a valid age from user input
    private static int getValidAge() {
        int age = 0;
        boolean validInput = false;

        while (!validInput) {
            String ageInput = JOptionPane.showInputDialog("Enter your age:");
            try {
                age = Integer.parseInt(ageInput);
                if(age >100 || age<0){ 
                throw new IllegalArgumentException();
                   }
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for your age.");
            } 
               catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for your age.");

            }
        }

        return age;
    }


    private static Customer createCustomer(String name, int age) {
     String numPassesInput="-1";
     int numPasses=-1;
     boolean vaildInput = false;
    while(vaildInput != true){
      try{
         numPassesInput = JOptionPane.showInputDialog("Enter the number of movie passes (max 10):");
          numPasses = Integer.parseInt(numPassesInput);
           vaildInput = true;
             if(numPasses >10 || numPasses<0){ 
                throw new IllegalArgumentException();
                   }
        }
                catch (IllegalArgumentException e) {
                   JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number (1-10) for passes to purchase.");
                   numPasses=-1;
                   vaildInput = false;
            }
        
        }
       
        String isSeasonPassHolderInput = JOptionPane.showInputDialog("Are you a Season Pass holder? (true/false):");
        boolean isSeasonPassHolder = Boolean.parseBoolean(isSeasonPassHolderInput);

        // creates either a PurchasedSeasonPass or Customer object based on Season Pass status
        if (isSeasonPassHolder) {
            return new PurchasedSeasonPass(name, age, numPasses);
        } else {
            return new Customer(name, age, numPasses, false);
        }
    }

    // this method to get the minimum age for a given movie rating
    private static int getMinimumAge(String movieRating) {
        switch (movieRating) {
            case "PG":
                return 0; // minimum age for "PG" is 0 
            case "PG-13":
                return 13;// minimum age for "PG-13" is 13 and below
            case "R":
                return 18;// minimum age for "R" is 18 and below
            default:
                return 0; // Default value
        }
    }
}
