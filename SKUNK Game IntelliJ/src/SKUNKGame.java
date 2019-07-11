import java.util.ArrayList;
/**
 * @author Frey COMP 1451
 * @version Assignment 0, SKUNKGame.java
 */
public class SKUNKGame extends Game {

    private String          winningPlayer;
    private int             eyeCount;
    private int             roundPoints;
    private int             sitCount;
    private int             diceFaces;
    private ArrayList<Dice> diceSet;

    public static final int     MINIMUM_STANDARD_DICE = 2;
    public static final int     MAXIMUM_STANDARD_DICE = 3;
    public static final int     STANDARD_DICE_FACES   = 6;
    public static final int     SKUNK_ROUNDS          = 5;
    public static final int     SNAKE_EYE             = 1;
    public static final int     SNAKE_EYES            = 2;
    public static final int     LUCKY_NUMBER          = 3;
    public static final int     BONUS_POINTS          = 100;
    public static final int     NO_SNAKE_EYES         = 0;
    public static final int     POINTS_RESET          = 0;
    public static final int     NO_SITTERS            = 0;
    public static final int     SITTING               = 1;
    public static final int     UNEXPECTED_ROUND      =-1;
    public static final int     ROUND_S               = 0;
    public static final int     ROUND_K               = 1;
    public static final int     ROUND_U               = 2;
    public static final int     ROUND_N               = 3;
    public static final String  PARTICIPATING         = "Standing";
    public static final String  NOT_PARTICIPATING     = "Sitting";
    public static final String  IS_WINNER             = "Wins!!";

    /**
     * The SKUNKGame() constructor calls the super class
     * and sets up the game by guiding the user through a step by step process.
     */
    public SKUNKGame(){

        super();
        diceSet = new ArrayList<>();
        System.out.println("If you would like to play a customized game of SKUNK, enter: \"YES\"");
        System.out.println("Or enter any other key if you would like to play a standard game of SKUNK.\n");

        if (ScannerUtility.getInput().equalsIgnoreCase("yes")){
            customGameSetup();
        }
        else {

            diceFaces = STANDARD_DICE_FACES;
            standardGameSetup();
        }
        setRoundPoints(POINTS_RESET);
        setSitCount(NO_SITTERS);
        setEyeCount(NO_SNAKE_EYES);
    }

    /**
     * The standardGameSetup() method prompts the user the amount of dice to use for a standard game
     */
    private void standardGameSetup(){

        System.out.println("Would you like to use " + MINIMUM_STANDARD_DICE + " or " + MAXIMUM_STANDARD_DICE + " dice?\n");

        setDiceSet(ScannerUtility.getIntBetween(MINIMUM_STANDARD_DICE, MAXIMUM_STANDARD_DICE) == MINIMUM_STANDARD_DICE
                ? MINIMUM_STANDARD_DICE : MAXIMUM_STANDARD_DICE);
    }

    /**
     * The customGameSetup() method prompts the user how many dice should be used and the number of faces on the dice
     */
    private void customGameSetup(){

        System.out.println("Enter the number of dice you would like to use. (Minimum (" + MINIMUM_STANDARD_DICE + ") dice\n");
        int dice = ScannerUtility.getInt(MINIMUM_STANDARD_DICE);

        if (dice > MAXIMUM_STANDARD_DICE){
            System.out.println("Recommendation: Increase the amount of faces on each die for better game functionality.\n");
        }

        System.out.println("Would you like to change how many faces are on the dice? Enter: \"YES\"/\"NO\" \n");

        if (ScannerUtility.getYesOrNo()){
            System.out.println("Enter the number of faces desired for your dice (Minimum " + STANDARD_DICE_FACES + " faces) \n");
            diceFaces = ScannerUtility.getInt(STANDARD_DICE_FACES);
        }

        setDiceSet(dice);
    }

    /**
     * The start() method initiates the game and announces the winner in the end.
     */
    public void start(){

        for (int i = 0; i < SKUNK_ROUNDS; i++) {

            for (Player p : getPlayers()){
                setPlayerParticipation(p, true, i);
            }
            round(i);
        }

        ASCIIArt.pageBreak(FULL_PAGE_BREAK);
        printDetails();
        printWord(getWinningPlayer());
        printWord(IS_WINNER);
        System.out.println("Play again? \"YES\" / \"NO\"");

        if (ScannerUtility.getYesOrNo()){

            for (Player p : getPlayers()){

                setPlayerParticipation(p, true, 0);

                if (p.getClass().getSimpleName().equalsIgnoreCase("SKUNKPlayer") && getPlayerParticipation(p)){
                    ((SKUNKPlayer)p).getPlayerScore().snakeEyes();
                    System.out.println(p.getUsername() + " was reset");
                    setPlayerParticipation(p, false, 0);

                }
                else if (p.getClass().getSimpleName().equalsIgnoreCase("SKUNKArtificialPlayer") && getPlayerParticipation(p)){
                    ((SKUNKArtificialPlayer)p).getPlayerScore().snakeEyes();
                    System.out.println(p.getUsername() + " was reset");
                }
            }
            start();
        }
    }

