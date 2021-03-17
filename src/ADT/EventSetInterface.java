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
public interface EventSetInterface<T> {

    public boolean add(T newEntry);
    //public V search(K key);
//     public boolean remove(Object x);
//     public void displayAll();

    public T getEntry(int index);

    public boolean isEmpty();

    public int getSize();

    public boolean isFull();

    public T remove(T element);

    public boolean contains(T target);
//         public boolean remove(T anElement);
//    public boolean checkSubset(SetInterface anotherSet);
//    public void union(SetInterface anotherSet);
//    public SetInterface intersection(SetInterface anotherSet);

//    public boolean contains(String regis);

//    public boolean contains(String target);
}
