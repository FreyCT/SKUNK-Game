import java.util.ArrayList;
/**
 * @author Frey COMP 1451
 * @version Assignment 0, Game.java
 */
public abstract class Game {

    private ArrayList<Player> players;

    public static final int     INDEX_OFFSET        = 1;
    public static final int     NOVICE_DIFFICULTY   = 1;
    public static final int     MEDIUM_DIFFICULTY   = 2;
    public static final int     FULL_PAGE_BREAK     = 50;
    public static final int     SINGLE_PLAYER       = 1;
    public static final int     END_PROGRAM         = 0;
    public static final String  MISTAKE_WORD        = "undo";
    public static final String  FINISHED_WORD       = "done";
    public static final String  QUIT_WORD           = "Q";
    public static final String  EXAMPLE_NAME        = "Pander";
    public static final String  DEFAULT_NAME        = "Loner";
    public static final String  TAB                 = "\t";

    public Game(){
        players = new ArrayList<>();

        System.out.println("Welcome.\n");
        System.out.println("Enter the usernames of the players participating one at a time. E.g \"" + EXAMPLE_NAME + "\" \n");
        System.out.println("Type: \"" + MISTAKE_WORD + "\" if you made a mistake and want to re-enter the username.");
        System.out.println("Type: \"" + FINISHED_WORD + "\" when finished to continue, or \"" + QUIT_WORD + "\" to quit.");

        addPlayers();

        System.out.println("Would you like to play with a CPU? Type \"yes\" or \"no\"");

        if (ScannerUtility.getYesOrNo()){
            addArtificialPlayer();
        }

        for (int i = 0; i < INDEX_OFFSET; i++){
            if (players.size() == 0){
                System.out.println("There are no players at all! A computer players have been made.");
                players.add(new SKUNKArtificialPlayer(EXAMPLE_NAME, MEDIUM_DIFFICULTY));
                i -= INDEX_OFFSET;
            }
            else if (players.size() == SINGLE_PLAYER){
                System.out.println("A player cant play the game on your own. Another computer player was created for to play with. \n" +
                        "Enter any key to continue: ");
                players.add(new SKUNKArtificialPlayer(DEFAULT_NAME, MEDIUM_DIFFICULTY));
                ScannerUtility.getInput();
            }
        }
    }

    /**
     *
     * @param players The list of players added
     * @param username the desired username of a player
     * @return True if no duplicate player names
     */
    public boolean noDuplicatePlayers(ArrayList<Player> players, String username){
        boolean duplicate = true;
        for (Player p : players){
            if (p.getUsername().equalsIgnoreCase(username)){
                duplicate = false;
            }
        }
        return duplicate;
    }

    public void addPlayers(){

        boolean setup = true;

        while (setup){                                                                  //Intake of players

            String input = ScannerUtility.getInput();
            System.out.println("You typed: " + input);

            if (!input.equalsIgnoreCase(MISTAKE_WORD) && !input.equalsIgnoreCase(FINISHED_WORD) && noDuplicatePlayers(players, input)){

                players.add(new SKUNKPlayer(input));
                System.out.println(input + " has been added to the game.");
            }
            else if (input.equalsIgnoreCase(MISTAKE_WORD) && players.size() > 0){

                System.out.println("Removing player: " + players.get(players.size()-INDEX_OFFSET).getUsername());
                players.remove(players.size()-INDEX_OFFSET);
            }
            else if (input.equalsIgnoreCase(FINISHED_WORD)){
                setup = false;
            }
            else if (input.equalsIgnoreCase(QUIT_WORD)){
                System.exit(END_PROGRAM);
            }
        }
    }

    public void addArtificialPlayer(){

        boolean setup = true;

        System.out.print("Give the CPU a name: ");
        while (setup){

            String input = ScannerUtility.getInput();

            if (!input.equalsIgnoreCase(MISTAKE_WORD) && !input.equalsIgnoreCase(FINISHED_WORD) && noDuplicatePlayers(players, input)){

                System.out.println("\nChoose a difficulty from levels " + NOVICE_DIFFICULTY + "-" + MEDIUM_DIFFICULTY + ". e.g \"" + MEDIUM_DIFFICULTY + "\"");
                players.add(new SKUNKArtificialPlayer(input, ScannerUtility.getIntBetween(NOVICE_DIFFICULTY, MEDIUM_DIFFICULTY)));
                System.out.println(input + "Bot has been added to the game.");
            }
            else if (input.equalsIgnoreCase(MISTAKE_WORD) && players.size() > 0){

                System.out.println("Removing ArtificialPlayer: " + players.get(players.size()-INDEX_OFFSET).getUsername());
                players.remove(players.size()-INDEX_OFFSET);
            }
            else if (input.equalsIgnoreCase(FINISHED_WORD)){
                setup = false;
            }
            else if (input.equalsIgnoreCase(QUIT_WORD)){
                System.exit(END_PROGRAM);
            }
            if (setup){
                System.out.println("Type: \"" + MISTAKE_WORD + "\" if you made a mistake and want to re-enter the username.");
                System.out.print("You may enter another CPU or type: \"" + FINISHED_WORD + "\" when finished to continue");
                System.out.println(", or \"" + QUIT_WORD + "\" to quit.");
            }
        }
    }

    /**
     *
     * @return The list of players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public abstract void printRules();

    public void printDetails(){
    System.out.println("Usernames" + TAB + "|" + TAB + "Scores" + TAB + "|");
    System.out.println("============+===========+");

        for (Player p : players) {

            String tab = ASCIIArt.getTabs(p.getUsername().length());

            if (p.getClass().getSimpleName().equalsIgnoreCase("SKUNKPlayer")){
                SKUNKPlayer s = (SKUNKPlayer)p;
                System.out.println(p.getUsername() + tab + "|" + TAB + s.getPlayerScore().getScore() + TAB + TAB + "|");
            }
            else {
                SKUNKArtificialPlayer s = (SKUNKArtificialPlayer)p;
                System.out.println(p.getUsername() + tab + "|" + TAB + s.getPlayerScore().getScore() + TAB + TAB + "|");
            }
            System.out.println("------------+-----------+");
        }
    }
}