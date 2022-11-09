package SortedArrays;

import java.util.Random;

public class Dupliactes2 {

	public static void main(String[] args) {
		int n = 12800;
		double t = 0;
		int []keys = sorted(n);
		int []array = sorted(n);
		double sum = 0;
		long t0 = System.nanoTime();
		
		search(keys,array);
		t = (System.nanoTime() - t0);
		sum=sum+t;
		System.out.println(sum);
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
	
		public static void search(int[]array,int []keys) {
			int index = 0;
			for(int i =0; i<keys.length;i++) {
				if(keys[i] >= array[index]) {
					index++;
				}
			}
		}

}

