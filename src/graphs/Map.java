package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Map {
	public City[] cities;
	private final int mod = 541;
	public Map() {
		File files = new File("C:\\Users\\filip\\Desktop\\KTH UNI\\Algorithms and Data Structures\\trains.csv");
		cities = new City[mod];
		try (BufferedReader br = new BufferedReader(new FileReader(files))) {
			String line;
			cities = new City[541];
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				City city1 = lookup(row[0]);
				City city2 = lookup(row[1]);
				int distance = Integer.valueOf(row[2]);
				city1.addConnection(city2, distance);
				city2.addConnection(city1, distance);
			}
		} catch (Exception e) {
			System.out.println(" file " + files + " not found or corrupt");
		}
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