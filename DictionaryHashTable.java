import java.util.*;

public class DictionaryHashTable {

    static class Entry {
        String word;
        String meaning;

        Entry(String word, String meaning) {
            this.word = word;
            this.meaning = meaning;
        }
    }

    private List<LinkedList<Entry>> table;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public DictionaryHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public DictionaryHashTable(int capacity) {
        this.capacity = capacity;
        table = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }
    }

    public int hashFunction(String word) {
        int hash = 0;
        for (char c : word.toCharArray()) {
            hash += c;
        }
        return hash % capacity;
    }

    public void add(String word, String meaning) {
        int index = hashFunction(word);
        LinkedList<Entry> bucket = table.get(index);

        for (Entry e : bucket) {
            if (e.word.equals(word)) {
                e.meaning = meaning;
                return;
            }
        }

        bucket.add(new Entry(word, meaning));
    }

    public String search(String word) {
        int index = hashFunction(word);
        LinkedList<Entry> bucket = table.get(index);

        for (Entry e : bucket) {
            if (e.word.equals(word)) {
                return e.meaning;
            }
        }
        return null; 
    }
    public void delete(String word) {
        int index = hashFunction(word);
        LinkedList<Entry> bucket = table.get(index);

        bucket.removeIf(e -> e.word.equals(word));
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Index " + i + ": ");
            for (Entry e : table.get(i)) {
                System.out.print("[" + e.word + " = " + e.meaning + "] ");
            }
            System.out.println();
        }
    }

        public static void main(String[] args) {
        DictionaryHashTable dict = new DictionaryHashTable();

        dict.add("apple", "A sweet red fruit");
        dict.add("cat", "A small domesticated animal");
        dict.add("java", "A programming language");

        System.out.println("Meaning of 'cat': " + dict.search("cat"));

        dict.delete("apple");

        System.out.println("\nComplete Dictionary:");
        dict.display();
    }
}
