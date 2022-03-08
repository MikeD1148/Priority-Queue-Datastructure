import java.util.Scanner;

public class main {

    public static int queueSize = 10,front,rear,pointer = 0;
    public static int[] STACK = new int[queueSize];
    public static String[] DATA = new String[queueSize];
    public static int[] LINK = new int[queueSize];

    public static void main(String[] args)
    {
        create();
        System.out.println("This application will store data as a priority queue using a linked list");
        int option;
        do
        {
            System.out.println("Press 1 to add an item to the Queue");
            System.out.println("Press 2 to remove an item from the Queue");
            System.out.println("Press 9 to exit program");
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            switch(option)
            {
                case 1: add(); break;
                case 2: remove(); break;
                case 9: break;
                default: System.out.println("Invalid input please try again");
            }
            print();
        } while (option!=9);
    }

    public static void create()
    {
        front = 0;
        rear = 0;
    }

    public static boolean isEmpty()
    {
        return DATA[0] == null;
    }

    public static boolean isFull()
    {
        return DATA[queueSize - 1] != null;
    }

    public static void getNode()
    {
        if(isFull())
        {
            System.out.println("There are no more nodes to call");
        }
        else
        {
            for (int i = 0; i < queueSize; i++)
            {
                if (STACK[i] == 0)
                {
                    pointer = i;
                    break;
                }
            }
            STACK[pointer] = -1;
        }
    }

    public static void getFront()
    {
        //Smaller numbers have higher priority
        int priority = queueSize;
        for (int i = 0; i < queueSize; i++)
        {
            if (LINK[i] != 0 && LINK[i] < priority)
            {
                priority = LINK[i];
            }
            front = priority;
        }
    }

    public static void add()
    {
        if (isFull())
        {
            System.out.println("The Queue is full");
        }
        else
        {
            getNode();
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the data you wish to store");
            DATA[pointer] = input.nextLine();
            while (LINK[pointer] > queueSize || LINK[pointer] < 1)
            {
                System.out.println("Please enter the priority this data will have between 1 and " + queueSize);
                LINK[pointer] = input.nextInt();
            }
        }
    }

    public static void remove()
    {
        if (isEmpty())
        {
            System.out.println("The Queue is empty");
        }
        else
        {
            getFront();
            for (int i = 0; i < queueSize; i++)
            {
                if (LINK[i] == front)
                {
                    for (int j = i; j < queueSize-1; j++)
                    {
                        LINK[j] = LINK[j+1];
                        DATA[j] = DATA[j+1];
                        STACK[j] = STACK[j+1];
                    }
                    LINK[queueSize-1] = 0;
                    DATA[queueSize-1] = null;
                    STACK[queueSize-1] = 0;
                    break;
                }
            }
        }
    }

    public static void print()
    {
        System.out.println("The current Queue with a dataset of " + queueSize + " is");
        for (int i = 0; i < queueSize; i++)
        {
            System.out.print(DATA[i] + " with a priority of " + LINK[i] + " || ");
        }
        System.out.println("\n");
    }

}
