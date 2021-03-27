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
public class ArrayList<T> implements ListInterface<T> {
    private final static int MAX_SIZE = 100;
    private T[] array;
    private int size;

    public ArrayList() {
        array = (T[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public boolean add(T item) {
        if (item != null) {
            if (isFull()) {
                expandArray();
            }
        }

        array[size] = item; //numberOfEntries is the index for the next entry
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        
        if (!isEmpty()){
            if ((index >= 1) && (index <= size)) {
                T removedEntry = array[index - 1];
                size--;
                for(int i = index; i < size; i++){
                    array[i-1] = array[i]; // do sifting
                }
            return removedEntry;                  
            }
           
        }
        return null; //position wasn't found/ list is empty
    }

    @Override
    public T getEntry(int index) {
        if (!isEmpty()){
            if ((index >= 1) && (index <= size)) {
                return array[index - 1];
            }
        }
        return null;
    }
    


    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    private void expandArray() {
        //assign array address to oldArray
        T[] oldArray = array;
        //create new array with double the size
        array = (T[]) new Object[oldArray.length * 2];
        //copy value one by one from oldArray to array
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
        oldArray = null;
    }

    @Override
    public String toString() {
        String str = "";
        System.out.println("================================================================================================================================");
        System.out.println("No" + "     " + "Payment No" + "    " + "Payment Date" + "     " + "Payment Time" + "       " + "Register No" + "       " + "Event No" + "       " + "Student ID" + "       " + "Total Amount(RM)");
        System.out.println("================================================================================================================================");
        for (int i = 0; i < size; i++) {
            //str += "[" + i + "]" + array[i].toString() + "\n";
            str += "[" + (i+1) + "]" + "    " + array[i].toString() + "\n";
           
        }
        return str;

    }

    
    @Override
    public boolean contains(T element) {
        boolean found = false;
        for (int index = 0; !found && (index < size); index++) {
            if (element.equals(array[index]) == true) {
                found = true;
            }
        }
        return found;
    }

    
}
