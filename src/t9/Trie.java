package t9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;

import hashTables.Zip4.Bucket;
import hashTables.Zip4.Node;

public class Trie {

	public class Node {
		public Node[] next;
		public boolean word;
		public Node() {
			next = new Node[27];
			word = false;
		}
	}

	public Node root;
	public Trie() {
		this.root = new Node();
		File file = new File("C:\\Users\\filip\\Desktop\\KTH UNI\\kelly.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				add(line);
			}
		} catch (Exception e) {
			System.out.println(" file " + file + " not found");
		}
	}
	
	public void add(String word) {
		Node current = root;
		for(int i = 0; i < word.length(); i++) {
			if(current.next[getCode(word.charAt(i))] == null) {
				current.next[getCode(word.charAt(i))] = new Node();
			}
			current = current.next[getCode(word.charAt(i))];
		}
		current.word = true;
	}

	public String[] search(String sequence, String path) {
		Node current = root;
		String[][] words = new String[3][];
		for(int i = 0; i < path.length(); i++) {
			current = current.next[getCode(path.charAt(i))];
		}
		int index = getIndex(Character.getNumericValue(sequence.charAt(path.length())));
		words[0] = null;
		words[1] = null;
		words[2] = null;
		String tempPath;
		for(int i = 0; i < 3; i++) {
			if(current.next[3*index+i] != null) {
				tempPath = path + getChar(3*index+i);
				if(tempPath.length() == sequence.length()) {
					if(current.next[3*index+i].word) {
						words[i] = new String[]{tempPath};
					}
				}else {
					words[i] = search(sequence, tempPath);
				}
			}
		}
		ArrayList<String> allWords = new ArrayList<String>();
		for(int i = 0; i < 3; i++) {
			if(words[i] != null) {
				for (String element : words[i]) {
					if(element != null) {
						allWords.add(element);
					}
				}
			}
		}
		return allWords.toArray(new String[0]);
	}

	public int getIndex(int key) {
		return key-1;
	}
	
	public String getKey(String word) {
		String key = "";
		for(int i = 0; i < word.length(); i++) {
			key = key + (getCode(word.charAt(i))/3 + 1);
		}
		return key;
	}

	public Integer getCode(char c) {
		switch(c) {
		case 'a':
			return 0;	
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		case 'h':
			return 7;
		case 'i':
			return 8;
		case 'j':
			return 9;
		case 'k':
			return 10;
		case 'l':
			return 11;
		case 'm':
			return 12;
		case 'n':
			return 13;
		case 'o':
			return 14;
		case 'p':
			return 15;
		case 'r':
			return 16;
		case 's':
			return 17;
		case 't':
			return 18;
		case 'u':
			return 19;
		case 'v':
			return 20;
		case 'x':
			return 21;
		case 'y':
			return 22;
		case 'z':
			return 23;
		case '\u00e5':
			return 24;
		case '\u00e4':
			return 25;
		case '\u00f6':
			return 26;
		default:
			return null;
		}
	}
	
	public char getChar(Integer code) {
		switch(code) {
		case 0:
			return 'a';	
		case 1:
			return 'b';
		case 2:
			return 'c';
		case 3:
			return 'd';
		case 4:
			return 'e';
		case 5:
			return 'f';
		case 6:
			return 'g';
		case 7:
			return 'h';
		case 8:
			return 'i';
		case 9:
			return 'j';
		case 10:
			return 'k';
		case 11:
			return 'l';
		case 12:
			return 'm';
		case 13:
			return 'n';
		case 14:
			return 'o';
		case 15:
			return 'p';
		case 16:
			return 'r';
		case 17:
			return 's';
		case 18:
			return 't';
		case 19:
			return 'u';
		case 20:
			return 'v';
		case 21:
			return 'x';
		case 22:
			return 'y';
		case 23:
			return 'z';
		case 24:
			return '\u00e5';
		case 25:
			return '\u00e4';
		case 26:
			return '\u00f6';
		}
		return ' ';
	}
}
