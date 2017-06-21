
/**
 *A class for  user input
 * 
 * @author (Stefan Derian Hartono) 
 * @version (25/05/2017)
 */

import java.util.Scanner;
import java.util.*;
public class UserInput
{
    // instance variables - replace the example below with your own

    /**
     * method for asking input from a user
     * @param pamameter name from the business rule
     * @return     the input string from the user
     */
    public String  stringInput(String param)
    {
        // put your code here
        String output = "";

        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        Validation validation = new Validation();

        while(!valid){

            try{
                System.out.print("Please enter "+ param+": ");

                output = sc.nextLine();

                System.out.println("");
                if(!validation.validateString(output))
                {
                    throw new NullPointerException("");
                }
                valid = true;
            }catch(NullPointerException exception)
            {
                System.out.println("Please do not put empty string");

            }
        }

        return output;
    }

    /**
     * method for asking input from a user yes or no
     * @param pamameter name from the business rule
     * @return     the booelan from the user
     */
    public boolean booleanInput(String param)
    {
        // put your code here
        String output = "";

        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        Validation validation = new Validation();

        while(!valid){

            try{
                System.out.print("Please enter "+ param+": ");

                output = sc.nextLine();

                System.out.println("");
                if(!validation.validateString(output))
                {
                    throw new NullPointerException("");
                }

                if(output.equalsIgnoreCase("Y"))
                    return true;

                else{
                    valid = true;
                }

            }catch(NullPointerException exception)
            {
                System.out.println("Please do not put empty string");

            }
        }

        return false;
    }

    /**
     * method for asking input from a user
     * @param parameter name from the business rule
     * @return     the input string from the user
     */
    public int integerInput(String param,int bottom, int upper)
    {
        // put your code here

        int output = 0;

        Scanner sc = new Scanner(System.in);

        boolean valid = false;

        while(!valid){
            try{
                System.out.print("Please enter "+ param+": ");

                output = sc.nextInt();
                Validation validation = new Validation();
                if(!validation.validateBoundary(output,bottom,upper))
                {
                    throw new IllegalArgumentException("");
                }
                valid = true;
                System.out.println("");
            }catch(NullPointerException exception)
            {
                System.out.println("Please do not put empty number");

            }catch(InputMismatchException exception)
            {
                System.out.println("Please enter appropriate integer format");
                sc.next();
            }catch(IllegalArgumentException exception)
            {
                System.out.println("The Number must be within the range of "+bottom+" up to"+upper);

            }
        }
        return output;
    }

    /**
     * method for asking strings input from a user
     * @param parameter name from the business rule, fixed size of an array
     * @return     string array as an output from a user
     */
    public ArrayList<String> stringArrayListInput(String param,int size)
    {
        ArrayList<String> outputArray = new ArrayList<String>();;

        Scanner sc = new Scanner(System.in);

        boolean valid = false;

        Validation validation = new Validation();
        while(!valid){

            System.out.println("please add "+param+"s at least 1 and no more than"+ size);
            int iterator;
            iterator = 0;
            outputArray = new ArrayList<String>();
            while(iterator < size)
            {

                String output;
                System.out.print("please add "+(param)+" -"+(iterator+1)+" ");
                output = sc.nextLine();

                System.out.println();
                outputArray.add(output);
                if(validation.validateString(output))
                {
                    
                    valid = true;

                }
                iterator++;
            }
            if(!valid)
            {
                System.out.println("please add at least one"+ param);
            }
        }

        return outputArray;
    }

}
