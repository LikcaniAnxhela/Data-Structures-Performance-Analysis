/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectPart2;

public class SimpleAVLTree {

    /*
     * Node used in the AVL Tree.
     * Stores the word, height and references to children.
     */
    private static class Node {

        String word;
        Node left;
        Node right;
        int height;

        public Node(String word) {
            this.word = word;
            left = null;
            right = null;
            height = 0;
        }
    }

    private Node root;

    public SimpleAVLTree() {
        root = null;
    }

    /*
     * Returns height of a node.
     */
    private int height(Node t) {
        return t == null ? -1 : t.height;
    }

    /*
     * Public insert method.
     */
    public void insert(String word) {
        root = insert(word, root);
    }

    /*
     * Recursive AVL insertion.
     */
    private Node insert(String word, Node t) {

        if (t == null) {
            return new Node(word);
        }

        int compareResult = word.compareTo(t.word);

        if (compareResult < 0) {
            t.left = insert(word, t.left);
        }
        else if (compareResult > 0) {
            t.right = insert(word, t.right);
        }

        return balance(t);
    }

    /*
     * Public search method.
     */
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
        }
        else if (compareResult > 0) {
            return contains(word, t.right);
        }
        else {
            return true;
        }
    }

    /*
     * Public remove method.
     */
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
        }
        else if (compareResult > 0) {
            t.right = remove(word, t.right);
        }
        else if (t.left != null && t.right != null) {

            t.word = findMin(t.right).word;

            t.right = remove(t.word, t.right);
        }
        else {
            t = (t.left != null) ? t.left : t.right;
        }

        return balance(t);
    }

    /*
     * Finds the smallest element.
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

    private static final int ALLOWED_IMBALANCE = 1;

    /*
     * Balances the tree after insertion/removal.
     */
    private Node balance(Node t) {

        if (t == null) {
            return t;
        }

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {

            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            }
            else {
                t = doubleWithLeftChild(t);
            }
        }

        else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {

            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            }
            else {
                t = doubleWithRightChild(t);
            }
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;

        return t;
    }

    /*
     * Single rotation with left child.
     */
    private Node rotateWithLeftChild(Node k2) {

        Node k1 = k2.left;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;

        return k1;
    }

    /*
     * Single rotation with right child.
     */
    private Node rotateWithRightChild(Node k1) {

        Node k2 = k1.right;

        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;

        return k2;
    }

    /*
     * Double rotation (left-right).
     */
    private Node doubleWithLeftChild(Node k3) {

        k3.left = rotateWithRightChild(k3.left);

        return rotateWithLeftChild(k3);
    }

    /*
     * Double rotation (right-left).
     */
    private Node doubleWithRightChild(Node k1) {

        k1.right = rotateWithLeftChild(k1.right);

        return rotateWithRightChild(k1);
    }
}