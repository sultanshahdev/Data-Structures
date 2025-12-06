public class HashTableUser {

    public static void main(String args[])
    {
        HashTable hashTable = new HashTable();

        hashTable.insert(45);
        hashTable.insert(29);

        System.out.println(hashTable.search(29));


    }
}
