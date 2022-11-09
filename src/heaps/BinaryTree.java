package heaps;

public class BinaryTree{

	public class Node {
		public int value;
		public Node left, right;
		public int subLeft, subRight;
		public int size;
		public Node(int value) {
			this.value = value;
			this.left = this.right = null;
			this.subLeft = 0;
			this.subRight = 0;
			this.size = this.subLeft + this.subRight;
		}
	}

	Node root;
	public BinaryTree() {
		root = null;
	}
	
	public int add(int n) {
		Node node = new Node(n);
		int level = 0;
		if(root == null) {
			root = node;
		}else {
			Node current = root;
			while(true) {
				if(node.value<current.value) {
					int temp = current.value;
					current.value = node.value;
					node.value = temp;
				}
				if(current.left == null){
					current.left = node;
					current.subLeft +=1;
					break;
				}else if(current.right == null) {
					current.right = node;
					current.subRight += 1;
					break;
				}else {
					if(current.subLeft < current.subRight) {
						current.subLeft += 1;
						current = current.left;
					}else {
						current.subRight += 1;
						current = current.right;
					}
				}
				level +=1;
			}
		}
		return level;
	}
	
	public Integer remove() {
		Integer toBeRemoved = root.value;
		if (root == null) {
			return null;
		}
		if(root.subLeft == 0 && root.subRight == 0) {
			Integer temp = root.value;
			root = null;
			return temp;
		}
		Node current = root;
		while(true) {
			if(current.left == null) {
				current.value = current.right.value;
				if(current.right.subLeft == 0 && current.right.subRight == 0) {
					current.right = null;
					current.subRight = 0;
					break;
				}else {
					current.subRight -= 1;
					current = current.right;
				}
				
			}else if(current.right == null) {
				current.value = current.left.value;
				if(current.left.subLeft == 0 && current.left.subRight == 0) {
					current.left = null;
					current.subLeft = 0;
					break;
				}else {
					current.subLeft -= 1;
					current = current.left;
				}
			}else if(current.right.value < current.left.value) {
				current.value = current.right.value;
				if(current.right.subLeft == 0 && current.right.subRight == 0) {
					current.right = null;
					current.subRight = 0;
					break;
				}else {
					current.subRight -= 1;
					current = current.right;
				}
			}else {
				current.value = current.left.value;
				if(current.left.subLeft == 0 && current.left.subRight == 0) {
					current.left = null;
					current.subLeft = 0;
					break;
				}else {
					current.subLeft -= 1;
					current = current.left;
				}
			}
		}
		return toBeRemoved;
	}
	
	
	public Integer push(int incr) {
		root.value = root.value + incr;
		Node current = root;
		int level = 0;
		if (root == null) {
			return null;
		}
		if(root.subLeft == 0 && root.subRight == 0) {
			return level;
		}
		while(true) {
			if(current.left == null) {
				if(current.right == null) {
					return level;
				}
				if(current.value > current.right.value) {
					int temp = current.value;
					current.value = current.right.value;
					current.right.value = temp;
					current = current.right;
				}else {
					break;
				}
			}else if(current.right == null) {
				if(current.left == null) {
					return level;
				}
				if(current.value > current.left.value) {
					int temp = current.value;
					current.value = current.left.value;
					current.left.value = temp;
					current = current.left;
				}else {
					break;
				}
			}else if(current.left.value<current.right.value) {
				if(current.value > current.left.value) {
					int temp = current.value;
					current.value = current.left.value;
					current.left.value = temp;
					current = current.left;
				}else {
					break;
				}
			}else  {
				if(current.value > current.right.value) {
					int temp = current.value;
					current.value = current.right.value;
					current.right.value = temp;
					current = current.right;
				}else {
					break;
				}
			}
			level+=1;	
		}
		return level;
	}

}
