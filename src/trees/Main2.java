package trees;

import java.util.Iterator;

public class Main2 {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();	
		tree.add(5,12);
		tree.add(2,5);
		tree.add(7,21);
		tree.add(1,1);
		tree.add(13,50);
		tree.add(6,17);
		tree.add(3,10);
		for(int i : tree) {
			System.out.println("value: "+i);
		}
	}

}
