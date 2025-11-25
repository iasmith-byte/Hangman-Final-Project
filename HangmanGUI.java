//Docuemntation used:
// https://www.jetbrains.com/help/idea/design-gui-using-swing.html#place_gui_components
// https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html
//https://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html
//Project Partner Bree Stewart

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
    //button to try another word
    private JButton tryAgain;
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
    //Counter variable
    private int count;


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

        //creates an array list containing the word to be guessed
        List<String> word = Arrays.asList("F","L","O","U","R");
        //stores the length of the word
        int n = word.size();

        //creates new JPanel object for where the word will be displayed
        textSlots = new JPanel();
        //creates flowlayout layout for a five letter word
        textSlots.setLayout(new FlowLayout());

        //loop adds the dashes to where words should be
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


        //Button creation
        //String array containing the alphabet
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
                "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        //For each creates new button objects for letters
            for (String c : alphabet) {
                JButton b = new JButton(c);
                //Action lister added to buttons to take input
                b.addActionListener(e -> {
                    //letters are set
                    textInput.setText(c);
                    // If the word contains the current alphabet letter
                    if (word.contains(c)) {
                        //loop through the word and compares the element at the index
                        for (int i = 0; i < n; i++) {
                            if (c.equalsIgnoreCase(word.get(i))) {
                                //stores the dashes in the temp variable
                                JLabel temp = (JLabel) textSlots.getComponent(i);
                                //draws the correct letter guessed at the appropriate index
                                temp.setText(word.get(i));
                            }
                        }
                    }
                    // Else
                    else {
                        //count increments if guessed wrong
                        count++;
                        //displays the number of wrong guesses
                        displayScore2.setText(String.valueOf(count));
                    }
                    // Draw hangman + increase count
                    // If game condition met, end game
                    b.setEnabled(false);
                });
                southBox.add(b);

            }

        //Inner JPanel for Try Again button
        innerBox = new JPanel(new BorderLayout());
        //positions the panel to the east (Right hand Side)
        add(innerBox, BorderLayout.EAST);
        //creates a new JButton object for Trying another word
        tryAgain = new JButton("Try Another Word");
        //Adds the button to the innerBox and positions it south in the east panel
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

        //Text Field for input
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

        //TODO: Create method that checks if the game has been won.

        //TODO: Create method to check if counter has reached 6, and the player has lost the game.

        setVisible(true);
    }

    //Main method to run the game
    public static void main(String[] args) {
        HangmanGUI hg = new HangmanGUI();
        // user selects letter
        // update jpanels for word


    }
}