/**
 * @author Frey COMP 1451
 * @version Assignment 0, Main.java
 */
public class Main {

    /**
     *
     * @param args the arguments for the main method
     */
    public static void main(String[] args){

        ASCIIArt.dice();
        SKUNKGame skunk = new SKUNKGame();
        ASCIIArt.skunkLogo();
        skunk.printRules();
        System.out.println("Youre all set! Press any key to start! ");
        System.out.println(ScannerUtility.getInput() + "\n");
        skunk.start();
        ScannerUtility.closeScanner();
    }
}