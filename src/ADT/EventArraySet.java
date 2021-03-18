/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import java.util.NoSuchElementException;

/**
 *
 * @author Fung Ann
 * @param <T>
 */
public class EventArraySet<T> implements EventSetInterface<T> {

    private T[] arraySet;
    private int size;

//    private static final double LOAD_FACTOR = .6;
    private static final int DEFAULT_SIZE = 11; // should be prime
    private final int NOT_FOUND = -1;

    public EventArraySet() {
        this(DEFAULT_SIZE);
    }

    public EventArraySet(int capacity) {
        this.size = 0; //initial to 0, means start adding at index 0
        // setArray = new int[capacity]
        // java SUPER class - Object
        arraySet = (T[]) new Object[capacity];
    }

    @Override
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

    @Override
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

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
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

//        public boolean remove(T anElement){
//        for(int i=0; i<size;i++){
//            if(arraySet[i].equals(anElement)){
//                //remove by calling removeGap
//                removeGap(i);
//                size--;
//                return true;
//            }
//        }
//        return false;
//    }
//        
//            private void removeGap(int targetIndex){
//        // the for loop should start from the targetIndex onward 
//        for(int i=targetIndex; i<size-1;i++){
//            arraySet[i] = arraySet[i+1];
//        }
//    }
    @Override
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
    public EventSetInterface<T> union(EventLinkedStackInterface<T> set) {
        EventArraySet<T> both = new EventArraySet<>();

        for (int index = 0; index < size; index++) {
            both.add(arraySet[index]);
        }

//        Iterator scan = set.iterator();
//        while (scan.hasNext()) {
//            both.add((T) scan.next());
//        }
        return both;
    }

//    public boolean contains(T element) {
//        for (int i = 0; i < size; i++) {
//            if (arraySet[i].equals(element)) {
//                return true;
//            }
//        }
//        return false;
//    }
    @Override
    public boolean contains(T target) {
        int search = NOT_FOUND;

        for (int index = 0; index < size && search == NOT_FOUND; index++) {
            if (arraySet[index].equals(target)) {
//                search = index;
                return true;
            }
        }
        return false;
//        return (search != NOT_FOUND);
    }
    
//    public boolean search(T target) {
//        EventArraySet<T> keyword = new EventArraySet<>();
//        
//        for (int i = 0; i < size; i++) {
//            if (arraySet[i].equals(keyword.getEntry(i))) {
//                return true;
//            }
//        }
//        return false;
//    }
    
//    @Override
//        public EventArraySet<T> search(T regNo) {
//        EventArraySet<T> item = new EventArraySet<>();
//        for(int i=0; i < size; i++){
//            if(arraySet[i].compareRegisNo(regNo) == 0){
//                item.add(arraySet[i]);
//            }
//        }
//        return item;
//    }
        

//    public EventSetInterface<T> contains(T searchRegisNo, T searchStudID, T searchEventNo) {
//        EventArraySet<T> keyword = new EventArraySet<>();
////        Event e = new Event();
//        T[] array = arraySet;
//        for (int i = 0; i < size; i++) {
//            if ((searchRegisNo, searchStudID, searchEventNo) == 0) {
//
//                return true;
//            }
//            break;
//        }
//        return false;
//    }
//    public LinkedListInterface<T> filterAdvance(T filterId1, T filterName1, T filterDate1, T filterDesc1, T filterURL1, T filterKeyword1, T filtersysRequirement1, T filterPEGI1, T filterSize1, T filterRating1) {
//        LinkedList<T> advanceKeyword = new LinkedList<>();
//        Node temp = firstNode;
//        for (int i = 0; i < numberOfEntries; i++) {
//            if (temp.data.compareByAdvance(filterId1, filterName1, filterDate1, filterDesc1, filterURL1, filterKeyword1, filtersysRequirement1, filterPEGI1, filterSize1, filterRating1) == 0) {
//                advanceKeyword.add((T) temp.data);
//                temp = temp.next;
//            } else {
//                temp = temp.next;
//            }
//
//        }
//        return advanceKeyword;
//
//    }
    @Override
    public T getEntry(int index) {
        T result = null;

        if ((index >= 0) && (index <= size)) {
            result = arraySet[index];
        }

        return result;
    }

//         public T getEntry(int index) {
//
//    }
    public int getSize() {
        return size;
    }

}
