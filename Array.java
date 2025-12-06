import java.util.NoSuchElementException;

public class Array
{



	public static void main(String args[])
	{
		Array arr= new Array();

		arr.add(19);
		arr.add(23);
		arr.add(34);

		try
		{	
			arr.remove(1);
		}
		catch(Exception e)
		{
			System.out.println("Caught Exception of the type "+ e.getMessage());
		}
		finally
		{
			System.out.print(arr);
		}
	}
    private int[] array;
    private int numOfElems;
    private static final int DEFAULT_ARRAY_CAPACITY=10;
    private int sizeOfArray;

    public Array(int size)
    {
	array=new int[size];
	numOfElems=0;
    }

    public Array()
    {
	this(DEFAULT_ARRAY_CAPACITY);
    }

    public void  add(int val)
    {
		setValue(val,numOfElems);
		increaseSize();
		
    }
	
    public int get(int index) throws Exception
    {
		ensureBounds(index);

		return array[index];
    }


    public void remove(int index) throws Exception
    {
		ensureBounds(index);
		int i=numOfElems;
		while(i>index)
		{
			setValue(get(i),i-1);
		}
		decreaseSize();
		
	}

    public void removeValue(int val) throws Exception
    {
	int indexOfVal = search(val);
	if(indexOfVal==-1)
	{
		throw new NoSuchElementException("No such element found exited with eror code"+ indexOfVal);
	}
	if(!checkTwo(indexOfVal,-1,0));
	{
	    remove(indexOfVal);
	}
    }

    public int search(int val)
    {
	for(int i=0;i<array.length;i++)
	{
	    if(array[i]==val)
		return i;
	}
	return -1;
    }
    
    public void decreaseSize()
    {
	numOfElems--;
    }

    public boolean ensureBounds(int index) throws Exception
    {
		if(checkTwo(index,0,-1) || checkTwo(index,numOfElems,1))
		{
			throw new IllegalArgumentException("illegal argument");  
		}	
		
		return true;
    }


    public void ensureCapacity()
    {
	if(checkTwo(numOfElems,sizeOfArray,0))
	{
	    int[] temp = new int[sizeOfArray*2];
	    for(int i=0;i <sizeOfArray;i++)
			temp[i]=array[i];

	    setArrayTo(array,temp);
        }

    }

	public void setArrayTo(int[] arr,int[] temp)
	{
		arr=temp;
	}


    public boolean checkTwo(int val1,int val2, int condition)
    {
		if(condition==-1)
			return val1<val2;
		else if(condition==0)
			return val1==val2;
		else if(condition==1)
			return val1>val2;

		return false;	
    }
	

    

    public void setValue(int val,int index)
    {
		ensureCapacity();
		array[index]=val;
    }

    public void increaseSize()
    {
		numOfElems++;
    }
    
    public String toString()
    {
	String s="[";
	for(int i=0;i<numOfElems;i++)
	{
	    s+=String.valueOf(array[i]);
	    if(i!=numOfElems-1)
			s+=",";

	    

	}
	s+="]";

	return s;
    }
	
	   
}
    
    
    
    
