package leetcode;

public class Entry<K, V> {
    public K key;
    public V value;
    public Entry next;

    public Entry(K key, V value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
