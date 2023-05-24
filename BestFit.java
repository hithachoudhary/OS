package BestFit;

import java.util.Scanner;
public class Best {
	// Java implementation of Best - Fit algorithm


		// Method to allocate memory to blocks as per Best fit
		// algorithm
		static void bestFit(int blockSize[], int bnum, int processSize[],
														int pnum)
		{
			// Stores block id of the block allocated to a
			// process
			int allocation[] = new int[bnum];
		
			// Initially no block is assigned to any process
			for (int i = 0; i <bnum; i++)
				allocation[i] = -1;
		
		// pick each process and find suitable blocks
			// according to its size ad assign to it
			for (int i=0; i<pnum; i++)
			{
				// Find the best fit block for current process
				int bestIdx = -1;
				for (int j=0; j<bnum; j++)
				{
					if (blockSize[j] >= processSize[i])
					{
						if (bestIdx == -1)
							bestIdx = j;
						else if (blockSize[bestIdx] > blockSize[j])
							bestIdx = j;
					}
				}
		
				// If we could find a block for current process
				if (bestIdx != -1)
				{
					// allocate block j to p[i] process
					allocation[i] = bestIdx;
		
					// Reduce available memory in this block.
					blockSize[bestIdx] -= processSize[i];
				}
			}
		
			System.out.println("\nProcess No.\tProcess Size\tBlock no.");
			for (int i = 0; i < pnum; i++)
			{
				System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");
				if (allocation[i] != -1)
					System.out.print(allocation[i] + 1);
				else
					System.out.print("Not Allocated");
				System.out.println();
			}
		}
		
		// Driver Method
		public static void main(String[] args)
		{
			int pnum,bnum;
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter number of processes: ");
			pnum=sc.nextInt();
			System.out.println("Enter number of blocks: ");
			bnum=sc.nextInt();
			int blockSize[] = new int[bnum];
			int processSize[] = new int[pnum];
			
			for(int g=0;g<pnum;g++) {
				System.out.println("Enter the size of process "+(g+1)+": ");
				processSize[g]=sc.nextInt();
			}
			
			for(int p=0;p<bnum;p++) {
				System.out.println("Enter the size of the block "+(p+1)+": ");
				blockSize[p]=sc.nextInt();
			}
			
			
			bestFit(blockSize, bnum, processSize, pnum);
		}

}