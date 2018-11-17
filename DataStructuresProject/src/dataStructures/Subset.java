package dataStructures;

public class Subset<T extends Comparable<T>> implements Comparable<T> {

	private Vertex<T> parent;
	private Vertex<T> rank;

	public Subset(Vertex<T> parent, Vertex<T> rank) {

		this.parent = parent;
		this.rank = rank;

	}

	public Vertex<T> getParent() {
		return parent;
	}

	public void setParent(Vertex<T> parent) {
		this.parent = parent;
	}

	public Vertex<T> getRank() {
		return rank;
	}

	public void setRank(Vertex<T> rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean equals(Subset<T> s) {

		return (this.parent.getValue() == s.getParent().getValue()) && (this.rank.getValue() == s.getRank().getValue());

	}

}
