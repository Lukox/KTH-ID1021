package hashTables;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Zip4 z = new Zip4(new File("C:\\Users\\filip\\eclipse-workspace\\AlgoTasks\\src\\hashTables\\postnummer.csv"));
		Zip3 z2 = new Zip3(new File("C:\\Users\\filip\\eclipse-workspace\\AlgoTasks\\src\\hashTables\\postnummer.csv"));
		//z2.collisions(10000);
		double sum = 0;
		double sum2 = 0;
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			//long t0 = System.nanoTime();
			Integer zip = r.nextInt(90000)+10000;
			//Integer zip = 21118;
			int x = z.lookup(zip);
			int y = z2.lookup(zip);
			//long t1 = System.nanoTime();
			//double time = (t1 - t0);
			sum+=x;
			sum2+=y;
			//long t2 = System.nanoTime();
			//z.binary(99499);
			//long t3 = System.nanoTime();
			//time = (t3 - t2);
			//sum2+=time;
		}
		System.out.println(sum/1000);
		System.out.println(sum2/1000);
		//for(int i = 0; i < 23456; i++) {
		//	if(z.buckets[i] != null && z.buckets[i].elements.length!=0)
			//	System.out.println((z.buckets[i].elements.length));
		//}
		//System.out.println(sum2/10000);
		//z.collisions(50000);
	}

}
