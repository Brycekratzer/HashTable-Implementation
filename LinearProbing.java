import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * LinearProbing class represents a hash table implementation using linear probing collision resolution.
 * Extends the Hashtable class.
 */
public class LinearProbing extends Hashtable {

    /**
     * Constructs a new LinearProbing instance with the specified capacity and load factor.
     *
     * @param capacity   the initial capacity of the hash table
     * @param loadFactor the load factor threshold for resizing the hash table
     */
    public LinearProbing(int capacity, double loadFactor){
        super(capacity, loadFactor);
    }

    private int h(Object key){
        return positiveMod(key.hashCode(), capacity);
    }
    /**
     * Inserts an element into the hash table using linear probing.
     *
     * @param element the element to be inserted
     * @return 0 if insertion is successful, -1 if element already exists and its frequency is incremented, -2 if table is full
     */
    @Override
    protected int Hashinsert(Object element) {
        HashObject newHashObject = new HashObject(element);
        int position = h(element);
        while((size / capacity) <= loadFactor){
            if(hashtable[position] == null) {
                hashtable[position] = newHashObject;
                totalProbes = totalProbes + newHashObject.getProbe();
                size++;
                return 0;
            } else if (hashtable[position].equals(element)){
                hashtable[position].incrementFrequency();
                return -1;
            } else {
                newHashObject.incrementProbe();
            }
            position = (position + 1) % capacity;
        }
        return -2; //table full
    }

    /**
     * Searches for an element in the hash table using linear probing.
     *
     * @param element the element to be searched
     * @return the index of the element if found, otherwise -1
     */
    @Override
    protected int Hashsearch(Object element) {
        int i = 0;
        int j = h(element);
        do{
            j = (j + 1) % capacity;
            if(hashtable[j] != null && hashtable[j].equals(element)){
                return j;
            }
            i++;
        }while(i < capacity);
        return j;
    }

    /**
     * Performs positive modulo operation to handle negative dividends.
     *
     * @param dividend the dividend
     * @param divisor  the divisor
     * @return the positive remainder after division
     */
    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0){
            quotient += divisor;
        }
        return quotient;
    }
    
    /**
     * Gets the probe count for a specific element in the hash table.
     *
     * @param element the element to get the probe count for
     * @return the probe count
     */
    public int getProbe(Object element){
        return hashtable[Hashsearch(element)].getProbe();
    }

    /**
     * Gets the current size of the hash table.
     *
     * @return the size of the hash table
     */
    public int getSize(){
        return size;
    }

    /**
     * Dumps the contents of the hash table to a file.
     *
     * @param fileName the name of the file to dump the contents to
     */
    public void dumpToFile(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < capacity; i++){
            if(hashtable[i] != null){
                out.println("table[" +  i + "]: " + hashtable[i]);
            }
        }
        out.close();
    }
    public int getProbeCount(){
        return totalProbes;
    }
}