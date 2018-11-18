package dataStructures;

public class NodeMST {

	private int height;
	private int id;
	private NodeMST parent;
	
	public NodeMST(int height, int id, NodeMST parent) {
		this.height = height;
		this.id = id;
		this.parent = parent;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NodeMST getParent() {
		return parent;
	}
	public void setParent(NodeMST parent) {
		this.parent = parent;
	}
	
	
	
}
