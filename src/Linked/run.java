package Linked;

import java.util.Random;

public class run {

	public static void main(String[] args) {
		int[] sizes = {25,50,100,200,400,800,1600,3200};
		System.out.printf("#%7s%10s%10s\n","n" ,"Avg", "Min");
		for ( int n : sizes) {
			System.out.printf("%8d", n);
			int loop = 1000;
			double min = Double.POSITIVE_INFINITY;
			double sum = 0;
			double avg;
			for(int i = 0; i<loop;i++) {
				long t0 = System.nanoTime();
				int[] array2 = unsortedArray(n	);
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min)
					min = t;
				sum+=t;
			}
			avg = sum/loop;
			System.out.printf("%10.0f", (avg));
			System.out.printf("%10.0f\n", (min));	    

		}
	
	}
	
	private static void combine(int[] array, int[] array2) {
		int[] finalArray =  new int[array.length+array2.length];
		for (int i = 0; i < array.length;i++) {
			finalArray[i] = array[i];
		}
		for (int j = 0; j < array2.length;j++) {
			finalArray[j+array.length] = array2[j];
		}
	}

	private static int[] unsortedArray(int n) {
		int array[] = new int[n];
		for(int i = 0; i<n;i++) {
			array[i] = 1;
		}
		return array;
	}

}
