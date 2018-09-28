/**
 * 
 * @author Jerson Robles
 *
 */

public class List{
	NodeH head;
	int size;
	
	/**
	 * Inicializa la propiedad head apuntando a null
	 */
	public List(){
		head = null;
	}
	
	/**
	 * Regresa true si lista esta vacia.
	 * @return
	 */
	public boolean isEmpty(){
		return (head == null);
	}
	
	/**
	 * agrega un nuevo nodo a la lista con los parametros expresion y total
	 * @param expresion
	 * @param total
	 */
	public void add(String expresion, double total){
		NodeH nuevoNodo = new NodeH();
		
		if(isEmpty()){
			nuevoNodo.setFuncion(expresion, total);
			head = nuevoNodo;
		} else {
			NodeH aux = head;	
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			nuevoNodo.setFuncion(expresion, total);
			aux.setNext(nuevoNodo);
		}
		size++;
	}
	
	
	/**
	 * Se recorre la lista para imprimir su valor funcion. 
	 * @param list
	 */
	public void print(List list){
		List lista = list;
		if(isEmpty()) {
			System.out.println("Nothing to Print");
		} else {
			NodeH aux = head;
			int size = lista.size;
			
			for(int i=0; i<size; i++) {
				String funcion = aux.getFuncion();
				System.out.println(funcion);
				aux = aux.getNext();
			}
			
		}
	}
	
}

