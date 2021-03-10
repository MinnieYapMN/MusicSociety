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
public interface EventListInterface<Event> {

    public void push (Event newEntry);

public void updateEvent();

public void updateMember();

public void pop();

public boolean isEmpty();
public void clear();

public void sortEvent();


    
    
}
