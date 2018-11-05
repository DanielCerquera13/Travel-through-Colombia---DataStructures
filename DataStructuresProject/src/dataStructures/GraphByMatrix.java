package dataStructures;

import java.util.ArrayList;

public class GraphByMatrix<T extends Comparable<T>> implements IGraph<T> {

	private ArrayList<Edge<?>>[][] adjMatrix;
	private ArrayList<Vertex<T>> vertices;
	private int numVertex;

	/**
	 * Graph Constructor
	 * 
	 * @param numVertex The number of vertices that the graph will have.
	 */
	public GraphByMatrix(int numVertex) {

		this.numVertex = numVertex;

		vertices = new ArrayList<Vertex<T>>();
		adjMatrix = new ArrayList[numVertex][numVertex];

		initMatrix();

	}

	/**
	 * This method puts ArrayList in all matrix positions.
	 */
	private void initMatrix() {

		for (int i = 0; i < adjMatrix.length; i++) {

			for (int j = 0; j < adjMatrix[0].length; j++) {

				adjMatrix[i][j] = new ArrayList<Edge<?>>();

			}

		}

	}

	/**
	 * This method gets the index where the vertex is saved. Then with this index,
	 * it is possible to identify this vertex like a row or like a column in the
	 * matrix
	 * 
	 * @param valueVertex The value of the vertex
	 * @return The index where the vertex is saved in the vertices array.
	 */
	private int getIndexVertex(T valueVertex) {

		int index = -1;

		for (int i = 0; i < vertices.size(); i++) {

			if (vertices.get(i).getValue().equals(valueVertex))

				index = i;

		}

		return index;

	}

	@Override
	public void addEdge(T from, T destination, boolean directed, double cost, String name) {

		int f = getIndexVertex(from);
		int d = getIndexVertex(destination);

		if (directed) {
			adjMatrix[f][d].add(new Edge<>(directed, cost, name));
		} else {
			adjMatrix[f][d].add(new Edge<>(directed, cost, name));
			adjMatrix[d][f].add(new Edge<>(directed, cost, name));
		}
	}

	@Override
	public void removeEdge(T from, T destination, boolean directed, double cost) {

		int f = getIndexVertex(from);
		int d = getIndexVertex(destination);

		if (directed) {

			for (int i = 0; i < adjMatrix[f][d].size(); i++) {

				if (adjMatrix[f][d].get(i).getCost() == cost)
					adjMatrix[f][d].remove(i);
			}
		} else {
			for (int i = 0; i < adjMatrix[f][d].size(); i++) {

				if (adjMatrix[f][d].get(i).getCost() == cost)
					adjMatrix[f][d].remove(i);

				if (adjMatrix[d][f].get(i).getCost() == cost)
					adjMatrix[d][f].remove(i);
			}
		}
	}

	@Override
	public void addVertex(T valueVertex) {

		if (vertices.size() < numVertex)
			vertices.add(new Vertex<T>(valueVertex));

	}

	@Override
	public void removeVertex(T valueVertex) {

	}

	@Override
	public boolean isAdjacent(T vertexA, T vertexB) {

		boolean is = false;
		int a = getIndexVertex(vertexA);
		int b = getIndexVertex(vertexB);

		if (adjMatrix[a][b].size() > 0 || adjMatrix[b][a].size() > 0) {

			is = true;

		}

		return is;

	}

	public ArrayList<Edge<?>> getEdgesOfVertex(T valueVertex) {

		int v = getIndexVertex(valueVertex);
		ArrayList<Edge<?>> edges = new ArrayList<>();

		for (int i = 0; i < adjMatrix[0].length; i++) {

			if (!adjMatrix[v][i].isEmpty()) {

				edges.addAll(adjMatrix[v][i]);

			}

		}

		return edges;

	}

	public String graphToString() {

		String g = "";

		for (int i = 0; i < adjMatrix.length; i++) {

			for (int j = 0; j < vertices.size(); j++) {

				if (!adjMatrix[i][j].isEmpty()) {
					for (int k = 0; k < adjMatrix[i][j].size(); k++) {

						if (adjMatrix[i][j].get(k).isDirected())
							g += vertices.get(i).toString() + " ----> " + vertices.get(j).toString() + " : "
									+ adjMatrix[i][j].get(k).toString() + "\n";
						else
							g += vertices.get(i).toString() + " <---> " + vertices.get(j).toString() + " : "
									+ adjMatrix[i][j].get(k).toString() + "\n";

					}

				}
			}
			g += "\n";
		}

		return g;

	}

	@Override
	public int getNumVertex() {

		return numVertex;
	}

	public ArrayList<Edge<?>>[][] getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(ArrayList<Edge<?>>[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	public ArrayList<Vertex<T>> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

}
