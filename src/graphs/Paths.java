package graphs;

public class Paths {
	City[] path;
	int sp;
	public Paths() {
		path = new City[54];
		sp = 0;
	}

	private Integer shortest(City from, City to, Integer max) {
		if (max < 0)
			return null;
		if (from == to)
			return 0;
		Integer shrt = null;
		for (int i = 0; i < sp; i++) {
			if (path[i] == from)
				return null;
		}
		path[sp++] = from;

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
		path[sp--] = null;
		return shrt;
	}

	public static void main(String[] args) {
		Paths p = new Paths();
		Map map = new Map();
		String from = "Malmö" ;
		//String from = "Stockholm" ;
		//String to = "Umeå";
		//String to = "Sundsvall" ;
		//String from = "Göteborg";
		String to = "Kiruna";
		Integer max = Integer.valueOf("10000");
		long t0 = System.nanoTime();
		Integer dist = p.shortest(map.lookup(from), map.lookup(to), max);
		long time = (System.nanoTime() - t0)/1_000_000;
		System.out.println("shorest: " + dist + " min (" + time + " ms)");
	}


}

