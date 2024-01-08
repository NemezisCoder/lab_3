import java.util.LinkedList;

public class HashTable<K, V> {
    // Внутренний класс Entry для хранения пар ключ-значение
    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // Геттеры и сеттеры
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    // Массив связных списков для хранения записей
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    // Конструктор хэш-таблицы с заданной вместимостью
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    // Хэш-функция для вычисления индекса по ключу
    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    // Добавление пары ключ-значение в таблицу
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    // Получение значения по ключу
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null; // Если ключ не найден
    }

    // Удаление записи по ключу
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    bucket.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    // Возвращает количество элементов в хэш-таблице
    public int size() {
        return size;
    }

    // Проверяет, пуста ли хэш-таблица
    public boolean isEmpty() {
        return size == 0;
    }
}