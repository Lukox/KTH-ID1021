package t9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("aaad");
		t.add("ee");
		File file = new File("C:\\Users\\filip\\Desktop\\KTH UNI\\kelly.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(Arrays.toString(t.search((t.getKey(line)),"")));
			}
		} catch (Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}

}
