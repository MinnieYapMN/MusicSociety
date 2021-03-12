/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamaintenance;

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
public boolean isEmpty();
public void clear();
public void sortEvent();



    
    
}
