/**
 * 
 * @author Jerson Robles
 *
 */
public class Node {
	
	private Double number;
	private Node link;
	
	/**
	 * Inicializa el nodo con el link apuntando a null.
	 */
	public Node(){
		link = null;
	}
	
	public Double getNumber() {
		return number;
	}
	public void setNumber(Double number) {
		this.number = number;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
	
	
}
