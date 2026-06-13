/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectPart2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2FileReader {

    /*
     * Reads words from the text file used in the project.
     * Removes punctuation and converts all words to lowercase.
     * Returns an ArrayList containing up to 10,000 words.
     */
    public static ArrayList<String> readWords(String fileName)
            throws FileNotFoundException {

        // ArrayList used to store the words read from the file
        ArrayList<String> words = new ArrayList<>();

        // Open the file
        Scanner input = new Scanner(new File(fileName));

        // Read words until end of file or until 10,000 words are loaded
        while (input.hasNext() && words.size() < 10000) {

            String word = input.next();

            // Convert to lowercase for consistency
            word = word.toLowerCase();

            // Remove punctuation, numbers and special characters
            word = word.replaceAll("[^a-z]", "");

            // Store only valid words
            if (!word.equals("")) {
                words.add(word);
            }
        }

        // Close the file
        input.close();

        // Return all collected words
        return words;
    }
}