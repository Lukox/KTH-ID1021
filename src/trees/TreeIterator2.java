package trees;

import java.util.Iterator;
import java.util.NoSuchElementException;

import trees.BinaryTree.Node;

public class TreeIterator2 implements Iterator<Integer> {
	private Node next;
	private Queue<Node> q;
	public TreeIterator2(BinaryTree tree) throws Exception{
		q = new Queue<Node>();
		next = tree.root;
		q.add(next);
	}
	
	@Override	
	public boolean hasNext() {
        return q.hasItems();
	}

	@Override
	public Integer next(){
		Node current = q.remove();
		if (current.left != null) {
            q.add(current.left);
        }
        if (current.right != null) {
            q.add(current.right);
        }
		return current.value;
	}
}
