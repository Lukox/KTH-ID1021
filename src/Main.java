
public class Main {

	public static void main(String[] args) {
		Item[] items = {new Item(ItemType.VALUE, 6), new Item(ItemType.VALUE, 2), new Item(ItemType.DIV, 0),new Item(ItemType.VALUE, 6),new Item(ItemType.MUL, 0),new Item(ItemType.VALUE, 8),new Item(ItemType.VALUE, 3),new Item(ItemType.VALUE, 6),new Item(ItemType.VALUE, 9),new Item(ItemType.VALUE, 4),new Item(ItemType.VALUE, 4),new Item(ItemType.VALUE, 3),new Item(ItemType.VALUE, 2),new Item(ItemType.SUB, 6),new Item(ItemType.ADD, 6),new Item(ItemType.ADD, 6),new Item(ItemType.SUB, 6),new Item(ItemType.SUB, 6),new Item(ItemType.MUL, 6),new Item(ItemType.ADD, 6),new Item(ItemType.SUB, 6)};
		
		Calculator calc = new Calculator(items);
		System.out.println(calc.run());

	}
	
	


}
