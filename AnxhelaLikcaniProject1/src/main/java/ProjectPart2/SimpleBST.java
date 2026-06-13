/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectPart2;

public class SimpleBST {

    /*
     * Node class used to store each word in the tree.
     */
    private static class Node {

        String word;
        Node left;
        Node right;

        public Node(String word) {
            this.word = word;
            left = null;
            right = null;
        }
    }

    // Root of the Binary Search Tree
    private Node root;

    // Constructor
    public SimpleBST() {
        root = null;
    }

    /*
     * Public insert method.
     * Calls the recursive insert helper.
     */
    public void insert(String word) {
        root = insert(word, root);
    }

    /*
     * Recursive insertion.
     * Smaller words go left.
     * Larger words go right.
     */
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

        // Ignore duplicates
        return t;
    }

    /*
     * Public search method.
     */
    public boolean contains(String word) {
        return contains(word, root);
    }

    /*
     * Recursive search.
     */
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

    /*
     * Public remove method.
     */
    public void remove(String word) {
        root = remove(word, root);
    }

    /*
     * Recursive remove.
     */
    private Node remove(String word, Node t) {

        if (t == null) {
            return null;
        }

        int compareResult = word.compareTo(t.word);

        if (compareResult < 0) {
            t.left = remove(word, t.left);
        } else if (compareResult > 0) {
            t.right = remove(word, t.right);
        }

        // Node with two children
        else if (t.left != null && t.right != null) {

            t.word = findMin(t.right).word;

            t.right = remove(t.word, t.right);
        }

        // One child or no child
        else {
            t = (t.left != null) ? t.left : t.right;
        }

        return t;
    }

    /*
     * Finds the minimum node in a subtree.
     */
    private Node findMin(Node t) {

        if (t == null) {
            return null;
        }

        while (t.left != null) {
            t = t.left;
        }

        return t;
    }
}