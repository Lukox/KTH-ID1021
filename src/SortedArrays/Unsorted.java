package SortedArrays;

import java.util.Random;

public class Unsorted {

	public static void main(String[] args) {
		int[] sizes = {100,200,400,800,1600,3200,6400,12800};
		Random r = new Random();
		System.out.printf("#%7s%8s%8s\n","n" ,"Avg", "Min");
		for ( int n : sizes) {
			System.out.printf("%8d", n);
			int loop = 10000;
			int[] array = sorted(n);
			double min = Double.POSITIVE_INFINITY;
			double sum = 0;
			double avg;
			for(int i = 0; i<loop;i++) {
				long t0 = System.nanoTime();
				binary_search(array, r.nextInt(array[n-1]));
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

	public static boolean search_sorted(int[] array, int key) {
		for (int index = 0; index < array.length ; index++) {
			if(array[index]>key) {
				return false;
			}
			if (array[index] == key) {
				return true;
			}
		}
		return false;
	}


	private static int[] sorted(int n) {
		Random rnd = new Random();
		int[] array = new int[n];
		int nxt = 0;
		for (int i = 0; i < n ; i++) {
			nxt += rnd.nextInt(10) + 1;
			array[i] = nxt;
		}
		return array;
	}
	
	public static boolean binary_search(int[]array, int key) {
		int first = 0;
		int last = array.length-1;
		while (true) {
			int index = (first+last)/2 ;
			if (array[index] == key) {
				return true;

			}
			if (array[index] < key && index < last) {
				first = index + 1;
				continue;
			}
			if (array[index] > key && index > first) {
				last = index-1 ;
				continue;
			}
			break;
		}
		return false;
	}
}
