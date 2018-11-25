package model;

import java.util.Arrays;

import dataStructures.GraphByLists;

public class TravelingProgram {

	public static final int CITIES=32;
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
		
		cities[0]=new City("Leticia", 531, 694);
		cities[1]=new City("Medellin", 296, 265);
		cities[2]=new City("Arauca", 497, 241);
		cities[3]=new City("Barranquila", 326, 73);
		cities[4]=new City("Cartagena", 300, 102);
		cities[5]=new City("Tunja", 391, 300);
		cities[6]=new City("Manizales", 296, 314);
		cities[7]=new City("Florencia", 296, 461);
		cities[8]=new City("Yopal", 438, 312);
		cities[9]=new City("Popay�n", 244, 426);
		cities[10]=new City("Valledupar", 391, 95);
		cities[11]=new City("Quibd�", 245, 293);
		cities[12]=new City("Monter�a", 285, 167);
		cities[13]=new City("Bogot�", 357, 337);
		cities[14]=new City("Puerto In�rida", 617, 378);
		cities[15]=new City("San Jos� del Guaviare", 418, 426);
		cities[16]=new City("Neiva", 304, 406);
		cities[17]=new City("Riohacha", 412, 54);
		cities[18]=new City("Santa Marta", 359, 63);
		cities[19]=new City("Villavicencio", 377, 362);
		cities[20]=new City("Pasto", 214, 475);
		cities[21]=new City("C�cuta", 425, 199);
		cities[22]=new City("Mocoa", 244, 485);
		cities[23]=new City("Armenia", 289, 343);
		cities[24]=new City("Pereira", 285, 330);
		cities[25]=new City("Bucaramanga", 392, 238);
		cities[26]=new City("Sincelejo", 305, 150);
		cities[27]=new City("Ibagu�", 312, 358);
		cities[28]=new City("Cali", 254, 381);
		cities[29]=new City("Mit�", 523, 482);
		cities[30]=new City("Puerto Carre�o", 628, 277);
		cities[31]=new City("San Andres",212,64);
		
		
		
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
