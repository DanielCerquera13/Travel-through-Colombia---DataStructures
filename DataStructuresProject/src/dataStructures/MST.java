package dataStructures;

import java.util.ArrayList;

public class MST<T extends Comparable<T>> {

	private ArrayList<Vertex<T>> tree;
	private double minCost;

	public MST(ArrayList<Vertex<T>> tree, double minCost) {

		tree = new ArrayList<>();
		this.minCost = minCost;

	}

	public ArrayList<Vertex<T>> getTree() {
		return tree;
	}

	public void setVertices(ArrayList<Vertex<T>> tree) {
		this.tree = tree;
	}

	public double getMinCost() {
		return minCost;
	}

	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}

}
