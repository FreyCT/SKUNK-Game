import java.util.Random;
/**
 * @author Frey COMP 1451
 * @version Assignment 0, SKUNKArtificialPlayer.java
 */
public class SKUNKArtificialPlayer extends Player {
    private int                 difficulty;
    private boolean             participate;
    private SKUNKScore          playerScore;
    private Random              rand;

    public static final int     NOVICE_DIFFICULTY   = 1;
    public static final int     MEDIUM_DIFFICULTY   = 2;
    public static final int     EARLY_SIT           = 1;
    public static final int     DECENT_CASH_IN      = 50;
    public static final int     INDEX_OFFSET        = 1;
    public static final int     CHANCE_BASE         = 100;
    public static final int     MEDIUM_CHANCE       = 85;
    public static final int     NOVICE_CHANCE       = 55;

    /**
     *
     * @param username The username for the artificial player
     * @param difficulty The difficulty set for the artificial player
     */
    public SKUNKArtificialPlayer(final String username, final int difficulty){

        super(username + "Bot");

        setDifficulty(difficulty);
        setParticipate(true);

        setplayerScore(new SKUNKScore());
        rand        = new Random();

    }

    /**
     *
     * @return The difficulty for the artificial player
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     *
     * @param difficulty The difficulty for the artificial player
     */
    private void setDifficulty(final int difficulty) {
        if (difficulty >= NOVICE_DIFFICULTY && difficulty <= MEDIUM_DIFFICULTY){
            this.difficulty = difficulty;
        }
        else {
            throw new IllegalArgumentException("Invalid level of difficulty.");
        }
    }

    /**
     *
     * @return True if the artificial player is standing
     */
    public boolean isParticipate() {
        return participate;
    }

    /**
     *
     * @param participate True if the artificial player is standing
     */
    public void setParticipate(boolean participate) {
        this.participate = participate;
    }

    /**
     *
     * @return The player's score
     */
    public SKUNKScore getPlayerScore() {
        return playerScore;
    }

    /**
     *
     * @param playerScore The player's score
     */
    public void setplayerScore(SKUNKScore playerScore) {
        this.playerScore = playerScore;
    }

    /**
     *
     * @param roundPoints The points accumulated during the round
     * @param myScore The artificial players score
     * @param winningScore The score of the winning player
     * @param sitters The amount of players sitting
     * @param isSnakeEye True if any ones were rolled
     */
    public void setParticipate(int roundPoints, int myScore, int winningScore, int sitters, boolean isSnakeEye){
        if (getDifficulty() == MEDIUM_DIFFICULTY){        //Medium AI Calculation

            setParticipate(mediumCalculations(roundPoints, myScore, winningScore, sitters));
        }
        else if (getDifficulty() == NOVICE_DIFFICULTY){   //Novice AI Calculation

            setParticipate(noviceCalculations(roundPoints, myScore, winningScore, sitters, isSnakeEye));
        }
        else {
            setParticipate(mediumCalculations(roundPoints, myScore, winningScore, sitters));
        }
    }

    /**
     *
     * @param roundPoints The points accumulated during the round
     * @param myScore The artificial players score
     * @param winningScore The score of the winning player
     * @param sitters The amount of players sitting
     * @param isSnakeEye True if any ones were rolled
     * @return True if the player decides to stay standing
     */
    public boolean noviceCalculations(int roundPoints, int myScore, int winningScore, int sitters, boolean isSnakeEye){

        return (myScore + roundPoints <= winningScore) ? (!isSnakeEye) : ((sitters < EARLY_SIT)
                && ((roundPoints > DECENT_CASH_IN) && (rand.nextInt(CHANCE_BASE) + INDEX_OFFSET) > NOVICE_CHANCE));

    }

    /**
     *
     * @param roundPoints The points accumulated during the round
     * @param myScore The artificial players score
     * @param winningScore The score of the winning player
     * @param sitters The amount of players sitting
     * @return True if the player decides to stay standing
     */
    public boolean mediumCalculations(int roundPoints, int myScore, int winningScore, int sitters){

        return (sitters >= EARLY_SIT) ? (rand.nextInt(CHANCE_BASE) + INDEX_OFFSET > MEDIUM_CHANCE)
                : ((roundPoints > DECENT_CASH_IN) && (myScore + roundPoints < winningScore));
    }
}