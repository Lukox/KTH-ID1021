package hashTables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Zip {
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
	public Zip(File file) {
		data = new Node[10000];
		keys = new Integer[100000];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
				data[i] = new Node(code, row[1], Integer.valueOf(row[2]));
				keys[i] = code;
				i++;
			}
			//System.out.println(keys[9674]);
			max = i;
		} catch (Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}
	
	public void linear(Integer code) {
		for(int i = 0; i < max; i++) {
			if(data[i].code.equals(code)) {
				break;
			}
		}
	}
	
	public void binary(Integer code) {
		int first = 0;
		int last = max;
		while (first <= last) {
			int index = (first+last)/2 ;
			int result = Integer.compare(code, data[index].code);
			if (result == 0)
                break;
            if (result > 0)
            	first = index + 1;    
            else
                last = index - 1;
        }
	}
	
	public void collisions(int mod) {
		int[] data = new int[mod];
		int[] cols = new int[18];
		for (int i = 0; i < max; i++) {
			Integer index = keys[i] % mod;
			cols[data[index]]++;
			data[index]++;
		}
		System.out.print(mod);
		for (int i = 0; i < 18; i++) {
			System.out.print("\t" + cols[i]);
		}
		System.out.println();
	}
}
