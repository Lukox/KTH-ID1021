package Doubly;

import java.util.ArrayList;

public class DoublyLinkedList {

	Node nextNode;
	Node prevNode;
	Node elements;
	
	public DoublyLinkedList(Node[] elements) {
		if (elements.length > 0)
		{
			Node node = elements[0];
			this.elements = node;
			int pos = 1;
			while (pos < elements.length)
			{
				node.nextNode = elements[pos];
				if(pos == 1) {
					node.prevNode = null;
				}else {
					node.prevNode = elements[pos-2];
				}
				node = node.nextNode;
				pos++;
			}
			node.prevNode = elements[pos-2];
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
	    		n.nextNode.prevNode = n;
	    	}
		}
		
		public void remove(Node n) {
			//System.out.println("HEY");
			if(n.prevNode == null) {
				elements = n.nextNode;
				n.nextNode.prevNode = null;
			}else if(n.nextNode == null) {
				n.prevNode.nextNode = null;
			}else {
				n.prevNode.nextNode = n.nextNode;
				n.nextNode.prevNode = n.prevNode;
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
	
