
/**
 * A class for testing newly created testMovie objects
 * 
 * @author (Stefan Derian Hartono) 
 * @version (24/05/17)
 */

import java.util.ArrayList;
public class TestMovies
{

    
    Movie testMovie;
    public TestMovies()
    {
        

        ArrayList<String> actors = new ArrayList<String>();

        actors.add("Raditya Dika");
        actors.add("Sandy Sandoro");

        this.testMovie = new Movie("Jomblo","Eki",actors,10);

    }

    public void testSetTitle()
    {
        UserInput userInput = new UserInput();

        String title = userInput.stringInput("Title");

        this.testMovie.setTitle(title);

    }

    public void testSetDirector()
    {
        UserInput userInput = new UserInput();

        String director = userInput.stringInput("director");

        this.testMovie.setTitle(director);
    }
    
    
    public void testSetActors()
    {
        UserInput userInput = new UserInput();

        ArrayList<String> actors = userInput.stringArrayListInput("actor", 3);

        this.testMovie.setActors(actors);
    }

    public void testSetRating()
    {
         UserInput userInput = new UserInput();

        int rating = userInput.integerInput("rating",1, 10);

        this.testMovie.setRating(rating);
    }
}
