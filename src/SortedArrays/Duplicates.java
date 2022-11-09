package SortedArrays;

import java.util.Random;

public class Duplicates {

	public static void main(String[] args) {
		int n = 800;
		double t = 0;
		int []keys = unsortedArray(n);
		int []array = unsortedArray(n);
		double sum = 0;
		int x = 0;
		for (int ki = 0; ki < n; ki++) {
			long t0 = System.nanoTime();
			for(int j = 0; j<n;j++) {
				if(keys[ki] == array[j]) {
					x++;
					break;
				}
			}
			t = (System.nanoTime() - t0);
			sum=sum+t;
		}
		System.out.println(sum);
	}

	
	private static int[] unsortedArray(int n) {
		Random r = new Random();
		int array[] = new int[n*10];
		for(int i = 0; i<n;i++) {
			array[i] = r.nextInt(n*10);
		}
		return array;
	}

}
