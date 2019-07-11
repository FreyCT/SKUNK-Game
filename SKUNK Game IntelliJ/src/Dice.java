import java.util.Random;
/**
 * @author Frey COMP 1451
 * @version Assignment 0, Dice.java
 */
public class Dice {

    private Random      rand;
    private int         roll;
    private final int   faces;

    /**
     *
     * @param faces The amount of dice faces
     */
    public Dice(final int faces) {

        rand = new Random();
        this.faces = faces;
        reRoll();
    }

    /**
     *
     * @return the integer rolled
     */
    public int getRoll() {
        return roll;
    }

    public void reRoll() {
        this.roll = rand.nextInt(faces) + 1;
    }

    /**
     *
     * @return The number of faces on the dice
     */
    private int getFaces() {
        return faces;
    }
}