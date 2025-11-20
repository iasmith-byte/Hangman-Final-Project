//Docuemntation used:
// https://www.jetbrains.com/help/idea/design-gui-using-swing.html#place_gui_components
// https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html
//https://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html

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
    //West J Panel
    private JPanel westBox;
    //display score box2
    private JLabel displayScore2;
    //private center box
    private HangmanCanvas centerBox;
    //InnerCenterBox
    private JPanel innerCenterBox;
    private Dimension inputSize;
    private JPanel southBox;
    //Button variables (**Will change in favor of loop)
    private JButton letterA;
    private JButton letterB;
    private JButton letterC;
    private JButton letterD;
    private JButton letterE;
    private JButton letterF;
    private JButton letterG;
    private JButton letterH;
    private JButton letterI;
    private JButton letterJ;
    private JButton letterK;
    private JButton letterL;
    private JButton letterM;
    private JButton letterN;
    private JButton letterO;
    private JButton letterP;
    private JButton letterQ;
    private JButton letterR;
    private JButton letterS;
    private JButton letterT;
    private JButton letterU;
    private JButton letterV;
    private JButton letterW;
    private JButton letterX;
    private JButton letterY;
    private JButton letterZ;
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

        //create new object to display words\
        List<String> word = Arrays.asList("F","L","O","U","R");
        int n = word.size();

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

        southBox = new JPanel();
        southBox.setLayout(new GridLayout(2, 13));
        add(southBox, BorderLayout.SOUTH);

