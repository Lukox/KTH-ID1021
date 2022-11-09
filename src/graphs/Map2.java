package graphs;

public class Map2 {
	public City[] cities;
	private final int mod = 541;
	public Map2() {
		cities = new City[mod];

		City city1 = lookup("A");
		City city2 = lookup("B");
		int distance = 100;
		city1.addConnection(city2, distance);
		city2.addConnection(city1, distance);
		
		city1 = lookup("A");
		city2 = lookup("D");
		distance = 200;
		city1.addConnection(city2, distance);
		city2.addConnection(city1, distance);
		
		city1 = lookup("B");
		city2 = lookup("E");
		distance = 50;
		city1.addConnection(city2, distance);
		city2.addConnection(city1, distance);
		
		city1 = lookup("B");
		city2 = lookup("C");
		distance = 200;
		city1.addConnection(city2, distance);
		city2.addConnection(city1, distance);
		
		city1 = lookup("D");
		city2 = lookup("E");
		distance = 100;
		city1.addConnection(city2, distance);
		city2.addConnection(city1, distance);
		
		city1 = lookup("C");
		city2 = lookup("E");
		distance = 50;
		city1.addConnection(city2, distance);
		city2.addConnection(city1, distance);
		
		city1 = lookup("E");
		city2 = lookup("F");
		distance = 100;
		city1.addConnection(city2, distance);
		city2.addConnection(city1, distance);
		
		city1 = lookup("D");
		city2 = lookup("F");
		distance = 100;
		city1.addConnection(city2, distance);
		city2.addConnection(city1, distance);
		

	}
	public City lookup(String name) {
		Integer index = hash(name);
		if(cities[index] != null && name.equals(cities[index].name)) {
			return cities[index];
		}else {
			while(cities[index] != null) {
				if(name.equals(cities[index].name)) {
					return cities[index];
				}
				index+=1;
			}
			City city = new City(name);
			cities[index] = city;
			return cities[index];
		}
	}
	
	private Integer hash(String name) {
		int hash = 7;
		for (int i = 0; i < name.length(); i++) {
			hash = (hash*31 % mod) + name.charAt(i);
		}
		return hash % mod;
	}
}