package model;

import java.util.Arrays;

import dataStructures.GraphByLists;

public class TravelingProgram {

	public static final int CITIES=31;
	private City[] cities;
	private Highway[] highways;
	private GraphByLists<City, Highway> graph; 
	
	
	public TravelingProgram() {
		cities= new City[CITIES];
		//highways=new Highway[];
		graph= new GraphByLists<>(CITIES);
		refillCities();
		
	}
	
	
	public void refillCities() {
		
		cities[0]=new City("Leticia", 525, 673);
		cities[1]=new City("Medellin", 319, 296);
		cities[2]=new City("Arauca", 493, 250);
		cities[3]=new City("Barranquila", 334, 92);
		cities[4]=new City("Cartagena", 302, 113);
		cities[5]=new City("Tunja", 405, 309);
		cities[6]=new City("Manizales", 333, 353);
		cities[7]=new City("Florencia", 323, 469);
		cities[8]=new City("Yopal", 448, 325);
		cities[9]=new City("Popay�n", 268, 442);
		cities[10]=new City("Valledupar", 389, 117);
		cities[11]=new City("Quibd�", 275, 327);
		cities[12]=new City("Monter�a", 290, 189);
		cities[13]=new City("Bogot�", 355, 362);
		cities[14]=new City("Puerto In�rida", 603, 379);
		cities[15]=new City("San Jos� del Guaviare", 420, 424);
		cities[16]=new City("Neiva", 344, 435);
		cities[17]=new City("Riohacha", 401, 73);
		cities[18]=new City("Santa Marta", 356, 79);
		cities[19]=new City("Villavicencio", 384, 381);
		cities[20]=new City("Pasto", 254, 479);
		cities[21]=new City("C�cuta", 416, 226);
		cities[22]=new City("Mocoa", 292, 484);
		cities[23]=new City("Armenia", 340, 388);
		cities[24]=new City("Pereira", 325, 371);
		cities[25]=new City("Bucaramanga", 384, 262);
		cities[26]=new City("Sincelejo", 318, 517);
		cities[27]=new City("Ibagu�", 347, 390);
		cities[28]=new City("Cali", 292, 413);
		cities[29]=new City("Mit�", 505, 527);
		cities[30]=new City("Puerto Carre�o", 612, 281);
		
		Arrays.sort(cities);
		
		
	}


	public City[] getCities() {
		return cities;
	}


	public void setCities(City[] cities) {
		this.cities = cities;
	}


	public Highway[] getHighways() {
		return highways;
	}


	public void setHighways(Highway[] highways) {
		this.highways = highways;
	}


	public GraphByLists<City, Highway> getGraph() {
		return graph;
	}


	public void setGraph(GraphByLists<City, Highway> graph) {
		this.graph = graph;
	}


	
	
	
}
