package model;

public class Highway implements Comparable<Highway>{

	/**
	 * Variable name, que representa el nombre de la carretera
	 */
	private String name;
	
	/**
	 * Constructor de la clase Highway
	 * @param name
	 */
	public Highway(String name) {
		this.name=name;
	}

	
	/**
	 * Método que retorna un string, el cual pertenece al nombre de la carretera
	 * @return
	 */
	public String getName() {
		return name;
	}


	/**
	 * Método que permite modificar el nombre de la carretera
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	
	@Override
	/**
	 * Método que compara las carreteras de acuerdo a su nombre
	 */
	public int compareTo(Highway o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	/**
	 * Método toString de la carretera, a partir del nombre
	 */
	public String toString() {
		return name; 
	} 
	
	
}
