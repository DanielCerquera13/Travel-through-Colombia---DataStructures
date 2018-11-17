package Tests;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import dataStructures.GraphByLists;
import dataStructures.GraphByMatrix;
import dataStructures.MethodsGraphs;
import dataStructures.Vertex;

class MethodsGraphsTest {

	GraphByLists<Integer,Integer> graphList;
	GraphByMatrix<Integer,Integer> graphMatrix;
	MethodsGraphs<Integer,Integer> mG;
	
	public void stageOne() {
    	
		mG=new MethodsGraphs<>();
    	graphList = new GraphByLists<>(5);
    	Integer v1=13;
    	Integer v2=8; 
    	Integer v3=9;
    	Integer v4=21;
    	Integer v5=5;
    	
    	graphList.addVertex(v1);
    	graphList.addVertex(v2);
    	graphList.addVertex(v3);
    	graphList.addVertex(v4);
    	graphList.addVertex(v5);
    	
    	
    	graphList.addEdge(v1, v2, false, 5, 1);
    	graphList.addEdge(v1, v4, false, 4, 2);
    	graphList.addEdge(v1, v5, false, 2, 3);
    	graphList.addEdge(v2, v3, false, 1, 4);
    	graphList.addEdge(v3, v4, false, 4, 5);
    	graphList.addEdge(v4, v5, false, 3, 6);
    	
    	
    	
    }
	
	public void stageTwo() {
		
		mG=new MethodsGraphs<>();
		graphMatrix= new GraphByMatrix<>(5);
		Integer v1=13;
    	Integer v2=8; 
    	Integer v3=9;
    	Integer v4=21;
    	Integer v5=5;
    	
    	graphMatrix.addVertex(v1);
    	graphMatrix.addVertex(v2);
    	graphMatrix.addVertex(v3);
    	graphMatrix.addVertex(v4);
    	graphMatrix.addVertex(v5);
    	
    	
    	graphMatrix.addEdge(v1, v2, false, 5, 1);
    	graphMatrix.addEdge(v1, v4, false, 4, 2);
    	graphMatrix.addEdge(v1, v5, false, 2, 3);
    	graphMatrix.addEdge(v2, v3, false, 1, 4);
    	graphMatrix.addEdge(v3, v4, false, 4, 5);
    	graphMatrix.addEdge(v4, v5, false, 3, 6);
	}
	
	
	
	public void stageThree(){
		
		mG=new MethodsGraphs<>();
		graphList = new GraphByLists<>(5);
    	Integer v1=13;
    	Integer v2=8; 
    	Integer v3=9;
    	Integer v4=21;
    	Integer v5=5;
    	
    	graphList.addVertex(v1);
    	graphList.addVertex(v2);
    	graphList.addVertex(v3);
    	graphList.addVertex(v4);
    	graphList.addVertex(v5);
    	
    	graphList.addEdge(v1, v2, false, 5, 1);
    	graphList.addEdge(v1, v4, false, 4, 2);
    	graphList.addEdge(v1, v5, false, 2, 3);
    	graphList.addEdge(v2, v3, false, 1, 4);
    	graphList.addEdge(v4, v5, false, 3, 5);
		
	}
	
	public void stageFour() {
		
		mG=new MethodsGraphs<>();
		graphMatrix= new GraphByMatrix<>(5);
		Integer v1=13;
    	Integer v2=8; 
    	Integer v3=9;
    	Integer v4=21;
    	Integer v5=5;
    	
    	graphMatrix.addVertex(v1);
    	graphMatrix.addVertex(v2);
    	graphMatrix.addVertex(v3);
    	graphMatrix.addVertex(v4);
    	graphMatrix.addVertex(v5);
    	
    	
    	graphMatrix.addEdge(v1, v2, false, 5, 1);
    	graphMatrix.addEdge(v1, v4, false, 4, 2);
    	graphMatrix.addEdge(v1, v5, false, 2, 3);
    	graphMatrix.addEdge(v2, v3, false, 1, 4);
    	graphMatrix.addEdge(v4, v5, false, 3, 5);
		
	}
	
	//Test DFS for GraphByLists
	@Test
	public void testDFS() {
		stageOne();
		
		ArrayList<Vertex<Integer>> arr= new ArrayList<>(); 
		Integer v1=13;
    	Integer v2=8; 
    	Integer v3=9;
    	Integer v4=21;
    	Integer v5=5;
    	
    	
    	Vertex<Integer> vertex1 = new Vertex<>(v1);
    	Vertex<Integer> vertex2 = new Vertex<>(v2);
    	Vertex<Integer> vertex3 = new Vertex<>(v3);
    	Vertex<Integer> vertex4 = new Vertex<>(v4);
    	Vertex<Integer> vertex5 = new Vertex<>(v5);
		
    	arr.add(vertex1);
    	arr.add(vertex2);
    	arr.add(vertex3);
    	arr.add(vertex4);
    	arr.add(vertex5);
		
    	System.out.println(vertex1);
    	
		
		assertEquals(vertex1.getValue(),mG.DFS(graphList, graphList.getVertices().get(0).getValue()));
		
	}
	
	//Test DFS for GraphByMatrix
	@Test
	public void testDFSMatrix() {
		stageTwo();
		
	}
	
	
	
	//Test BFS for GraphByLists
	@Test
	public void testBFS() {
		stageThree();
		
	}
	
	
	
	//Test BFS for GraphByMatrix
	@Test
	public void testBFSMatrix() {
		stageFour();
		
		
	}
	
	
	
	
	

}
