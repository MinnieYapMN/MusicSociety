/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Fung Ann
 */
public interface SetInterface<T> {

    public boolean add(T newEntry);

    public boolean isFull();

    public boolean isEmpty();

    public T remove(T element);

    public String toString();

    public SetInterface<T> union(EventLinkedStackInterface<T> set);

    public boolean contains(T target);

    public T getEntry(int index);

    public int getSize();

}
