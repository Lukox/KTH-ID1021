package trees;

import java.util.Iterator;
import java.util.NoSuchElementException;

import trees.BinaryTree.Node;

public class TreeIterator implements Iterator<Integer> {

	
	private Node next;
	private Stack<Node> stack;
	public TreeIterator(BinaryTree tree) throws Exception{
		next = tree.root;
		stack = new Stack<Node>();
		while (next != null) {
            stack.push(next);
            next = next.left;
        }
	}
	
	@Override
	public boolean hasNext() {
        return !stack.isStackEmpty();
	}

	@Override
	public Integer next(){
		if (!hasNext()) {
            return null;
		}else {
        Node current = null;
		try {
			current = stack.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        if (current.right != null) {
        	while (current.right != null) {
            	try {
					stack.push(current.right);
				} catch (Exception e) {
					e.printStackTrace();
				}											
            	current.right = current.right.left;
        	}
        }
        return current.value;
		}
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