    /**
     *
     * @return The set of dice used for game-play
     */
    public ArrayList<Dice> getDiceSet() {
        return diceSet;
    }

    /**
     *
     * @param diceAmount The amount of die used for the game
     */
    public void setDiceSet(int diceAmount) {

        for (int i = 0; i < diceAmount; i++){
            diceSet.add(new Dice(diceFaces));
        }
    }

    /**
     *
     * @return The amount of "ones" rolled in the set of dice
     */
    public int getEyeCount() {
        return eyeCount;
    }

    /**
     *
     * @param eyeCount The amount of "ones" rolled in the set of dice
     */
    public void setEyeCount(int eyeCount) {
        this.eyeCount = eyeCount;
    }

    /**
     *
     * @return The points accumulated during the round
     */
    public int getRoundPoints() {
        return roundPoints;
    }

    /**
     *
     * @param roundPoints The points being added from the set of rolled dice
     */
    public void setRoundPoints(int roundPoints) {
        this.roundPoints = roundPoints;
    }

    /**
     *
     * @return The amount of people sitting during the round
     */
    public int getSitCount() {
        return sitCount;
    }

    /**
     *
     * @param sitCount The amount of people who decided to sit
     */
    public void setSitCount(int sitCount) {
        this.sitCount = sitCount;
    }

    /**
     *
     * @return The username of the winning player
     */
    public String getWinningPlayer() {
        getHighestScore();
        return winningPlayer;
    }

