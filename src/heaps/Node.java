package heaps;

public class Node {
	
	int value;
	Node nextNode;
	Node prevNode;
	
	public Node(int value) {
		this.value = value;
		nextNode = null;
		prevNode = null;
	}

	public String toString() {
	    return "("+value+")";
	}	
}
