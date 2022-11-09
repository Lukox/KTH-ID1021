package heaps;

import java.util.Arrays;
import java.util.Random;

public class Main1 {
	public static int k;
	public static Integer[] tree;
	public static void main(String[] args) {
		Random r = new Random();
		int[] sizes = {2,4,8,16,32,64,128,256,512,1024};
		System.out.printf("#%7s%10s%10s\n","n" ,"Singly", "Doubly");
		for ( int n : sizes) {
			k=0;
			tree = new Integer[1024];
			System.out.printf("%8d", n);
			int loop = 100;
			double sum = 0;
			for(int i = 0; i<loop;i++) {
				long t0 = System.nanoTime();
				for(int j =0;j<n;j++) {
					add(r.nextInt(n*10));
				}
				for(int j =0;j<n;j++) {
					int x = remove();
				}
				long t1 = System.nanoTime();
				double time = (t1 - t0);
				sum+=time;
			}
			System.out.printf("%10.0f", (sum/loop));
			System.out.printf("%10.0f\n", (sum/loop));
		}
		
	}
	
	public static void add(int value) {
		int saveK = k;
		tree[k] = value;
		while(k!=0){
			int index = (k-(2-k%2))/2;
			if(tree[k] < tree[index]) {
				int temp = tree[k];
				tree[k] = tree[index];
				tree[index] = temp;
				k = index;
			}else {
				break;
			}
		}
		k = saveK+1;
	}
	
	public static Integer remove() {
		k -= 1; 
		Integer value = tree[0];
		tree[0] = tree[k];
		tree[k] = null;
		int current = 0;

		while(true) {
			int leftBranch = current*2+1;
			int rightBranch = current*2+2;
			if(leftBranch>=k || rightBranch>=k) {
				break;
			}
			if(tree[leftBranch] < tree[rightBranch]) {
				if(tree[current]>tree[leftBranch]) {
					int temp = tree[current];
					tree[current] = tree[leftBranch];
					tree[leftBranch] = temp;
					current = leftBranch;
				}else {
					break;
				}
			}else {
				if(tree[current]>tree[rightBranch]) {
					int temp = tree[current];
					tree[current] = tree[rightBranch];
					tree[rightBranch] = temp;
					current = rightBranch;
				}else {
					break;
				}
			}
		}
		return value;
	}

}
