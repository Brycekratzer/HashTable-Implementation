import java.util.Objects;

/**
 * Represents an object that can be stored in a hash table.
 */
public class HashObject {
    private Object key;
    private int frequencyCount;
    private int probeCount;

    /**
     * Constructs a HashObject with the specified key.
     * @param key the key of the object
     */
    public HashObject(Object key){
        this.key = key;
        frequencyCount = 1;
        probeCount = 1;
    }

    /**
     * Retrieves the key of the HashObject.
     * @return the key of the object
     */
    public Object getKey(){
        return key;
    }

    /**
     * Increments the frequency count of the HashObject.
     */
    public void incrementFrequency(){
        frequencyCount++;
    }

    /**
     * Increments the probe count of the HashObject.
     */
    public void incrementProbe(){
        probeCount++;
    }

    /**
     * Retrieves the probe count of the HashObject.
     * @return the probe count
     */
    public int getProbe(){
        return probeCount;
    }
    
    /**
     * Retrieves the frequency count of the HashObject.
     * @return the frequency count
     */
    public int getFrequency(){
        return frequencyCount;
    }

    /**
     * Compares this HashObject with the specified object for equality.
     * @param object the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object object){
        return key.equals(object);
    }
    
    /**
     * Returns a string representation of the HashObject.
     * @return a string representation
     */
    @Override
    public String toString(){
        return key + " " + frequencyCount + " " + probeCount;
    }

    /**
     * Returns a hash code value for the HashObject.
     * @return a hash code value
     */
    @Override
    public int hashCode(){
        return Objects.hash(key);
    }
}