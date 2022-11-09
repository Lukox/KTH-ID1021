package hashTables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Zip3 {
	Bucket[] buckets;
	int max;
	Integer[] keys;
	int modulo =80000;
	public class Node {
		Integer code;
		String name;
		Integer pop;
		Node next;
		public Node(Integer code, String name, Integer pop) {
			this.code = code;
			this.name = name;
			this.pop = pop;
		}
	}
	
	public class Bucket {
		Node[] elements;
		public Bucket(Node node) {
			Node[] nodes = {node};
			this.elements = nodes;
		}
	}
	
	public Zip3(File file) {
		buckets = new Bucket[modulo];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
				Node node = new Node(code, row[1], Integer.valueOf(row[2]));
				Integer index = code % modulo;
				if(buckets[index] == null) {
					buckets[index] = new Bucket(node);
				}else {
					Node[] nodes = new Node[buckets[index].elements.length+1];
					int i;
					for(i=0; i < buckets[index].elements.length; i++) {
						nodes[i] = buckets[index].elements[i];
					}
					nodes[i] = node;
					buckets[index].elements = nodes;
				}
			}
		} catch (Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}

	public int lookup(Integer code) {
		Integer index = code % modulo;
		int x = 1;
		if(buckets[index] == null) {
			return 0;
		}
		for(int i = 0; i < buckets[index].elements.length;i++) {
			if(buckets[index].elements[i].code.equals(code)) {
				return x;
			}
			x+=1;
		}
		return x;
		//not found
	}
	
	public void collisions(int mod) {
		int[] data = new int[mod];
		int[] cols = new int[10];
		for (int i = 0; i < max; i++) {
			Integer index = keys[i] % mod;
			cols[data[index]]++;
			data[index]++;
		}
		System.out.print(mod);
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + cols[i]);
		}
		System.out.println();
	}

}
