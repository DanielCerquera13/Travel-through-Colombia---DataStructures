package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphByLists<T extends Comparable<T>, E extends Comparable<E>> implements IGraph<T,E>{

	
	private Map<Vertex<T>,ArrayList<Edge<?>>> adjList;
	
	
	public GraphByLists() {
	
	adjList = new HashMap<Vertex<T>, ArrayList<Edge<?>>>();
		
	}

	@Override
	public void addEdge(T from, T destination, boolean directed, double cost, E value) {
		
		
		
		
	}

	@Override
	public void removeEdge(T from, T destination, boolean directed, double cost) {

		
	}

	@Override
	public void addVertex(T valueVertex) {
		adjList.put(new Vertex<T>(valueVertex), new ArrayList<Edge<?>>());
		
	}

	@Override
	public void removeVertex(T valueVertex) {

		
	}

	@Override
	public boolean isAdjacent(T vertexA, T vertexB) {
		
		return false;
	}

	@Override
	public int getNumVertex() {
		
		return 0;
	}
	
	
}
