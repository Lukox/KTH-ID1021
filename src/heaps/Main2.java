package heaps;

import java.util.Random;

public class Main2 {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Random r = new Random();
		double sum = 0;
		double sum2 = 0;
		
		int numbers[] = new int[100];
		for(int i =0; i< 64;i++) {
			tree.add(r.nextInt(100));
		}
		for(int i =0; i< 100;i++) {
			numbers[i] = (r.nextInt(20)+5);
		}
		for(int i =0; i< 100;i++) {
			sum += tree.push(numbers[i]);
			sum2 += tree.add(numbers[i]);
		}
		System.out.println(sum/100);
		System.out.println(sum2/100);

		//System.out.println(tree.remove());
		//System.out.println(tree.remove());
		//System.out.println(tree.remove());


	}

}
