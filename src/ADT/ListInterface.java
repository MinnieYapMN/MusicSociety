/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 * 
 * @author Khau Wen Xuen 20WMR08920
 * 
 */
public interface ListInterface<T> {
    public boolean add(T newEntry);
    public T remove(int givenPosition);
    public T getEntry(int index);
    public void clear();
    public boolean isEmpty();
    public int getSize();
    public boolean isFull();
    public boolean contains(T element);   
}
