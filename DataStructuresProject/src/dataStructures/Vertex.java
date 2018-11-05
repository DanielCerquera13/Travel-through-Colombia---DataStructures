package dataStructures;

import java.util.ArrayList;

public class Vertex<T extends Comparable<T>> implements Comparable<T> {

	private T value;
	private ArrayList<Edge<?>> edges;

	public Vertex(T value) {

		this.value = value;
		edges = new ArrayList<Edge<?>>();

	}

	public ArrayList<Edge<?>> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge<?>> edges) {
		this.edges = edges;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {

		return value.toString();

	}

}
