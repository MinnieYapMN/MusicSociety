package ADT;

/**
 * LList.java A class that implements the ADT list by using a chain of nodes,
 * with the node implemented as an inner class. nee
 */ 
public class LinkList<T> implements LinkListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkList() {
        clear();
    }

    @Override
    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }

        numberOfEntries++;
        return true;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 0) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 0; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                result = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
            }
            numberOfEntries--;
        }

        return result;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition; ++i) {
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }

        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return found;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        boolean result;

        result = numberOfEntries == 0;

        return result;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
