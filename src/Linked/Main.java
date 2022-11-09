package Linked;

public class Main {

	public static void main(String[] args) {
		LinkedList listA;
		LinkedList listB;
		int[] sizes = {25,50,100,200,400,800,1600,3200};
		System.out.printf("#%7s%10s%10s\n","n" ,"Avg", "Min");
		for ( int n : sizes) {
			System.out.printf("%8d", n);
			int loop = 1000;
			double min = Double.POSITIVE_INFINITY;
			double sum = 0;
			double avg;
			for(int i = 0; i<loop;i++) {
				long t0 = System.nanoTime();
				listA = new LinkedList(1,null);
				//listB = new LinkedList(1,null);
				for(int j = 0; j < n; j++) {
					listA.append(new LinkedList(1,null));
				}
				//for(int j = 0; j < 100; j++) {
				//	listB.append(new LinkedList(1,null));
				//}
				//listA.append(listB);
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
}
