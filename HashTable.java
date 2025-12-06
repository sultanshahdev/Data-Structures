import java.util.*;

public class HashTable
{

    private ArrayList<int> hashTableArray;
    public int capacity;
    private int DEFAULT_CAPACITY=10;


    public HashTable(int capacity)
    {
        this.hashTableArray=new ArrayList<int>();
        this.capacity=capacity;
    }
    public HashTable()
    {
        this.hashTableArray= new ArrayList<LinkedList>();
        this.capacity=DEFAULT_CAPACITY;
    }

    public int hashFunction(int keyValue)
    {
        return keyValue%(this.capacity);
    }

    public void insert(int value)
    {
        int index = hashFunction(value);
        insertAt(index,value);

    }
    public void insertAt(int index, int value)
    {

        hashTableArray.set(index,value);
    }

    public boolean search(int value)
    {
        int index = hashFunction(value);
        return searchAt(index,value);
    }
    public boolean searchAt(int index,int value)
    {
        return hashTableArray.get(index).contains(value);
    }
}