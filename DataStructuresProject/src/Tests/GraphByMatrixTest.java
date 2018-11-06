package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.Edge;
import dataStructures.GraphByMatrix;
import dataStructures.Vertex;
import junit.framework.TestCase;

class GraphByMatrixTest extends TestCase {


    GraphByMatrix<String,String>  graph;
    
	 
	
    public void stageOne() {
    	
    	graph = new GraphByMatrix<>(5);
    }
    
    
	 
	
    public void stageTwo() {
    	
    	graph = new GraphByMatrix<>(3);
    	

    	String bogota = new String("bogota");
    	String cali = new String("cali");
    	
    	graph.addVertex(cali);
    	graph.addVertex(bogota);
    
    }
    

    public void stageThree() {
    	
    	graph = new GraphByMatrix<>(3);
    	

    	String bogota = new String("bogota");
    	String cali = new String("cali");
    	
    	graph.addVertex(cali);
    	graph.addVertex(bogota);
    	
     	String troncal = new String("troncal");
    	String panamericana= new String("panamericana");

    	graph.addEdge(bogota, cali, true, 1333, troncal);
    	graph.addEdge(bogota, cali, true, 1000, panamericana);
    
    }
    
    
    @Test
    public void testInitMatrix() {
    	 
    	stageOne();
    	
    	assertNotNull(graph.getAdjMatrix());
    	
    }
    
    @Test
    public void testAddVertex() {
    	
    	stageOne();
    	
    	String vertexA = new String("Cartagena");
    	String vertexB = new String("Cali");
    	String vertexC = new String("Bogota");
    	
    	graph.addVertex(vertexA);
    	graph.addVertex(vertexB);
    	graph.addVertex(vertexC);

    	
    	assertEquals(3, graph.getVertices().size());

    	
    }
    
    @Test
    public void testAddEdge() {
    	
    	stageTwo();
    	
    
    	String bogota = new String("bogota");
    	String cali = new String("cali");
    	String troncal = new String("troncal");
    	String panamericana= new String("panamericana");

    	

    	//graph.addEdge(bogota, cali, true, troncal.getCost(), troncal);
   

    	graph.addEdge(bogota, cali, true, 1333, troncal);
    	graph.addEdge(bogota, cali, true, 1000, panamericana);

        assertEquals(2, graph.numEdgesOfVertex(bogota));
    }
    
    @Test
    public void testRemoveEdge() {
    	
    	stageThree(); 
    	
    	graph.removeEdge("bogota", "cali", true, 1000);
    	
        assertNotEquals(2, graph.numEdgesOfVertex("bogota"));

    	
    }
    
    @Test
    public void testIsAdjacent() {
    	
    	stageThree();
    	
    	
    	
    	assertTrue(graph.isAdjacent("bogota", "cali"));
    }
    
    @Test 
    public void testGetEdgesOfVertex() {
    	
    	stageThree();
    	
    	assertEquals(2, graph.numEdgesOfVertex("bogota"));
    }

}







