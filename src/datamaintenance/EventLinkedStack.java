/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamaintenance;
import java.util.*;
import java.util.NoSuchElementException;

/**
 *
 * @author Ren
 */
public class EventLinkedStack<T> implements EventLinkedStackInterface<T>  {
   
    private int eList;
   private Node topNode;

 

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
    }


    public void updateEvent() {
        
    }
    
   @Override
    public T pop() {
        T top = peek();

        if (topNode != null) {
            topNode = topNode.next;
        }

        return top;
    }

    
    public T peek(){
          Node returnNode = null;
        if (topNode != null) {
            returnNode = topNode;

        }

        return (T) returnNode.data;
    }
    
    public void display(){
        if(topNode == null){
            System.out.println("Nothing in event list");
        //back to menu
        }
        else{
            
            while(topNode != null){
                int no =0;
                no +=1;
                
                System.out.printf("%-4s %-4s %-4s %-2s %-8s %-8s");// show list value / how???
//                return String.format("%-4s %-4s %-4s %-2s %-8s %-8s ",eventNo,title,date,time,location,description,fees);
      
            }
        }
    }
    
    public boolean isEmpty() {
       
        return topNode == null;
    }

 public int EventTotal(){
     return eList;
 }
    public void clear() {
//        eList.clear();
        
    }

  
    public void sortEvent() {

        
    }
 
    
    
    
}
