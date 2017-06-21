
/**
 * A class for menu operation
 *
 * @author (Stefan Derian Hartono)
 * @version (25/05/2017)
 */

import java.util.ArrayList;
public class MovieDatabase
{

    private MovieCollection movieCollection;
    /**
     * Constructor for objects of class MovieDatabase
     */
    public MovieDatabase()
    {

        this.movieCollection = new MovieCollection();

    }

    /**
     *a method for displaying D menu for maintaining movie database
     */
    public void displayDMenu()
    {

        UserInput userInput;
        userInput = new UserInput();

        while(true)
        {
            int option ;
            option = 0;
            System.out.println ("Welcome to movie database");
            System.out.println ("(1) Search /movies based on titles");
            System.out.println ("(2) Add Movies");
            System.out.println ("(3)Delete Movies");
            System.out.println ("(4) Display Favorite Movies");
            System.out.println ("(5) Exit System");
            System.out.print ("Choose an option : ");

            option = userInput.integerInput("option",1,5);
            switch (option){
                case 1 :
                searchTitle();
                break;

                case 2 :
                addMovies();
                break;

                case 3 :
                deleteMovies();
                break;

                case 4 :
                displayFavorites();
                break;

                case 5 :

                exitSystem();
                return;

                default:
                displayError ("no option available for this, Please select only the available option");
                break;
            }
            System.out.println ();
            System.out.println ();
        }

    }

    /**
     *a method for displaying HD level menu for maintaining movie database
     */
    public void displayHDMenu()
    {

        UserInput userInput;
        userInput = new UserInput();

        while(true)
        {
            int option ;
            option = 0;
            System.out.println ("Welcome to movie database");
            System.out.println ("(1) Search /movies based on titles");
            System.out.println ("(2) search movies based on director");
            System.out.println ("(3) Add Movies");
            System.out.println ("(4)Delete Movies");
            System.out.println ("(5)Delete Movies by partial search");
            System.out.println ("(6) Display Favorite Movies");
            System.out.println ("(7) Update Movie");
            System.out.println ("(8) Exit System");
            System.out.print ("Choose an option : ");

            option = userInput.integerInput("option",1,8);
            switch (option){
                case 1 :
                searchTitle();
                break;

                case 2 :
                searchDirectors();
                break;

                case 3 :
                addMovies();
                break;
                
                case 4 :
                deleteMovies();
                break;

                case 5 :
                deletePartial();
                break;

                case 6 :
                displayFavorites();
                break;

                case 7 :
                updateMovie();
                break;

                case 8 :

                exitSystem();

                return;

                default:
                displayError ("no option available for this, Please select only the available option");
                break;
            }
            System.out.println ();
            System.out.println ();
        }

    }

    private void updateMovie()
    {
        UserInput userInput = new UserInput();

        String keyword = userInput.stringInput("Title you want to search");
        if(this.movieCollection.checkAvailbility(keyword)){
            boolean updateMore;
            updateMore = true;

            while(updateMore)
            {

                System.out.println("There are several movies here, please choose to delete");
                System.out.println("Please enter the number of the movie to update");
                this.movieCollection.partialListMovies(keyword);
                int option;
                option = userInput.integerInput("Movie to update", 1, this.movieCollection.fetchSize(keyword));
                String director = userInput.stringInput("new director");
                ArrayList<String> actors = userInput.stringArrayListInput("new actors", 3);

                this.movieCollection.updatePartialMovie(keyword,option,director,actors);

                updateMore = userInput.booleanInput("do you want to update more?");
            }

        }

    }

    /**
     * a method for exiting the system

     */
    private void exitSystem()
    {
        System.out.println("Bye Bye see you again");
        this.movieCollection.writeMovies("myvideos.txt");

    }

    /**
     * a method for displaying movies' information based on movie title
     * arraylist, the movies' list to be searched
     */
    private void searchTitle()
    {
        UserInput userInput = new UserInput();

        String title = userInput.stringInput("Title you want to search");

        this.movieCollection.searchTitle(title);
    }

    /**
     * a method for displaying movies' information based on directors
     * arraylist, the movies' list to be searched
     */
    private void searchDirectors()
    {
        UserInput userInput = new UserInput();

        boolean searchDirector = true;
        ArrayList<String> directorParam = new ArrayList<String>();
        while(searchDirector)
        {

            String director = userInput.stringInput("Director you want to search");

            searchDirector =  userInput.booleanInput("do you add more director");

            directorParam.add(director);

        }
        this.movieCollection.searchDirectors(directorParam);
    }

    /**
     *a method for adding movies' information
     *
     */
    private void addMovies()
    {    
        UserInput userInput;
        userInput = new UserInput();

        String title;
        title = "";
        boolean validTitle = true;

        do
        {
            title = userInput.stringInput("Title");
            validTitle = this.movieCollection.validateTitle(title);
            if(!validTitle)
                displayError("Please enter another name which is different from another titles");
        }
        while(!validTitle);

        String director;
        director  = userInput.stringInput("Director");
        int rating = userInput.integerInput("Rating",1 ,10);
        ArrayList<String> actors = new ArrayList<String>();
        actors = userInput.stringArrayListInput("actor",3);

        this.movieCollection.addMovie(title, director, actors, rating);  
        System.out.println("Movie Added");

    }

    /**
     *a method for deleting movies' information from database based on keyword
     */
    private void deleteMovies()
    {
        UserInput userInput;
        userInput = new UserInput();

        String keyword;
        keyword = userInput.stringInput("Title");
        this.movieCollection.deleteMovies(keyword);

    }

    /**
     *a method for deleting movies' information from database based on keyword
     */
    private void deletePartial()
    {
        UserInput userInput;
        userInput = new UserInput();

        String keyword;
        keyword = userInput.stringInput("Title");        
        boolean deleteMore;
        deleteMore = true;
        while(this.movieCollection.checkAvailbility(keyword) && deleteMore)
        {

            System.out.println("There are several movies here, please choose to delete");

            System.out.println("Please enter the number of the movie to delete");

            this.movieCollection.partialListMovies(keyword);

            int option;
            option = userInput.integerInput("Movie to delete", 1, this.movieCollection.fetchSize(keyword));

            this.movieCollection.deletePartialMovie(keyword,option);

            System.out.println("Do you want to delete again? ");
            deleteMore = userInput.booleanInput("choice");
            if(!this.movieCollection.checkAvailbility(keyword))
                System.out.println("sorry no more to delete");

        }
    }

    /**
     *a method for displaying favorite movies
     */
    private void displayFavorites()
    {
        UserInput userInput;
        userInput = new UserInput();

        int rating;
        rating = userInput.integerInput("Rating",1,10);

        this.movieCollection.displayFavorites(rating);

    }


    /**
     *a method for displaying error when it is needed
     *@params String, a message of error
     */
    private void displayError(String message)
    {

        System.out.println (message);

    }
}
