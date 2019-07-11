/**
 * @author Frey COMP 1451
 * @version Assignment 0, ASCIIArt.java
 */
public final class ASCIIArt {

    public static final int     SMALL_WORD_LENGTH   = 4;
    public static final int     MEDIUM_WORD_LENGTH  = 8;
    public static final int     LARGE_WORD_LENGTH   = 12;
    public static final int     FULL_PAGE_BREAK     = 50;
    public static final int     INDEX_OFFSET        = 1;
    public static final int     FIRST_DOUBLE_DIGIT  = 10;
    public static final int     HIGHER_THAN_DIE     = 7;
    public static final int     CHAR_HEIGHT_LINES   = 8;
    public static final int     DICE_HEIGHT_LINES   = 5;
    public static final int     DICE_FACE_ONE       = 1;
    public static final int     DICE_FACE_TWO       = 2;
    public static final int     DICE_FACE_THREE     = 3;
    public static final int     DICE_FACE_FOUR      = 4;
    public static final int     DICE_FACE_FIVE      = 5;
    public static final int     DICE_FACE_SIX       = 6;
    public static final int     ASCII_LINE_ONE      = 0;
    public static final int     ASCII_LINE_TWO      = 1;
    public static final int     ASCII_LINE_THREE    = 2;
    public static final int     ASCII_LINE_FOUR     = 3;
    public static final int     ASCII_LINE_FIVE     = 4;
    public static final int     ASCII_LINE_SIX      = 5;
    public static final int     ASCII_LINE_SEVEN    = 6;
    public static final int     ASCII_LINE_EIGHT    = 7;

