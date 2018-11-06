package dataStructures;


public class Vertex<T extends Comparable<T>> implements Comparable<T> {

	private T value;

	public Vertex(T value) {

		this.value = value;

	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public int compareTo(T o) {
		return 0;
	}

	@Override
	public String toString() {

		return value.toString();

	}

}
