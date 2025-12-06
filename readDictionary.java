import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.random.RandomGenerator;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class readDictionary {

    //Method to select a random word from the dictionary text file
    public String getRandomWord() {
        // Points to Dictionary
        File DictionaryFile = new File("dictionary-2.txt");
        // ArrayList to hold the words in the Dict
        ArrayList<String> words_In_Dict = new ArrayList<>();
        try {
            // reads the dictionary.txt
            Scanner ReadDict = new Scanner(DictionaryFile);
            // loops through every word in the file
            while (ReadDict.hasNext()) {
                //Stores the words in the arraylist
                words_In_Dict.add(ReadDict.next());

                // Don't accidentally add a print statement in a loop....
            }
            ReadDict.close(); // closes the scanner ReadDict

            //creates new random object
            Random randomWord = new Random();
            // goes through the array from index 0 to -1, also keeps it from going out of bounds
            int index = randomWord.nextInt(words_In_Dict.size());
            return words_In_Dict.get(index); //gets the index of the words stored in the array

        } catch (FileNotFoundException X) {
            System.out.println("Source file Not Found: " + X.getMessage());
            return null;//gives user an error if file can't be found
        }


    }
    //Method to access scores from scores text file
    public List<Integer> getScores() {
        //Variable storing file name
        String filePath = "scores.txt";
        //Array list to store the scores
        List<Integer> scores = new ArrayList<>();
        File scoreFile = new File(filePath);
        try {
            if (scoreFile.createNewFile())
                System.out.println("File created: scores.txt");
        }catch (IOException e){
            System.out.println("Error creating file: scores.txt");
        }

        //Scanner object to read the file
        try (Scanner scanner = new Scanner(scoreFile)) {
            //While loop adds the scores the array list
            while (scanner.hasNextInt()) {
                scores.add(scanner.nextInt());
            }
            //Error handling if the file is not found
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return scores;
    }

    //Method to write the scores to file
    public void writeResultsToFile(int currentScore, List<Integer> scores) {
        try {
            // Add new current score to beginning
            if(currentScore >= 0) {
                scores.addFirst(currentScore);


                // Write all scores to file, overwriting previous content
                PrintWriter writer = new PrintWriter(new FileWriter("scores.txt"));

                //for each loop writes the scores text file
                for (int score : scores) {
                    writer.println(score);
                }
                //closes the file succuessfuly
                writer.close();
            }
            //error handling for issues writing to the text file
        } catch (IOException e) {
            System.out.println("Error when writing to File");
        }
    }
}

