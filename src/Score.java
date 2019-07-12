/**
 * @author Frey COMP 1451
 * @version Assignment 0, Score.java
 */
public class Score {

    private int score;

    public Score(){
        score = 0;
    }

    /**
     *
     * @return The score
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score The score
     */
    public void setScore(int score){
        this.score = score;
    }

    public void printScore(){
        System.out.print(score);
    }
}

/*
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }
 */


