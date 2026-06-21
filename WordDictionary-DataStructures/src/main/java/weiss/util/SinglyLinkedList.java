/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weiss.util;

/**
 *
 * @author Anxhi
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<AnyType extends Comparable<? super AnyType>>
        implements Iterable<AnyType>{
    
    private static class Node<AnyType>{
        
        AnyType data;
        Node<AnyType> next;
        
        Node(AnyType d, Node<AnyType> n) {
        data = d;
        next = n;
    }
    }
    
    private Node<AnyType> head;
    private Node<AnyType> tail;
    private int size;
    
    public SinglyLinkedList(){
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
    
    //add at the end (needed for loading 10000 words)
    public void addLast(AnyType x){
        Node<AnyType> newNode = new Node<>(x, null);
        
        if(isEmpty()){
            head=newNode;
            tail=newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    //get element by index
    
    public AnyType get(int index){
        Node<AnyType> current = head;
        
        for(int i = 0; i<index; i++){
            current = current.next;
        }
        return current.data;
    }
    
    //print first few elements
    public void printFirst(int limit){
        Node<AnyType> current = head;
        int count = 0;
        
        while(current != null&& count <limit){
            System.out.print(current.data + " ");
            current = current.next;
            count++;
        }
        System.out.println();
    }
    //iterator
    public Iterator <AnyType> iterator(){
        return new Iterator<AnyType>(){
            private Node<AnyType> current = head;
            
            public boolean hasNext(){
                return current!=null;
            }
            public AnyType next (){
                if(!hasNext())
                    throw new NoSuchElementException();
                
                AnyType data = current.data;
                current = current.next;
                return data;
            }
        };
    }
    
    //------
    // 2.a.i makeUnion
    public static <AnyType extends Comparable<? super AnyType>>
        SinglyLinkedList<AnyType> makeUnion(SinglyLinkedList<AnyType> list1,
        SinglyLinkedList<AnyType> list2){
    
    SinglyLinkedList<AnyType> result = new SinglyLinkedList<>();
    
    Node<AnyType> p= list1.head;
    Node<AnyType> q = list2.head;
    
    while(p != null&& q != null){
        int cmp = p.data.compareTo(q.data);
        
        if(cmp < 0){
            result.addLast(p.data);
            p=p.next;
        }else if(cmp > 0){
            result.addLast(q.data);
            q = q.next;
        }else{
            result.addLast(p.data);
            p=p.next;
            q = q.next;
        }
    }
    while(p != null){
        result.addLast(p.data);
        p=p.next;
    }
    while(q != null){
        result.addLast(q.data);
        q = q.next;
    }
    return result;
}
     
        //2.a.iiIntersect
        
        public static <AnyType extends Comparable<? super AnyType>>
        SinglyLinkedList<AnyType> intersect(SinglyLinkedList<AnyType> list1,
                SinglyLinkedList<AnyType> list2){
            SinglyLinkedList<AnyType> result = new SinglyLinkedList<>();
            
            Node<AnyType> p =list1.head;
            Node<AnyType> q = list2.head;
            
            while(p != null && q !=null){
                int cmp = p.data.compareTo(q.data);
                
                if(cmp<0){
                    p=p.next;
                }else if(cmp>0){
                    q=q.next;
                }else {
                    result.addLast(p.data);
                    p=p.next;
                    q=q.next;
                }
            }
            return result;
        }
}