public class GameState {
    private int mistakesCounter;
    private int correctGuesses;
    private boolean won;
    private int currentScore;

    //Constructor
    public GameState(int currentScore){
        this.mistakesCounter = 0;
        this.correctGuesses = 0;
        this.won = false;
        this.currentScore = currentScore;

    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }


    //getter for correct guesses counter
    public int getCorrectGuesses(){
        return correctGuesses;
    }
    //getter for mistakes counter
    public int getMistakesCounter() {
        return mistakesCounter;
    }
    //setter for updating mistakes counter
    public void setMistakesCounter(int mistakesCounter) {
        this.mistakesCounter = mistakesCounter;
    }
    //setter for updating mistake counter
    public void setCorrectGuesses(int correctGuesses){
        this.correctGuesses = correctGuesses;
    }
    //boolean for checking if win condition is met
    public boolean isWon() {
        return won;
    }
    //boolean for
    public void setWon(boolean won) {
        this.won = won;
    }
}
