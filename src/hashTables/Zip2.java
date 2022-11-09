package hashTables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Zip2 {
	Node[] data;
	int max;
	Integer[] keys;
	public class Node {
		Integer code;
		String name;
		Integer pop;
		public Node(Integer code, String name, Integer pop) {
			this.code = code;
			this.name = name;
			this.pop = pop;
		}
	}
	public Zip2(File file) {
		data = new Node[100000];
		keys = new Integer[100000];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
				data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
				keys[code] = code;
			}
			max = 100000;
		} catch (Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}

	public void lookup(Integer code) {
		if(data[code] != null) {
			return;
		}
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
