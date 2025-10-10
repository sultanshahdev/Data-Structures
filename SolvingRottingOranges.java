

//adding a change for gid push

import java.util.ArrayList;

public class SolvingRottingOranges
{

    public static int arr[][];

    public static ArrayList<Index> indexesToModify = new ArrayList<Index>();

    public static class Index
    {
        int i;
        int j;

        public Index(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String args[])
    {
        int [][]arr = {{1,2,0},
                       {2,0,1},
                       {1,1,1}};
        int numOfMinutes = orangesRotting(arr);
        System.out.println(numOfMinutes);
    }
    public static int minutes=0;
    public static int orangesRotting(int a[][])
    {
        arr = a;
        minutes=0;

        while(iterateCheckAndModify()==true)
        {
            for(int i = 0; i<arr.length;i++)
            {
                for (int j=0;j<arr[0].length;j++)
                {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            minutes++;
            System.out.println("Minutes"+ minutes);
        }

        if(hasFresh())
        {
            return -1;
        }
        else
        {
            return minutes;
        }

    }

    private static boolean hasFresh() {

        boolean flag = false;

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if (arr[i][j]==1)
                {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }


    public static boolean iterateCheckAndModify()
    {

        boolean flag = false;

        for(int i=0; i<arr.length;i++) {
            for (int j = 0; j < arr[0].length; j++)
            {
                if (arr[i][j]==1)
                {
                    if(checkSurroundingsForRottenOranges(i,j))
                    {
                        noteDown(i,j);
                        flag=true;
                    }

                }
            }
        }

        modify();
        clearNoteBook();
        return flag;


    }

    public static void modify()
    {
        for(int i =0; i< indexesToModify.size();i++)
        {
            arr[indexesToModify.get(i).i][indexesToModify.get(i).j] = 2;
        }
    }
    public static void clearNoteBook()
    {
        indexesToModify.clear();
    }

    private static void noteDown(int i,int j) {
        indexesToModify.add(new Index(i,j));
    }

    public static boolean checkSurroundingsForRottenOranges(int i, int j)
    {
        if(checkUp(i,j)==true||checkDown(i,j)==true|| checkLeft(i,j)==true||checkRight(i,j)==true) {
            return true;
        }
        return false;


    }
    public static boolean checkUp(int i, int j)
    {
        if (BoundaryCheck(i,0))
        {
            return false;
        } else if(arr[i - 1][j] == 2)
        {
            return true;
        }
        return false;
    }

    public static boolean checkDown(int i, int j)
    {
        int noOfRows = arr.length-1;
        if(BoundaryCheck(i,noOfRows))
        {
           return false;
        }
        else if(arr[i+1][j]==2)
        {
            return true;
        }
        return false;
    }

    public static boolean checkRight( int i, int j)
    {
        int noOfColumns = arr[0].length-1;
        if(BoundaryCheck(j,noOfColumns))
        {
            return false;
        }
        else
        {
            if(RottenOrangeCheck(i,j+1))
            {
                return true;
            }
        }
        return false;

    }
    public static boolean checkLeft(int i, int j)
    {
        if(BoundaryCheck(j,0))
        {
            return false;
        }
        else
        {
            if(RottenOrangeCheck(i,j-1))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean RottenOrangeCheck(int i, int j)
    {
        return arr[i][j]==2;
    }
    //Checks If The Index Value is at a boundary of the grid
    public static boolean BoundaryCheck(int indexValue,int checkedIndexValue)
    {
        return indexValue==checkedIndexValue;
    }
}