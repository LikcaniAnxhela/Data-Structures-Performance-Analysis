/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.ProjectPart2;

/**
 *
 * @author Anxhi
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2FileReader {

    /*
     * Reads words from the text file.
     * It cleans punctuation and converts words to lowercase.
     */
    public static ArrayList<String> readWords(String fileName)
            throws FileNotFoundException {

        ArrayList<String> words = new ArrayList<>();

        Scanner input = new Scanner(new File(fileName));

        while (input.hasNext() && words.size() < 10000) {
            String word = input.next();

            word = word.toLowerCase();
            word = word.replaceAll("[^a-z]", "");

            if (!word.equals("")) {
                words.add(word);
            }
        }

        input.close();

        return words;
    }
}