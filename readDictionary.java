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
    public static void main(String[] args) {
        File DictionaryFile = new File("dictionary-2.txt");// Points to Dictionary
        ArrayList<String> words_In_Dict = new ArrayList<>(); // ArrayList to hold the words in the Dict
        try {
            Scanner ReadDict = new Scanner(DictionaryFile);// reads the dictionary.txt
            while (ReadDict.hasNext()) {// loops through every word in the file
                words_In_Dict.add(ReadDict.next()); //Stores the words in the arraylist

                // Don't accidentally add a print statement in a loop....
            }
            ReadDict.close(); // closes the scanner ReadDict

            
            Random randomWord = new Random(); // creates random object
            int index = randomWord.nextInt(words_In_Dict.size()); // goes throw the array from index 0 to -1
            String random_Word = words_In_Dict.get(index); //gets the index of the words stored in the array
            System.out.println(random_Word); // prints chosen word to terminal
        }
        catch (FileNotFoundException X) {
            System.out.println("Source file Not Found: " + DictionaryFile.getAbsolutePath()); //gives user an error if file can't be found
        }
    }
}
// Still working on Top scores and Saving Scores
