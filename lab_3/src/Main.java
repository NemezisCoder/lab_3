public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("key1", 1);
        hashTable.put("key2", 2);
        hashTable.put("key3", 3);

        System.out.println(hashTable.get("key2")); // Выводит 2
        hashTable.remove("key2");

        System.out.println(hashTable.get("key2")); // Выводит null
        System.out.println("Size: " + hashTable.size()); // Выводит 2
    }
}