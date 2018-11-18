package dataStructures;

import java.util.ArrayList;

public class MST<E extends Comparable<E>> {

	private ArrayList<Edge<E>> tree;
	private double minCost;

	public MST(ArrayList<Edge<E>> tree, double minCost) {

		tree = new ArrayList<>();
		this.minCost = minCost;

	}

	public ArrayList<Edge<E>> getTree() {
		return tree;
	}

	public void setVertices(ArrayList<Edge<E>> tree) {
		this.tree = tree;
	}

	public double getMinCost() {
		return minCost;
	}

	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}

}
