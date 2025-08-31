class Node 
{
	int value;
	Node next;

	public Node ()
	{
		this.value = 0;
		this.next  = null;	
	}
	
	public Node (int value)
	{
		this.value = value;
		this.next  = null;	
	}
	
	public Node (int value, Node next)
	{
		this.value = value;
		this.next  = next ;	
	}
}

public class SLinkedList 
{
	Node head;
	int  size;
	int  index;
	


	public SLinkedList ()
	{
		this.size =  0  ;
		this.head = null;
			
	}

	public boolean isListEmpty()
	{
		if (size==0)return true;
		else{return false;}
	}

 	public void addToFront (int value)
	{
		if(isListEmpty())
		{
			head = new Node(value);
			size++ ;
			index++;  
		}
		else
		{
			Node temp = new Node (value);
			temp.next = head;
			head      = temp;
			size++;
			index++;
		}
	}
	
	public int getFrontItem()
	{
		if (!isListEmpty())
		{	
			return head.value;
		}		
		else
		{
			System.out.println("list is Empty");
			return -1;
		}
	}
	
	public void removeFrontItem ()
	{
		if (!isListEmpty())
		{
			head = head.next;
			size--;
		}
		else
		{
			System.out.println("list is Empty");
		}	

	}
		

	public void addToBack (int value)
	{	
		if (!isListEmpty()) 
		{
		     	Node current = head;
			while (current.next!= null)
			{
				current = current.next;	
			}
			current.next = new Node (value);
			size++;	
		}
		
		else	
		{
			head = new Node (value);
		}
		size++;
	}
	
	public int getBackItem()
	{
		if (!isListEmpty())
		{
			Node current = head;
			while (current.next!= null)
			{
				current = current.next;	
			}
			return current.value;
		}
		
		else
		{
			System.out.println("LinkedList is Empty reuturned with error code ");
			return -1;	
		
		}
	}
	
	public void removeBackItem()
	{
		if (size == 0)
		{
			System.out.println("LinkedList is Empty reuturned with error code ");
			return; 	
		}
	
	
		if (size == 1)
		{
			head = null;
			size--;
		}	
		if (size>1)
		{
			Node current = head;
			while (current.next.next!= null)
			{
				current = current.next;	
			}
			
			current.next = null;
			size--;
			return;
		}
		
		
	}
	
	public boolean find(int key)
	{
		
		if (size == 0)
		{
			System.out.println("LinkedList is Empty");
			return false;
		}
		
		if (size>0)
		{		
			Node current = head;
			while(current!=null)
			{
				if(current.value==key)
				{
					return true;
				}
				current=current.next;	
			}	
		}
		return false;
	
	}
	
	
	
	public void remove(int key)
	{
		
		
		if (size==0)
		{
			System.out.println("The linked List is Empty");
			return;

		}
		if (head.value == key)
		{
			head = head.next;
			size--;	
			return;
		}
	
		Node current = head;
		while (current.next!=null && current.next.value!= key)
		{
			current = current.next;
		}
		
		if (current.next==null)
		{
			System.out.println("No element with the key found");
			return;	
		}
		
		current.next = current.next.next;
		size--;
				
		
	
	
	}


	public void addKeyBeforeNode(int key,int value)
	{
		if (size==0)
		{	
			System.out.println("LinkedList is Empty");
			return;
		}
		if (head.value==key)
		{	
			Node temp = new Node(value);
			temp.next = head;
			head      = temp;
			size++          ;
			return          ;
		}
		Node current = head;
		while (current.next!=null && current.next.value!=key)
		{	
			current= current.next;
		}
		if (current.next==null)
		{	
			System.out.println("No element with key " + key + " found!");
			return;
	
		}
		
		Node temp = new Node(value);
		temp.next = current.next   ;
		current.next = temp        ;
		size++			   ;
		
	}
	
	public void addKeyAfterNode(int key, int value)
	{	
		if (size==0)
		{
			System.out.println("The linked List is Empty");
			return;
		}
		Node current = head;
		while (current!=null && current.value!=key )
		{
			current = current.next;
		}
		if(current==null)
		{
			System.out.println("No element with the key " + key  +" found!");
			return;
		}

		Node temp = new Node(value);
		temp.next = current.next   ;
		current.next = temp        ;
		size++;
		
		
	}
	
