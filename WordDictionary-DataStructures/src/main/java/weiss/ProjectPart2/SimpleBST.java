/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.ProjectPart2;

/**
 *
 * @author Anxhi
 */
public class SimpleBST {

    /*
     * Node of the Binary Search Tree.
     * Each node stores one word and two child links.
     */
    private static class Node {
        String word;
        Node left;
        Node right;

        Node(String word) {
            this.word = word;
            left = null;
            right = null;
        }
    }

    private Node root;

    public SimpleBST() {
        root = null;
    }

    // Inserts a word into the BST
    public void insert(String word) {
        root = insert(word, root);
    }

    private Node insert(String word, Node t) {
        if (t == null) {
            return new Node(word);
        }

        int compareResult = word.compareTo(t.word);

        if (compareResult < 0) {
            t.left = insert(word, t.left);
        } else if (compareResult > 0) {
            t.right = insert(word, t.right);
        }

        // Duplicate words are ignored
        return t;
    }

    // Searches for a word in the BST
    public boolean contains(String word) {
        return contains(word, root);
    }

    private boolean contains(String word, Node t) {
        if (t == null) {
            return false;
        }

        int compareResult = word.compareTo(t.word);

        if (compareResult < 0) {
            return contains(word, t.left);
        } else if (compareResult > 0) {
            return contains(word, t.right);
        } else {
            return true;
        }
    }

    // Removes a word from the BST
    public void remove(String word) {
        root = remove(word, root);
    }

    private Node remove(String word, Node t) {
        if (t == null) {
            return null;
        }

        int compareResult = word.compareTo(t.word);

        if (compareResult < 0) {
            t.left = remove(word, t.left);
        } else if (compareResult > 0) {
            t.right = remove(word, t.right);
        } else if (t.left != null && t.right != null) {
            t.word = findMin(t.right).word;
            t.right = remove(t.word, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }

        return t;
    }

    // Finds the smallest word in a subtree
    private Node findMin(Node t) {
        while (t != null && t.left != null) {
            t = t.left;
        }

        return t;
    }
}