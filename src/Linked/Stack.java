package Linked;

public class Stack {

	public static void main(String[] args) {
		LinkedList stack = new LinkedList(1,null);
		stack.push(new LinkedList(31,null));
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(new LinkedList(69,null));
		stack.push(new LinkedList(31,null));

		System.out.println(stack.pop());
		//stack.pop();
	}

}