	public void printAll()
	{
		if (size==0)
		{
			System.out.println("The linked List is Empty");
			return;
		}

		Node current = head;
		System.out.print("[");
		while (current!= null)
		{
			System.out.print(current.value);
			if (current.next!=null)
			{
				System.out.print(", ");
			}
			current = current.next;
		}
		System.out.println("]");
		
		
		
	}
	
		
	public int get(int index)
	{
		if (index<0 || index>=size)
		{	
			System.out.println("Index must be with the size of LinkedList exited with error code");
			return -1;
		}		
		else
		{	
			Node current = head;	
			for (int i=0; i<index;i++)
			{	
				current=current.next;
			}
			return current.value;
		}
	}
	public void insertAt(int index, int value)
	{	
		if (index<0 || index>size)
		{	
			System.out.println("Index must be with the size of LinkedList");
			
			
		}
	
		else
		{
			Node temp = new Node(value);
			if(index==0)	
			{	
				temp.next = head;
				head      = temp;				
			}	
			else
			{	
				Node current = head;
				for(int i=0;i<index-1;i++)
				{	
					current=current.next;
				}
				temp.next = current.next  ;
				current.next = temp       ;
				
			}
			size++;

		}
	}	
	
	public void removeFrom(int index)
	{		
		if (index<0 || index>=size)
		{	
			System.out.println("Index must be with the the size of LinkedList");
		}
		else
		{
			if (index==0)
			{
				head=head.next;
			}
			else
			{	
				Node current = head;
				for (int i=0;i<index-1;i++)
				{	
					current=current.next;
				}
				current.next = current.next.next;

			}
			size--;
		}
		
	}
	
	public int getSize()
	{	
		return size;	
	}
	
	public void reverse() 
	{
   		Node prev = null;
    		Node current = head;
    		Node next = null;

    		while (current != null) {
        	next = current.next;  
        	current.next = prev;   
        	prev = current;      
        	current = next;        
    		}
	
		head = prev;
	}

	
	
	public static void main(String[] args) 
	{
		SLinkedList list = new SLinkedList();
		int test = 1;

		System.out.println("=====================================");
		System.out.println("      LINKED LIST TESTING PROGRAM    ");
		System.out.println("=====================================\n");

		System.out.println("Test " + (test++) + ": addToFront()");
		list.addToFront(34); list.printAll();
		list.addToFront(3353); list.printAll();
		list.addToFront(999); list.printAll();
		list.addToFront(-232); list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": getFrontItem()");
		System.out.println("Front item is: " + list.getFrontItem());
		list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": removeFrontItem()");
		list.removeFrontItem(); list.printAll();
		list.removeFrontItem(); list.printAll();
		list.removeFrontItem(); list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": addToBack()");
		list.addToBack(3434); list.printAll();
		list.addToBack(341);  list.printAll();
		list.addToBack(-23);  list.printAll();
		list.addToBack(87);   list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": getBackItem()");
		System.out.println("Back item is: " + list.getBackItem());
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": removeBackItem()");
		list.removeBackItem(); list.printAll();
		list.removeBackItem(); list.printAll();
		list.removeBackItem(); list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": find()");
		System.out.println("Finding 34 -> " + list.find(34));
		System.out.println("Finding -3 -> " + list.find(-3));
		System.out.println("-------------------------------------");

		System.out.println("Adding some elements to the list...");
		list.addToBack(343);
		list.addToBack(998);
		list.addToBack(343);
		list.addToBack(7746);
		list.addToBack(-56);
		list.addToBack(-57);
		list.addToBack(45);
		list.addToBack(17);
		list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": remove()");
		list.remove(-57); list.printAll();
		list.remove(17);  list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": isListEmpty()");
		System.out.println("Is list empty? " + list.isListEmpty());
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": addKeyBeforeNode()");
		list.addKeyBeforeNode(998, 97); list.printAll();
		list.addKeyBeforeNode(-2323, 88); list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": addKeyAfterNode()");
		list.addKeyAfterNode(-56, 88); list.printAll();
		list.addKeyAfterNode(996, 66); list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": get(index)");
		System.out.println("Element at index 3 is: " + list.get(3));
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": insertAt(index, value)");
		list.insertAt(2, 999); list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": removeFrom(index)");
		list.removeFrom(1); list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("Test " + (test++) + ": reverse()");
		System.out.println("Original List:");
		list.printAll();
		list.reverse();
		System.out.println("After Reversing:");
		list.printAll();
		System.out.println("-------------------------------------");

		System.out.println("=====================================");
		System.out.println("      END OF LINKED LIST TESTS       ");
		System.out.println("=====================================");
	}


	
}





