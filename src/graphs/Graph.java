package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import hashTables.Zip.Node;

public class Graph {
	
	public Graph() {
		File file = new File("C:\\Users\\filip\\Desktop\\KTH UNI\\kelly.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				
				//Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
				
			}
		} catch (Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}

}
