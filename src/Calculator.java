
public class Calculator {

	Item[] expr;
	int ip;
	StackStatic stack;

	public Calculator(Item[] expr) {
		this.expr = expr;
		this.ip = 0;
		this.stack = new StackStatic();
	}

	public int run() {
		long n0 = System.nanoTime();
		while ( ip < expr.length ) {
			step();
		}
		System.out.println(System.nanoTime()-n0);
		return (int) stack.pop();
	}

	public void step() {
		Item nxt = expr[ip++];
		switch(nxt.type()) {
		case ADD : {
			int y = stack.pop();
			int x = stack.pop();
			stack.push(x + y);
			break;


		}
		case SUB : {
			int y = stack.pop();
			int x = stack.pop();
			stack.push(x - y);
			break;


		}
		case MUL : {
			int y = stack.pop();
			int x = stack.pop();
			stack.push(x * y);
			break;


		}
		case DIV : {
			int y = stack.pop();
			int x = stack.pop();
			stack.push(x / y);
			break;


		}
		case VALUE : {
			stack.push(nxt.getValue());
			break;
		}
		case MOD10 : {
			int y = stack.pop();
			stack.push(y % 10);
			break;
		}
		case STRANGE : {
			int y = stack.pop();
			int x = y%10;
			int z = y/10;
			stack.push(x+z);
			break;
		}
		}
	}
}
