package SortedArrays;

import java.util.Random;

public class Sorted {

	public static void main(String[] args) {
		int[] sizes = {100,200,400,800,1600,3200,6400,12800};
		Random r = new Random();
		System.out.printf("#%7s%8s%8s\n","n" ,"Avg", "Min");
		for ( int n : sizes) {
		    System.out.printf("%8d", n);
			int loop = 10000;
			int[] array = unsortedArray(n);
		    double min = Double.POSITIVE_INFINITY;
		    double sum = 0;
		    double avg;
			for(int i = 0; i<loop;i++) {
				long t0 = System.nanoTime();
				search_unsorted(array, r.nextInt(n*10));
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				
				if (t < min)
				    min = t;
				sum+=t;
			    }
			avg = sum/loop;
		    System.out.printf("%8.0f", (avg));
		    System.out.printf("%8.0f\n", (min));	    

			}
		}
	
	public static boolean search_unsorted(int[] array, int key) {
		for (int index = 0; index < array.length ; index++) {
			if (array[index] == key) {
				return true;
			}
		}
		return false;
	}

	
	private static int[] unsortedArray(int n) {
		Random r = new Random();
		int array[] = new int[n];
		for(int i = 0; i<n;i++) {
			array[i] = r.nextInt(n);
		}
		return array;
	}

}
