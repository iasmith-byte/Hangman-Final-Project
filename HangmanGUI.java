//Docuemntation used:
// https://www.jetbrains.com/help/idea/design-gui-using-swing.html#place_gui_components
// https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html
//https://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html
//Project Partner Bre Stewart

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;

public class HangmanGUI extends JFrame {
    //collects input for the words
    private JTextField textInput;
    //way to display the words
    private JPanel textSlots;
    //Displays the score
    private JLabel displayScore;
    //shows the letters already guessed
    private JLabel displayGuessedWords;
    //buttons for letters
    private JButton letters;
    //another j panel
    private JPanel innerBox;
    //West J Panel for the left hand side of the
    private JPanel westBox;
    //display score box2
    private JLabel displayScore2;
    //Center box containing the drawings
    private HangmanCanvas centerBox;
    //Inner JPanel object container for the textfield
    private JPanel innerCenterBox;
    //dimension object to manipulate the size of the textfield
    private Dimension inputSize;
    //Panel object for the bottom of the GUI
    private JPanel southBox;
    //variable to stores JButtons
    private List<JButton> letterButtons = new ArrayList<>();
    //Upper case random word chosen
    private String ChosenWordUpper;
    //New game button
    private JButton newGame;
    private GameState ng;
    private List<String> stringList;
    private readDictionary dict;
    private String newWord;
    private int n;


    public HangmanGUI() {

        //method sets the title of the game
        setTitle("Hangman game");
        //Closes the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the size of the GUI
        setSize(1200, 800);
        //manages the layout of the screen
        setLayout(new BorderLayout());
        //getContentPane().setLayout(new FlowLayout());

        //creates new object to read in a word
        this.dict = new readDictionary();
        //stores the random word chosen
        String chosenWord = dict.getRandomWord();
        //coverts the word chosen to uppercase
        this.ChosenWordUpper = chosenWord.toUpperCase();
        //String chosenWordUpper = chosenWord.toUpperCase();
        //test shows the word chosen, makes sure it's correct format
        System.out.println(chosenWord);
        //coverts the word chosen to an array and splits them into individual characters
        String[] chosenWordArray = ChosenWordUpper.split("");
        //creates a list object for comparison
        //List<String> stringList = new ArrayList<>(Arrays.asList(chosenWordArray));
        this.stringList = new ArrayList<>(Arrays.asList(chosenWordArray));
        System.out.println(stringList);

        //stores the length of the random word
        this.n = stringList.size();

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

        //Creates a JPanel object container for the bottom of the GUI
        southBox = new JPanel();
        //setLayout is set to grid layout for buttons
        southBox.setLayout(new GridLayout(2, 13));
        //adds the south box to the gui
        add(southBox, BorderLayout.SOUTH);


        //creates a new gamestate object
        //GameState ng = new GameState();
        this.ng = new GameState();


        //Button creation
        //String array containing the alphabet
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
                "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
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
                                ng.setCorrectGuesses(ng.getCorrectGuesses()+1);
                                System.out.println(ng.getCorrectGuesses());
                            }
                        }
                    }
                    // Else
                    else {
                        //count increments if guessed wrong
                        ng.setMistakesCounter(ng.getMistakesCounter()+1);
                        //redraws the canvas
                        centerBox.repaint();
                        //displays the number of wrong guesses
                        displayScore2.setText(String.valueOf(ng.getMistakesCounter()));

                    }
                    // Draw hangman + increase count
                    // If game condition met, end game
                    b.setEnabled(false);
                    gameOver(ng,ChosenWordUpper);
                    isWon(ng, n, ChosenWordUpper);
                });
                southBox.add(b);

            }


        //TODO: Inner box container housing new game button
        innerBox = new JPanel(new BorderLayout());
        //positions the panel to the east (Right hand Side)
        add(innerBox, BorderLayout.EAST);
        //creates a new JButton object for Trying another word
        newGame = new JButton("New Game");
        newGame.addActionListener(e -> startNewGame());


        //Adds the button to the innerBox and positions it south in the east panel
        innerBox.add(newGame, BorderLayout.SOUTH);

        //TODO: Left hand box for mistakes JPanel
        //creates new panel object for the left hand side of the GUI
        westBox = new JPanel(new FlowLayout());
        //adds the object top the left hand side of the screen
        add(westBox, BorderLayout.WEST);
        //creates new object for text display of the score
        displayScore = new JLabel("Mistakes: ");
        //creates new object of the score
        displayScore2 = new JLabel("0");
        //adds the text display label to the left hand panel
        westBox.add(displayScore);
        //adds the score label the left hand panel
        westBox.add(displayScore2);

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


        setVisible(true);
    }
    public void startNewGame(){
        // 1. Reset game state
        ng = new GameState();
        centerBox.setGameState(ng);

        // 2. Pick a new random word
        String newWord = dict.getRandomWord();
        ChosenWordUpper = newWord.toUpperCase();
        System.out.println(ChosenWordUpper);
        stringList = Arrays.asList(ChosenWordUpper.split(""));
        System.out.println(stringList);
        int n = stringList.size();

        // 3. Reset text slots (underscores)
        textSlots.removeAll();
        for (int i = 0; i < n; i++) {
            textSlots.add(new JLabel("_", SwingConstants.CENTER));
        }
        textSlots.revalidate();
        textSlots.repaint();

        // 4. Re-enable letter buttons
        for (JButton b : letterButtons) {
            b.setEnabled(true);
        }

        // 5. Reset score display
        displayScore2.setText("0");

        // 6. Clear input field
        textInput.setText("");

        // 7. Reset canvas
        centerBox.repaint();
        }


    //TODO: Create method that checks if the game has been won.
    public void isWon(GameState ng, int n, String chosenWordUpper) {
        if(ng.getCorrectGuesses() == n){
            // 1. Disable all letter buttons
            for (JButton b : letterButtons)  {
                b.setEnabled(false);
            }

            // 2. Disable text input
            textInput.setEnabled(false);

            // 3. Show message with correct word
            JOptionPane.showMessageDialog(
                    this,
                    "You Win!\nThe correct word was: " + chosenWordUpper,
                    "Hangman",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }
    }
    //TODO: Create method to check if counter has reached 6, and the player has lost the game.
    public void gameOver(GameState ng, String chosenWordUpper) {

        // If the mistakes reached 6 → player loses
        if (ng.getMistakesCounter() >= 6) {

            // 1. Disable all letter buttons
            for (JButton b : letterButtons)  {
                b.setEnabled(false);
            }

            // 2. Disable text input
            textInput.setEnabled(false);

            // 3. Show message with correct word
            JOptionPane.showMessageDialog(
                    this,
                    "GAME OVER!\nThe correct word was: " + chosenWordUpper,
                    "Hangman",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    //Main method to run the game
    public static void main(String[] args) {
        HangmanGUI hg = new HangmanGUI();


    }
}