/**
 * Abstract class representing a hash table.
 */
public abstract class Hashtable {
    protected int size; // Number of elements in the table
    protected int capacity; // Capacity of the table
    protected double loadFactor; // Load factor of the table
    protected HashObject hashtable[]; // Array to store HashObjects
    protected int totalProbes;

    /**
     * Constructs a hash table with the specified capacity and load factor.
     * @param capacity the capacity of the hash table
     * @param loadFactor the load factor of the hash table
     */
    public Hashtable(int capacity, double loadFactor){
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        hashtable = new HashObject[capacity];
    }

    /**
     * Abstract method to insert an element into the hash table.
     * @param element the element to insert
     * @return 0 if successful, -1 if duplicate, -2 if table is full
     */
    protected abstract int Hashinsert(Object element);

    /**
     * Abstract method to search for an element in the hash table.
     * @param element the element to search for
     * @return the index of the element if found, -1 otherwise
     */
    protected abstract int Hashsearch(Object element);

    /**
     * Abstract method to get the size of the hash table.
     * @return the number of elements in the hash table
     */
    protected abstract int getSize();

    /**
     * Abstract method to dump the contents of the hash table to a file.
     * @param filename the name of the file to dump to
     */
    protected abstract void dumpToFile(String filename);
}
