/**
 * 
 * @author Jerson Robles
 *
 */
public class NodeH {
	
	private double total;
	private String expresion;
	private String funcion = expresion+" = "+total;
	private NodeH next;
	
	
	/**
	 * Inicializa el nodo con los valor obtenidos.
	 */
	public NodeH(){
		next = null;
	}
	
	public String getFuncion() {
		return funcion;
	}
	
	public NodeH getNext() {
		return next;
	}
	
	public double getTotal() {
		return total;
	}
	
	public String getExpresion() {
		return expresion;
	}
	
	public void setNext(NodeH nuevoNodo) {
		this.next =nuevoNodo; 
	}
	
	public void setFuncion(String expresion, double total) {
		this.expresion = expresion;
		this.total = total;
		this.funcion = expresion+" = "+total;
	}
	
	public void setNodeH(String expresion, double total) {
		this.expresion = expresion;
		this.total = total;
		setFuncion(expresion, total);
	}
	
	
	
}
