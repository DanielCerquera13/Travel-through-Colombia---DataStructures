package dataStructures;

import java.util.ArrayList;
import java.util.Stack;

public class MethodsGraphs<T extends Comparable<T>, E extends Comparable<E>> {

	public MethodsGraphs() {

	}

	private ArrayList<Vertex<T>> DFS(GraphByMatrix<T, E> g, Vertex<T> v, boolean[] visited, Stack<Vertex<T>> stack,
			ArrayList<Vertex<T>> dfs) {

		if (stack.isEmpty()) {
			return dfs;
		}

		ArrayList<Vertex<T>> vertices = g.getVertices();

		int index = g.getIndexVertex(v.getValue());

		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {

			if (stack.peek() != v) {
				stack.push(v);

			}

			if (visited[g
					.getIndexVertex((T) vertices.get(index).getEdges().get(i).getDestination().getValue())] == false) {

				visited[index] = true;
				System.out.println(v);
				dfs.add(v);
				return DFS(g, (Vertex<T>) vertices.get(index).getEdges().get(i).getDestination(), visited, stack, dfs);

			}

		}

		stack.pop();

		return DFS(g, stack.peek(), visited, stack, dfs);

	}

	public ArrayList<Vertex<T>> DFS(GraphByMatrix<T, E> g, Vertex<T> v) {

		boolean[] visited = new boolean[g.getVertices().size()];
		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		ArrayList<Vertex<T>> dfs = new ArrayList<>();
		stack.push(v);
		dfs.add(v);
		return DFS(g, v, visited, stack, dfs);

	}

//public Vertex<T>[] prim(GraphByLists<T,E> graph, int v) {
//	
//	int[] d=new int[graph.] 
//	
//			
//	
//}	

	public static void main(String[] args) {

		GraphByMatrix<Integer, Integer> g = new GraphByMatrix<>(5);

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
		g.addEdge(nueve, v1, false, 0, 1);
		g.addEdge(v1, cinco, false, 0, 1);
		System.out.println(g.getVertices());
		System.out.println(g.getVertices().get(4).getEdges().size());

		MethodsGraphs<Integer, Integer> m = new MethodsGraphs<>();

//		System.out.println(m.DFS(g, new Vertex<Integer>(trece)));

	}

}
