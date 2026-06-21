/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.util;

/**
 *
 * @author Anxhi
 * 2.b.ii
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedListTailNoHeader<AnyType> implements Iterable<AnyType>{
    
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
    private Node<AnyType> first;
    private Node<AnyType> tail;
    private int size;
    
    public DoubleLinkedListTailNoHeader(){
        tail = new Node<>(null, null, null);
        first = tail;
        size =0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    //add at the end
    public void addLast(AnyType x){
        Node<AnyType> newNode = new Node<>(x, tail.prev, tail);
        
        if(isEmpty()){
            first = newNode;
        }else{
            tail.prev.next = newNode;
        }
        
        tail.prev = newNode;
        size++;
    }
    
    //add at the beginning
    public void addFirst(AnyType x){
        Node<AnyType> newNode = new Node<>(x, null, first);
        
        if(isEmpty()){
            tail.prev = newNode;
            
        }else{
            first.prev = newNode;
            
        }
        first = newNode;
        size++;
    }
    
    public AnyType get(int index){
        Node<AnyType> current = first;
        
        for (int i=0; i<index; i++){
            current = current.next;
        }
        return current.data;
    }
    
    public void printFirst(int limit){
        Node<AnyType> current = first;
        int count = 0;
        
        while(current != tail && count<limit){
            System.out.print(current.data + " ");
            current = current.next;
            count++;
            
        }
        System.out.println();
    }
    
    public Iterator<AnyType> iterator(){
        return new Iterator<AnyType>(){
            private Node<AnyType> current = first;
            
            public boolean hasNext(){
                return current != tail;
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
