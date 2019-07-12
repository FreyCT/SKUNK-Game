import java.util.Scanner;
/**
 * @author Frey COMP 1451
 * @version Assignment 0, ScannerUtility.java
 */
public final class ScannerUtility{ //utility class

    private static Scanner       input = new Scanner(System.in);

    private static final int     STANDARD_LINE_BREAK = 2;
    private static final String  NO_INPUT = "";

    private ScannerUtility(){}

    /**
     *
     * @return True if yes
     */
    public static boolean getYesOrNo(){

        String userInput = (input.hasNext()) ? input.next() : NO_INPUT;
        System.out.println("you typed: \"" + userInput + "\"");
        ASCIIArt.pageBreak(STANDARD_LINE_BREAK);

        if (!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no")){
            System.out.println("Invalid entry, you typed: \"" + userInput + "\". Please enter \"Yes\" or \"No\".");
        }
        return (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no"))
                ? (userInput.equalsIgnoreCase("yes")) : getYesOrNo();
    }

    /**
     *
     * @return The user input
     */
    public static String getInput(){

        String userInput = (input.hasNext()) ? input.next() : NO_INPUT;

        if (userInput == null || userInput.equals(NO_INPUT)){
            System.out.println("Invalid entry,you typed: \"" + userInput + "\". Please enter a valid input." );
        }

        return (userInput != null && !userInput.equals(NO_INPUT)) ? userInput : getInput();
    }

    /**
     *
     * @param min The minimal integer typed as input
     * @return The input as an int
     */
    public static int getInt(int min){

        int userInput = (input.hasNext() && input.hasNextInt()) ? input.nextInt() : min ;

        if (userInput < min){
            System.out.println("Invalid entry,you typed: \"" + userInput + "\". Please enter an integer greater or equal to (" + min + ")." );
        }

        return (userInput >= min) ? userInput : getInt(min);
    }

    /**
     *
     * @param min The minimal integer typed as input
     * @param max The maximum integer type as input
     * @return The input as an int
     */
    public static int getIntBetween(int min, int max){

        int userInput = (input.hasNext() && input.hasNextInt()) ? input.nextInt() : min;

        if (userInput < min || userInput > max){
            System.out.println("Invalid entry,you typed: \"" + userInput + "\". Please enter an integer between  (" + min + "-" + max + ")." );
        }

        return (userInput >= min && userInput <= max) ? userInput : getIntBetween(min, max);
    }

    public static void closeScanner(){
        input.close();
    }
}
