package ADT;

public interface LinkListInterface<T> {

    public boolean add(T newEntry);

    public T remove(int givenPosition);

    public void clear();

    public T getEntry(int givenPosition);

    public boolean contains(T anEntry);

    public int getNumberOfEntries();

    public boolean isEmpty();
}
