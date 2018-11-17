package dataStructures;

import java.util.*;

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

	// BFS by graph by Matrix. Aux
	private ArrayList<Vertex<T>> BFS(GraphByMatrix<T, E> g, Vertex<T> v, boolean[] visited, Queue<Vertex<T>> queue,
			ArrayList<Vertex<T>> bfs) {

		if (bfs.size() == g.getVertices().size()) {
			return bfs;
		}

		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();

		visited[index] = true;

		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {

			if (visited[g
					.getIndexVertex((T) vertices.get(index).getEdges().get(i).getDestination().getValue())] == false) {

				queue.add((Vertex<T>) vertices.get(index).getEdges().get(i).getDestination());

			}
		}

		bfs.add(queue.poll());

		return BFS(g, queue.peek(), visited, queue, bfs);

	}

	// BFS by graph by Matrix.
	public ArrayList<Vertex<T>> BFS(GraphByLists<T, E> g, Vertex<T> v) {

		boolean[] visited = new boolean[g.getVertices().size()];
		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		ArrayList<Vertex<T>> bfs = new ArrayList<>();
		queue.add(v);

		return BFS(g, v, visited, queue, bfs);

	}

	// BFS by graph by Lists Aux.
	private ArrayList<Vertex<T>> BFS(GraphByLists<T, E> g, Vertex<T> v, boolean[] visited, Queue<Vertex<T>> queue,
			ArrayList<Vertex<T>> bfs) {

		if (bfs.size() == g.getVertices().size()) {
			return bfs;
		}

		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();

		visited[index] = true;

		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {

			if (visited[g
					.getIndexVertex((T) vertices.get(index).getEdges().get(i).getDestination().getValue())] == false) {

				queue.add((Vertex<T>) vertices.get(index).getEdges().get(i).getDestination());

			}
		}

		bfs.add(queue.poll());

		return BFS(g, queue.peek(), visited, queue, bfs);

	}

	// BFS by graph by lists.
	public ArrayList<Vertex<T>> BFS(GraphByMatrix<T, E> g, Vertex<T> v) {

		boolean[] visited = new boolean[g.getVertices().size()];
		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		ArrayList<Vertex<T>> bfs = new ArrayList<>();
		queue.add(v);

		return BFS(g, v, visited, queue, bfs);

	}

	// Dijkstra by graph by matrix relax aux.
	private void relax(int actual, int adj, double weight, double[] distances, PriorityQueue<Node<T>> queue,
			GraphByMatrix<T, E> g) {

		if (distances[actual] + weight < distances[adj]) {

			distances[adj] = distances[actual] + weight;
			queue.add(new Node<T>(g.getVertices().get(adj), distances[adj]));

		}

	}

	// Dijkstra by graph by matrix aux.
	private double[] Dijkstra(GraphByMatrix<T, E> g, Vertex<T> v, boolean[] included, double[] distances,
			ArrayList<Double> minDistances, PriorityQueue<Node<T>> queue) {

		for (int i = 0; i < distances.length; i++) {

			distances[i] = Double.MAX_VALUE;

		}

		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();

		distances[index] = 0.0;

		queue.add(new Node<>(v, distances[index]));

		while (!queue.isEmpty()) {

			Node<T> u = queue.poll();
			int indexAux = g.getIndexVertex(u.getVertex().getValue());

			if (included[indexAux]) {

				u = queue.poll();

			}

			included[indexAux] = true;

			for (int i = 0; i < vertices.get(indexAux).getEdges().size(); i++) {

				int adj = g.getIndexVertex((T) vertices.get(indexAux).getEdges().get(i).getDestination().getValue());
				double weight = vertices.get(indexAux).getEdges().get(i).getCost();

				if (included[adj] == false) {

					relax(indexAux, adj, weight, distances, queue, g);

				}

			}

		}

		return distances;
	}

	// Dijkstra by graph by matrix.
	public double[] Dijkstra(GraphByMatrix<T, E> g, Vertex<T> v) {

		boolean[] included = new boolean[g.getVertices().size()];
		double[] distances = new double[g.getVertices().size()];
		PriorityQueue<Node<T>> queue = new PriorityQueue<>();
		ArrayList<Double> minDistances = new ArrayList<>();

		return Dijkstra(g, v, included, distances, minDistances, queue);

	}

	// Dijkstra by graph by matrix relax aux.
	private void relax(int actual, int adj, double weight, double[] distances, PriorityQueue<Node<T>> queue,
			GraphByLists<T, E> g) {

		if (distances[actual] + weight < distances[adj]) {

			distances[adj] = distances[actual] + weight;
			queue.add(new Node<T>(g.getVertices().get(adj), distances[adj]));

		}

	}

	// Dijkstra by graph by matrix aux.
	private double[] Dijkstra(GraphByLists<T, E> g, Vertex<T> v, boolean[] included, double[] distances,
			ArrayList<Double> minDistances, PriorityQueue<Node<T>> queue) {

		for (int i = 0; i < distances.length; i++) {

			distances[i] = Double.MAX_VALUE;

		}

		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();

		distances[index] = 0.0;

		queue.add(new Node<>(v, distances[index]));

		while (!queue.isEmpty()) {

			Node<T> u = queue.poll();
			int indexAux = g.getIndexVertex(u.getVertex().getValue());

			if (included[indexAux]) {

				u = queue.poll();

			}

			included[indexAux] = true;

			for (int i = 0; i < vertices.get(indexAux).getEdges().size(); i++) {

				int adj = g.getIndexVertex((T) vertices.get(indexAux).getEdges().get(i).getDestination().getValue());
				double weight = vertices.get(indexAux).getEdges().get(i).getCost();

				if (included[adj] == false) {

					relax(indexAux, adj, weight, distances, queue, g);

				}

			}

		}

		return distances;
	}

	// Dijkstra by graph by matrix.
	public double[] Dijkstra(GraphByLists<T, E> g, Vertex<T> v) {

		boolean[] included = new boolean[g.getVertices().size()];
		double[] distances = new double[g.getVertices().size()];
		PriorityQueue<Node<T>> queue = new PriorityQueue<>();
		ArrayList<Double> minDistances = new ArrayList<>();

		return Dijkstra(g, v, included, distances, minDistances, queue);

	}

	// Floyd-Warshall by graph by matrix aux.
	private double[][] floydWarshall(GraphByMatrix<T, E> g, double[][] matrixFW) {

		// Refill the matrix in all positions except when i == j with the value
		// "infinite"
		for (int i = 0; i < matrixFW.length; i++) {

			for (int j = 0; j < matrixFW[0].length; j++) {

				if (i != j) {
					matrixFW[i][j] = Double.MAX_VALUE;
				}

			}

		}

		// Refill the matrix with all shortest path of each adjacent vertex.
		for (int i = 0; i < g.getVertices().size(); i++) {

			for (int j = 0; j < g.getVertices().get(i).getEdges().size(); j++) {

				int index = g.getIndexVertex((T) g.getVertices().get(i).getEdges().get(j).getDestination().getValue());

				if (matrixFW[i][index] != Double.MAX_VALUE) {

					if (matrixFW[i][index] > g.getVertices().get(i).getEdges().get(j).getCost()) {

						matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getCost();

					}

				} else {

					matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getCost();

				}

			}

		}

		for (int k = 0; k < matrixFW.length; k++) {
			for (int i = 0; i < matrixFW.length; i++) {
				for (int j = 0; j < matrixFW.length; j++) {

					matrixFW[i][j] = Math.min(matrixFW[i][j], matrixFW[i][k] + matrixFW[k][j]);

				}
			}
		}

		return matrixFW;

	}

	// Floyd-Warshall by graph by matrix.
	public double[][] floydWarshall(GraphByMatrix<T, E> g) {

		double[][] matrixFW = new double[g.getVertices().size()][g.getVertices().size()];

		return floydWarshall(g, matrixFW);

	}

	// Floyd-Warshall by graph by matrix aux.
	private double[][] floydWarshall(GraphByLists<T, E> g, double[][] matrixFW) {

		// Refill the matrix in all positions except when i == j with the value
		// "infinite"
		for (int i = 0; i < matrixFW.length; i++) {

			for (int j = 0; j < matrixFW[0].length; j++) {

				if (i != j) {
					matrixFW[i][j] = Double.MAX_VALUE;
				}

			}

		}

		// Refill the matrix with all shortest path of each adjacent vertex.
		for (int i = 0; i < g.getVertices().size(); i++) {

			for (int j = 0; j < g.getVertices().get(i).getEdges().size(); j++) {

				int index = g.getIndexVertex((T) g.getVertices().get(i).getEdges().get(j).getDestination().getValue());

				if (matrixFW[i][index] != Double.MAX_VALUE) {

					if (matrixFW[i][index] > g.getVertices().get(i).getEdges().get(j).getCost()) {

						matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getCost();

					}

				} else {

					matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getCost();

				}

			}

		}

		for (int k = 0; k < matrixFW.length; k++) {
			for (int i = 0; i < matrixFW.length; i++) {
				for (int j = 0; j < matrixFW.length; j++) {

					matrixFW[i][j] = Math.min(matrixFW[i][j], matrixFW[i][k] + matrixFW[k][j]);

				}
			}
		}

		return matrixFW;

	}

	// Floyd-Warshall by graph by matrix.
	public double[][] floydWarshall(GraphByLists<T, E> g) {

		double[][] matrixFW = new double[g.getVertices().size()][g.getVertices().size()];

		return floydWarshall(g, matrixFW);

	}

	private int getIndexSubset(ArrayList<Subset<T>> subsets, T parentValue, T rankValue) {

		int index = -1;

		for (int i = 0; i < subsets.size(); i++) {

		
			if(subsets.get(i).getParent().getValue() == parentValue && subsets.get(i).getRank().getValue() == rankValue) {
				
				index = i;
				
			}
			

		}

		return index;

	}
	
	
