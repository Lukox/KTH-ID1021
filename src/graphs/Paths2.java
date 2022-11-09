package graphs;

public class Paths2 {
	City[] path;
	int sp;
	public Paths2() {
		path = new City[54];
		sp = 0;
	}
	
	private Integer shortest(City from, City to, Integer max) {
		if (max != null && max < 0)
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
				Integer tempmax;
				if(shrt != null) {
					tempmax = shrt - conn.minutes;
				}else if(max == null) {
					tempmax = null;
				}else {
					tempmax = max - conn.minutes;
				}
				Integer time = shortest(conn.city, to, tempmax);
				if(time!=null) {
					shrt = time + conn.minutes;
				}
			}
		}
		path[sp--] = null;
		return shrt;
	}

	public static void main(String[] args) {
		Paths2 p = new Paths2();
		Map map = new Map();
		String from = "Malmö" ;
		String to = "Kiruna";
		Integer max = null;
		long t0 = System.nanoTime();
		Integer dist = p.shortest(map.lookup(from), map.lookup(to), max);
		long time = (System.nanoTime() - t0)/1_000_000;
		System.out.println("shorest: " + dist + " min (" + time + " us)");
	}


}

