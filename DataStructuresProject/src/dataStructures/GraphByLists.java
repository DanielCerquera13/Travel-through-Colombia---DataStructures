package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphByLists<T extends Comparable<T>> implements IGraph<T>{

	
	private Map<Vertex<T>,ArrayList<Edge<?>>> adjList;
	
	
	public GraphByLists() {
	
	adjList = new HashMap<Vertex<T>, ArrayList<Edge<?>>>();
		
	}

	@Override
	public void addEdge(T from, T destination, boolean directed, double cost, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge(T from, T destination, boolean directed, double cost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVertex(T valueVertex) {
		adjList.put(new Vertex<T>(valueVertex), new ArrayList<Edge<?>>());
		
	}

	@Override
	public void removeVertex(T valueVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAdjacent(T vertexA, T vertexB) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumVertex() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
