package Doubly;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		//System.out.println(list);

		int[] sizes = {2,4,8,16,32,64,128,256,512,1024,2048,4096};
		System.out.printf("#%7s%10s%10s\n","k" ,"Singly", "Doubly");
		for ( int n : sizes) {
			int[] sequence = new int[n];
			Random rnd = new Random();
			System.out.printf("%8d", n);
			int loop = 10000;
			double sum = 0;
			double sum2 = 0;
			double min = Double.POSITIVE_INFINITY;
			double min2 = Double.POSITIVE_INFINITY;
			Node[] nodes = nodeArray(100);
			for(int i = 0; i<loop;i++) {
				for (int j = 0; j < n; j++) {
					sequence[j] = rnd.nextInt(100);
				}
				LinkedList list = new LinkedList(nodes);
				DoublyLinkedList list2 = new DoublyLinkedList(nodes);
				long t0 = System.nanoTime();
				for (int j = 0; j < n; j++) {
					list.remove(nodes[sequence[j]]);
					list.add(nodes[sequence[j]]);
				}
				long t1 = System.nanoTime();
				long t2 = System.nanoTime();
				for (int j = 0; j < n; j++) {
					list2.remove(nodes[sequence[j]]);
					list2.add(nodes[sequence[j]]);
				}
				long t3 = System.nanoTime();
				double time = (t1 - t0);
				double time1 = (t3 - t2);
				sum+=time;
				sum2+=time1;
				if(time<min) {
					min = time;
				}
				if(time1<min2) {
					min2 = time1;
				}
			}
			System.out.printf("%10.0f", (sum/loop));
			System.out.printf("%10.0f\n", (sum2/loop));
		}
	}

	public static Node[] nodeArray(int size) {
		Random r = new Random();
		Node[] nodes = new Node[size];
		for(int i =0; i<nodes.length;i++) {
			nodes[i] = new Node(r.nextInt(10));
		}
		return nodes;
	}
}
