import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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
    private void writeResultsToFile(int beeCounter, int antennaCounter, int flowerCounter,
                                           int barryBensonCounter, int honeyCounter) throws IOException {
        // Create PrintWriter object to write to the results.txt file
        PrintWriter writer = new PrintWriter(new FileWriter("results.txt"));


        // Writes the results in into the results.txt file
        writer.println("The keyword bee appeared " + beeCounter + " times");
        writer.println("The keyword antenna appeared " + antennaCounter + " times");
        writer.println("The keyword flower appeared " + flowerCounter + " times");
        writer.println("The keyword Barry Benson appeared " + barryBensonCounter + " times");
        writer.println("The keyword honey appeared " + honeyCounter + " times");

        //close the file
        writer.close();
    }
}
// Still working on Top scores and Saving Scores
