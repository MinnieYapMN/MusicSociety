/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Entity.EventDetails;

/**
 *
 * @author Ren
 */
public interface EventLinkedStackInterface<T> {
public void push (T newEntry); // add new details
public T pop(); // remove the top event details
public T peek();
//public void display(); // display all in stack
public boolean isEmpty();
public void clear(); // clear all daata
 public int EventTotal(); // total in listt
public T getEntry(int a); // get all entry in data


    
    
}
