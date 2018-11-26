package model;

import java.util.ArrayList;
import java.util.Arrays;

import dataStructures.GraphByLists;
import dataStructures.MethodsGraphs;
import dataStructures.Vertex;

public class TravelingProgram {

	public static final int CITIES = 32;
	private City[] cities;
	private GraphByLists<City, Highway> graph;

	public TravelingProgram() {
		cities = new City[CITIES];
		graph = new GraphByLists<>(CITIES);
		refillCities();
		refillGraph();

	//	System.out.println(graph.graphToString());
		MethodsGraphs<City, Highway> m;
		m = new MethodsGraphs<>();
		
		//System.out.println(stringPath(new Vertex<City>(cities[5]), new Vertex<City>(cities[2])));
		//System.out.println(Arrays.toString(cities));
		
	}

	public void refillCities() {

		cities[0] = new City("Leticia", 531, 694);
		cities[1] = new City("Medellin", 296, 265);
		cities[2] = new City("Arauca", 497, 241);
		cities[3] = new City("Barranquila", 326, 73);
		cities[4] = new City("Cartagena", 300, 102);
		cities[5] = new City("Tunja", 391, 300);
		cities[6] = new City("Manizales", 296, 314);
		cities[7] = new City("Florencia", 296, 461);
		cities[8] = new City("Yopal", 438, 312);
		cities[9] = new City("Popay�n", 244, 426);
		cities[10] = new City("Valledupar", 391, 95);
		cities[11] = new City("Quibd�", 245, 293);
		cities[12] = new City("Monter�a", 285, 167);
		cities[13] = new City("Bogot�", 357, 337);
		cities[14] = new City("Puerto In�rida", 617, 378);
		cities[15] = new City("San Jos� del Guaviare", 418, 426);
		cities[16] = new City("Neiva", 304, 406);
		cities[17] = new City("Riohacha", 412, 54);
		cities[18] = new City("Santa Marta", 359, 63);
		cities[19] = new City("Villavicencio", 377, 362);
		cities[20] = new City("Pasto", 214, 475);
		cities[21] = new City("C�cuta", 425, 199);
		cities[22] = new City("Mocoa", 244, 485);
		cities[23] = new City("Armenia", 289, 343);
		cities[24] = new City("Pereira", 285, 330);
		cities[25] = new City("Bucaramanga", 392, 238);
		cities[26] = new City("Sincelejo", 305, 150);
		cities[27] = new City("Ibagu�", 312, 358);
		cities[28] = new City("Cali", 254, 381);
		cities[29] = new City("Mit�", 523, 482);
		cities[30] = new City("Puerto Carre�o", 628, 277);
		cities[31] = new City("San Andres", 212, 64);

		Arrays.sort(cities);

	}

