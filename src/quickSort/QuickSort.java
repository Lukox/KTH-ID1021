package quickSort;

import java.util.Arrays;

public class QuickSort {

	public static void sort(int[]arr, int ind1, int ind2) {
		if (ind1 < ind2) {
			int pivotIndex = partition(arr, ind1, ind2);
			sort(arr, ind1, pivotIndex-1);
			sort(arr, pivotIndex+1, ind2);
		}	
	}

	public static int partition(int[]arr, int ind1, int ind2) {
		int pivot = arr[ind1];
		int i = ind1+1;
		int j = ind2;
		while(i<=j) {
			while(i<=j && arr[i] <= pivot ) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}
			
			if(i<=j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		int temp = arr[j];
		arr[j] = pivot;
		arr[ind1] = temp;
		return j;
	}
}
