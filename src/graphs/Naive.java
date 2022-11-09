package graphs;

public class Naive {

	private static Integer shortest(City from, City to, Integer max) {
		if (max < 0)
			return null;
		if (from == to)
			return 0;
		Integer shrt = null;
		for (int i = 0; i < from.connections.length; i++) {
			if (from.connections[i] != null) {
				Connection conn = from.connections[i];
				int tempmax;
				tempmax = max - conn.minutes;
				Integer time = shortest(conn.city, to, tempmax);
				if(time!=null) {
					if(shrt == null || time+conn.minutes < shrt) {
						shrt = time + conn.minutes;
					}
				}
			}
		}
		return shrt;
	}

	public static void main(String[] args) {
		Map map = new Map();
		//String from = "Malmö" ;
		//String from = "Stockholm" ;
		String from = "Umeå";
		//String to = "Sundsvall" ;
		String to = "Göteborg";
		//String to = "D";
		//String from = "B";
		Integer max = Integer.valueOf("750");
		long t0 = System.nanoTime();
		Integer dist = shortest(map.lookup(from), map.lookup(to), max);
		long time = (System.nanoTime() - t0)/1_000_000;
		System.out.println("shorest: " + dist + " min (" + time + " ms)");
	}

}
