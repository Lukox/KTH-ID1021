package queues;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] sizes = {25,50,100,200,400,800,1600,3200,6400};
		System.out.printf("#%7s%10s%10s\n","n" ,"Avg", "Min");
		for ( int n : sizes) {
			System.out.printf("%8d", n);
			int loop = 100;
			double min = Double.POSITIVE_INFINITY;
			double sum = 0;
			double avg;
			for(int i = 0; i<loop;i++) {
				Queue q = new Queue();
				Random r =  new Random();
				long t0 = System.nanoTime();
				for(int j = 0; j< 100;j++) {
					q.add(r.nextInt(n));
				}
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

	private static void emptyQueue(Queue q, int n) {
		for(int i = 0; i< n;i++) {
			int x = q.remove();
		}
	}
}