//
//        //button(s)
//        letterA = new JButton("A");
//        letterA.addActionListener(e -> {
//            textInput.setText("A");
//            letterA.setEnabled(false);
//
//        });
//        southBox.add(letterA, BorderLayout.SOUTH);
//
//        letterB= new JButton("B");
//        letterB.addActionListener(e -> {
//            textInput.setText("B");
//            letterB.setEnabled(false);
//
//        });
//        southBox.add(letterB, BorderLayout.SOUTH);
//
//
//        letterC = new JButton("C");
//        letterC.addActionListener(e -> {
//            textInput.setText("C");
//            letterC.setEnabled(false);
//
//        });
//        southBox.add(letterC, BorderLayout.SOUTH);
//
//        letterD = new JButton("D");
//        letterD.addActionListener(e -> {
//            textInput.setText("D");
//            letterD.setEnabled(false);
//
//        });
//        southBox.add(letterD, BorderLayout.SOUTH);
//
//        letterE = new JButton("E");
//        letterE.addActionListener(e -> {
//            textInput.setText("E");
//            letterE.setEnabled(false);
//
//        });
//        southBox.add(letterE, BorderLayout.SOUTH);
//
//        letterF = new JButton("F");
//        letterF.addActionListener(e -> {
//            textInput.setText("F");
//            letterF.setEnabled(false);
//
//        });
//        southBox.add(letterF, BorderLayout.SOUTH);
//
//        letterG = new JButton("G");
//        letterG.addActionListener(e -> {
//            textInput.setText("G");
//            letterG.setEnabled(false);
//
//        });
//        southBox.add(letterG, BorderLayout.SOUTH);
//
//        letterH = new JButton("H");
//        letterH.addActionListener(e -> {
//            textInput.setText("H");
//            letterH.setEnabled(false);
//
//        });
//        southBox.add(letterH, BorderLayout.SOUTH);
//
//        letterI = new JButton("I");
//        letterI.addActionListener(e -> {
//            textInput.setText("I");
//            letterI.setEnabled(false);
//
//        });
//        southBox.add(letterI, BorderLayout.SOUTH);
//
//        letterJ = new JButton("J");
//        letterJ.addActionListener(e -> {
//            textInput.setText("J");
//            letterJ.setEnabled(false);
//
//        });
//        southBox.add(letterJ, BorderLayout.SOUTH);
//
//        letterK = new JButton("K");
//        letterK.addActionListener(e -> {
//            textInput.setText("K");
//            letterK.setEnabled(false);
//
//        });
//        southBox.add(letterK, BorderLayout.SOUTH);
//
//        letterL = new JButton("L");
//        letterL.addActionListener(e -> {
//            textInput.setText("L");
//            letterL.setEnabled(false);
//
//        });
//        southBox.add(letterL, BorderLayout.SOUTH);
//
//        letterM = new JButton("M");
//        letterM.addActionListener(e -> {
//            textInput.setText("M");
//            letterM.setEnabled(false);
//
//        });
//        southBox.add(letterM, BorderLayout.SOUTH);
//
//        letterN = new JButton("N");
//        letterN.addActionListener(e -> {
//            textInput.setText("N");
//            letterN.setEnabled(false);
//
//        });
//        southBox.add(letterN, BorderLayout.SOUTH);
//
//        letterO = new JButton("O");
//        letterO.addActionListener(e -> {
//            textInput.setText("O");
//            letterO.setEnabled(false);
//
//        });
//        southBox.add(letterO, BorderLayout.SOUTH);
//
//        letterP = new JButton("P");
//        letterP.addActionListener(e -> {
//            textInput.setText("P");
//            letterP.setEnabled(false);
//
//        });
//        southBox.add(letterP, BorderLayout.SOUTH);
//
//        letterQ = new JButton("Q");
//        letterQ.addActionListener(e -> {
//            textInput.setText("Q");
//            letterQ.setEnabled(false);
//
//        });
//        southBox.add(letterQ, BorderLayout.SOUTH);
//
//
//        letterR = new JButton("R");
//        letterR.addActionListener(e -> {
//            textInput.setText("R");
//            letterR.setEnabled(false);
//
//        });
//
//        southBox.add(letterR, BorderLayout.SOUTH);
//
//        letterS = new JButton("S");
//        letterS.addActionListener(e -> {
//            textInput.setText("S");
//            letterS.setEnabled(false);
//
//        });
//        southBox.add(letterS, BorderLayout.SOUTH);
//
//        letterT = new JButton("T");
//        letterT.addActionListener(e -> {
//            textInput.setText("T");
//            letterT.setEnabled(false);
//
//        });
//        southBox.add(letterT, BorderLayout.SOUTH);
//
//        letterU = new JButton("U");
//        letterU.addActionListener(e -> {
//            textInput.setText("U");
//            letterU.setEnabled(false);
//
//        });
//        southBox.add(letterU, BorderLayout.SOUTH);
//
//
//        letterV = new JButton("V");
//        letterV.addActionListener(e -> {
//            textInput.setText("V");
//            letterV.setEnabled(false);
//
//        });
//        southBox.add(letterV, BorderLayout.SOUTH);
//
//
//        letterW = new JButton("W");
//        letterW.addActionListener(e -> {
//            textInput.setText("W");
//            letterW.setEnabled(false);
//
//        });
//        southBox.add(letterW, BorderLayout.SOUTH);
//
//
//        letterX = new JButton("X");
//        letterX.addActionListener(e -> {
//            textInput.setText("X");
//            letterX.setEnabled(false);
//
//        });
//        southBox.add(letterX, BorderLayout.SOUTH);
//
//        letterY = new JButton("Y");
//        letterY.addActionListener(e -> {
//            textInput.setText("Y");
//            letterY.setEnabled(false);
//
//        });
//        southBox.add(letterY, BorderLayout.SOUTH);
//
//        letterZ = new JButton("Z");
//        letterZ.addActionListener(e -> {
//            textInput.setText("Z");
//            letterZ.setEnabled(false);
//
//        });
//        southBox.add(letterZ, BorderLayout.SOUTH);

        //Button creation
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
                "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        //new button object created
            for (String c : alphabet) {
                JButton b = new JButton(c);
                b.addActionListener(e -> {
                    textInput.setText(c);
                    // If the word contains the current alphabet letter
                    if (word.contains(c)) {
                        for (int i = 0; i < word.size(); i++) {
                            if (c.equalsIgnoreCase(word.get(i))) {
                                JLabel temp = (JLabel) textSlots.getComponent(i);
                                temp.setText(word.get(i));
                            }
                        }
                    }
                    // Else
                    else {
                        count++;
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
        innerCenterBox = new JPanel();
        centerBox.add(innerCenterBox);
        textInput = new JTextField("Enter a letter: ");
//        textInput.setBounds(500, 500, 100, 20);
        inputSize = new Dimension(100, 20);
        textInput.setPreferredSize(inputSize);
        innerCenterBox.add(textInput, BorderLayout.SOUTH);



//

        //tryAgain.setPreferredSize(buttonSize);
//        tryAgain.setBounds(50, 50, 20, 50); // x=50, y=50, width=100, height=50
//        add(tryAgain);
//        tryAgain.setLayout(new GridLayout(2, 5));
//        add(tryAgain);

        setVisible(true);
    }

    public static void main(String[] args) {
        HangmanGUI hg = new HangmanGUI();
        // user selects letter
        // update jpanels for word


    }
}