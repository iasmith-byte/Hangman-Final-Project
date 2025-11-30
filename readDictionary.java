import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.random.RandomGenerator;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class readDictionary {


    public String getRandomWord() {
        File DictionaryFile = new File("dictionary-2.txt");// Points to Dictionary
        ArrayList<String> words_In_Dict = new ArrayList<>(); // ArrayList to hold the words in the Dict
        try {
            Scanner ReadDict = new Scanner(DictionaryFile);// reads the dictionary.txt
            while (ReadDict.hasNext()) {// loops through every word in the file
                words_In_Dict.add(ReadDict.next()); //Stores the words in the arraylist

                // Don't accidentally add a print statement in a loop....
            }
            ReadDict.close(); // closes the scanner ReadDict

            //creates new random object
            Random randomWord = new Random(); // creates random object
            int index = randomWord.nextInt(words_In_Dict.size()); // goes through the array from index 0 to -1, also keeps it from going out of bounds
            return words_In_Dict.get(index); //gets the index of the words stored in the array

        } catch (FileNotFoundException X) {
            System.out.println("Source file Not Found: " + DictionaryFile.getAbsolutePath());
            return null;//gives user an error if file can't be found
        }


    }

    public List<Integer> getScores() {
        String filePath = "scores.txt";
        List<Integer> scores = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextInt()) {
                scores.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return scores;
    }

    public void writeResultsToFile(int currentScore, List<Integer> scores) {

        try {
            if(currentScore > 0) {
                scores.addFirst(currentScore);  // Add new current score to beginning


                // Write all scores to file, overwriting previous content
                PrintWriter writer = new PrintWriter(new FileWriter("scores.txt"));

                for (int score : scores) {
                    writer.println(score);
                }

                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error when writing to File");
        }
    }
}
// Still working on Top scores and Saving Scores
