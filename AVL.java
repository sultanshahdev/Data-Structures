

public class AVL
{
    public static void main(String args[])
    {
        BST bst= new BST();


        bst.add(12);
        bst.add(34);
        bst.add(23);
        bst.add(30);



        bst.inOrder();

        bst.delete(12);


        bst.inOrder();


        bst.search(30);


    }


    class Node
    {
        int val,height;
        Node left,right;
        


        public Node()
        {
            this.val=0;
            this.left=null;
            this.right=null;
            this.height=1;
        }

        public Node(int val)
        {
            this.val=val;
            this.left=null;
            this.right=null;
            this.height=1;

        }

        public void setLeft(Node node)
        {
            left=node;
        }

        public void setRight(Node node)
        {
            right=node;

        }


        public void setVal(int val)
        {
            this.val = val;

        }



        
        
    }


    private Node root;

    BST()
    {
        root=null;
    }

    public void add(int val)
    {
        root= addRec(val, root);
    }

    private Node addRec(int val,Node node)
    {
        if(node==null)
            node= new Node(val);

        else if(val>node.val)
            node.right = addRec(val,node.right);

        else
            node.left= addRec(val, node.left);

    
        return node;    
    }
    
    
    public Node deleteRec(Node node, int val)
    {
        if(node==null)
            return node;

        else if(val>node.val)
        {
            node.right=deleteRec(node.right, val);

        }
        else if(val<node.val)
        {
            node.left=deleteRec(node.left, val);
        }

        else
        {
            if(node.left==null && node.right==null)
            {
                return null;
            }
            else if(node.left==null)
            {
                return node.right;
            }
            else if(node.right==null)
                return node.left;
            
            else
            {
                int temp=findMin(node.right);
                node.val=temp;
                node.right=deleteRec(node.right, temp);
            }
        }
        return node;


    }

    public int findMin(Node node) {
        if(node.left==null)
        {
            return node.val;
        }

        return findMin(node.left);

    }
    public int findMax(Node node)
    {
        if(node.right==null)
        {
            return node.val;
        }

        return findMax(node.right);
    }


    public void inOrder()
    {
        inOrderRec(root);
        System.out.println();
    }
    public void inOrderRec(Node node)
    {
        if(node==null)
            return;

        inOrderRec(node.left);
        System.out.print(node.val + " ");
        inOrderRec(node.right);
    }


    public void delete(int val)
    {
        root= deleteRec(root, val);

    }


    public void search(int val)
    {
        if(searchRec(root, val) )
            System.out.println("The tree contains " + val + " !");
       
        else{
            System.out.println("The tree does not contain " + val);
        }
    }




    public boolean searchRec(Node node, int val)
    {
        if(node==null)
            return false;

        else if(node.val==val)
            return true;

        else if(val>node.val)
        {
            return searchRec(node.right,val);
        }

        else
        {
            return searchRec(node.left,val);

        }


    }

    
}
