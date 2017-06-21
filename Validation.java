
/**
 * A class for handling various validation
 * (ie. file validation, null validation, empty string validation)
 * 
 * @author (Stefan Derian Hartono) 
 * @version (19/05/2017)
 */
public class Validation
{
    // instance variables - replace the example below with your own

    /**
     * A method for handling rating input
     * 
     * @param  int rating   and bottom and upper boundary
     * @return  true if it is within boundary
     */
    public boolean validateBoundary(int rating, int bottom, int upper)
    {

        if(rating < bottom || upper < rating){

            return false;
        }
        return true;
    }

    /**
     * A method for handling string
     * 
     * @param  string to be validated
     * @return  true if the string is not empty
     */
    public boolean validateString(String string)
    {

        if(string.trim().equalsIgnoreCase("")){
            return false;
        }

        return true;
    }

}
