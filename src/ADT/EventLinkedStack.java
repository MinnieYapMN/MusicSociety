/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;
import Entity.EventDetails;
import java.util.*;
//import java.util.NoSuchElementException;

/**
 *
 * @author Ren
 */
public class EventLinkedStack<T> implements EventLinkedStackInterface<T>  {
   
    private int eList;
   private Node topNode;

EventLinkedStackInterface <EventDetails> eventList ;
 

    //Inner class
    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;

        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;

        }

    }

    @Override
    public void push(T newEntry) {

        Node newNode = new Node(newEntry);

        newNode.next = topNode;

        topNode = newNode;
        eList++;
  
    }


    @Override
    public void updateEvent() {
        
    }
    
   @Override
    public T pop() {
        T top = peek();

        if (topNode != null) {
            topNode = topNode.next;
        }
    eList--;
        return top;
    }

    
    @Override
    public T peek(){
          Node returnNode = null;
        if (topNode != null) {
            returnNode = topNode;

        }

        return (T) returnNode.data;
    }
    
    
    
    @Override
    public boolean isEmpty() {
       
        return topNode == null;
    }

    /**
     *
     * @return
     */
    @Override
 public int EventTotal(){
     return eList;
 }
    @Override
    public void clear() {
//        eList.clear();
        
    }

  
    public void sortEvent() {

        
    }
    
    
    public boolean search(int No){
       if(topNode == null)
        return false;
       
       if(topNode.data.equals(No))
           return true;
       
       return search(No);
       
    }
    
    @Override
    public void display(){
      
         Node current = this.topNode;
        String result = "";
        for (int i = 0; i <eList ; i++) {
            System.out.println("No"+ (i+1)+" " +current.data.toString() + " ");
            current = current.next;
        }
    }
    
    @Override
     public T getEntry(int eStatus) {
        T result = null;

        if ((eStatus >= 0) && (eStatus <= eList)) {
            Node currentNode = topNode;
            for (int i = 0; i < eStatus; ++i) {
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }

        return result;
    }
 
 
    @Override
   public EventDetails get(int status) {
        return eventList.getEntry(status);
        
       
        
    }
    
      
    /**
     *
     * @return
     */
    @Override
      public int getDetails(){
          return eventList.EventTotal();
      }
      
//
//    
    

}