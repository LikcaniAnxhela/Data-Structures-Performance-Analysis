/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.util;

/**
 *
 * @author Anxhi
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TextFileReader {
    public static ArrayList<String> readAndSortWords(String fileName)
            throws FileNotFoundException {
        
        ArrayList<String> words = new ArrayList<>();
        
        try (Scanner input = new Scanner(new File(fileName))) {
            while (input.hasNext()) {
                String word = input.next();
                
                word = word.toLowerCase();
                word = word.replaceAll("[^a-z]","");
                
                if(!word.equals("")){
                    words.add(word);
                }
            }
        }
        
        Collections.sort(words);
        
        return words;
    }
}