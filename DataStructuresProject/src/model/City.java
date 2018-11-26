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
	 * @param name
	 * @param x
	 * @param y
	 */
	public City(String name, int x, int y) {
		this.name=name;
		this.x=x;
		this.y=y;
				
	}


	/**
	 * M�todo que retorna un string, el cual pertenece al nombre de una ciudad
	 * @return string
	 */
	public String getName() {
		return name;
	}


	/**
	 * M�todo que permite modificar el nombre de la ciudad
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * M�todo que retorna un entero, que pertenece a la posici�n en el eje x de una ciudad 
	 * @return int
	 */
	public int getX() {
		return x;
	}


	/**
	 * M�todo que permite modificar la posici�n en el eje X de la ciudad
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * M�todo que retorna un entero, que pertenece a la posici�n en el eje Y de una ciudad
	 * @return int
	 */
	public int getY() {
		return y;
	}


	/**
	 * M�todo que permite modificar la posici�n en el eje Y de la ciudad
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}


	@Override
	/**
	 * M�todo que compara las ciudades a partir de su nommbre
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
	 * M�todo toString de la ciudad que lo hace a partir del nombre
	 */
	public String toString() {
		return name;
	}
	
	
	
}
