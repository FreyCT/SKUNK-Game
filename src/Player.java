/**
 * @author Frey COMP 1451
 * @version Assignment 0, Player.java
 */
public class Player {

    private String username;

    /**
     *
     * @param username The username
     */
    public Player(final String username) {

        if (username != null && !username.equalsIgnoreCase("")) {
            setUsername(username);
        } else {
            throw new IllegalArgumentException("Invalid username");
        }
    }

    /**
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username The username
     */
    private void setUsername(final String username) {
        this.username = username;
    }
}