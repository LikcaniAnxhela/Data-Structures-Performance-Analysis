/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.util;

/**
 *
 * @author Anxhi
 * *1.c
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<AnyType> implements Iterable<AnyType>{
    private static class Node<AnyType> {
        AnyType data;
        Node<AnyType> prev;
        Node<AnyType> next;
        
        Node(AnyType d, Node<AnyType> p, Node<AnyType> n){
            data = d;
            prev = p;
            next = n;
        }
    }
    private Node<AnyType> head;
    private Node<AnyType> tail;
    private int size;
    
    public DoubleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    //add at the end
    public void addLast(AnyType x){
        Node<AnyType> newNode = new Node<>(x, tail, null);
        
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.next=newNode;
            tail = newNode;
        }
        size ++;
    }
    
    //add ata the beginning
    public void addFirst(AnyType x){
        Node<AnyType> newNode = new Node<>(x, null, head);
        
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    //get element by index
    public AnyType get(int index){
        Node<AnyType> current;
        
        if(index<size/2){
            current = head;
            for(int i =0; i<index; i++){
                current = current.next;
            }
        }else{
            current = tail;
            for(int i =size - 1; i>index; i--){
                current = current.prev;
            }
        }
        return current.data;
    }
    
    //print first few elements
    public void printFirst(int limit){
        Node<AnyType> current = head;
        int count = 0;
        
        while (current != null && count<limit){
            System.out.print(current.data + " ");
            current = current.next;
            count++;
        }
        System.out.println();
    }
    
    //Iterator
    public Iterator<AnyType> iterator(){
        return new Iterator<AnyType>(){
            private Node<AnyType> current = head;
            
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