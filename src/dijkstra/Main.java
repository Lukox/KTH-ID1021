package dijkstra;

import java.util.Arrays;

import dijkstra.PQ.Node;

public class Main {
	Node[] processed;
	PQ p;
	static Map map;
	private int mod = 541;
	public Main() {
		p = new PQ();
		processed = new Node[mod];
	}
	
	public Integer dijkstra(City from, City to) {
		p.add(from.name, 0, null, from.number);
		while(p.k != 0) {
			Node path = p.remove();
			if(path.name.equals(to.name)) {
				return path.distance;
			}
			int index = hash(path.name);
			while(processed[index%mod] != null) {
				index+=1;
			}	
			processed[index%mod] = path;
			City c = map.lookup(path.name);
			int prevDist = path.distance;
			for(int i = 0; i<c.connections.length;i++) {
				Connection conn = c.connections[i];
				int procIndex = hash(conn.city.name); 
				if(processed[procIndex] == null) {
					Node node = p.hashTable[p.hash(conn.city.number)];
					if(node!=null) {
						if(path.distance+conn.minutes < node.distance) {
							node.distance = prevDist + conn.minutes;
							p.bubble(node, map);
						}
					}else {
						p.add(conn.city.name, prevDist+conn.minutes, c, conn.city.number);
					}
				}else {
					while(true) {
						if(processed[procIndex] == null) {
							Node node = p.hashTable[p.hash(conn.city.number)];
							if(node!=null) {
								if(path.distance+conn.minutes < node.distance) {
									node.distance = path.distance + conn.minutes;
									p.bubble(node,map);
								}
							}else {
								p.add(conn.city.name, path.distance+conn.minutes, c, conn.city.number);
							}
							break;
						}
						if(processed[procIndex].name.equals(conn.city.name)) {
							break;
						}
						procIndex = (procIndex+1)%mod;
					}
				}
			}
		}
		return null;
	}
	
	private Integer hash(String name) {
		int hash = 7;
		for (int i = 0; i < name.length(); i++) {
			hash = (hash*31 % mod) + name.charAt(i);
		}
		return hash % mod ;
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		map = new Map();
		String from = "Malmö" ;
		//String from = "Stockholm" ;
		String to = "Umeå";
		//String to = "Sundsvall" ;
		//String to = "Göteborg";
		//String from = "Stockholm" ;
		//String to = "Sundsvall";
		long time = 0;
		long t0 = System.nanoTime();
		Integer dist = m.dijkstra(map.lookup(from), map.lookup(to));
		//for(int i = 0; i < dist.length; i++) {
		//	if(dist[i] != null)
		//		System.out.println(dist[i].name + " " + dist[i].distance);
		//}
		time =(System.nanoTime() - t0)/1_000;
		
		System.out.println("shorest: " + dist + " min (" + time + " us)");
	}

}
