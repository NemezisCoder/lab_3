import java.util.LinkedList;

public class ProductHashTable {
    private class Entry {
        private String key;
        private Product value;

        Entry(String key, Product value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;
    private int size;

    public ProductHashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(String key, Product value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry(key, value));
        size++;
    }

    public Product get(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key.equals(key)) {
                    bucket.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }
}