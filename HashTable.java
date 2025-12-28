import java.util.*;

public class HashTable
{

    public static void main(String[] args)
    {
        HashTable ht = new HashTable();

        
        String st="the cat sat on the mat";

        String[] s=st.split(" ");

        for(String string:s)
        {
            ht.insert(string);
        }

        ht.printWordFrequency();





    }
    private List <LinkedList<String>> array;
    public int capacity;
    private static final int DEFAULT_CAPACITY=10;


    public HashTable(int capacity)
    {
        array= new ArrayList<LinkedList<String>>(capacity);
        for(int i=0;i<capacity;i++)
        {
            array.add(new LinkedList<String>());
        }
        this.capacity=capacity;
    }
    public HashTable()
    {
        this(DEFAULT_CAPACITY);

    }

    public int hashFunction(String str)
    {
        int hashValue=0;
        for(char c:str.toCharArray())
        {
            hashValue+=c;
        }
        return hashValue %capacity;
    }

    public void insert(String str)
    {
        int index = hashFunction(str);
        insertAt(index,str);

    }
    public void insertAt(int index, String str)
    {

        array.get(index).add(str);
    }

    public String toString()
    {
        String s="[";
        for(int i=0;i<capacity;i++)
        {

            s+="index-> "+ i + " "; 
            for(int j=0;j<array.get(i).size();j++)
            {
                s+=array.get(i).get(j)+",";
            }
            
        }
        s+="]";


        return s;
    }



    public void delete(String str)
    {
        int[] index=search(str);

        if(index[0]!=-1)
        {
            array.get(index[0]).remove(index[1]);
        }

    }
    public int[] search(String str)
    {
        int index=hashFunction(str);
        LinkedList temp = array.get(index);
        for(int i=0;i<temp.size();i++)
        {
            if(temp.get(i).equals(str))
            {

                return new int[] {index,i};
            }
        }
        return new int[]{-1,-1};
    }
    public void printWordFrequency() {
    HashMap<String, Integer> freq = new HashMap<>();

    for (int i = 0; i < capacity; i++) {
        for (String w : array.get(i)) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
    }

    System.out.println(freq);
}


}