package graphs;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Map m = new Map();
		int j =0;
		for(int i = 0; i < 541; i++) {
			if(m.cities[i] != null) {
				System.out.println(m.cities[i].name);
				System.out.println(j++);
			}
		}
	}

}
