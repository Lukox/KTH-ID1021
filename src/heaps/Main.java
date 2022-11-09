package heaps;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Node []	array = new Node[5];
		//array[0] = new Node(7);
		//array[1] = new Node(4);
		//array[2] = new Node(9);
		//array[3] = new Node(2);
		//array[4] = new Node(1);
		//LinkedList list = new LinkedList(array);
		//System.out.println(list.remove());
		
		
		int[] sizes = {2,4,8,16,32,64,128,256,512};
		System.out.printf("#%7s%10s%10s\n","n" ,"Singly", "Doubly");
		for ( int n : sizes) {
			System.out.printf("%8d", n);
			int loop = 100;
			double sum = 0;
			double sum2 = 0;
			Node[] node = {new Node(1)};
			for(int i = 0; i<loop;i++) {
				Node[] nodes = nodeArray(n);
				LinkedList list = new LinkedList(node);
				LinkedList2 list2 = new LinkedList2(node);
				long t0 = System.nanoTime();
				for (int j = 0; j < n; j++) {
					list.add(nodes[j]);
				}
				for (int j = 0; j < n; j++) {
					int x = list.remove();
				}
				long t1 = System.nanoTime();
				long t2 = System.nanoTime();
				for (int j = 0; j < n; j++) {
					list2.add(nodes[j]);
				}
				for (int j = 0; j < n; j++) {
					int x = list2.remove();
				}
				long t3 = System.nanoTime();
				double time = (t1 - t0);
				double time1 = (t3 - t2);
				sum+=time;
				sum2+=time1;
			}
			System.out.printf("%10.0f", (sum/loop));
			System.out.printf("%10.0f\n", (sum2/loop));
		}
		
		
	}
	
	public static Node[] nodeArray(int size) {
		Random r = new Random();
		Node[] nodes = new Node[size];
		for(int i =0; i<nodes.length;i++) {
			nodes[i] = new Node(r.nextInt(size*10));
		}
		return nodes;
	}

}
