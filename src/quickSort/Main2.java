package quickSort;

import java.util.Arrays;
import java.util.Random;

import quickSort.QuickSortLL.Node;

public class Main2 {

	public static void main(String[] args) {
		QuickSortLL list
		= new QuickSortLL();
		Random r = new Random();
		for(int i = 0;i<30;i++) {
			list.addNode(r.nextInt(100));
		}
		Node n = list.head;
		while (n.next != null)
			n = n.next;

		System.out.println("Linked List before sorting");
		list.printList(list.head);

		// Function call
		list.sort(list.head, n);

		System.out.println("\nLinked List after sorting");
		list.printList(list.head);	

	}	
}
