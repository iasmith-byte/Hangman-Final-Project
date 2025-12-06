//Docuemntation used:
// https://www.jetbrains.com/help/idea/design-gui-using-swing.html#place_gui_components
// https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html
//https://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html
//Project Partner Bre Stewart

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HangmanGUI extends JFrame {
    //collects input for the words
    private JTextField textInput;
    //way to display the words
    private JPanel textSlots;
    //Displays the score
    private JLabel displayScoreLabel;
    //shows the letters already guessed
    private JLabel displayGuessedWords;
    //buttons for letters
    private JButton letters;
    //another j panel
    private JPanel innerBox;
    //West J Panel for the left hand side of the
    private JPanel westBox;
    //display score box2
    private JLabel displayScoreValue;
    //Center box containing the drawings
    private HangmanCanvas centerBox;
    //Inner JPanel object container for the textfield
    private JPanel innerCenterBox;
    //dimension object to manipulate the size of the textfield
    private Dimension inputSize;
    //Panel object for the bottom of the GUI
    private JPanel southBox;
    //variable to stores JButtons
    private final List<JButton> letterButtons = new ArrayList<>();
    //Upper case random word chosen
    private String chosenWordUpper;
    //New game JButton
    private JButton newGame;
    //New Gamestate object that tracks progress
    private GameState ng = new GameState(0);
    //ArrayList
    private List<String> stringList;
    //dic object for accessing the random word to be guessed
    private final readDictionary dict;
    //unused variable
    private String newWord;
    //stores the length of the word
    private int n;
    //JLabel for the current score label in GUI
    private final JLabel currentScoreLabel = new JLabel("Current Score: ");
    //JLabel for the current score value label in GUI
    private final JLabel currentScoreValue = new JLabel("0");
    //JLabel for the High Scores label in GUI
    private final JLabel highScoreText = new JLabel("High Scores");
    //1st top score
    private final JLabel highScore1Value = new JLabel();
    //2nd top score
    private final JLabel highScore2Value = new JLabel();
    //3rd top score
    private final JLabel highScore3Value = new JLabel();
    //1st top score
    private final JLabel highScore1Label = new JLabel("1. ");
    //2nd top score
    private final JLabel highScore2Label = new JLabel("2. ");
    //3rd top score
    private final JLabel highScore3Label = new JLabel("3. ");


    public HangmanGUI(int currentScore) {
        //creates new object to read in a word
        this.dict = new readDictionary();
        List<Integer> scores = dict.getScores();
        //calls methods to handle the game logic
        init(scores, currentScore);
        getClue();
        drawClue();
        drawHangman();
        drawGuess(scores);
        drawScore(scores);

        setVisible(true);
    }

    //Main method to run the game
    public static void main(String[] args) {
        //instantiates the object and sets the current score
        HangmanGUI hg = new HangmanGUI(0);
    }

    private void drawScore(List<Integer> scores) {
        //creates new panel object
        westBox = new JPanel();
        //sets the layout of the JPanel to the left hands side of the GUI
        westBox.setLayout(new BoxLayout(westBox, BoxLayout.Y_AXIS));
        //adds the object top the left hand side of the screen
        add(westBox, BorderLayout.WEST);

        JPanel mistakePanel = new JPanel(new FlowLayout());
        //creates new object for text display of the score
        displayScoreLabel = new JLabel("Mistakes: ");
        //creates new object of the score
        displayScoreValue = new JLabel("0");

        //adds the display score label to the JPanel
        mistakePanel.add(displayScoreLabel);
        //adds the display score value to the JPanel
        mistakePanel.add(displayScoreValue);
        //adds the text display label to the left hand panel
        westBox.add(mistakePanel);

        //creates a new JPanel for the scores
        JPanel scorePanel = new JPanel();
        // Current Score
        JPanel currentScorePanel = new JPanel(new FlowLayout());
        //adds the current score value
        currentScorePanel.add(currentScoreLabel);
        //adds the current score value to the JPanel
        currentScorePanel.add(currentScoreValue);

        scorePanel.add(currentScorePanel);
        //Array list contains the scores from the scores text file
        List<Integer> tempScores = new ArrayList<Integer>(scores);
        //sorts the scores in the correct order
        tempScores.sort(Collections.reverseOrder());

        //creates new JPanel for the highScore
        JPanel highScorePanel = new JPanel();
        //sets the layout for the panel descending
        highScorePanel.setLayout(new BoxLayout(highScorePanel, BoxLayout.Y_AXIS));
        //adds the highscore text to the label
        highScorePanel.add(highScoreText);

        // Top Score JPanel
        JPanel highScore1Panel = new JPanel(new FlowLayout());

        //TODO: Set to Highest score
        //highScore1Value.setText(tempScores.getFirst().toString());

         highScore1Value.setText(tempScores.size() > 0 ? String.valueOf(tempScores.get(0)): "0"); // checks the size of the list, used the ternary (?) to set the true false value
        // the "0" is just a placeholder if the list is empty.
        highScore1Panel.add(highScore1Label);
        highScore1Panel.add(highScore1Value);
        highScorePanel.add(highScore1Panel);

        // Second highest score JPanel
        JPanel highScore2Panel = new JPanel(new FlowLayout());
        //TODO: Set to Second Highest score
       // highScore2Value.setText(tempScores.get(1).toString());

        highScore2Value.setText(tempScores.size() > 1 ? String.valueOf(tempScores.get(1)) : "0"); // checks the size of the list, used the ternary (?) to set the true false value
        // this one checks the scores to see if there is one item in the array.
        highScore2Panel.add(highScore2Label);
        highScore2Panel.add(highScore2Value);
        highScorePanel.add(highScore2Panel);

        // Third highest score JPanel
        JPanel highScore3Panel = new JPanel(new FlowLayout());
        //TODO: Set to Third Highest score
        //highScore3Value.setText(tempScores.get(2).toString());

        highScore3Value.setText(tempScores.size() > 2 ? String.valueOf(tempScores.get(2)) : "0");
        // this one checks the scores to see if there are two items in the array.
        highScore3Panel.add(highScore3Label);
        highScore3Panel.add(highScore3Value);
        highScorePanel.add(highScore3Panel);
        //adds the highscore panel to the Gui
        scorePanel.add(highScorePanel);
        //adds the current score and highscore panel to the westbox panel
        westBox.add(currentScorePanel);
        westBox.add(highScorePanel);

    }

    private void drawGuess(List<Integer> scores) {
        //Button creation
        //String array containing the alphabet
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        //For each creates new button objects for letters
        for (String c : alphabet) {
            JButton b = new JButton(c);
            letterButtons.add(b);
            //Action lister added to buttons to take input
            b.addActionListener(e -> {
                //letters are set
                textInput.setText(c);
                // If the word contains the current alphabet letter
                if (HangmanGUI.this.stringList.contains(c)) {
                    //loop through the word and compares the element at the index
                    for (int i = 0; i < n; i++) {
                        if (c.equalsIgnoreCase(this.stringList.get(i))) {
                            //stores the dashes in the temp variable
                            JLabel temp = (JLabel) this.textSlots.getComponent(i);
                            //draws the correct letter guessed at the appropriate index
                            temp.setText(HangmanGUI.this.stringList.get(i));
                            //correct guesses counter is incremented by one if guess is correct
                            ng.setCorrectGuesses(ng.getCorrectGuesses() + 1);
                            //tester shows the counter incrementing
                            System.out.println(ng.getCorrectGuesses());
                        }
                    }
                }
                // Else
                else {
                    //count increments if guessed wrong
                    ng.setMistakesCounter(ng.getMistakesCounter() + 1);
                    //redraws the canvas
                    centerBox.repaint();
                    //displays the number of wrong guesses in the JLabel
                    displayScoreValue.setText(String.valueOf(ng.getMistakesCounter()));

                }
                // Draw hangman + increase count
                // If game condition met, end game
                b.setEnabled(false);
                //if statements checks if the player has made 6 mistkes and drawn the hangman
                if (ng.getMistakesCounter() >= 6) {
                    //calls the gameover method and the player loses
                    gameOver(scores);
                }
                //If statement checks if the player has correctly guessed the number of letters in the word
                if (ng.getCorrectGuesses() == n) {
                    //calls the isWon method if the player has won the game
                    isWon();
                }
            });
            //adds the buttons to the south box Panel of the GUI
            southBox.add(b);

        }
    }

    private void drawHangman() {
        //TODO: Hangman Canvas in center container
        //creates new object in center panel
        centerBox = new HangmanCanvas();
        //sets the new game state
        centerBox.setGameState(ng);
        //adds the panel to the center
        add(centerBox, BorderLayout.CENTER);

        // TODO: Text Field for input
        //creates new JPanel container object
        innerCenterBox = new JPanel();
        //adds the new container to the centerBox container
        centerBox.add(innerCenterBox);
        //creates a text field object for taking input
        textInput = new JTextField("Enter a letter: ");
        //creates a dimension object to set the width and height of the text field box
        inputSize = new Dimension(100, 20);
        //methods sets the size of the text field
        textInput.setPreferredSize(inputSize);
        //adds the textfield object to the container
        innerCenterBox.add(textInput, BorderLayout.SOUTH);
    }

    private void drawClue() {
        //creates new JPanel object for where the word will be displayed
        textSlots = new JPanel();
        //creates flowlayout layout for the JPanel
        textSlots.setLayout(new FlowLayout());
        //loop adds the dashes to where words should be, goes to the length of the word
        for (int i = 0; i < n; i++) {
            //adds JLabel dashes for where words will be displayed in the center of screen
            textSlots.add(new JLabel("_", SwingConstants.CENTER));
        }
        //adds them to screen and centers them north at the top of the screen
        add(textSlots, BorderLayout.NORTH);
    }

    private void getClue() {
        //stores the random word chosen
        String chosenWord = dict.getRandomWord();
        //coverts the word chosen to uppercase
        this.chosenWordUpper = chosenWord.toUpperCase();
        //test shows the word chosen, makes sure it's correct format
        System.out.println(chosenWord);
        //coverts the word chosen to an array and splits them into individual characters
        String[] chosenWordArray = chosenWordUpper.split("");
        //creates a list object for comparison
        this.stringList = new ArrayList<>(Arrays.asList(chosenWordArray));
        //shows the correct word to guess for testing purposes
        System.out.println(stringList);

        //stores the length of the random word
        this.n = stringList.size();
    }

    private void init(List<Integer> scores, int currentScore) {
        //method sets the title of the game
        setTitle("Hangman game");
        //Closes the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the size of the GUI
        setSize(1200, 800);
        //manages the layout of the screen
        setLayout(new BorderLayout());

        //Handles window being closed by "x"
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //runs when X button is clicked
                dict.writeResultsToFile(ng.getCurrentScore(), scores);
            }
        });

        //creates a new gamestate object
        this.ng = new GameState(currentScore);
        //updates the JLabel in the GUI with the current score
        this.currentScoreValue.setText(String.valueOf(ng.getCurrentScore()));

        //Creates a JPanel object container for the bottom of the GUI
        southBox = new JPanel();
        //setLayout is set to grid layout for buttons
        southBox.setLayout(new GridLayout(2, 13));
        //adds the south box to the gui
        add(southBox, BorderLayout.SOUTH);

        //TODO: Inner box container housing new game button
        innerBox = new JPanel(new BorderLayout());
        //positions the panel to the east (Right hand Side)
        add(innerBox, BorderLayout.EAST);
        //creates a new JButton object for Trying another word
        newGame = new JButton("End Game");
        newGame.addActionListener(e -> {
            //writes the results to the file
            dict.writeResultsToFile(ng.getCurrentScore(), scores);
            //safely closes the window
            this.dispose();
        });

        //Adds the button to the innerBox and positions it south in the east panel
        innerBox.add(newGame, BorderLayout.SOUTH);
    }

    //TODO: Create method that checks if the game has been won.
    public void isWon() {
        //For each loop sisable all letter buttons after the game ends
        for (JButton b : letterButtons) {
            b.setEnabled(false);
        }

        //Disable text input
        textInput.setEnabled(false);


        //Update current score
        ng.setCurrentScore(ng.getCurrentScore() + 1);
        //updates the value of the JLabel
        currentScoreValue.setText(String.valueOf(ng.getCurrentScore()));

        //Pop up message telling the player they won and displaying the correct word
        JOptionPane.showMessageDialog(
                this,
                "You Win!\nThe correct word was: " + chosenWordUpper,
                "Hangman",
                JOptionPane.INFORMATION_MESSAGE
        );

        //Safely closes the window
        this.dispose();
        //creates a new game and gets the current score from the previous game
        new HangmanGUI(ng.getCurrentScore());


    }

    //TODO: Create method to check if counter has reached 6, and the player has lost the game.
    public void gameOver(List<Integer> scores) {

        //For each loop disable all letter buttons once game ends
        for (JButton b : letterButtons) {
            b.setEnabled(false);
        }

        //Disable text input
        textInput.setEnabled(false);

        dict.writeResultsToFile(ng.getCurrentScore(), scores);

        //reset the score to 0 after losing a game
        ng.setCurrentScore(0);
        //sets the JLabel to 0
        currentScoreValue.setText("0");

        //Pop up messages Show displays game over and the correct word
        JOptionPane.showMessageDialog(
                this,
                "GAME OVER!\nThe correct word was: " + chosenWordUpper,
                "Hangman",
                JOptionPane.INFORMATION_MESSAGE
        );
        //Safely closes the window
        this.dispose();
        //Creates new game and grabs the previous score
        new HangmanGUI(ng.getCurrentScore());

    }
}
