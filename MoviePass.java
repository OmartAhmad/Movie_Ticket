//Omar's Part

import javax.swing.JOptionPane;

public class MoviePass {
    // instance variables to store movie name and rating
    private String movieName;
    private String movieRating;

    // constructors to initialize MoviePass with movie name and rating
    public MoviePass(String movieName, String movieRating) {
        this.movieName = movieName;
        this.movieRating = movieRating;
    }

    // getters
    public String getMovieName() {
        return movieName;
    }


    public String getMovieRating() {
        return movieRating;
    }

    // setters
    public void setMovieName(String movieName) {
        if (movieName.equals("") || movieName == null) {
            throw new IllegalArgumentException("Movie Name must be provided");
        }
        this.movieName = movieName;
    }


    public void setMovieRating(String movieRating) {
        // check if the provided movie rating is one of the valid options
        if (!movieRating.equals("PG") || !movieRating.equals("PG-13") || !movieRating.equals("R")) {
            throw new IllegalArgumentException("Movie Rating must be provided");
        }
        this.movieRating = movieRating;
    }



    public static MoviePass createMoviePassWithDialog() {
        // ask the user to enter the movie name
        String movieName = JOptionPane.showInputDialog("Enter the movie name:");

        // ask the user to select the movie rating from a list
        String movieRating = (String) JOptionPane.showInputDialog(
            null,
            "Select the movie rating:",
            "Movie Rating",
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] {"PG", "PG-13", "R"},
            "PG"
        );

        return new MoviePass(movieName, movieRating);
    }
}
