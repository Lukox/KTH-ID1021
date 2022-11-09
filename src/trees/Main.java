package trees;

import java.util.Iterator;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();	
		tree.add(5,12);
		tree.add(2,5);
		tree.add(7,21);
		tree.add(1,1);
		tree.add(13,50);
		tree.add(6,17);
		tree.add(3,10);
		//for(int i : tree) {
		//	System.out.println("value: "+i);
		//}
		 Iterator<Integer> itr = tree.iterator();
	      
	     for(int i = 0; i<5;i++) {
	     Object element = itr.next();
	     System.out.print(element + " ");
	    	 System.out.println();
	     }
	     tree.add(11, 40);
	     tree.add(14, 60);
	     tree.add(4, 11);

	     for(int i : tree) {
	    	 System.out.println(i);
	     }
	}

	public static boolean binary_search(Integer[]array, int key) {
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
	
	public static Integer[] keys(int n) {
		Random r =  new Random();
		Integer[]keys = new Integer[n];
		for(int i =0;i<n;i++) {
			keys[i] = r.nextInt(n*10);
		}
		return keys;
	}
	
}
	