package heaps;

import java.util.ArrayList;

public class LinkedList2 {
	Node nextNode;
	Node elements;
	
	public LinkedList2(Node[] elements) {
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
			Node current = elements;
			if(n.value < current.value) {
				elements = n;
				elements.nextNode = current;
			}else {
				while(current.nextNode != null && current.nextNode.value < n.value) {
					current = current.nextNode;
				}
				Node temp = current.nextNode;
				current.nextNode = n;
				current.nextNode.nextNode = temp;
			}
		}
		
		public int remove() {
			Node temp = elements;
			elements = elements.nextNode;
			return temp.value;
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
