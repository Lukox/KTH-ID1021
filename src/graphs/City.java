package graphs;

public class City {
	public String name;
	Connection[] connections;
	public City(String name) {
		this.name = name;
		this.connections = new Connection[0];
	}
	
	public void addConnection(City city, int minutes) {
		Connection newC = new Connection(city, minutes);
		Connection tempConnections[] = new Connection[connections.length + 1];
		int i = 0;
		for(i = 0; i < connections.length; i++) {
			tempConnections[i] = connections[i];
		}
		tempConnections[i] = newC;
		connections = tempConnections;
	}
}
