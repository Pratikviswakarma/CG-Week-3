package hashmapandhashfunctions;

import java.util.*;

public class CustomHashMap<K, V> {
    private static final int SIZE = 16; // Default capacity
    private LinkedList<Entry<K, V>>[] map;

    // Entry class (Key-Value pair)
    static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public CustomHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int getHash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Put (Insert or Update)
    public void put(K key, V value) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }
        bucket.add(new Entry<>(key, value)); // Insert new entry
    }

    // Get (Retrieve value)
    public V get(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove (Delete key-value pair)
    public void remove(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    // Display HashMap
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (!map[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : map[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    // Main Method (Test Cases)
    public static void main(String[] args) {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();

        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 35);
        hashMap.put("Alice", 28); // Update value for Alice

        System.out.println("Alice's Age: " + hashMap.get("Alice")); // Output: 28
        System.out.println("Charlie's Age: " + hashMap.get("Charlie")); // Output: 35

        hashMap.remove("Bob");
        System.out.println("Bob's Age (After Removal): " + hashMap.get("Bob")); // Output: null

        hashMap.display(); // Show all key-value pairs
    }
}

