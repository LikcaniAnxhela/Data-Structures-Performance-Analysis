/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.util;

/**
 *
 * @author Anxhi
 * 2.b.i
 * 
 * 
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedListHeaderNoTail<AnyType> implements Iterable<AnyType>{
    private static class Node<AnyType>{
        AnyType data;
        Node<AnyType> prev;
        Node<AnyType> next;
        
        Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
        data = d;
        prev = p;
        next = n;
    }
    }
    private Node<AnyType> header;
    private int size;
    
    public DoubleLinkedListHeaderNoTail(){
        header = new Node<>(null,null,null);
        size = 0;
        
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    
    //-------
    //add at the end
    public void addLast(AnyType x){
        Node<AnyType> current = header;
        
        while (current.next != null){
            current = current.next;
        }
        
        Node<AnyType> newNode = new Node<>(x, current, null);
        current.next = newNode;
        size++;
    }
    //------
    /* add att the beginning*/
    
    public void addFirst(AnyType x){
        Node<AnyType> first = header.next;
        Node<AnyType> newNode = new Node<>(x, header, first);
        
        header.next = newNode;
        
        if(first != null){
            first.prev = newNode;
        }
        size++;
    }
    //-----
    //get element by index
    public AnyType get(int index){
        Node<AnyType> current = header.next;
        for (int i=0; i<index; i++){
            current = current.next;
        }
        return current.data;
    }
    //------
    //print first few elements
    public void printFirst(int limit){
        Node<AnyType> current = header.next;
        int count = 0;
        
        while (current != null && count<limit){
            System.out.print(current.data + " ");
            current = current.next;
            count++;
        }
        System.out.println();
    }
    
    public Iterator <AnyType> iterator(){
        return new Iterator<AnyType>(){
            private Node<AnyType> current = header.next;
            
            public boolean hasNext(){
                return current != null;
            }
            public AnyType next(){
                if(!hasNext())
                    throw new NoSuchElementException();
                
                AnyType data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
