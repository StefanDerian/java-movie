
/**
 * A class containing information of a movie
 * 
 * @author (Stefan Derian Hartono) 
 * @version (30/04/2016)
 */

import java.util.ArrayList;
import java.util.*;

public class Movie
{
    // instance variables - replace the example below with your own
    private String title;
    private String director;
    private ArrayList<String> actors;
    private int rating;

    /**
     * Special Constructor for objects of class movie
     */
    public Movie(String title, String director,ArrayList<String> actors, int rating)
    {
        this.title = title;
        this.director = director;
        this. actors = actors;
        this.rating = rating;
    }

    /**
     *method for setting a movie name
     *@param movie title
     */
    public void setTitle(String title)
    {

        this.title = this.title;
    }

    /**
     *method for obtaining a movie director
     *@return title of a movie 
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     *method for setting a movie director
     *@param director of the movie
     */
    public void setDirector(String director)
    {
        this.director = director;
    }

    /**
     *method for obtaining a movie name
     *@return name of a movie 
     */
    public String getDirector()
    {
        return this.director;
    }

    /**
     *method for setting a movie rating
     *@param rating of the movie
     */
    public void setRating(int rating)
    {
        this.rating = rating;

    }

    /**
     *method for setting a movie actors
     */
    public void setActors(ArrayList<String> actors)
    {
        this.actors = actors;

    }

    /**
     *method for getting a movie actors
     */
    public ArrayList<String> getActors()
    {
        return this.actors;

    }

    /**
     *method for obtaining a movie rating
     *@return rating of a movie 
     */
    public int getRating()
    {
        return this.rating;
    }

    public void display()
    {
        System.out.println("TITLE: "+this.title);
        System.out.println("DIRECTOR: "+this.director);

        for (String actor : this.actors)
        {
            if(!actor.trim().equals(""))
                System.out.println("Actor: " +actor);
        }
        System.out.println("RATING: "+this.rating);
        System.out.println("=========================================");
    }

}