	public void refillGraph() {

		for (int i = 0; i < cities.length; i++) {

			graph.addVertex(cities[i]);
		}

		// RIOHACHA
		graph.addEdge(cities[23], cities[26], false, 167.37, new Highway("9009"));
		graph.addEdge(cities[23], cities[29], false, 158.2, new Highway("8004A"));

		// SANTA MARTA
		graph.addEdge(cities[26], cities[2], false, 94.79, new Highway("9007"));
		graph.addEdge(cities[26], cities[6], false, 158.2, new Highway("90A01"));
		graph.addEdge(cities[26], cities[29], false, 317.2, new Highway("8004"));

		// BARRANQUILLA
		graph.addEdge(cities[2], cities[6], false, 121.6, new Highway("90AAT05"));

		// VALLEDUPAR
		graph.addEdge(cities[29], cities[7], false, 556.4, new Highway("55NS08"));
		graph.addEdge(cities[29], cities[4], false, 459.1, new Highway("6602"));

		// CARTAGENA
		graph.addEdge(cities[6], cities[27], false, 190.1, new Highway("2514A"));
		graph.addEdge(cities[6], cities[4], false, 662.4, new Highway("45AST08"));
		graph.addEdge(cities[6], cities[7], false, 759.7, new Highway("7009A"));

		// SINCELEJO
		graph.addEdge(cities[27], cities[15], false, 167.4, new Highway("2310"));

		// MONTERIA
		graph.addEdge(cities[15], cities[12], false, 402.2, new Highway("2510"));

		// CUCUTA
		graph.addEdge(cities[7], cities[4], false, 202, new Highway("6603"));
		graph.addEdge(cities[7], cities[0], false, 440.6, new Highway("6606"));

		// ARAUCA
		graph.addEdge(cities[0], cities[31], false, 364.2, new Highway("6512"));
		graph.addEdge(cities[0], cities[28], false, 475.6, new Highway("55BYA"));

		// BUCARAMANGA
		graph.addEdge(cities[4], cities[12], false, 391, new Highway("6205"));
		graph.addEdge(cities[4], cities[28], false, 279.1, new Highway("60BY14"));

		// MEDELLIN
		graph.addEdge(cities[12], cities[28], false, 421.7, new Highway("D1547643"));
		graph.addEdge(cities[12], cities[22], false, 222.5, new Highway("6002"));
		graph.addEdge(cities[12], cities[11], false, 198.6, new Highway("3301"));

		// TUNJA
		graph.addEdge(cities[28], cities[3], false, 162.6, new Highway("5008"));
		graph.addEdge(cities[28], cities[31], false, 219.5, new Highway("6211"));
		graph.addEdge(cities[28], cities[11], false, 419.6, new Highway("5005"));

		// QUIBDO
		graph.addEdge(cities[22], cities[11], false, 312.2, new Highway("29CL06_1"));
		graph.addEdge(cities[22], cities[18], false, 259.7, new Highway("29RSA"));
		graph.addEdge(cities[22], cities[5], false, 425.5, new Highway("2301"));

		// YOPAL
		graph.addEdge(cities[31], cities[3], false, 336.6, new Highway("50_MOCHI"));
		graph.addEdge(cities[31], cities[30], false, 251.7, new Highway("6510"));

		// BOGOTA
		graph.addEdge(cities[3], cities[11], false, 289.8, new Highway("5006"));
		graph.addEdge(cities[3], cities[30], false, 114.7, new Highway("6509"));
		graph.addEdge(cities[3], cities[9], false, 187.5, new Highway("40TLC"));
		graph.addEdge(cities[3], cities[16], false, 299, new Highway("43HL02"));

		// MANIZALES
		graph.addEdge(cities[11], cities[18], false, 51.4, new Highway("PPC_PER1_0"));
		graph.addEdge(cities[11], cities[9], false, 182, new Highway("40QN05"));

		// PEREIRA
		graph.addEdge(cities[18], cities[9], false, 120.8, new Highway("29QN01"));
		graph.addEdge(cities[18], cities[1], false, 49.9, new Highway("PPC_ARM_6_0"));

		// ARMENIA
		graph.addEdge(cities[1], cities[5], false, 180.5, new Highway("PPC_CLI1_0"));
		graph.addEdge(cities[1], cities[9], false, 84.2, new Highway("4003"));

		// CALI
		graph.addEdge(cities[5], cities[19], false, 140.1, new Highway("25CCB"));
		graph.addEdge(cities[5], cities[9], false, 263.5, new Highway("4002A"));
		graph.addEdge(cities[5], cities[16], false, 365.4, new Highway("4505"));

		// IBAGUE
		graph.addEdge(cities[9], cities[16], false, 204.2, new Highway("43HL02"));

		// POPAYAN
		graph.addEdge(cities[19], cities[17], false, 224.3, new Highway("PPC_PST2_0"));
		graph.addEdge(cities[19], cities[16], false, 276.5, new Highway("PPC_NVA_1_0"));
		graph.addEdge(cities[19], cities[14], false, 282.8, new Highway("4503"));

		// PASTO

		// NEIVA
		graph.addEdge(cities[16], cities[8], false, 238.3, new Highway("PPC_FLA_1_0"));
		graph.addEdge(cities[16], cities[14], false, 322.1, new Highway("45PT34"));

		// MOCOA
		graph.addEdge(cities[14], cities[8], false, 257.3, new Highway("FLA3"));

		// FLORENCIA
	

		// VILLAVICENCIO
		graph.addEdge(cities[30], cities[25], false, 283.6, new Highway("PPC_SJG1_0"));
		graph.addEdge(cities[30], cities[20], false, 852.5, new Highway("40"));

		// SAN JOS� DEL GUAVIARE - NO EXISTEN VIAS TERRESTRES PARA LLEGAR A ESTE LUGAR
	

		// PUERTO CARRE�O - NO EXISTEN VIAS TERRESTRES PARA LLEGAR A ESTE LUGAR

		// PUERTO INIRIDA - NO EXISTEN VIAS TERRESTRES PARA LLEGAR A ESTE LUGAR

		// MITU 

		// SAN ANDR�S - NO EXISTEN VIAS TERRESTRES PARA LLEGAR A ESTE LUGAR
		

	}

	public City[] getCities() {
		return cities;
	}

	public void setCities(City[] cities) {
		this.cities = cities;
	}

	public GraphByLists<City, Highway> getGraph() {
		return graph;
	}

	public void setGraph(GraphByLists<City, Highway> graph) {
		this.graph = graph;
	}

	public ArrayList<Vertex<City>> getPath(Vertex<City> from, Vertex<City> destination) {

		MethodsGraphs<City, Highway> m = new MethodsGraphs<>();

		ArrayList<Vertex<City>> path = m.dijkstra(graph, from).creatingPath(from, destination);

		return path;

	}

	public String stringPath(Vertex<City> from, Vertex<City> destination) {

		MethodsGraphs<City, Highway> m = new MethodsGraphs<>();

		ArrayList<Vertex<City>> path = m.dijkstra(graph, from).creatingPath(from, destination);

		String pathTxt = "";

		for (int i = 0; i < path.size() - 1; i++) {

			Vertex<City> a = path.get(i);
			Vertex<City> b = path.get(i + 1);

			pathTxt += a.toString() + " -- " + graph.edgesBetween(a.getValue(), b.getValue()) + " --> " + b.toString()
					+ "\n";

		}

		return pathTxt;

	}

}
