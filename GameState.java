public class GameState {
    private int mistakesCounter;
    private int correctGuesses;

    public GameState(){
        this.mistakesCounter = 0;
        this.correctGuesses = 0;
    }

    public int getCorrectGuesses(){
        return correctGuesses;
    }

    public int getMistakesCounter() {
        return mistakesCounter;
    }

    public void setMistakesCounter(int mistakesCounter) {
        this.mistakesCounter = mistakesCounter;
    }
    public void setCorrectGuesses(int correctGuesses){
        this.correctGuesses = correctGuesses;
    }
}
