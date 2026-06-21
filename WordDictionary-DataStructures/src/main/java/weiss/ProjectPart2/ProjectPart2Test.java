/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.ProjectPart2;

/**
 *
 * @author Anxhi
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProjectPart2Test {

    public static void main(String[] args) {

        String fileName = "data/ProjectDS2026.txt";

        try {
            // Read 10,000 words from the text file
            ArrayList<String> words = Part2FileReader.readWords(fileName);

            System.out.println("Words loaded: " + words.size());
            System.out.println();

            /*
             * BST performance test
             */
            SimpleBST bst = new SimpleBST();

            long startBSTInsert = System.nanoTime();
            for (String word : words) {
                bst.insert(word);
            }
            long endBSTInsert = System.nanoTime();

            long startBSTSearch = System.nanoTime();
            for (String word : words) {
                bst.contains(word);
            }
            long endBSTSearch = System.nanoTime();

            long startBSTRemove = System.nanoTime();
            for (String word : words) {
                bst.remove(word);
            }
            long endBSTRemove = System.nanoTime();

            /*
             * AVL Tree performance test
             */
            SimpleAVLTree avl = new SimpleAVLTree();

            long startAVLInsert = System.nanoTime();
            for (String word : words) {
                avl.insert(word);
            }
            long endAVLInsert = System.nanoTime();

            long startAVLSearch = System.nanoTime();
            for (String word : words) {
                avl.contains(word);
            }
            long endAVLSearch = System.nanoTime();

            long startAVLRemove = System.nanoTime();
            for (String word : words) {
                avl.remove(word);
            }
            long endAVLRemove = System.nanoTime();

            /*
             * Hash Table performance test
             */
            int tableSize = words.size() * 2;
            SimpleHashTable hashTable = new SimpleHashTable(tableSize);

            long startHashInsert = System.nanoTime();
            for (String word : words) {
                hashTable.countHashPosition(word);
                hashTable.insert(word);
            }
            long endHashInsert = System.nanoTime();

            long startHashSearch = System.nanoTime();
            for (String word : words) {
                hashTable.contains(word);
            }
            long endHashSearch = System.nanoTime();

            long startHashRemove = System.nanoTime();
            for (String word : words) {
                hashTable.remove(word);
            }
            long endHashRemove = System.nanoTime();

            /*
             * Print final results
             */
            System.out.println("==================================");
            System.out.println("PART 2 RESULTS");
            System.out.println("==================================");
            System.out.println();

            System.out.println("BST");
            System.out.println("Insert Time : " + (endBSTInsert - startBSTInsert) + " ns");
            System.out.println("Search Time : " + (endBSTSearch - startBSTSearch) + " ns");
            System.out.println("Remove Time : " + (endBSTRemove - startBSTRemove) + " ns");
            System.out.println();

            System.out.println("AVL TREE");
            System.out.println("Insert Time : " + (endAVLInsert - startAVLInsert) + " ns");
            System.out.println("Search Time : " + (endAVLSearch - startAVLSearch) + " ns");
            System.out.println("Remove Time : " + (endAVLRemove - startAVLRemove) + " ns");
            System.out.println();

            System.out.println("HASH TABLE");
            System.out.println("Insert Time : " + (endHashInsert - startHashInsert) + " ns");
            System.out.println("Search Time : " + (endHashSearch - startHashSearch) + " ns");
            System.out.println("Remove Time : " + (endHashRemove - startHashRemove) + " ns");

            // Print hash distribution required in the project
            hashTable.printHashDistribution();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.out.println("Expected file: " + fileName);
        }
    }
}