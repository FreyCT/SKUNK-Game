/**
 * @author Frey COMP 1451
 * @version Assignment 0, SKUNKPlayer.java
 */
public class SKUNKPlayer extends Player {

    private boolean     participate;
    private SKUNKScore  playerScore;

    /**
     *
     * @param username The username
     */
    public SKUNKPlayer(final String username){

        super(username);
        setParticipate(true);
        playerScore = new SKUNKScore();
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
    public void setPlayerScore(SKUNKScore playerScore) {
        this.playerScore = playerScore;
    }

    /**
     *
     * @param participate True if the player is standing
     */
    public void setParticipate(boolean participate) {
        this.participate = participate;
    }

    /**
     *
     * @return True if the player is standing
     */
    public boolean isParticipate() {
        return participate;
    }
}