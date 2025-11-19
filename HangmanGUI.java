//Docuemntation used:
// https://www.jetbrains.com/help/idea/design-gui-using-swing.html#place_gui_components
// https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html
//https://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Dimension;
import java.util.Arrays;
import java.awt.Font;
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
    //button to try another word
    private JButton tryAgain;
    //another j panel
    private JPanel innerBox;
    //West J Panel
    private JPanel westBox;
    //display score box2
    private JLabel displayScore2;
    //private center box
    private HangmanCanvas centerBox;



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

        //create new object to display words\
        String word = "Flour";
        int n = word.length();

        String[] dashes = new String[n];
        Arrays.fill(dashes, "_");

        textSlots = new JPanel();
        //creates grid layout for a five letter word
        textSlots.setLayout(new FlowLayout());

        //loop adds the dashes to where words should be
        for (int i = 0; i < n; i++) {
            //adds dashes for where words will be displayed in the center of screen
            textSlots.add(new JLabel("_", SwingConstants.CENTER));
            }
        //adds them to screen and centers them north at the top of the screen
        add(textSlots, BorderLayout.NORTH);

        //Button layout for letters to choose from
        String[] alphabet = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
        //new button object created
        letters = new JButton();
        //sets the layout for where the buttons will appear
        letters.setLayout(new GridLayout(2, 5));
        //for each loop creates new buttons for each letter of alphabet
            for (String c : alphabet) {
                letters.add(new JButton(c), SwingConstants.CENTER);
            }
        //adds them to the screen
        add(letters, BorderLayout.SOUTH);

        innerBox = new JPanel(new BorderLayout());
        add(innerBox, BorderLayout.EAST);
        tryAgain = new JButton("Try Another Word");
        innerBox.add(tryAgain, BorderLayout.SOUTH);

        //creates new panel object for the left hand side of the GUI
        westBox = new JPanel(new FlowLayout());
        //adds the object top the left hand side of the screen
        add(westBox, BorderLayout.WEST);
        //creates new object for text display of the score
        displayScore = new JLabel("Score: ");
        //creates new object of the score
        displayScore2 = new JLabel("0");
        //adds the text display label to the left hand panel
        westBox.add(displayScore);
        //adds the score label the left hand panel
        westBox.add(displayScore2);

        //creates new object in center panel
        centerBox = new HangmanCanvas();
        //adds the panel to the center
        add(centerBox, BorderLayout.CENTER);









        //tryAgain.setPreferredSize(buttonSize);
//        tryAgain.setBounds(50, 50, 20, 50); // x=50, y=50, width=100, height=50
//        add(tryAgain);
//        tryAgain.setLayout(new GridLayout(2, 5));
//        add(tryAgain);


//
//
//        // Input panel
//        JPanel inputPanel = new JPanel();
//        guessField = new JTextField(1); // single letter input
//        JButton guessButton = new JButton("Guess");
//        inputPanel.add(new JLabel("Enter a letter:"));
//        inputPanel.add(guessField);
//        inputPanel.add(guessButton);
//        add(inputPanel, BorderLayout.CENTER);
//
//        // Feedback and score
//        JPanel infoPanel = new JPanel(new GridLayout(2,1));
//        guessedLettersLabel = new JLabel("Guessed Letters: ");
//        topScoreLabel = new JLabel("Top Score: 0");
//        infoPanel.add(guessedLettersLabel);
//        infoPanel.add(topScoreLabel);
//        add(infoPanel, BorderLayout.SOUTH);
//
        setVisible(true);
    }

    public static void main(String[] args) {
        new HangmanGUI();

    }
}