/**
 * 
 * @author Jerson Robles
 *
 */
public class Stack {
	private Node inicio;
	private Double size = 0.0;
	
	/**
	 * Inicializa la pila con la cabeza apuntando a null.
	 */
	public Stack(){
		inicio = null;
	}
	
	
	public Node getInicio(){
		return inicio;
	}
	
	public Double size(){
		return size;
	}
	
	/**
	 * Agrega un nuevo Nodo a la pila con el valor dado. 
	 * @param number
	 */
	public void push(Double number){
		Node nuevo = new Node();
		nuevo.setNumber(number);
		
		if(inicio == null){
			nuevo.setLink(null);
			inicio = nuevo;
			size ++;
		} else {
			nuevo.setLink(inicio);
			inicio = nuevo;
			size ++;
		}
	}
	
	/**
	 * Regresa el ultimo elemento de la pila.
	 * @return
	 */
	public Double pop(){
		if(inicio != null){
			Double valor = inicio.getNumber();
			inicio = inicio.getLink();
			return valor;
		} else {
			return Double.MAX_VALUE;
		}
	}
	
}
