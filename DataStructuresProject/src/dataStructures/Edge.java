package dataStructures;

public class Edge<E extends Comparable<E>> implements Comparable<E> {

	private E value;
	private double cost;
	private boolean directed;

	public Edge(boolean directed, double cost, E value) {

		this.value = value;
		this.cost = cost;
		this.directed = directed;

	}

	public E getValue() {
		return value;
	}

	public void setName(E value) {
		this.value = value;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {

		return cost + " - " + value.toString();

	}

}