    public static void pageBreak(int lines) {

        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    /**
     *
     * @param wordLength The length of a word
     * @return The correct amount of tab formatting
     */
    public static String getTabs(int wordLength){

        if (wordLength < SMALL_WORD_LENGTH){
            return "\t\t\t";
        }
        if (wordLength < MEDIUM_WORD_LENGTH){
            return "\t\t";
        }
        if (wordLength < LARGE_WORD_LENGTH){
            return "\t";
        }
        else {
            return "\t";
        }
    }

    public static void dice(){
        System.out.println("                   ______");
        System.out.println("      .-------.   /\\     \\");
        System.out.println("     /   o   /|  /o \\  o  \\");
        System.out.println("    /_______/o| /   o\\_____\\");
        System.out.println("    | o     | | \\o   /o    /");
        System.out.println("    |   o   |o/  \\ o/  o  /");
        System.out.println("    |     o |/    \\/____o/");
        System.out.println("    '-------'");
    }

    /**
     *
     * @param numb The number rolled from a die
     * @param line The line for the ASCII art to print its picture.
     */
    public static void printDiceFaces(int numb, int line){

        String spacedNumb = "? ?";
        if (numb >= FIRST_DOUBLE_DIGIT){
            spacedNumb = Integer.toString(numb).substring(0, Integer.toString(numb).length()-INDEX_OFFSET)
                    + " " + Integer.toString(numb).substring(Integer.toString(numb).length()-INDEX_OFFSET);
        }

        //Print DiceFace One
        System.out.print((numb == DICE_FACE_ONE && line == ASCII_LINE_ONE) ? "     _______ " : "");
        System.out.print((numb == DICE_FACE_ONE && line == ASCII_LINE_TWO) ? "    |       |" : "");
        System.out.print((numb == DICE_FACE_ONE && line == ASCII_LINE_THREE) ? "    |   o   |" : "");
        System.out.print((numb == DICE_FACE_ONE && line == ASCII_LINE_FOUR) ? "    |       |" : "");
        System.out.print((numb == DICE_FACE_ONE && line == ASCII_LINE_FIVE) ? "    `-------`" : "");

        //Print DiceFace Two
        System.out.print((numb == DICE_FACE_TWO && line == ASCII_LINE_ONE) ? "     _______ " : "");
        System.out.print((numb == DICE_FACE_TWO && line == ASCII_LINE_TWO) ? "    | o     |" : "");
        System.out.print((numb == DICE_FACE_TWO && line == ASCII_LINE_THREE) ? "    |       |" : "");
        System.out.print((numb == DICE_FACE_TWO && line == ASCII_LINE_FOUR) ? "    |     o |" : "");
        System.out.print((numb == DICE_FACE_TWO && line == ASCII_LINE_FIVE) ? "    `-------`" : "");

        //Print DiceFace Three
        System.out.print((numb == DICE_FACE_THREE && line == ASCII_LINE_ONE) ? "     _______ " : "");
        System.out.print((numb == DICE_FACE_THREE && line == ASCII_LINE_TWO) ? "    | o     |" : "");
        System.out.print((numb == DICE_FACE_THREE && line == ASCII_LINE_THREE) ? "    |   o   |" : "");
        System.out.print((numb == DICE_FACE_THREE && line == ASCII_LINE_FOUR) ? "    |     o |" : "");
        System.out.print((numb == DICE_FACE_THREE && line == ASCII_LINE_FIVE) ? "    `-------`" : "");

        //Print DiceFace Four
        System.out.print((numb == DICE_FACE_FOUR && line == ASCII_LINE_ONE) ? "     _______ " : "");
        System.out.print((numb == DICE_FACE_FOUR && line == ASCII_LINE_TWO) ? "    | o   o |" : "");
        System.out.print((numb == DICE_FACE_FOUR && line == ASCII_LINE_THREE) ? "    |       |" : "");
        System.out.print((numb == DICE_FACE_FOUR && line == ASCII_LINE_FOUR) ? "    | o   o |" : "");
        System.out.print((numb == DICE_FACE_FOUR && line == ASCII_LINE_FIVE) ? "    `-------`" : "");

        //Print DiceFace Five
        System.out.print((numb == DICE_FACE_FIVE && line == ASCII_LINE_ONE) ? "     _______ " : "");
        System.out.print((numb == DICE_FACE_FIVE && line == ASCII_LINE_TWO) ? "    | o   o |" : "");
        System.out.print((numb == DICE_FACE_FIVE && line == ASCII_LINE_THREE) ? "    |   o   |" : "");
        System.out.print((numb == DICE_FACE_FIVE && line == ASCII_LINE_FOUR) ? "    | o   o |" : "");
        System.out.print((numb == DICE_FACE_FIVE && line == ASCII_LINE_FIVE) ? "    `-------`" : "");

        //Print DiceFace Six
        System.out.print((numb == DICE_FACE_SIX && line == ASCII_LINE_ONE) ? "     _______ " : "");
        System.out.print((numb == DICE_FACE_SIX && line == ASCII_LINE_TWO) ? "    | o   o |" : "");
        System.out.print((numb == DICE_FACE_SIX && line == ASCII_LINE_THREE) ? "    | o   o |" : "");
        System.out.print((numb == DICE_FACE_SIX && line == ASCII_LINE_FOUR) ? "    | o   o |" : "");
        System.out.print((numb == DICE_FACE_SIX && line == ASCII_LINE_FIVE) ? "    `-------`" : "");

        //Print DiceFace Seven or Higher
        System.out.print((numb >= HIGHER_THAN_DIE && line == ASCII_LINE_ONE) ? "     _______ " : "");
        System.out.print((numb >= HIGHER_THAN_DIE && line == ASCII_LINE_TWO) ? "    |       |" : "");
        System.out.print((numb >= HIGHER_THAN_DIE && numb < FIRST_DOUBLE_DIGIT && line == ASCII_LINE_THREE) ? "    |   " + numb + "   |"
                : ((numb >= FIRST_DOUBLE_DIGIT && line == ASCII_LINE_THREE)) ? "    |  " + spacedNumb + "  |" : "");
        System.out.print((numb >= HIGHER_THAN_DIE && line == ASCII_LINE_FOUR) ? "    |       |" : "");
        System.out.print((numb >= HIGHER_THAN_DIE && line == ASCII_LINE_FIVE) ? "    `-------`" : "");
    }

    public static void skunkLogo(){

        pageBreak(FULL_PAGE_BREAK);
        System.out.println("  .d8888b.  888    d8P  888     888 888b    888 888    d8P");
        System.out.println(" d88P  Y88b 888   d8P   888     888 8888b   888 888   d8P");
        System.out.println(" Y88b.      888  d8P    888     888 88888b  888 888  d8P");
        System.out.println("  \"Y888b.   888d88K     888     888 888Y88b 888 888d88K");
        System.out.println("     \"Y88b. 8888888b    888     888 888 Y88b888 8888888b");
        System.out.println("       \"888 888  Y88b   888     888 888  Y88888 888  Y88b");
        System.out.println(" Y88b  d88P 888   Y88b  Y88b. .d88P 888   Y8888 888   Y88b");
        System.out.println("  \"Y8888P\"  888    Y88b  \"Y88888P\"  888    Y888 888    Y88b");
        System.out.println();
    }

    public static void scoreboard() {

        System.out.println("   .d8888b.   .d8888b.   .d88888b.  8888888b.  8888888888 888888b.    .d88888b.        d8888 8888888b.  8888888b.");
        System.out.println("  d88P  Y88b d88P  Y88b d88P\" \"Y88b 888   Y88b 888        888  \"88b  d88P\" \"Y88b      d88888 888   Y88b 888  \"Y88b");
        System.out.println("  Y88b.      888    888 888     888 888    888 888        888  .88P  888     888     d88P888 888    888 888    888");
        System.out.println("   \"Y888b.   888        888     888 888   d88P 8888888    8888888K.  888     888    d88P 888 888   d88P 888    888 ");
        System.out.println("      \"Y88b. 888        888     888 8888888P\"  888        888  \"Y88b 888     888   d88P  888 8888888P\"  888    888");
        System.out.println("        \"888 888    888 888     888 888 T88b   888        888    888 888     888  d88P   888 888 T88b   888    888 ");
        System.out.println("  Y88b  d88P Y88b  d88P Y88b. .d88P 888  T88b  888        888   d88P Y88b. .d88P d8888888888 888  T88b  888  .d88P");
        System.out.println("   \"Y8888P\"   \"Y8888P\"   \"Y88888P\"  888   T88b 8888888888 8888888P\"   \"Y88888P\" d88P     888 888   T88b 8888888P\"");
    }

    /**
     *
     * @param letter A letter of the Alphabet
     * @param line The line number of the ASCII Art to print its picture
     */
    public static void printString(char letter, int line){
        System.out.print((letter == 'A' && line == ASCII_LINE_ONE)   ? "\b\b       d8888  " : "");
        System.out.print((letter == 'A' && line == ASCII_LINE_TWO)   ? "\b\b      d88888  " : "");
        System.out.print((letter == 'A' && line == ASCII_LINE_THREE) ? "\b\b     d88P888  " : "");
        System.out.print((letter == 'A' && line == ASCII_LINE_FOUR)  ? "\b\b    d88P 888  " : "");
        System.out.print((letter == 'A' && line == ASCII_LINE_FIVE)  ? "\b\b   d88P  888  " : "");
        System.out.print((letter == 'A' && line == ASCII_LINE_SIX)   ? "\b\b  d88P   888  " : "");
        System.out.print((letter == 'A' && line == ASCII_LINE_SEVEN) ? "\b\b d8888888888  " : "");
        System.out.print((letter == 'A' && line == ASCII_LINE_EIGHT) ? "\b\bd88P     888  " : "");

        //
        System.out.print((letter == 'B' && line == ASCII_LINE_ONE)   ? "888888b.    " : "");
        System.out.print((letter == 'B' && line == ASCII_LINE_TWO)   ? "888  \"88b   " : "");
        System.out.print((letter == 'B' && line == ASCII_LINE_THREE) ? "888  .88P   " : "");
        System.out.print((letter == 'B' && line == ASCII_LINE_FOUR)  ? "8888888K.   " : "");
        System.out.print((letter == 'B' && line == ASCII_LINE_FIVE)  ? "888  \"Y88b  " : "");
        System.out.print((letter == 'B' && line == ASCII_LINE_SIX)   ? "888    888  " : "");
        System.out.print((letter == 'B' && line == ASCII_LINE_SEVEN) ? "888   d88P  " : "");
        System.out.print((letter == 'B' && line == ASCII_LINE_EIGHT) ? "8888888P\"   " : "");

        //
        System.out.print((letter == 'C' && line == ASCII_LINE_ONE)   ? " .d8888b.   " : "");
        System.out.print((letter == 'C' && line == ASCII_LINE_TWO)   ? "d88P  Y88b  " : "");
        System.out.print((letter == 'C' && line == ASCII_LINE_THREE) ? "888    888  " : "");
        System.out.print((letter == 'C' && line == ASCII_LINE_FOUR)  ? "888         " : "");
        System.out.print((letter == 'C' && line == ASCII_LINE_FIVE)  ? "888         " : "");
        System.out.print((letter == 'C' && line == ASCII_LINE_SIX)   ? "888    888  " : "");
        System.out.print((letter == 'C' && line == ASCII_LINE_SEVEN) ? "Y88b  d88P  " : "");
        System.out.print((letter == 'C' && line == ASCII_LINE_EIGHT) ? " \"Y8888P\"   " : "");

        //
        System.out.print((letter == 'D' && line == ASCII_LINE_ONE)   ? "8888888b.   " : "");
        System.out.print((letter == 'D' && line == ASCII_LINE_TWO)   ? "888  \"Y88b  " : "");
        System.out.print((letter == 'D' && line == ASCII_LINE_THREE) ? "888    888  " : "");
        System.out.print((letter == 'D' && line == ASCII_LINE_FOUR)  ? "888    888  " : "");
        System.out.print((letter == 'D' && line == ASCII_LINE_FIVE)  ? "888    888  " : "");
        System.out.print((letter == 'D' && line == ASCII_LINE_SIX)   ? "888    888  " : "");
        System.out.print((letter == 'D' && line == ASCII_LINE_SEVEN) ? "888  .d88P  " : "");
        System.out.print((letter == 'D' && line == ASCII_LINE_EIGHT) ? "8888888P\"   " : "");
        //
        System.out.print((letter == 'E' && line == ASCII_LINE_ONE)   ? "8888888888  " : "");
        System.out.print((letter == 'E' && line == ASCII_LINE_TWO)   ? "888         " : "");
        System.out.print((letter == 'E' && line == ASCII_LINE_THREE) ? "888         " : "");
        System.out.print((letter == 'E' && line == ASCII_LINE_FOUR)  ? "8888888     " : "");
        System.out.print((letter == 'E' && line == ASCII_LINE_FIVE)  ? "888         " : "");
        System.out.print((letter == 'E' && line == ASCII_LINE_SIX)   ? "888         " : "");
        System.out.print((letter == 'E' && line == ASCII_LINE_SEVEN) ? "888         " : "");
        System.out.print((letter == 'E' && line == ASCII_LINE_EIGHT) ? "8888888888  " : "");

        //
        System.out.print((letter == 'F' && line == ASCII_LINE_ONE)   ? "8888888888  " : "");
        System.out.print((letter == 'F' && line == ASCII_LINE_TWO)   ? "888         " : "");
        System.out.print((letter == 'F' && line == ASCII_LINE_THREE) ? "888         " : "");
        System.out.print((letter == 'F' && line == ASCII_LINE_FOUR)  ? "8888888     " : "");
        System.out.print((letter == 'F' && line == ASCII_LINE_FIVE)  ? "888         " : "");
        System.out.print((letter == 'F' && line == ASCII_LINE_SIX)   ? "888         " : "");
        System.out.print((letter == 'F' && line == ASCII_LINE_SEVEN) ? "888         " : "");
        System.out.print((letter == 'F' && line == ASCII_LINE_EIGHT) ? "888         " : "");

        //
        System.out.print((letter == 'G' && line == ASCII_LINE_ONE)   ? " .d8888b.   " : "");
        System.out.print((letter == 'G' && line == ASCII_LINE_TWO)   ? "d88P  Y88b  " : "");
        System.out.print((letter == 'G' && line == ASCII_LINE_THREE) ? "888    888  " : "");
        System.out.print((letter == 'G' && line == ASCII_LINE_FOUR)  ? "888         " : "");
        System.out.print((letter == 'G' && line == ASCII_LINE_FIVE)  ? "888  88888  " : "");
        System.out.print((letter == 'G' && line == ASCII_LINE_SIX)   ? "888    888  " : "");
        System.out.print((letter == 'G' && line == ASCII_LINE_SEVEN) ? "Y88b  d88P  " : "");
        System.out.print((letter == 'G' && line == ASCII_LINE_EIGHT) ? "\"Y8888P8\"   " : "");

        //
        System.out.print((letter == 'H' && line == ASCII_LINE_ONE)   ? "888    888  " : "");
        System.out.print((letter == 'H' && line == ASCII_LINE_TWO)   ? "888    888  " : "");
        System.out.print((letter == 'H' && line == ASCII_LINE_THREE) ? "888    888  " : "");
        System.out.print((letter == 'H' && line == ASCII_LINE_FOUR)  ? "8888888888  " : "");
        System.out.print((letter == 'H' && line == ASCII_LINE_FIVE)  ? "888    888  " : "");
        System.out.print((letter == 'H' && line == ASCII_LINE_SIX)   ? "888    888  " : "");
        System.out.print((letter == 'H' && line == ASCII_LINE_SEVEN) ? "888    888  " : "");
        System.out.print((letter == 'H' && line == ASCII_LINE_EIGHT) ? "888    888  " : "");

        //
        System.out.print((letter == 'I' && line == ASCII_LINE_ONE)   ? "8888888  " : "");
        System.out.print((letter == 'I' && line == ASCII_LINE_TWO)   ? "  888    " : "");
        System.out.print((letter == 'I' && line == ASCII_LINE_THREE) ? "  888    " : "");
        System.out.print((letter == 'I' && line == ASCII_LINE_FOUR)  ? "  888    " : "");
        System.out.print((letter == 'I' && line == ASCII_LINE_FIVE)  ? "  888    " : "");
        System.out.print((letter == 'I' && line == ASCII_LINE_SIX)   ? "  888    " : "");
        System.out.print((letter == 'I' && line == ASCII_LINE_SEVEN) ? "  888    " : "");
        System.out.print((letter == 'I' && line == ASCII_LINE_EIGHT) ? "8888888  " : "");

        //
        System.out.print((letter == 'J' && line == ASCII_LINE_ONE)   ? "  8888888  " : "");
        System.out.print((letter == 'J' && line == ASCII_LINE_TWO)   ? "     \"88b  " : "");
        System.out.print((letter == 'J' && line == ASCII_LINE_THREE) ? "     888   " : "");
        System.out.print((letter == 'J' && line == ASCII_LINE_FOUR)  ? "     888   " : "");
        System.out.print((letter == 'J' && line == ASCII_LINE_FIVE)  ? "     888   " : "");
        System.out.print((letter == 'J' && line == ASCII_LINE_SIX)   ? "   .d88P   " : "");
        System.out.print((letter == 'J' && line == ASCII_LINE_SEVEN) ? " .d88P\"    " : "");
        System.out.print((letter == 'J' && line == ASCII_LINE_EIGHT) ? "888P\"      " : "");

        //
        System.out.print((letter == 'K' && line == ASCII_LINE_ONE)   ? "888    d8P   " : "");
        System.out.print((letter == 'K' && line == ASCII_LINE_TWO)   ? "888   d8P    " : "");
        System.out.print((letter == 'K' && line == ASCII_LINE_THREE) ? "888  d8P     " : "");
        System.out.print((letter == 'K' && line == ASCII_LINE_FOUR)  ? "888d88K      " : "");
        System.out.print((letter == 'K' && line == ASCII_LINE_FIVE)  ? "8888888b     " : "");
        System.out.print((letter == 'K' && line == ASCII_LINE_SIX)   ? "888  Y88b    " : "");
        System.out.print((letter == 'K' && line == ASCII_LINE_SEVEN) ? "888   Y88b   " : "");
        System.out.print((letter == 'K' && line == ASCII_LINE_EIGHT) ? "888    Y88b  " : "");

        //
        System.out.print((letter == 'L' && line == ASCII_LINE_ONE)   ? "888       " : "");
        System.out.print((letter == 'L' && line == ASCII_LINE_TWO)   ? "888       " : "");
        System.out.print((letter == 'L' && line == ASCII_LINE_THREE) ? "888       " : "");
        System.out.print((letter == 'L' && line == ASCII_LINE_FOUR)  ? "888       " : "");
        System.out.print((letter == 'L' && line == ASCII_LINE_FIVE)  ? "888       " : "");
        System.out.print((letter == 'L' && line == ASCII_LINE_SIX)   ? "888       " : "");
        System.out.print((letter == 'L' && line == ASCII_LINE_SEVEN) ? "888       " : "");
        System.out.print((letter == 'L' && line == ASCII_LINE_EIGHT) ? "88888888  " : "");
        //
        System.out.print((letter == 'M' && line == ASCII_LINE_ONE)   ? "888b     d888  " : "");
        System.out.print((letter == 'M' && line == ASCII_LINE_TWO)   ? "8888b   d8888  " : "");
        System.out.print((letter == 'M' && line == ASCII_LINE_THREE) ? "88888b.d88888  " : "");
        System.out.print((letter == 'M' && line == ASCII_LINE_FOUR)  ? "888Y88888P888  " : "");
        System.out.print((letter == 'M' && line == ASCII_LINE_FIVE)  ? "888 Y888P 888  " : "");
        System.out.print((letter == 'M' && line == ASCII_LINE_SIX)   ? "888  Y8P  888  " : "");
        System.out.print((letter == 'M' && line == ASCII_LINE_SEVEN) ? "888   \"   888  " : "");
        System.out.print((letter == 'M' && line == ASCII_LINE_EIGHT) ? "888       888  " : "");

        //
        System.out.print((letter == 'N' && line == ASCII_LINE_ONE)   ? "888b    888  " : "");
        System.out.print((letter == 'N' && line == ASCII_LINE_TWO)   ? "8888b   888  " : "");
        System.out.print((letter == 'N' && line == ASCII_LINE_THREE) ? "88888b  888  " : "");
        System.out.print((letter == 'N' && line == ASCII_LINE_FOUR)  ? "888Y88b 888  " : "");
        System.out.print((letter == 'N' && line == ASCII_LINE_FIVE)  ? "888 Y88b888  " : "");
        System.out.print((letter == 'N' && line == ASCII_LINE_SIX)   ? "888  Y88888  " : "");
        System.out.print((letter == 'N' && line == ASCII_LINE_SEVEN) ? "888   Y8888  " : "");
        System.out.print((letter == 'N' && line == ASCII_LINE_EIGHT) ? "888    Y888  " : "");

        //
        System.out.print((letter == 'O' && line == ASCII_LINE_ONE)   ? " .d88888b.  " : "");
        System.out.print((letter == 'O' && line == ASCII_LINE_TWO)   ? "d88P\" \"Y88b  " : "");
        System.out.print((letter == 'O' && line == ASCII_LINE_THREE) ? "888     888  " : "");
        System.out.print((letter == 'O' && line == ASCII_LINE_FOUR)  ? "888     888  " : "");
        System.out.print((letter == 'O' && line == ASCII_LINE_FIVE)  ? "888     888  " : "");
        System.out.print((letter == 'O' && line == ASCII_LINE_SIX)   ? "888     888  " : "");
        System.out.print((letter == 'O' && line == ASCII_LINE_SEVEN) ? "Y88b. .d88P  " : "");
        System.out.print((letter == 'O' && line == ASCII_LINE_EIGHT) ? " \"Y88888P\"   " : "");

        //
        System.out.print((letter == 'P' && line == ASCII_LINE_ONE)   ? " 8888888b.  " : "");
        System.out.print((letter == 'P' && line == ASCII_LINE_TWO)   ? "888   Y88b  " : "");
        System.out.print((letter == 'P' && line == ASCII_LINE_THREE) ? "888    888  " : "");
        System.out.print((letter == 'P' && line == ASCII_LINE_FOUR)  ? "888   d88P  " : "");
        System.out.print((letter == 'P' && line == ASCII_LINE_FIVE)  ? "8888888P\"   " : "");
        System.out.print((letter == 'P' && line == ASCII_LINE_SIX)   ? "888         " : "");
        System.out.print((letter == 'P' && line == ASCII_LINE_SEVEN) ? "888         " : "");
        System.out.print((letter == 'P' && line == ASCII_LINE_EIGHT) ? "888         " : "");

        //
        System.out.print((letter == 'Q' && line == ASCII_LINE_ONE)   ? "  .d88888b.   " : "");
        System.out.print((letter == 'Q' && line == ASCII_LINE_TWO)   ? "d88P\" \"Y88b  " : "");
        System.out.print((letter == 'Q' && line == ASCII_LINE_THREE) ? "888     888  " : "");
        System.out.print((letter == 'Q' && line == ASCII_LINE_FOUR)  ? "888     888  " : "");
        System.out.print((letter == 'Q' && line == ASCII_LINE_FIVE)  ? "888 Y8b 888  " : "");
        System.out.print((letter == 'Q' && line == ASCII_LINE_SIX)   ? "Y88b.Y8b88P  " : "");
        System.out.print((letter == 'Q' && line == ASCII_LINE_SEVEN) ? " \"Y888888\"   " : "");
        System.out.print((letter == 'Q' && line == ASCII_LINE_EIGHT) ? "        Y8b  " : "");

        //
        System.out.print((letter == 'R' && line == ASCII_LINE_ONE)   ? "8888888b.   " : "");
        System.out.print((letter == 'R' && line == ASCII_LINE_TWO)   ? "888   Y88b  " : "");
        System.out.print((letter == 'R' && line == ASCII_LINE_THREE) ? "888    888  " : "");
        System.out.print((letter == 'R' && line == ASCII_LINE_FOUR)  ? "888   d88P  " : "");
        System.out.print((letter == 'R' && line == ASCII_LINE_FIVE)  ? "8888888P\"   " : "");
        System.out.print((letter == 'R' && line == ASCII_LINE_SIX)   ? "888 T88b    " : "");
        System.out.print((letter == 'R' && line == ASCII_LINE_SEVEN) ? "888  T88b   " : "");
        System.out.print((letter == 'R' && line == ASCII_LINE_EIGHT) ? "888   T88b  " : "");

        //
        System.out.print((letter == 'S' && line == ASCII_LINE_ONE)   ? " .d8888b.   " : "");
        System.out.print((letter == 'S' && line == ASCII_LINE_TWO)   ? "d88P  Y88b  " : "");
        System.out.print((letter == 'S' && line == ASCII_LINE_THREE) ? "Y88b.       " : "");
        System.out.print((letter == 'S' && line == ASCII_LINE_FOUR)  ? " \"Y888b.    " : "");
        System.out.print((letter == 'S' && line == ASCII_LINE_FIVE)  ? "   \"Y88b.   " : "");
        System.out.print((letter == 'S' && line == ASCII_LINE_SIX)   ? "      \"888  " : "");
        System.out.print((letter == 'S' && line == ASCII_LINE_SEVEN) ? "Y88b  d88P  " : "");
        System.out.print((letter == 'S' && line == ASCII_LINE_EIGHT) ? " \"Y8888P\"   " : "");

        //
        System.out.print((letter == 'T' && line == ASCII_LINE_ONE)   ? "88888888888  " : "");
        System.out.print((letter == 'T' && line == ASCII_LINE_TWO)   ? "    888      " : "");
        System.out.print((letter == 'T' && line == ASCII_LINE_THREE) ? "    888      " : "");
        System.out.print((letter == 'T' && line == ASCII_LINE_FOUR)  ? "    888      " : "");
        System.out.print((letter == 'T' && line == ASCII_LINE_FIVE)  ? "    888      " : "");
        System.out.print((letter == 'T' && line == ASCII_LINE_SIX)   ? "    888      " : "");
        System.out.print((letter == 'T' && line == ASCII_LINE_SEVEN) ? "    888      " : "");
        System.out.print((letter == 'T' && line == ASCII_LINE_EIGHT) ? "    888      " : "");

        //
        System.out.print((letter == 'U' && line == ASCII_LINE_ONE)   ? "888     888  " : "");
        System.out.print((letter == 'U' && line == ASCII_LINE_TWO)   ? "888     888  " : "");
        System.out.print((letter == 'U' && line == ASCII_LINE_THREE) ? "888     888  " : "");
        System.out.print((letter == 'U' && line == ASCII_LINE_FOUR)  ? "888     888  " : "");
        System.out.print((letter == 'U' && line == ASCII_LINE_FIVE)  ? "888     888  " : "");
        System.out.print((letter == 'U' && line == ASCII_LINE_SIX)   ? "888     888  " : "");
        System.out.print((letter == 'U' && line == ASCII_LINE_SEVEN) ? "Y88b. .d88P  " : "");
        System.out.print((letter == 'U' && line == ASCII_LINE_EIGHT) ? " \"Y88888P\"   " : "");

        //
        System.out.print((letter == 'V' && line == ASCII_LINE_ONE)   ? "888     888  " : "");
        System.out.print((letter == 'V' && line == ASCII_LINE_TWO)   ? "888     888  " : "");
        System.out.print((letter == 'V' && line == ASCII_LINE_THREE) ? "888     888  " : "");
        System.out.print((letter == 'V' && line == ASCII_LINE_FOUR)  ? "Y88b   d88P  " : "");
        System.out.print((letter == 'V' && line == ASCII_LINE_FIVE)  ? " Y88b d88P   " : "");
        System.out.print((letter == 'V' && line == ASCII_LINE_SIX)   ? "  Y88o88P    " : "");
        System.out.print((letter == 'V' && line == ASCII_LINE_SEVEN) ? "   Y888P     " : "");
        System.out.print((letter == 'V' && line == ASCII_LINE_EIGHT) ? "     V       " : "");

        //
        System.out.print((letter == 'W' && line == ASCII_LINE_ONE)   ? "888       888  " : "");
        System.out.print((letter == 'W' && line == ASCII_LINE_TWO)   ? "888   o   888  " : "");
        System.out.print((letter == 'W' && line == ASCII_LINE_THREE) ? "888  d8b  888  " : "");
        System.out.print((letter == 'W' && line == ASCII_LINE_FOUR)  ? "888 d888b 888  " : "");
        System.out.print((letter == 'W' && line == ASCII_LINE_FIVE)  ? "888d88888b888  " : "");
        System.out.print((letter == 'W' && line == ASCII_LINE_SIX)   ? "88888P Y88888  " : "");
        System.out.print((letter == 'W' && line == ASCII_LINE_SEVEN) ? "8888P   Y8888  " : "");
        System.out.print((letter == 'W' && line == ASCII_LINE_EIGHT) ? "888P     Y888  " : "");

        //
        System.out.print((letter == 'X' && line == ASCII_LINE_ONE)   ? "Y88b   d88P  " : "");
        System.out.print((letter == 'X' && line == ASCII_LINE_TWO)   ? " Y88b d88P   " : "");
        System.out.print((letter == 'X' && line == ASCII_LINE_THREE) ? "  Y88o88P    " : "");
        System.out.print((letter == 'X' && line == ASCII_LINE_FOUR)  ? "   Y888P     " : "");
        System.out.print((letter == 'X' && line == ASCII_LINE_FIVE)  ? "   d888b     " : "");
        System.out.print((letter == 'X' && line == ASCII_LINE_SIX)   ? "  d88888b    " : "");
        System.out.print((letter == 'X' && line == ASCII_LINE_SEVEN) ? " d88P Y88b   " : "");
        System.out.print((letter == 'X' && line == ASCII_LINE_EIGHT) ? "d88P   Y88b  " : "");

        //
        System.out.print((letter == 'Y' && line == ASCII_LINE_ONE)   ? "Y88b   d88Y  " : "");
        System.out.print((letter == 'Y' && line == ASCII_LINE_TWO)   ? " Y88b d88Y   " : "");
        System.out.print((letter == 'Y' && line == ASCII_LINE_THREE) ? "  Y88o88Y    " : "");
        System.out.print((letter == 'Y' && line == ASCII_LINE_FOUR)  ? "   Y888Y     " : "");
        System.out.print((letter == 'Y' && line == ASCII_LINE_FIVE)  ? "    888      " : "");
        System.out.print((letter == 'Y' && line == ASCII_LINE_SIX)   ? "    888      " : "");
        System.out.print((letter == 'Y' && line == ASCII_LINE_SEVEN) ? "    888      " : "");
        System.out.print((letter == 'Y' && line == ASCII_LINE_EIGHT) ? "    888      " : "");

        //
        System.out.print((letter == 'Z' && line == ASCII_LINE_ONE)   ? "8888888888P  " : "");
        System.out.print((letter == 'Z' && line == ASCII_LINE_TWO)   ? "      d88P   " : "");
        System.out.print((letter == 'Z' && line == ASCII_LINE_THREE) ? "     d88P    " : "");
        System.out.print((letter == 'Z' && line == ASCII_LINE_FOUR)  ? "    d88P     " : "");
        System.out.print((letter == 'Z' && line == ASCII_LINE_FIVE)  ? "   d88P      " : "");
        System.out.print((letter == 'Z' && line == ASCII_LINE_SIX)   ? "  d88P       " : "");
        System.out.print((letter == 'Z' && line == ASCII_LINE_SEVEN) ? " d88P        " : "");
        System.out.print((letter == 'Z' && line == ASCII_LINE_EIGHT) ? "d8888888888  " : "");

        //
        System.out.print((letter == '!' && line == ASCII_LINE_ONE)   ? "888 " : "");
        System.out.print((letter == '!' && line == ASCII_LINE_TWO)   ? "888 " : "");
        System.out.print((letter == '!' && line == ASCII_LINE_THREE) ? "888 " : "");
        System.out.print((letter == '!' && line == ASCII_LINE_FOUR)  ? "888 " : "");
        System.out.print((letter == '!' && line == ASCII_LINE_FIVE)  ? "888 " : "");
        System.out.print((letter == '!' && line == ASCII_LINE_SIX)   ? "Y8Y " : "");
        System.out.print((letter == '!' && line == ASCII_LINE_SEVEN) ? " ^  " : "");
        System.out.print((letter == '!' && line == ASCII_LINE_EIGHT) ? "888 " : "");

    }
}

/*

        PERSONAL NOTES FOR LATER USE OR MEMORIZATION

        \t  Insert a tab in the text at this point.
        \b  Insert a backspace in the text at this point.
        \n  Insert a newline in the text at this point.
        \r  Insert a carriage return in the text at this point.
        \f  Insert a formfeed in the text at this point.
        \'  Insert a single quote character in the text at this point.
        \"  Insert a double quote character in the text at this point.
        \\  Insert a backslash character in the text at this point.

        //Ternary Operator Syntax:

        myFunc( (COND ? defaultValue : altValue) );
        variable = (COND ? defaultValue : altValue());

        if(keyboardScanner.hasNext()) {

            String userGuess = keyboardScanner.next();
            System.out.println("you typed " + userGuess);

        }
 */