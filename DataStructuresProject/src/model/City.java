package model;

public class City implements Comparable<City>{
	
	/**
	 * Variable name que representa el nombre de la ciudad
	 */
	private String name;
	
	/**
	 * Variable x, Coordenada en el eje X donde se encuentra ubicada cada ciudad
	 */
	private int x;
	
	/**
	 * Variable Y, Coordenada en el eje Y donde se encuentra ubicada cada ciudad
	 */
	private int y;
	

	/**
	 * Constructor de la clase City 
	 * @param name El nombre de la ciudad.
	 * @param x La coordenada X de la ciudad.
	 * @param y La coordenada Y de la ciudad.
	 */
	public City(String name, int x, int y) {
		this.name=name;
		this.x=x;
		this.y=y;
				
	}


	/**
	 * Método que retorna un string, el cual pertenece al nombre de una ciudad
	 * @return Retorna una cadena de texto que representa el nombre de la ciudad.
	 */
	public String getName() {
		return name;
	}


	/**
	 * Método que permite modificar el nombre de la ciudad
	 * @param name El nombre a modificar.
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Método que retorna un entero, que pertenece a la posición en el eje x de una ciudad 
	 * @return Retorna un numero entero que representa. la coordenada X de la ciudad.
	 */
	public int getX() {
		return x;
	}


	/**
	 * Método que permite modificar la posición en el eje X de la ciudad
	 * @param x La coordenada X a modificar.
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * Método que retorna un entero, que pertenece a la posición en el eje Y de una ciudad
	 * @return Retorna un numero entero que representa la coordenada Y de la ciudad.
	 */
	public int getY() {
		return y;
	}


	/**
	 * Método que permite modificar la posición en el eje Y de la ciudad
	 * @param y La coordenada Y a modificar.
	 */
	public void setY(int y) {
		this.y = y;
	}


	@Override
	/**
	 * Método que compara las ciudades con base en su nommbre
	 */
	public int compareTo(City o) {
		int x=0;
		if(this.name.compareTo(o.name)<0) {
			x=-1;
		}
		else if(this.name.compareTo(o.name)>0) {
			x=1;
		}
		return x;
		
	}
	
	@Override
	/**
	 * Método toString de la ciudad que retorna una cadena de texto que representa el nombre de la ciudad.
	 */
	public String toString() {
		return name;
	}
	
	
	
}
