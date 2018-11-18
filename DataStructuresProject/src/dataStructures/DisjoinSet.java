package dataStructures;

import java.util.ArrayList;

public class DisjoinSet<T extends Comparable<T>> {

	private int nodeCount;
	private int setCount;
	private ArrayList<NodeMST> rootNodes;
	
	public DisjoinSet(ArrayList<Vertex<T>> vertexList){
		this.rootNodes = new ArrayList<>(vertexList.size());
		makeSets(vertexList);
	}
	
	public int find(NodeMST node){
		
		NodeMST currentNode = node;
		
		while(currentNode.getParent() != null){
			currentNode = currentNode.getParent();
		}
		
		//"Path compression"
		
		NodeMST root = currentNode;
		currentNode = node;
		
		while(!currentNode.equals(root)){
			NodeMST temp = currentNode.getParent();
			currentNode.setParent(root);
			currentNode = temp;
		}
		
		return root.getId();
		
	}
	
	public void union(NodeMST node1, NodeMST node2){
		
		int index1 = find(node1);
		int index2 = find(node2);
		
		if(index1 == index2){
			return;
		}
		
		NodeMST root1 = this.rootNodes.get(index1);
		NodeMST root2 = this.rootNodes.get(index2);
		
		if(root1.getHeight() < root2.getHeight()){
			root1.setParent(root2);
		}else if(root1.getHeight() > root2.getHeight()){
			root2.setParent(root1);
		}else{
			root2.setParent(root1);
			root1.setHeight(root1.getHeight() + 1);
		}
		
		this.setCount--;
		
	}

	public void makeSets(ArrayList<Vertex<T>> vertexList) {
		
		for(Vertex<T> vertex : vertexList){
			makeSet(vertex);
		}
		
	}

	public void makeSet(Vertex<T> vertex) {
		
		NodeMST newNode = new NodeMST(0, this.rootNodes.size(), null);
		vertex.setNode(newNode);
		setCount++;
		nodeCount++;
		this.rootNodes.add(newNode);
		
	}
	
}
