package hasheddictionary;

public class HashTable<K,V> implements HashTableInterface{

    //array of list nodes that stores K,V pairs
    protected Pair[] buckets;

    //how many items are currently in the map
    protected int size;


    /**
     * stores a key value pair and the pointer for chaining values
     */
    public class Pair{
        protected Object key;
        protected Object value;

        public Pair(Object k, Object v){
            key = k;
            value = v;
        }
    }

    /**
     * initializes with default capacity of 17
     */
    public HashTable(){
        this(17);
    }

    /**
     * initializes with the given capacity
     * @param capacity the capacity to make the array
     */
    public HashTable(int capacity){
        buckets = createBucketArray(capacity);
    }

    public int getSize() {
        return size;
    }


    public int getCapacity() {
        return buckets.length;
    }


    public Object get(Object key) {

        int hashedKey = (Math.abs(key.hashCode()))%buckets.length;
        int j = 0;
        while(true){
            Pair toCheck = buckets[hashedKey];
            if(toCheck == null){
                return null;
            }
            else if (toCheck.key.equals(key)){
                return toCheck.value;
            }
            j++;
            hashedKey = hash(key, j);
        }
    }

    public Object put(Object key, Object val) {
        int hashedKey = hash(key,0);
        Pair toPut = new Pair(key,val);
        int j = 0;
        while (true){
            if (buckets[hashedKey] == null){
                buckets[hashedKey] = toPut;
                size++;
                growIfNeeded();
                return null;
            }
            else if(buckets[hashedKey].key.equals(toPut.key)){
                Object tmp =  buckets[hashedKey].value;
                buckets[hashedKey] = toPut;
                return tmp;
            }
            else{
                j++;
                hashedKey = hash(key, j);
            }
        }
    }


    public boolean containsKey(Object key) {
        int hashedKey = hash(key,0);
        int j = 0;
        while(true){
            if (buckets[hashedKey] == null){
                return false;
            }
            else if(buckets[hashedKey].key.equals(key)){
                return true;
            }
            else{
                j++;
                hashedKey = hash(key, j);
            }
        }
    }


    public Object remove(Object key) {
        int hashedKey = hash(key, 0);
        int j = 0;
        while (true){
            if (buckets[hashedKey] == null){
                return null;
            }
            else if (buckets[hashedKey].key.equals(key)){
                Object tmp = buckets[hashedKey].value;
                buckets[hashedKey] = null;
                size--;
                return tmp;
            }
            else{
                j++;
                hashedKey = hash(key,j);
            }
        }
    }


    public void growIfNeeded() {

        if ((double)getSize()/(double)getCapacity() > 0.8){
            Pair[] oldArray = buckets;
            int oldCapacity = getCapacity();
            buckets = createBucketArray(getCapacity()*2);
            for (Pair p : oldArray){
                if (p == null){
                    break;
                }
                else{
                    putNoSearch(p);
                }
            }
        }
        else{
            return;
        }
    }

    /**
     * a private version of put that is only run when there is no need to search for the key first, and the size isnt changing
     *
     * @param p the pair to put
     */
    private void putNoSearch(Pair p){
        int j = 0;
        while (true){
            int hashedKey = hash(p.key,j);
            if (buckets[hashedKey] == null){
                buckets[hashedKey] = p;
                return;
            }
            else{
                j++;
            }
        }
    }

    private int hash (Object key, int j){
        return (Math.abs(key.hashCode()) + (j*j))% getCapacity();
    }

    protected void dump(){
        System.out.println("Table size: " + getSize() + " capacity: " +
                getCapacity());
        for (int i = 0; i < buckets.length; i++) {
            System.out.print(i + ": --");
            Pair node = buckets[i];
            System.out.println("|");
        }
    }

    /**
     * initializes and returns the array of buckets with the given size
     * @param size the size
     * @return the array
     */
    protected Pair[] createBucketArray(int size){
        return (Pair[]) new HashTable<?,?>.Pair[size];
    }
}
