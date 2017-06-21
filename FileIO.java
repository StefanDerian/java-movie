
/**
 * A class for handling file input and output
 * 
 * @author (Stefan Derian Hartono) 
 * @version (09/05/2017)
 */

import java.util.ArrayList;
import java.io.*; 
import java.util.Scanner;
public class FileIO
{
    // instance variables - replace the example below with your own
    private String file;
    /**
     * Constructor for objects of class FileIO
     */
    public FileIO(String file)
    {
        // initialise instance variables
        this.file = file;
    }

    /**
     * A method for getting file string path
     * @return file String path
     */
    public String getFile()
    {
        return this.file;
    }

    /**
     * method for setting file Path
     * @param  a file path
     */
    public void setFile(String file)
    {
        this.file = file;
    }

    /**
     * method for getting file output in a form of ArrayList String[]
     * @return ArrayList<String[]> list of string arrays 
     */
    public ArrayList<String[]> readFile() throws IOException
    {

        ArrayList<String[]> fileOutput;
        fileOutput = new ArrayList<String[]>();
        FileReader inputFile = null;
        String filename = this.file; 
        try
        {
            inputFile = new FileReader(new File(filename)); 
            Scanner parser = new Scanner(inputFile);        

            while(parser.hasNextLine())
            {
                String [] output = new String[6];
                String rawOutput;
                rawOutput = parser.nextLine();
                output = rawOutput.split(",");

                fileOutput.add(output);
            }

        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found ");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
        finally
        {
            inputFile.close();
            return fileOutput;
        }

    }
    /**
     *a method for writing movies list into a file
     *@params an arraylist as a reference for writing
     */
    public void writeFile(ArrayList<String[]> outputString)
    {
        String filename = this.file; 
        PrintWriter outputFile = null;
        try
        {
            outputFile = new PrintWriter(filename);

            for(String[] singleOutput : outputString)
            {
                String formattedOutput = toFormat(singleOutput);
                outputFile.println(formattedOutput);
            }

        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found ");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
        finally
        {
            outputFile.close();
        }
    }

    private String toFormat(String[] array) {
        String result = "";

        if (array.length > 0) {
            StringBuilder sb = new StringBuilder();

            for (String s : array) {
                sb.append(s).append(",");
            }

            result = sb.deleteCharAt(sb.length() - 1).toString();
        }
        return result;
    }

}
