package dijkstra;

public class PQ {
	
	public class Node {
		public String name;
		public Integer distance;
		public City enter;
		public Node parent;
		public Node(String name, Integer distance, City enter) {
			this.name = name;
			this.distance = distance;
			this.enter = enter;
			this.parent = null;
		}
	}
	
	public int k;
	public Node[] tree;
	Node[] hashTable;
	public PQ() {
		k = 0;
		tree = new Node[53];
		hashTable = new Node[53];
	}
	
	public void add(String name, Integer distance, City enter, Integer number) {
		int saveK = k;
		Node node = new Node(name, distance, enter);
		int indexH = hash(number);
		hashTable[indexH] = node;
		tree[k] = node;
		while(k!=0){
			int index = (k-1)/2;
			tree[k].parent = tree[index];
			if(tree[k].distance < tree[index].distance) {
				Node temp = tree[k];
				tree[k] = tree[index];
				tree[index] = temp;
				hashTable[indexH] = tree[k];
				tree[index].parent = tree[k];
				k = index;
			}else {
				break;
			}
		}
		k = saveK+1;
	}
	
	public Node remove() {
		k -= 1; 
		Node value = tree[0];
		tree[0] = tree[k];
		tree[k] = null;
		int current = 0;
		while(true) {
			int leftBranch = current*2+1;
			int rightBranch = current*2+2;
			//System.out.println(tree[current].distance);
			if(leftBranch>=k) {
				break;
			}
			if(rightBranch>=k) {
				if(tree[current].distance>tree[leftBranch].distance) {
					Node temp = tree[current];
					tree[current] = tree[leftBranch];
					tree[leftBranch] = temp;
					current = leftBranch;
				}else {
					break;
				}
			}else if(tree[leftBranch].distance < tree[rightBranch].distance) {
				if(tree[current].distance>tree[leftBranch].distance) {
					Node temp = tree[current];
					tree[current] = tree[leftBranch];
					tree[leftBranch] = temp;
					current = leftBranch;
				}else {
					break;
				}
			}else {
				if(tree[current].distance>tree[rightBranch].distance) {
					Node temp = tree[current];
					tree[current] = tree[rightBranch];
					tree[rightBranch] = temp;
					current = rightBranch;
				}else {
					break;
				}
			}
		}
		return value;
	}

	public Integer hash(int number) {
		return number % 541;
	}

	public void bubble(Node node, Map m) {
		//int hashIndex = hash(m.lookup(node.name).number);
		Node current = node;
		while(current!=null){
			Node parent = current.parent;
			if(current.distance < parent.distance) {
				Node temp = current;
				current = parent;
				parent = temp;
				current = current.parent;
			}else {
				break;
			}
		}
	}
}
