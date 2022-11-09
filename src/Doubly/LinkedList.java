package Doubly;

import java.util.ArrayList;


public class LinkedList {
	
	Node nextNode;
	Node elements;
	
	public LinkedList(Node[] elements) {
		if (elements.length > 0)
		{
			Node node = elements[0];
			this.elements = node;
			int pos = 1;
			while (pos < elements.length)
			{
				node.nextNode = elements[pos++];
				node = node.nextNode;
			}
		}
	}
	
	public void add(Node n) {
		if (elements == null) {
    		elements = n;
    	}
    	else {    		
    		Node temp = elements;
    		elements = n;
    		n.nextNode = temp;
    	}
	}
	
	public void remove(Node n) {
		Node node = elements;
		if (n.equals(node)) {
			elements = node.nextNode;
		}else {
			while(!n.equals(node.nextNode)) {
				node = node.nextNode;
			}
		}
		if(node.nextNode.nextNode == null) {
			node.nextNode = null;
		}else {
			node.nextNode = node.nextNode.nextNode;
		}
		
	}
	
	public String toString() {
		String result = "[";
		Node[]n = getVertices();
		for(int i =0; i < n.length;i++) {
			result = result + n[i];
		}
		result = result+"]";
		return result;
	}

	
	public Node[] getVertices() {
		Node node = this.elements;
		ArrayList<Node> n = new ArrayList<Node>();
		while (node != null) {
			n.add(node);
			node = node.nextNode;
		}
		Node[] array = n.toArray(new Node[0]);
		return array;		
	}
}
