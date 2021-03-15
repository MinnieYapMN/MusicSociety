/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.*;
/**
 *
 * @author Fung Ann
 */
public class EventArraySet<T> implements EventSetInterface<T> {

    private T[] arraySet;
    private int size;
//    private static final double LOAD_FACTOR = .6;
    private static final int DEFAULT_SIZE = 11; // should be prime

    public EventArraySet() {
        this(DEFAULT_SIZE);
    }

    public EventArraySet(int capacity) {
        this.size = 0; //initial to 0, means start adding at index 0
        // setArray = new int[capacity]
        // java SUPER class - Object
        arraySet = (T[]) new Object[capacity];
    }

    public boolean add(T newElement) {
        // duplication check newElement is it exist in the currentSet
        for (int i = 0; i < size; i++) {
            if (arraySet[i].equals(newElement)) {
                if (isFull()) {
                    expandCapacity();
                }
                return false;
            }
        }

        // adding
        arraySet[size] = newElement;
        size++; //increase by and get ready  for next adding 
        return true;
    }

    public boolean isFull() {
        return size == arraySet.length;
    }

    private void expandCapacity() {
        T[] larger = (T[]) (new Object[arraySet.length * 2]);

        for (int index = 0; index < arraySet.length; index++) {
            larger[index] = arraySet[index];
        }

        arraySet = larger;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T remove(T element) {
        T retVal = null;
        int i = 0;
        //locate the element to be removed
        while (retVal == null && i < size) {
            if (arraySet[i].equals(element)) {
                retVal = arraySet[i];
                //shift all following elements one space forward
                //so there are no gaps in the array
                while (i < size) {
                    arraySet[i] = arraySet[i + 1];
                    i++;
                }
            }
            i++;
        }
        if (retVal == null) {
            throw new NoSuchElementException("ArraySet");
        }
        size--;
        return retVal;
    }

    public String toString() {
        String output = "";

        for (int index = 0; index < size; index++) {
            output = output + arraySet[index].toString() + "\n";
        }

        return output;
    }

//    public Iterator<T> iterator() {
//      return new ArrayIterator<T> (contents, count);
//        return ArraySet().iterator();
//    }

    public EventSetInterface<T> union(EventSetInterface<T> set) {
        EventArraySet<T> both = new EventArraySet<T>();

        for (int index = 0; index < size; index++) {
            both.add(arraySet[index]);
        }

//        Iterator scan = set.iterator();
//        while (scan.hasNext()) {
//            both.add((T) scan.next());
//        }

        return both;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (arraySet[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    
}
