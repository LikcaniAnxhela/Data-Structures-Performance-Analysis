/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.nonstandart;

/**
 *
 * @author Anxhi
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import weiss.util.DoubleLinkedList;
import weiss.util.DoubleLinkedListHeaderNoTail;
import weiss.util.DoubleLinkedListTailNoHeader;
import weiss.util.SinglyLinkedList;
import weiss.util.TextFileReader;

public class TestProgram{
    
    public static void main(String[]args){
        
        String fileName = "data/projectDS2026.txt";
        
        try {
            //1a.Read file and organize the dictionary
            ArrayList<String> words = TextFileReader.readAndSortWords(fileName);
            
            System.out.println("1.a Words read and sorted: " + words.size());
            
            //1b. Upload All words into the Singly Linked List
            SinglyLinkedList<String> singlyList = new SinglyLinkedList<>();
            
            for(String word: words){
                singlyList.addLast(word);
            }
            System.out.println("1b. Words uploaded into SinglyLinkedList:"+ singlyList.size());
            
            //1c. Upload ALL words into the Doubly Linked List
            DoubleLinkedList<String> doublyList = new DoubleLinkedList<>();
            
            for (String word: words){
                doublyList.addLast(word);
            }
            System.out.println("1c.Words uploaded into Double Linked List: "+ doublyList.size());
            
            // 2.a Singly Linked List operations: makeUnion and intersect
            // 3.a Split the 10,000 words in half
            
            int middle = words.size()/2;
            
            //3b. Uploaded each half into two different singly linked list
            
            SinglyLinkedList<String> firstHalf = new SinglyLinkedList<>();
            SinglyLinkedList<String> secondHalf = new SinglyLinkedList<>();
            
            for(int i = 0; i<middle; i++){
                firstHalf.addLast(words.get(i));
            }
            
            for(int i=middle; i<words.size(); i++){
                secondHalf.addLast(words.get(i));
            }
            System.out.println("3a. First half size:" + firstHalf.size());
            System.out.println("3a. Second half size:" + secondHalf.size());
            
            //3c. Use these lists to test makeUnion and interesct
            SinglyLinkedList<String> union = SinglyLinkedList.makeUnion(firstHalf, secondHalf);
            SinglyLinkedList<String> intersection = SinglyLinkedList.intersect(firstHalf, secondHalf);
            
            System.out.println("2.ai. / 3c Union size:" + union.size());
            union.printFirst(15);
            System.out.println("2.a.ii / 3.c Intersection size: " + intersection.size());
            
            //2b.i Doubly Linked List with ehader but no tail
            DoubleLinkedListHeaderNoTail<String> headerNoTail = new DoubleLinkedListHeaderNoTail<>();
            
            
            for (String word: words){
                headerNoTail.addLast(word);
            }
            System.out.println("2b.i Header but no tail size: " + headerNoTail.size());
            headerNoTail.printFirst(10);
            
            //2b.ii Double Linked List with tail but no header
            DoubleLinkedListTailNoHeader<String> tailNoHeader = new DoubleLinkedListTailNoHeader<>();
            
            for(String word: words){
                tailNoHeader.addLast(word);
            }
            System.out.println("2b.ii Tail but no header size: "+ tailNoHeader.size());
            
            System.out.print("First 10 words in tail/no-header list: ");
            tailNoHeader.printFirst(10);
            
            //4a. Final message for testing all routines
            System.out.println("4a. All routines and data structures tested successfully.");
            
        }catch (FileNotFoundException e){
            System.out.println("File not found. Check the data folder.");
            System.out.println("Expected path: "+ fileName);
            
        }
    }
    }


