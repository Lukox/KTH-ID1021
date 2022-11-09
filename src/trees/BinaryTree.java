package trees;

import java.util.Iterator;

import Doubly.Node;

public class BinaryTree implements Iterable<Integer>{

	public class Node {
		public Integer key;
		public Integer value;
		public Node left, right;
		public Node(Integer key, Integer value) {
			this.key = key;
			this.value = value;
			this.left = this.right = null;
		}
	}

	Node root;
	public BinaryTree() {
		root = null;
	}

	public void add(Integer key, Integer value) {
		Node newNode = new Node(key,value);
		Node current = root;
		boolean added = false;
		if(root == null) {
			root = newNode;
		}else {
			while(!added) {
				if(key<current.key) {
					if(current.left == null) {
						current.left = newNode;
						added = true;
					}else {
						current = current.left;
					}
				}else if(key>current.key){
					if(current.right == null) {
						current.right = newNode;
						added = true;
					}else {
						current = current.right;
					}
				}else {
					current.value = newNode.value;
					added = true;
				}
			}
		}
	}
	
	public Integer lookup(Integer key) {
		Node current = root;
		if(current == null) {
			return null;
		}
		while(key<current.key || key>current.key) {
			if(key<current.key) {
				if(current.left == null) {
					return null;
				}else {
					current = current.left;
				}
			}else{
				if(current.right == null) {
					return null;
				}else {
					current = current.right;
				}
			}
		}
		return current.value;
	}

	@Override
	public Iterator<Integer> iterator() {
			try {
				return new TreeIterator2(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
}
