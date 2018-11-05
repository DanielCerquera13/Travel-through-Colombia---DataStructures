package dataStructures;

public class Edge<T extends Comparable<T>> implements Comparable<T> {

	private String name;
	private Vertex<?> from;
	private Vertex<?> to;
	private double cost;
	private boolean directed;

	public Edge(Vertex<?> from, Vertex<?> to, int cost) {

		this.from = from;
		this.to = to;
		this.cost = cost;

	}
	
	public Edge(boolean directed,double cost, String name) {
	
		this.name = name;
		this.cost = cost;
		this.directed = directed;
		from = null;
		to = null;
	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public Vertex<?> getFrom() {
		return from;
	}

	public void setFrom(Vertex<?> from) {
		this.from = from;
	}

	public Vertex<?> getTo() {
		return to;
	}

	public void setTo(Vertex<?> to) {
		this.to = to;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		
	return cost+" - "+name;	
		
	}

}
