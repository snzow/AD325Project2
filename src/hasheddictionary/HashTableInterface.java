package hasheddictionary;

public interface HashTableInterface<K,V> {

    /**
     * returns the size of the table
     * @return the size of the table
     */
    public int getSize();

    /**
     * returns the current capacity of the table
     * @return the capacity of the table
     */
    public int getCapacity();

    /**
     * returns the value to which the key is mapped, or null if it doesnt contain the key
     * runs in O(1)
     * @param key the key to find the value with
     * @return the value associated with key
     */
    public V get(K key);

    /**
     * link the specified value with the specified key in the map. if the map already had mapping for the key
     * the old value is replaced. if the load factor is over 0.8 after this operation, will grow the array by a factor
     * of two and rehash
     * @param key the key value to associate val with
     * @param val the value to associate with the key - CAN NOT BE NULL
     * @return the previous value associated with the key, or null if it was unmapped
     */
    public V put(K key, V val);

    /**
     * returns true if the map contains a mapping for the key
     * @param key the key to check for
     * @return whether the map contains the key
     */
    public boolean containsKey(K key);

    /** remove the mapping for the key from the map if present
     *
     * @param key the key to check
     * @return the value associated with the key or null if it was unmapped
     */
    public V remove(K key);

    /**
     * checks the load factor, if it is over 0.8 doubles the array size and rehashes the values in the array
     */
    public void growIfNeeded();


}
