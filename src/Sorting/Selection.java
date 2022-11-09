package Sorting;

import java.util.Arrays;
import java.util.Random;

public class Selection {

	public static void main(String[] args) {

		int[] sizes = {25,50,100,200,400,800,1600,3200,6400,12800};
		System.out.printf("#%7s%10s%10s\n","n" ,"Avg", "Min");
		for ( int n : sizes) {
			System.out.printf("%8d", n);
			int loop = 1;
			double min = Double.POSITIVE_INFINITY;
			double sum = 0;
			double avg;
			for(int i = 0; i<loop;i++) {
				int[] array = unsortedArray(n);
				long t0 = System.nanoTime();
				MergeSort(array);
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

	private static int[] unsortedArray(int n) {
		Random r = new Random();
		int array[] = new int[n];
		for(int i = 0; i<n;i++) {
			array[i] = r.nextInt(n);
		}
		return array;
	}

	public static void SelectionSort(int []array) {
		for (int i = 0; i < array.length -1; i++) {
			int cand = i;
			for (int j = i; j < array.length ; j++) {
				if(array[j]<array[cand]) {
					cand=j;
				}
			}
			int temp = array[i];
			array[i] = array[cand];
			array[cand] = temp;	
		}
	}
	
	public static void InsertionSort(int [] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0 && array[j]<array[j-1] ; j--) {
				int temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;	
			}
		}
	}
	
	public static void MergeSort(int[] org) {
		if (org.length == 0)
		return;
		int[] aux = new int[org.length];
		sort(org, aux, 0, org.length -1);
	}
	
	private static void sort(int[] org, int[] aux, int lo, int hi) {
		if(lo!=hi) {
			int mid = lo + (hi-lo)/2;
			sort(org,aux,lo,mid);
			sort(org,aux,mid+1,hi);
			merge(org,aux,lo,mid,hi);
		}
	}
	
	private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
		for (int i = lo; i<=hi;i++) {
			aux[i] = org[i];
		}
		int i = lo;
		int j = mid+1; 
		for ( int k = lo; k <= hi; k++) {
			if (i>mid) {
				org[k]=aux[j];
				j++;
			}
			else if (j>hi) {
				org[k]=aux[i];
				i++;
			}
			else if (aux[i]<aux[j]) {
				org[k]=aux[i];
				i++;
			}
			else {
				org[k]=aux[j];
				j++;
			}
		
		}
		System.out.println(Arrays.toString(org));


	}


}
