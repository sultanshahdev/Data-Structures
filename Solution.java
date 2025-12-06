import java.util.HashMap;
import java.util.Map;

class Solution
{
    public int[] twoSum(int[] arr, int target)
    {
        Map<Integer,Integer> hashmap= new HashMap<Integer,Integer>();

        for(int i=0; i<arr.length;i++)
        {
            hashmap.put(arr[i], i);
        }

        for(int i=0;i<hashmap.size();i++)
        {
            int value=target-hashmap.get(i);
            
            (if hashmap.containsValue(value) && hashmap.compute(value)!=i)
            {
                return new int[] arr = {i,}
            }
             
        }


    }


}
