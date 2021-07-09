package leetcode;

public class MyHashMap<K, V> {
    public Entry[] table;
    private static final Integer CAPACITY = 8;

    public void put(K k, V v) {
        Entry<K, V> entry = new Entry<>(k, v);
        if (table == null) {
            inflate();
        }
        int hashCode = hash(k);
        int index = indexFor(hashCode);
        addEntry(k, v, index);


    }

    private void addEntry(K k, V v, int index) {
        Entry<K, V> newEntry = new Entry<>(k, v, table[index]);
        table[index] = newEntry;

    }

    private int indexFor(int hashCode) {
        return hashCode % CAPACITY;
    }

    private int hash(K k) {
        return k.hashCode();
    }

    private void inflate() {
        table = new Entry[CAPACITY];
    }

    public V get(K k) {
        return null;
    }

}
