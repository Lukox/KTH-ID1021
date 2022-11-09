package heaps;

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
		Node temp = elements;
		elements = n;
		elements.nextNode = temp;
	}
	
	public int remove() {
		Node current = elements;
		int min = current.value;
		Node prevMinNode = null;
		while(current.nextNode != null) {
			if(current.nextNode.value < min) {
				prevMinNode = current;
				min  = current.nextNode.value;
			}
			current = current.nextNode;
		}
		if(prevMinNode == null) {
			elements = elements.nextNode;
		}else {
			prevMinNode.nextNode = prevMinNode.nextNode.nextNode;
		}
		return min;
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