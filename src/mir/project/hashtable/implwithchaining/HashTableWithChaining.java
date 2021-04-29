package mir.project.hashtable.implwithchaining;

import java.lang.reflect.Array;

public class HashTableWithChaining<T extends Comparable> {
    private Node<T>[] internalArray;
    private final int INTERNAL_CAPASITY = 17;
    private int size;

    public HashTableWithChaining() {
        this.internalArray = (Node<T>[]) Array.newInstance(Node.class, INTERNAL_CAPASITY);;
    }

    public T put(String key, T item) {
        int hash = hash(key);
        Node<T> node = new Node<>(key, item);
        if (internalArray[hash] != null) {
            Node chain = internalArray[hash];
            while (chain.next != null) {
                if (chain.key.equals(key)) {
                    return null;
                }
                chain = chain.next;
            }
            if (chain.key.equals(key)) {
                return null;
            }
            chain.next = node;
            size++;
            return node.data;
        } else {
            size++;
            internalArray[hash] = node;
            return internalArray[hash].data;
        }
    }

    public T get(String key) {
        int hash = hash(key);
        if (internalArray[hash] == null) {
            return null;
        }

        Node<T> chain = internalArray[hash];

        if (chain.key.equals(key)) {
            return chain.data;
        }

        while (chain.next != null) {
            if (chain.next.key.equals(key)) {
                return chain.next.data;
            }
            chain = chain.next;
        }
        return null;
    }

    public T remove(String key) {
        int hash = hash(key);
        if (internalArray[hash] == null) {
            return null;
        }

        Node<T> chain = internalArray[hash];
        if (chain.key.equals(key)) {
            size--;
            internalArray[hash] = chain.next;
            return chain.data;
        }

        while (chain.next != null) {
            if (chain.next.key.equals(key)) {
                size--;
                T temp = chain.next.data;
                chain.next = chain.next.next;
                return temp;
            }
            chain = chain.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int hash(String text) {
        return text.length() % INTERNAL_CAPASITY;
    }
}
