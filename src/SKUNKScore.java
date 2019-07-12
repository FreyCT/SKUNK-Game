/**
 * @author Frey, COMP 1451
 * @version Assignment 0, SKUNKScore.java
 */
public class SKUNKScore extends Score {

    private int firstRoundScore;
    private int secondRoundScore;
    private int thirdRoundScore;
    private int fourthRoundScore;
    private int fifthRoundScore;

    public static final int    SCORE_RESET     = 0;
    public static final int    FIRST_ROUND     = 0;
    public static final int    SECOND_ROUND    = 1;
    public static final int    THIRD_ROUND     = 2;
    public static final int    FOURTH_ROUND    = 3;
    public static final int    FIFTH_ROUND     = 4;
    public static final String TAB             = "\t";

    SKUNKScore(){

        super();

        firstRoundScore     = SCORE_RESET;
        secondRoundScore    = SCORE_RESET;
        thirdRoundScore     = SCORE_RESET;
        fourthRoundScore    = SCORE_RESET;
        fifthRoundScore     = SCORE_RESET;
    }

    /**
     *
     * @return The score for the first round
     */
    private int getFirstRoundScore() {
        return firstRoundScore;
    }

    /**
     *
     * @param firstRoundScore The score for the first round
     */
    private void setFirstRoundScore(int firstRoundScore) {
        this.firstRoundScore = firstRoundScore;
    }

    /**
     *
     * @return The score for the second round
     */
    private int getSecondRoundScore() {
        return secondRoundScore;
    }

    /**
     *
     * @param secondRoundScore The score for the second round
     */
    private void setSecondRoundScore(int secondRoundScore) {
        this.secondRoundScore = secondRoundScore;
    }

    /**
     *
     * @return The score for the third round
     */
    private int getThirdRoundScore() {
        return thirdRoundScore;
    }

    /**
     *
     * @param thirdRoundScore The score for the third round
     */
    private void setThirdRoundScore(int thirdRoundScore) {
        this.thirdRoundScore = thirdRoundScore;
    }

    /**
     *
     * @return The score for the fourth round
     */
    private int getFourthRoundScore() {
        return fourthRoundScore;
    }

    /**
     *
     * @param fourthRoundScore The score for the fourth round
     */
    private void setFourthRoundScore(int fourthRoundScore) {
        this.fourthRoundScore = fourthRoundScore;
    }

    /**
     *
     * @return The score for the fifth round
     */
    private int getFifthRoundScore() {
        return fifthRoundScore;
    }

    /**
     *
     * @param fifthRoundScore The score for the fifth round
     */
    private void setFifthRoundScore(int fifthRoundScore) {
        this.fifthRoundScore = fifthRoundScore;
    }

    public void snakeEyes(){
        setFirstRoundScore(SCORE_RESET);
        setSecondRoundScore(SCORE_RESET);
        setThirdRoundScore(SCORE_RESET);
        setFourthRoundScore(SCORE_RESET);
        setFifthRoundScore(SCORE_RESET);
        setScore(SCORE_RESET);
    }

    /**
     *
     * @param roundScore The score recorded at the end of a round
     */
    public void addScore(int roundScore){
        setScore(getScore() + roundScore);
    }

    /**
     *
     * @param roundScore The score accumulated through out a round
     * @param round The round that ended
     */
    public void recordRoundScore(int roundScore, int round){

        switch (round){
            case FIRST_ROUND:
                setFirstRoundScore(roundScore);
                addScore(getFirstRoundScore());
                break;
            case SECOND_ROUND:
                setSecondRoundScore(roundScore);
                addScore(getSecondRoundScore());
                break;
            case THIRD_ROUND:
                setThirdRoundScore(roundScore);
                addScore(getThirdRoundScore());
                break;
            case FOURTH_ROUND:
                setFourthRoundScore(roundScore);
                addScore(getFourthRoundScore());
                break;
            case FIFTH_ROUND:
                setFifthRoundScore(roundScore);
                addScore(getFifthRoundScore());
                break;
            default:
                System.out.print(" the round score will not be recorded");
        }
    }

    public void printScore(){
        System.out.print((getFirstRoundScore()==SCORE_RESET) ? TAB + "-" + TAB + TAB + "|" : TAB + getFirstRoundScore() + TAB + TAB + "|");
        System.out.print((getSecondRoundScore()==SCORE_RESET) ? TAB + "-" + TAB + TAB + "|" : TAB + getSecondRoundScore() + TAB + TAB + "|");
        System.out.print((getThirdRoundScore()==SCORE_RESET) ? TAB + "-" + TAB + TAB + "|" : TAB + getThirdRoundScore() + TAB + TAB + "|");
        System.out.print((getFourthRoundScore()==SCORE_RESET) ? TAB + "-" + TAB + TAB + "|" : TAB + getFourthRoundScore() + TAB + TAB + "|");
        System.out.print((getFifthRoundScore()==SCORE_RESET) ? TAB + "-" + TAB + TAB + "|" : TAB + getFifthRoundScore() + TAB + TAB + "|");
        System.out.print((getScore()==SCORE_RESET) ? TAB + "-" + TAB + TAB + "|" : TAB + getScore() + TAB + TAB + "|");
    }
}
