package quickSort;

public class QuickSortLL {

	static class Node {

		int value;
		Node next;

		Node(int d)
		{
			this.value = d;
			this.next = null;
		}
	}

	Node head;
	Node last;

	void addNode(int data)
	{
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;

		Node newNode = new Node(data);
		curr.next = newNode;
		last = curr.next;
	}

	static void printList(Node n)
	{
		while (n != null) {
			System.out.println(n.value);
			n = n.next;
		}
		System.out.println("");
	}

	public static void sort(Node start, Node last) {
		if(start == null || last == null||start == last || start == last.next) 
			return;
		Node prevPivotNode = partition(start, last);
		sort(start, prevPivotNode);

        if (prevPivotNode != null && prevPivotNode.next != null)
        	sort(prevPivotNode.next.next,last);
        else 
        	sort(start.next,last);
        
	}

	private static Node partition(Node start, Node last) {
		if (start == last || start == null || last == null)
			return start;
		Node current = start.next;
		Node pivot = start;
		Node lastSmallIndex = pivot;
		Node prevPivot = null;
		while(current != last.next) {
			if(current.value <= pivot.value) {
				prevPivot = lastSmallIndex;
				swap(lastSmallIndex.next, current);
				lastSmallIndex = lastSmallIndex.next;
			}
			current = current.next;
		}
		swap(lastSmallIndex, pivot);
		return prevPivot;
	}

	public static  void swap (Node a, Node b) {
		int temp = a.value;
		a.value = b.value;
		b.value = temp;
		return;
	}
}