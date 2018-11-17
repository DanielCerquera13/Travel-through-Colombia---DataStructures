package dataStructures;

import java.util.ArrayList;
import java.util.Stack;

public class MethodsGraphs<T extends Comparable<T>, E extends Comparable<E>> {

	public MethodsGraphs() {

	}

	// DFS by graph by Matrix Aux
	private ArrayList<Vertex<T>> DFS(GraphByMatrix<T, E> g, Vertex<T> v, boolean[] visited, Stack<Vertex<T>> stack,
			ArrayList<Vertex<T>> dfs) {

		if (dfs.size() == g.getVertices().size()) {
			return dfs;
		}

		ArrayList<Vertex<T>> vertices = g.getVertices();

		int index = g.getIndexVertex(v.getValue());
		visited[index] = true;

		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {

			if (stack.peek() != v) {
				stack.push(v);
				dfs.add(v);

			}

			if (visited[g
					.getIndexVertex((T) vertices.get(index).getEdges().get(i).getDestination().getValue())] == false) {

				return DFS(g, (Vertex<T>) vertices.get(index).getEdges().get(i).getDestination(), visited, stack, dfs);

			}

		}

		stack.pop();

		return DFS(g, stack.peek(), visited, stack, dfs);

	}

	// DFS by graph by Matrix 
	public ArrayList<Vertex<T>> DFS(GraphByMatrix<T, E> g, Vertex<T> v) {

		boolean[] visited = new boolean[g.getVertices().size()];
		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		ArrayList<Vertex<T>> dfs = new ArrayList<>();
		stack.push(v);
		dfs.add(v);
		return DFS(g, v, visited, stack, dfs);

	}
	
	
	// DFS by graph Lists Aux
	private ArrayList<Vertex<T>> DFS(GraphByLists<T, E> g, Vertex<T> v, boolean[] visited, Stack<Vertex<T>> stack,
			ArrayList<Vertex<T>> dfs) {

		if (dfs.size() == g.getVertices().size()) {
			return dfs;
		}

		ArrayList<Vertex<T>> vertices = g.getVertices();

		int index = g.getIndexVertex(v.getValue());
		visited[index] = true;

		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {

			if (stack.peek() != v) {
				stack.push(v);
				dfs.add(v);

			}

			if (visited[g
					.getIndexVertex((T) vertices.get(index).getEdges().get(i).getDestination().getValue())] == false) {

				return DFS(g, (Vertex<T>) vertices.get(index).getEdges().get(i).getDestination(), visited, stack, dfs);

			}

		}

		stack.pop();

		return DFS(g, stack.peek(), visited, stack, dfs);

	}
	
	// DFS by Graph by lists.
	public ArrayList<Vertex<T>> DFS(GraphByLists<T, E> g, Vertex<T> v) {

		boolean[] visited = new boolean[g.getVertices().size()];
		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		ArrayList<Vertex<T>> dfs = new ArrayList<>();
		stack.push(v);
		dfs.add(v);
		return DFS(g, v, visited, stack, dfs);

	}
	

	

	public static void main(String[] args) {

		GraphByLists<Integer, Integer> g = new GraphByLists<>(5);

		Integer trece = 13;
		Integer ocho = 8;
		Integer nueve = 9;
		Integer v1 = 21;
		Integer cinco = 5;

		g.addVertex(trece);
		g.addVertex(ocho);
		g.addVertex(nueve);
		g.addVertex(v1);
		g.addVertex(cinco);

		g.addEdge(trece, ocho, false, 0, 1);

		g.addEdge(trece, cinco, false, 0, 1);
		g.addEdge(trece, v1, false, 0, 1);

		g.addEdge(ocho, nueve, false, 0, 1);
		g.addEdge(v1, cinco, false, 0, 1);
		System.out.println(g.getVertices());
		System.out.println(g.getVertices().get(4).getEdges().size());

		MethodsGraphs<Integer, Integer> m = new MethodsGraphs<>();

		System.out.println(m.DFS(g, new Vertex<Integer>(trece)));

	}

}
