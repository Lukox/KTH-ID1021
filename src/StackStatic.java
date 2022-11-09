
public class StackStatic {
	
	private int[] stack;
	private int sp;

	public StackStatic() {
		this.stack = new int[9];
		this.sp = 0;
	}
	
	public void push(int value) {
		if (sp!=9) {
			this.stack[sp] = value;
			sp++;
		}else {
			System.out.println("Stack full!");
		}
	}	
	
	public int pop() {
		if (sp != 0) {
			sp--;
			return this.stack[sp];
		}else {
			System.out.println("Empty Stack!");
			return 0;
		}
		
	}
	
}
