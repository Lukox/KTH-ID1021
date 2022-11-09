package quickSort;

import java.util.Arrays;
import java.util.Random;

import quickSort.QuickSortLL.Node;

public class Main {

	public static void main(String[] args) {
		//int[] array = unsortedArray(10);
		//System.out.println(Arrays.toString(array));
		//QuickSort.sort(array,0,array.length-1);
		int[] sizes = {25,50,100,200,400,800,1600,3200};
		System.out.printf("#%7s%10s%10s\n","n" ,"Avg", "Min");
		for ( int n : sizes) {
			System.out.printf("%8d", n);
			int loop = 1000;
			double min = Double.POSITIVE_INFINITY;
			double sum = 0;
			double sum1 = 0;
			double avg;
			for(int i = 0; i<loop;i++) {
				int[] array = unsortedArray(n);
				
				QuickSortLL list
				= new QuickSortLL();
				Random r = new Random();
				for(int j = 0;j<n;j++) {
					list.addNode(array[j]);
				}
				
				
				long t0 = System.nanoTime();
				QuickSort.sort(array,0,array.length-1);
				long t1 = System.nanoTime();
				long t2 = System.nanoTime();
				list.sort(list.head, list.last);
				long t3 = System.nanoTime();
				double t = (t1 - t0);
				double time = (t3 - t2);
				sum+=t;
				sum1+=time;
			}
			avg = sum/loop;
			double avg2 = sum1/loop;
			System.out.printf("%10.0f", (avg));
			System.out.printf("%10.0f\n", (avg2));	    

		}
	}
	
	private static int[] unsortedArray(int n) {
		Random r = new Random();
		int array[] = new int[n];
		for(int i = 0; i<n;i++) {
			array[i] = r.nextInt(n*5);
		}
		return array;
	}

}
