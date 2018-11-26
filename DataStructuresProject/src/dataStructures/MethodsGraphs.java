package dataStructures;

import java.util.*;

public class MethodsGraphs<T extends Comparable<T>, E extends Comparable<E>> {

	public MethodsGraphs() {

	}

	// DFS by graph by Matrix Aux

	/**
	 * This method realize the depth first search in a graph in order as the
	 * vertices were added.
	 * 
	 * @param g       The graph.
	 * @param v       The vertex where the method will start the path.
	 * @param visited A boolean array where the method controls which vertex has
	 *                been visited.
	 * @param stack   A stack that the method uses to realize the DFS path.
	 * @param dfs     An arraylist to save how the method was adding all vertices
	 *                according to the order.
	 * @return
	 */
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
	public ArrayList<Vertex<T>> BFS(GraphByMatrix<T, E> g, Vertex<T> v) {

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
	public ArrayList<Vertex<T>> BFS(GraphByLists<T, E> g, Vertex<T> v) {

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

	private int disjoinAuxVertex(int[] disjoin, int pos) {

		if (disjoin[pos] < 0) {

			return pos;

		} else {

			return disjoinAuxVertex(disjoin, disjoin[pos]);

		}

	}

	private double kruskal(GraphByMatrix<T, E> g, int[] disjoin, ArrayList<Edge<E>> edges) {

		double minCost = 0.0;
		int edgesValidate = 0;

		for (int i = 0; i < disjoin.length; i++) {

			disjoin[i] = -1;

		}

		while (edgesValidate != g.getVertices().size() - 1) {

			Edge<E> aux = edges.remove(0);

			Vertex<T> ini = (Vertex<T>) aux.getFrom();
			Vertex<T> dest = (Vertex<T>) aux.getDestination();

			int posIni = g.getIndexVertex(ini.getValue());
			int posDest = g.getIndexVertex(dest.getValue());

			if ((disjoin[posIni] < 0) && (disjoin[posDest] < 0)) {

				disjoin[posDest] += disjoin[posIni];
				disjoin[posIni] = posDest;
				minCost += aux.getCost();
				edgesValidate++;

			} else {

				int disjoinFrom = disjoinAuxVertex(disjoin, posIni);
				int disjoinTo = disjoinAuxVertex(disjoin, posDest);

				if (disjoinFrom != disjoinTo) {

					int valueFrom = disjoin[disjoinFrom];
//					int valueTo = disjoin[disjoinTo];

					disjoin[disjoinTo] += valueFrom;
					disjoin[disjoinFrom] = disjoinTo;

					minCost += aux.getCost();
					edgesValidate++;

				}

			}

		}

		return minCost;

	}

	public double kruskal(GraphByMatrix<T, E> g) {

		ArrayList<Edge<E>> edges = g.getEdges();
		int[] disjoin = new int[g.getVertices().size()];
		Collections.sort(edges);

		return kruskal(g, disjoin, edges);

	}

	private double kruskal(GraphByLists<T, E> g, int[] disjoin, ArrayList<Edge<E>> edges) {

		double minCost = 0.0;
		int edgesValidate = 0;

		for (int i = 0; i < disjoin.length; i++) {

			disjoin[i] = -1;

		}

		while (edgesValidate != g.getVertices().size() - 1) {

			Edge<E> aux = edges.remove(0);

			Vertex<T> ini = (Vertex<T>) aux.getFrom();
			Vertex<T> dest = (Vertex<T>) aux.getDestination();

			int posIni = g.getIndexVertex(ini.getValue());
			int posDest = g.getIndexVertex(dest.getValue());

			if ((disjoin[posIni] < 0) && (disjoin[posDest] < 0)) {

				disjoin[posDest] += disjoin[posIni];
				disjoin[posIni] = posDest;
				minCost += aux.getCost();
				edgesValidate++;

			} else {

				int disjoinFrom = disjoinAuxVertex(disjoin, posIni);
				int disjoinTo = disjoinAuxVertex(disjoin, posDest);

				if (disjoinFrom != disjoinTo) {

					int valueFrom = disjoin[disjoinFrom];
//					int valueTo = disjoin[disjoinTo];

					disjoin[disjoinTo] += valueFrom;
					disjoin[disjoinFrom] = disjoinTo;

					minCost += aux.getCost();
					edgesValidate++;

				}

			}

		}

		return minCost;

	}

	public double kruskal(GraphByLists<T, E> g) {

		ArrayList<Edge<E>> edges = g.getEdges();
		int[] disjoin = new int[g.getVertices().size()];
		Collections.sort(edges);

		return kruskal(g, disjoin, edges);

	}

	private int indexMinimumCost(double[] costs, boolean[] visited) {

		int indexAux = 0;
		double[] costsCopy = new double[costs.length];

		for (int i = 0; i < costs.length; i++) {

			costsCopy[i] = costs[i];

		}

		for (int i = 0; i < visited.length; i++) {

			if (visited[i]) {

				costsCopy[i] = Integer.MAX_VALUE;

			}

		}

		double min = costsCopy[0];
		for (int i = 1; i < costs.length; i++) {

			if (costsCopy[i] < min) {

				min = costsCopy[i];
				indexAux = i;

			}

		}

		return indexAux;

	}

	private double prim(GraphByMatrix<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited,
			double[] costs, int[] paths, int visits, int start, double cost, int initial) {

		if (visits == vertices.size()) {

			for (int i = 0; i < costs.length; i++) {

				if (i != initial) {
					cost += costs[i];
				}

			}

			return cost;

		}

		visited[start] = true;
		visits += 1;

		Vertex<T> actual = ini;

		if (visits <= vertices.size()) {

			int indexActual = g.getIndexVertex(actual.getValue());

			for (int i = 0; i < actual.getEdges().size(); i++) {

				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {

					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > actual
							.getEdges().get(i).getCost()) {

						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = actual
								.getEdges().get(i).getCost();
						paths[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;

					}

				}

			}

			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;

			return prim(g, ini, vertices, visited, costs, paths, visits, start, cost, initial);

		}

		return cost;

	}

	public double prim(GraphByMatrix<T, E> g, Vertex<T> ini) {

		ArrayList<Vertex<T>> vertices = g.getVertices();
		boolean[] visited = new boolean[vertices.size()];
		double[] costs = new double[vertices.size()];
		int[] paths = new int[vertices.size()];
		int visits = 0;
		int start = g.getIndexVertex(ini.getValue());
		double cost = 0.0;
		int initial = start;

		// Refill costs
		for (int i = 0; i < costs.length; i++) {

			if (i != start) {
				costs[i] = Integer.MAX_VALUE;
			}

		}

		for (int i = 0; i < paths.length; i++) {

			paths[i] = -1;

		}

		return prim(g, ini, vertices, visited, costs, paths, visits, start, cost, initial);

	}

	private double prim(GraphByLists<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited,
			double[] costs, int[] paths, int visits, int start, double cost, int initial) {

		if (visits == vertices.size()) {

			for (int i = 0; i < costs.length; i++) {

				if (i != initial) {
					cost += costs[i];
				}

			}

			return cost;

		}

		visited[start] = true;
		visits += 1;

		Vertex<T> actual = ini;

		if (visits <= vertices.size()) {

			int indexActual = g.getIndexVertex(actual.getValue());

			for (int i = 0; i < actual.getEdges().size(); i++) {

				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {

					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > actual
							.getEdges().get(i).getCost()) {

						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = actual
								.getEdges().get(i).getCost();
						paths[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;
					}

				}

			}

			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;

			return prim(g, ini, vertices, visited, costs, paths, visits, min, cost, initial);

		}

		return cost;

	}

	public double prim(GraphByLists<T, E> g, Vertex<T> ini) {

		ArrayList<Vertex<T>> vertices = g.getVertices();
		boolean[] visited = new boolean[vertices.size()];
		double[] costs = new double[vertices.size()];
		int[] paths = new int[vertices.size()];
		int visits = 0;
		int start = g.getIndexVertex(ini.getValue());
		double cost = 0.0;
		int initial = start;

		// Refill costs
		for (int i = 0; i < costs.length; i++) {

			if (i != start) {
				costs[i] = Integer.MAX_VALUE;
			}

		}

		for (int i = 0; i < paths.length; i++) {

			paths[i] = -1;

		}

		return prim(g, ini, vertices, visited, costs, paths, visits, start, cost, initial);

	}

	private Path<T, E> dijkstra(GraphByMatrix<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited,
			double[] costs, int[] vertexPath, Path<T, E> path, int visits, int start) {

		if (visits == vertices.size()) {

			return path;

		}

		visited[start] = true;
		visits += 1;

		Vertex<T> actual = ini;

		if (visits <= vertices.size()) {

			int indexActual = g.getIndexVertex(actual.getValue());

			for (int i = 0; i < actual.getEdges().size(); i++) {

				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {

					if (costs[g.getIndexVertex(
							(T) actual.getEdges().get(i).getDestination().getValue())] > costs[indexActual]
									+ actual.getEdges().get(i).getCost()) {

						costs[g.getIndexVertex(
								(T) actual.getEdges().get(i).getDestination().getValue())] = costs[indexActual]
										+ actual.getEdges().get(i).getCost();

						vertexPath[g.getIndexVertex(
								(T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;

					}

				}

			}

			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;

			return dijkstra(g, ini, vertices, visited, costs, vertexPath, path, visits, start);

		}

		return path;

	}

	public Path<T, E> dijkstra(GraphByMatrix<T, E> g, Vertex<T> ini) {

		ArrayList<Vertex<T>> vertices = g.getVertices();

		double[] costs = new double[g.getVertices().size()];

		boolean[] visited = new boolean[g.getVertices().size()];

		int[] vertexPath = new int[g.getVertices().size()];

		int start = g.getIndexVertex(ini.getValue());

		int visits = 0;

		Path<T, E> path = new Path<>(null, g, vertexPath);

		for (int i = 0; i < costs.length; i++) {

			if (i != start) {

				costs[i] = Double.MAX_VALUE;

			}

		}

		for (int i = 0; i < vertexPath.length; i++) {

			vertexPath[i] = -1;

		}

		return dijkstra(g, ini, vertices, visited, costs, vertexPath, path, visits, start);

	}

	private Path<T, E> dijkstra(GraphByLists<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited,
			double[] costs, int[] vertexPath, Path<T, E> path, int visits, int start) {

		if (visits == vertices.size()) {

			return path;

		}

		visited[start] = true;
		visits += 1;

		Vertex<T> actual = ini;

		if (visits <= vertices.size()) {

			int indexActual = g.getIndexVertex(actual.getValue());

			for (int i = 0; i < actual.getEdges().size(); i++) {

				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {

					if (costs[g.getIndexVertex(
							(T) actual.getEdges().get(i).getDestination().getValue())] > costs[indexActual]
									+ actual.getEdges().get(i).getCost()) {

						costs[g.getIndexVertex(
								(T) actual.getEdges().get(i).getDestination().getValue())] = costs[indexActual]
										+ actual.getEdges().get(i).getCost();

						vertexPath[g.getIndexVertex(
								(T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;

					}

				}

			}

			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;

			return dijkstra(g, ini, vertices, visited, costs, vertexPath, path, visits, start);

		}

		return path;

	}

	public Path<T, E> dijkstra(GraphByLists<T, E> g, Vertex<T> ini) {

		ArrayList<Vertex<T>> vertices = g.getVertices();

		double[] costs = new double[g.getVertices().size()];

		boolean[] visited = new boolean[g.getVertices().size()];

		int[] vertexPath = new int[g.getVertices().size()];

		int start = g.getIndexVertex(ini.getValue());

		int visits = 0;

		Path<T, E> path = new Path<>(g, null, vertexPath);

		for (int i = 0; i < costs.length; i++) {

			if (i != start) {

				costs[i] = Double.MAX_VALUE;

			}

		}

		for (int i = 0; i < vertexPath.length; i++) {

			vertexPath[i] = -1;

		}

		return dijkstra(g, ini, vertices, visited, costs, vertexPath, path, visits, start);

	}

	private Path<T, E> primP(GraphByMatrix<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited,
			double[] costs, int[] paths, int visits, int start, double cost, int initial, Path<T, E> pathO) {

		if (visits == vertices.size()) {

			return pathO;

		}

		visited[start] = true;
		visits += 1;

		Vertex<T> actual = ini;

		if (visits <= vertices.size()) {

			int indexActual = g.getIndexVertex(actual.getValue());

			for (int i = 0; i < actual.getEdges().size(); i++) {

				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {

					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > actual
							.getEdges().get(i).getCost()) {

						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = actual
								.getEdges().get(i).getCost();
						paths[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;

					}

				}

			}

			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;

			return primP(g, ini, vertices, visited, costs, paths, visits, start, cost, initial, pathO);

		}

		return pathO;

	}

	public Path<T, E> primP(GraphByMatrix<T, E> g, Vertex<T> ini) {

		ArrayList<Vertex<T>> vertices = g.getVertices();

		boolean[] visited = new boolean[vertices.size()];
		double[] costs = new double[vertices.size()];
		int[] paths = new int[vertices.size()];
		int visits = 0;
		int start = g.getIndexVertex(ini.getValue());
		double cost = 0.0;
		int initial = start;
		Path<T, E> pathO = new Path<>(null, g, paths);
		// Refill costs
		for (int i = 0; i < costs.length; i++) {

			if (i != start) {
				costs[i] = Integer.MAX_VALUE;
			}

		}

		for (int i = 0; i < paths.length; i++) {

			paths[i] = -1;

		}

		return primP(g, ini, vertices, visited, costs, paths, visits, start, cost, initial, pathO);

	}

	private Path<T, E> primP(GraphByLists<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited,
			double[] costs, int[] paths, int visits, int start, double cost, int initial, Path<T, E> pathO) {

		if (visits == vertices.size()) {

			return pathO;

		}

		visited[start] = true;
		visits += 1;

		Vertex<T> actual = ini;

		if (visits <= vertices.size()) {

			int indexActual = g.getIndexVertex(actual.getValue());

			for (int i = 0; i < actual.getEdges().size(); i++) {

				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {

					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > actual
							.getEdges().get(i).getCost()) {

						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = actual
								.getEdges().get(i).getCost();
						paths[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;

					}

				}

			}

			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;

			return primP(g, ini, vertices, visited, costs, paths, visits, start, cost, initial, pathO);

		}

		return pathO;

	}

	public Path<T, E> primP(GraphByLists<T, E> g, Vertex<T> ini) {

		ArrayList<Vertex<T>> vertices = g.getVertices();

		boolean[] visited = new boolean[vertices.size()];
		double[] costs = new double[vertices.size()];
		int[] paths = new int[vertices.size()];
		int visits = 0;
		int start = g.getIndexVertex(ini.getValue());
		double cost = 0.0;
		int initial = start;
		Path<T, E> pathO = new Path<>(g, null, paths);
		// Refill costs
		for (int i = 0; i < costs.length; i++) {

			if (i != start) {
				costs[i] = Integer.MAX_VALUE;
			}

		}

		for (int i = 0; i < paths.length; i++) {

			paths[i] = -1;

		}

		return primP(g, ini, vertices, visited, costs, paths, visits, start, cost, initial, pathO);

	}

	public static void main(String[] args) {

		GraphByMatrix<Integer, Integer> g = new GraphByMatrix<>(8);

		MethodsGraphs<Integer, Integer> m = new MethodsGraphs<>();

		Integer cero = 0;
		Integer uno = 1;
		Integer dos = 2;
		Integer tres = 3;
		Integer cuatro = 4;
		Integer cinco = 5;
		Integer seis = 6;
		Integer siete = 7;

		g.addVertex(cero);
		g.addVertex(uno);
		g.addVertex(dos);
		g.addVertex(tres);
		g.addVertex(cuatro);
		g.addVertex(cinco);
		g.addVertex(seis);
		g.addVertex(siete);

		g.addEdge(cero, uno, false, 5, 100);
		g.addEdge(cero, dos, false, 5, 101);
		g.addEdge(cero, cuatro, false, 8, 102);
		g.addEdge(uno, tres, false, 7, 103);
		g.addEdge(uno, cinco, false, 5, 104);
		g.addEdge(uno, seis, false, 3, 105);
		g.addEdge(dos, cuatro, false, 6, 106);
		g.addEdge(dos, seis, false, 3, 107);
		g.addEdge(tres, cinco, false, 8, 108);
		g.addEdge(tres, siete, false, 3, 109);
		g.addEdge(cuatro, seis, false, 2, 110);
		g.addEdge(cuatro, siete, false, 9, 111);
		g.addEdge(seis, siete, false, 1, 112);

		System.out.println(Arrays.toString(m.primP(g, new Vertex<Integer>(cero)).getPath()));

	}

}