    /**
     *
     * @param winningPlayer the user name of the player with the highest score
     */
    public void setWinningPlayer(String winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    /**
     *
     * @param round The current round being played
     */
    public void round(int round){

        setSitCount(NO_SITTERS);
        boolean playing = true;

        while (playing){

            String letter = (round == ROUND_S)?"S":(round == ROUND_K)?"K":(round == ROUND_U)?"U":(round == ROUND_N)?"N":"K";
            int points = readDice();
            ASCIIArt.pageBreak(FULL_PAGE_BREAK);

            System.out.println("\tROUND " + letter);
            printDiceRolls();
            System.out.println("Points accumulated for Round " + letter + ": " + (getRoundPoints() + points) + " (" + getRoundPoints() + " + " + points + ")");

            if (getSitCount() == getPlayers().size()){

                setRoundPoints(POINTS_RESET);
                playing = false;
            }
            else if (getEyeCount() == LUCKY_NUMBER){

                points += BONUS_POINTS;
                setRoundPoints(getRoundPoints() + points);
                printDetails();
                sit(round);
            }
            else if (getEyeCount() == SNAKE_EYE){

                printDetails();
                playing = (getSitCount() == NO_SITTERS);
                System.out.println((playing) ? "Everyone was still standing, so we'll keep going." : "");
                setRoundPoints(playing ? getRoundPoints() : POINTS_RESET);
                if (!playing){
                    System.out.println("Unlucky, enter any key to continue: ");
                    ScannerUtility.getInput();
                }
                roll();
            }
            else if (getEyeCount() == SNAKE_EYES || getEyeCount() > LUCKY_NUMBER){

                printDetails();
                playing = (getSitCount() == NO_SITTERS);
                System.out.println((playing) ? "Everyone was still standing, so we'll keep going." : "");
                setRoundPoints(playing ? getRoundPoints() : POINTS_RESET);

                if (getSitCount() != NO_SITTERS){
                    System.out.println(getSitCount() + "==" + NO_SITTERS); // remove this
                    totalScoreResetToZero();
                    System.out.print("Ouch, enter any key to continue: ");
                    ScannerUtility.getInput();
                }
                roll();
            }
            else{
                setRoundPoints(getRoundPoints() + points);
                printDetails();
                sit(round);
            }
            setEyeCount(NO_SNAKE_EYES);
        }

    }

    public void roll(){

        for (Dice d : getDiceSet()){
            d.reRoll();
        }
    }

    /**
     *
     * @return The amount of points from the dice roll
     */
    public int readDice(){
        int points = POINTS_RESET;
        boolean snakes = false;

        for (Dice d : getDiceSet()) {

            if (d.getRoll() != SNAKE_EYE && !snakes){
                points += d.getRoll();
            }
            else if (d.getRoll() == SNAKE_EYE){
                setEyeCount(getEyeCount() + SNAKE_EYE);
                points = POINTS_RESET;
                snakes = true;
            }
        }
        return points;
    }

    /**
     * The totalScoreResetToZero() method sets all player scores to zero if they're standing
     */
    public void totalScoreResetToZero(){

        for (Player p : getPlayers()){

            if (p.getClass().getSimpleName().equalsIgnoreCase("SKUNKPlayer") && getPlayerParticipation(p)){
                ((SKUNKPlayer)p).getPlayerScore().snakeEyes();
                System.out.println(p.getUsername() + " was reset");
            }
            else if (p.getClass().getSimpleName().equalsIgnoreCase("SKUNKArtificialPlayer") && getPlayerParticipation(p)){
                ((SKUNKArtificialPlayer)p).getPlayerScore().snakeEyes();
                System.out.println(p.getUsername() + " was reset");
            }
        }
    }

    /**
     *
     * @param round The current round in play.
     */
    public void sit(int round) {

        boolean choosing = true;

        roll();
        readDice();

        for (Player p : getPlayers()){                                                                                  //CPU calculations must be outside of the while loop or they will have
                                                                                                                        //multiple calculations per turn when they should only have one.
            if (p.getClass().getSimpleName().equals("SKUNKArtificialPlayer") && getPlayerParticipation(p)){

                ((SKUNKArtificialPlayer)p).setParticipate(getRoundPoints(), ((SKUNKArtificialPlayer)p).getPlayerScore().getScore(),
                        getHighestScore(), getSitCount(), (getEyeCount() >= SNAKE_EYE && getEyeCount() != LUCKY_NUMBER));

                setSitCount(!getPlayerParticipation(p) ? getSitCount() + SITTING: getSitCount());
                System.out.print((getPlayerParticipation(p)) ? p.getUsername() +  " stayed standing," : p.getUsername() + " Sat down. ");
                recordRoundScore(p, getPlayerParticipation(p) ? UNEXPECTED_ROUND : round);
            }
        }
        System.out.println();
        System.out.println("Enter the usernames of those who want to sit. e.g \"" + EXAMPLE_NAME + "\"");
        System.out.println("Enter \"" + FINISHED_WORD + "\" to start the next roll, or \"" + QUIT_WORD + "\" to quit.\n");

        while (choosing){

            String username = ScannerUtility.getInput();

            for (Player p : getPlayers()) {

                if (p.getUsername().equalsIgnoreCase(username) && getPlayerParticipation(p) && p.getClass().getSimpleName().equals("SKUNKPlayer")) {
                    setPlayerParticipation(p, false, round);
                    setSitCount(!getPlayerParticipation(p) ? getSitCount() + SITTING : getSitCount());

                }
                else if (p.getUsername().equalsIgnoreCase(username)) {
                    System.out.println(p.getUsername() + " is already sitting. " + getPlayerParticipation(p));
                }
            }

            if (username.equalsIgnoreCase(FINISHED_WORD)) {
                choosing = false;
            }
            else if (username.equalsIgnoreCase(QUIT_WORD)){
                System.exit(END_PROGRAM);
            }
        }
    }

    /**
     *
     * @param p The Player
     * @param participation True = standing, else Sitting
     * @param round The current round in play
     */
    public void setPlayerParticipation(Player p, boolean participation, int round){

        if (p.getClass().getSimpleName().equals("SKUNKPlayer")){
            ((SKUNKPlayer)p).setParticipate(participation);
        }
        else if (participation){

            ((SKUNKArtificialPlayer)p).setParticipate(true);
        }

        if (!getPlayerParticipation(p)){

            System.out.println(p.getUsername() + " Sat down. ");
            recordRoundScore(p, round);
        }
    }

    /**
     *
     * @param p The Player
     * @param round The current round in play
     */
    public void recordRoundScore(Player p, int round){

        if (p.getClass().getSimpleName().equalsIgnoreCase("SKUNKPlayer")){
            ((SKUNKPlayer)p).getPlayerScore().recordRoundScore(getRoundPoints(),round);
            System.out.println(p.getUsername() + "'s score has been recorded.");
        }
        else {
            ((SKUNKArtificialPlayer)p).getPlayerScore().recordRoundScore(getRoundPoints(),round);
            System.out.println(getPlayerParticipation(p) ? "" : (p.getUsername() + "'s score has been recorded.") );
        }
    }

    /**
     *
     * @param p The Player
     * @return True if the player is standing
     */
    public boolean getPlayerParticipation(Player p){
        return ((p.getClass().getSimpleName().equals("SKUNKPlayer"))) ? ((SKUNKPlayer)p).isParticipate() : ((SKUNKArtificialPlayer)p).isParticipate();
    }

    /**
     *
     * @return The highest player score
     */
    public int getHighestScore(){

        int highestScore = POINTS_RESET;

        for (Player p : getPlayers()){

            if (p.getClass().getSimpleName().equals("SKUNKPlayer")){

                if (highestScore < ((SKUNKPlayer)p).getPlayerScore().getScore()){
                    highestScore = ((SKUNKPlayer)p).getPlayerScore().getScore();
                    setWinningPlayer(p.getUsername());
                }
            }
            else if (highestScore < ((SKUNKArtificialPlayer)p).getPlayerScore().getScore()){
                highestScore = ((SKUNKArtificialPlayer)p).getPlayerScore().getScore();
                setWinningPlayer(p.getUsername());
            }
        }
        return highestScore;
    }

    /**
     *
     * @param word The word being printed in ASCII Art
     */
    public void printWord(String word){

        char[] CharArray = new char[word.length()];

        for (int i = 0; i < word.length(); i++){
            CharArray[i] = word.toUpperCase().charAt(i);
        }

        for (int i = 0; i < ASCIIArt.CHAR_HEIGHT_LINES; i++){

            for (char c : CharArray){
                ASCIIArt.printString(c, i);

            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    public void printDiceRolls(){

        for (int i = 0; i < ASCIIArt.DICE_HEIGHT_LINES; i++){

            for (Dice d : getDiceSet()){
                ASCIIArt.printDiceFaces(d.getRoll(), i);
            }
            System.out.println();
        }

        System.out.println();

    }

    @Override
    public void printRules() {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<RULES>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        System.out.println("Each letter of \"SKUNK\" represents a different round of the\n" +
                "game; play begins with the \"S\" column and continues through\n" +
                "the \"K\" column. The objective of \"SKUNK\" is to accumulate\n" +
                "the greatest possible point total over the five rounds. \n" +
                "The rules for play are the same for each of the five rounds.\n");
        System.out.println("To accumulate points in a given round, some dice are rolled, \n" +
                "and standing players can sit down for the round to record their score.\n");
        System.out.println("-\tRolling a \"one\" will end the round and anyone still\n" +
                "\tstanding will not record their points.\n");
        System.out.println("-\tRolling \"snake-eyes\" will end the round and anyone still\n" +
                "\tstanding will lose all their points including previous rounds.\n");
        System.out.println("-\tIf all the players are standing, rolling any ones will\n" +
                "\tnot negatively affect anyone and the round will not end.\n");
        System.out.println("-\tRolling \"triple-ones\" is worth 100 points.\n");
        System.out.println("-\tIf all the players sit and record their scores, the round will end.\n\n");
    }

    @Override
    public void printDetails(){

        //ASCIIArt.pageBreak(FULL_PAGE_BREAK);
        //ASCIIArt.SkunkLogo();
        System.out.println("+===========+===========+===========+===========+===========+===========+===========+===========+");
        System.out.println("|" + "Usernames" + TAB + "|" + TAB + "S" + TAB + TAB + "|" + TAB + "K" + TAB + TAB + "|" + TAB
                + "U" + TAB + TAB + "|" + TAB + "N" + TAB + TAB + "|" + TAB + "K" + TAB + TAB + "|" + TAB + "Score" + TAB + "|" + TAB + "Position" + "|");
        System.out.println("+===========+===========+===========+===========+===========+===========+===========+===========+");

        for (Player p : getPlayers()) {

            String tab = ASCIIArt.getTabs(p.getUsername().length() + INDEX_OFFSET);
            String position = (getPlayerParticipation(p)) ? PARTICIPATING : NOT_PARTICIPATING;

            System.out.print("|" + p.getUsername() + tab + "|");

            if (p.getClass().getSimpleName().equalsIgnoreCase("SKUNKPlayer")){
                ((SKUNKPlayer)p).getPlayerScore().printScore();
            }
            else {
                ((SKUNKArtificialPlayer)p).getPlayerScore().printScore();
            }

            System.out.print(TAB + position + (position.equals(PARTICIPATING) ? "|" : " |"));

            System.out.println("\n+-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+");
        }
    }
}