//	private Vertex<T> find(ArrayList<Subset<T>> subsets, Vertex<T> x){
//
//
//		
//		
//	}
	
	
//	private void union(ArrayList<Vertex<T>> tree,Vertex<T> x, Vertex<T> y) {
//		
//	Vertex<T> p = root(tree,x);
//	Vertex<T> q = root(tree,y);
//	tree.set(tree.indexOf(p), tree.get(tree.indexOf(q)));
//		
//		
//	}
//	
//	
//	
//	private MST<T> kruskal(GraphByMatrix<T, E> g, MST<T> mst){
//		
//	
//		
//		
//		
//		
//	}
	
//	public MST<T> kruskal(GraphByMatrix<T, E> g){
//		
//	ArrayList<Vertex<T>> tree = new ArrayList<>();
//	double minCost = 0.0;
//	
//	MST<T> mst = new MST<>(tree, minCost);
//	
//	return kruskal(g, mst);
//		
//		
//		
//	}
	
	


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

		g.addEdge(trece, ocho, false, 5, 1);
		g.addEdge(trece, cinco, false, 4, 2);
		g.addEdge(trece, v1, false, 2, 3);
		g.addEdge(nueve, v1, false, 5, 4);
		g.addEdge(ocho, nueve, false, 6, 5);
		g.addEdge(v1, cinco, false, 1, 6);

		System.out.println(g.getVertices());

		MethodsGraphs<Integer, Integer> m = new MethodsGraphs<>();
		
				

		
		
	
		

	}

}
