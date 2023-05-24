package FirstFit;
import java.util.*;
public class First {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println ("enter block size:");
	int m = sc.nextInt();
	int blockSize[]= new int[m];
	System.out.println ("enter process size:");
	int n = sc.nextInt();
	int processSize[]= new int[n];
	int allocation[] = new int[n];
	for(int i = 0; i < m; i++)
	{
		System.out.println("enter block " + (i+1) + " size: ");
		blockSize[i] = sc.nextInt();
	
	}
	for(int i = 0; i < n; i++)
	{
	System.out.println("enter process " + (i+1) + " size: ");
	processSize[i] = sc.nextInt();
	
	}
    for (int i = 0; i < allocation.length; i++)
        allocation[i] = -1;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (blockSize[j] >= processSize[i])
            {
                // allocate block j to p[i] process
                allocation[i] = j;
 
                // Reduce available memory in this block.
                blockSize[j] -= processSize[i];
 
                break;
            }
        }
    }
    System.out.println("\nProcess No.\tProcess Size\tBlock no.");
    for (int i = 0; i < n; i++)
    {
        System.out.print(" " + (i+1) + "\t\t" +
                         processSize[i] + "\t\t");
        if (allocation[i] != -1)
            System.out.print(allocation[i] + 1);
        else
            System.out.print("Not Allocated");
        System.out.println();
    }   
	} 
}