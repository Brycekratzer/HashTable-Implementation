import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Represents a hash table implemented using double hashing collision resolution strategy.
 */
public class DoubleHashing extends Hashtable {

    /**
     * Constructs a DoubleHashing object with the specified capacity and load factor.
     *
     * @param capacity   the initial capacity of the hash table
     * @param loadFactor the load factor threshold for resizing the hash table
     */
    public DoubleHashing(int capacity, double loadFactor){
        super(capacity, loadFactor);
    }

    /**
     * Computes the initial position hash value using the first hash function.
     *
     * @param key the key for which hash value is computed
     * @return the computed hash value
     */
    protected int h1(HashObject key) {
        int Index = positiveMod(key.getKey().hashCode(), capacity); // gets initial position h(k)
        return Index;
    }

    /**
     * Computes the secondary hash value for double hashing.
     *
     * @param key the key for which hash value is computed
     * @return the computed hash value
     */
    protected int h2(HashObject key){
        int Index = 1 + positiveMod(key.getKey().hashCode(), capacity - 2);
        return Index;
    }

    /**
     * Inserts the specified element into the hash table using double hashing.
     *
     * @param element the element to be inserted
     * @return 0 if insertion is successful, -1 if the element is already present (duplicate),
     *         or -2 if the table is full
     */
    @Override
    protected int Hashinsert(Object element) {
        HashObject newHashObject = new HashObject(element);
        int initialHash = h1(newHashObject);
        int hashFunction2 = h2(newHashObject);
        while((size / capacity) <= loadFactor){
            if(hashtable[initialHash] == null) {
                hashtable[initialHash] = newHashObject;
                totalProbes = totalProbes + newHashObject.getProbe();
                size++;
                return 0;
            } else if (hashtable[initialHash].equals(element)){
                hashtable[initialHash].incrementFrequency();
                return -1;
            } else {
                newHashObject.incrementProbe();
            }
            initialHash = (initialHash + hashFunction2) % capacity;
        }
        return -2; //table full
    }

    /**
     * Searches for the specified element in the hash table using double hashing.
     *
     * @param element the element to search for
     * @return the index of the element if found, otherwise -1
     */
    @Override
    protected int Hashsearch(Object element) {
        HashObject tempHashObject = new HashObject(element);
        int i = 0;
        int initialHash = h1(tempHashObject);
        int hashFunction2 = h2(tempHashObject);
        do{
            initialHash = (initialHash + hashFunction2) % capacity;
            if(hashtable[initialHash] != null && hashtable[initialHash].equals(element)){
                return initialHash;
            }
            i++;
        }while(i < capacity);
        return initialHash;
    }

    /**
     * Computes the positive modulus of the dividend and divisor.
     *
     * @param dividend the dividend
     * @param divisor  the divisor
     * @return the positive modulus result
     */
    protected int positiveMod(int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }

    /**
     * Retrieves the probe count for the specified element.
     *
     * @param element the element for which probe count is retrieved
     * @return the probe count
     */
    public int getProbe(Object element){
        return hashtable[Hashsearch(element)].getProbe();
    }

    /**
     * Retrieves the size of the hash table.
     *
     * @return the size of the hash table
     */
    public int getSize(){
        return size;
    }

    /**
     * Dumps the contents of the hash table to a file.
     *
     * @param fileName the name of the file to which the contents are dumped
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
