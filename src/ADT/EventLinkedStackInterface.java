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
public void push (T newEntry);
public void updateEvent();
public T pop();
public T peek();
public void display();
 public boolean search(int No);
public boolean isEmpty();
public void clear();
public void sortEvent();
 public int EventTotal();
public T getEntry(int eStatus);
public EventDetails get(int status);
public int getDetails();

    
    
}
