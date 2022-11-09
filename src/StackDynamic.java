
public class StackDynamic {
	private int[] stack;
	private int sp;

	public StackDynamic() {
		this.stack = new int[4];
		this.sp = 0;
	}
	
	public void push(int value) {
		if(sp==stack.length) {
			int []temp = new int[4+stack.length];
			for(int i = 0;i<stack.length;i++) {
				temp[i] = stack[i];
			}
			this.stack = temp;
		}
		this.stack[sp] = value;
		sp++;
	}	
	
	public int pop() {
		sp--;
		if (sp == -1) {
			sp++;
			return 0;
		}
		if(sp==stack.length-6) {
			int []temp = new int[stack.length-3];
			for(int i = 0;i<temp.length;i++) {
				temp[i] = stack[i];
			}
			this.stack = temp;
		}
		return this.stack[sp];
	}
	
}
