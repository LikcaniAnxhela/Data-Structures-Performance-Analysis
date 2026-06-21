/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.ProjectPart2;

/**
 *
 * @author Anxhi
 */
public class SimpleHashTable {

    private final String[] table;
    private final boolean[] deleted;
    private final int[] hashCounter;
    private final int tableSize;

    public SimpleHashTable(int tableSize) {
        this.tableSize = tableSize;
        table = new String[tableSize];
        deleted = new boolean[tableSize];
        hashCounter = new int[tableSize];
    }

    /*
     * Chapter 20 string hash function.
     * It multiplies the current hash value by 37
     * and adds each character.
     */
    public int hash(String word) {
        int hashVal = 0;

        for (int i = 0; i < word.length(); i++) {
            hashVal = 37 * hashVal + word.charAt(i);
        }

        hashVal %= tableSize;

        if (hashVal < 0) {
            hashVal += tableSize;
        }

        return hashVal;
    }

    /*
     * This method is only for distribution analysis.
     * It counts how many times each original hash position is used.
     */
    public void countHashPosition(String word) {
        int position = hash(word);
        hashCounter[position]++;
    }

    /*
     * Insert using linear probing.
     * If the calculated position is full, move to the next one.
     */
    public void insert(String word) {
        int position = hash(word);

        while (table[position] != null && !table[position].equals(word)) {
            position++;

            if (position == tableSize) {
                position = 0;
            }
        }

        table[position] = word;
        deleted[position] = false;
    }

    /*
     * Search using the same probing path as insertion.
     */
    public boolean contains(String word) {
        int position = hash(word);
        int startPosition = position;

        while (table[position] != null || deleted[position]) {
            if (table[position] != null && table[position].equals(word)) {
                return true;
            }

            position++;

            if (position == tableSize) {
                position = 0;
            }

            if (position == startPosition) {
                return false;
            }
        }

        return false;
    }

    /*
     * Lazy deletion.
     * The cell is marked as deleted instead of breaking the probing path.
     */
    public void remove(String word) {
        int position = hash(word);
        int startPosition = position;

        while (table[position] != null || deleted[position]) {
            if (table[position] != null && table[position].equals(word)) {
                table[position] = null;
                deleted[position] = true;
                return;
            }

            position++;

            if (position == tableSize) {
                position = 0;
            }

            if (position == startPosition) {
                return;
            }
        }
    }

    /*
     * Prints how many table positions were hashed to
     * 0 times, 1 time, 2 times, etc.
     */
    public void printHashDistribution() {
        int[] frequency = new int[20];

        for (int i = 0; i < tableSize; i++) {
            int count = hashCounter[i];

            if (count >= 19) {
                frequency[19]++;
            } else {
                frequency[count]++;
            }
        }

        System.out.println();
        System.out.println("Hash Distribution Analysis:");

        for (int i = 0; i < frequency.length; i++) {
            double percentage = (frequency[i] * 100.0) / tableSize;

            if (i == 19) {
                System.out.printf("Positions hashed 19 or more times: %d (%.2f%%)%n",
                        frequency[i], percentage);
            } else {
                System.out.printf("Positions hashed %d times: %d (%.2f%%)%n",
                        i, frequency[i], percentage);
            }
        }
    }
}