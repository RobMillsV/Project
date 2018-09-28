import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author Jerson Robles
 *
 */

public class RPNCalculator {
	
	public static List list = new List();
	public static List lista = new List();
	
	public static void main(String[] args) throws IOException {
		RPNCalculator calculator = new RPNCalculator(); 
		Scanner scanner = new Scanner(System.in);
			
		calculator.operate();				
					
	}
	
	
	/**
	 * Opera el menu que se muestra al usuario. 
	 * @throws IOException 
	 */
	public void operate() throws IOException{
		Scanner scanner = new Scanner(System.in);
		char attempt = 'y';
		int answer = 0; 
		String input;
		
		
		while(attempt != 'n') {
			System.out.println("Press 1 to try");
			System.out.println("Press 2 to print");
			System.out.println("Press 3 to exit");
			answer = scanner.nextInt();
			
			switch(answer) {
			case 1:
				calcularRPN();
				break;
				
			case 2:
				list.print(list);
				break;
				
			case 3:
				list.print(list);
				attempt = 'n';
				return;
				
			default:
				System.out.println("wrong answer!");
			}
			
			System.out.println("back to menu?");
			System.out.println("press y for Yes");
			System.out.println("press n for ");
			input = scanner.next().toLowerCase();
			attempt = input.charAt(0);
		}
		
		list.print(list);
		
		List sortedList = sort();
		archivarExpresiones(sortedList);
		List sortedListD = sortD();
		archivarExpresiones(sortedListD);
		
		System.out.println("Thanks For Using!");
		
	}
	
	public List sortD(){
			int tamanio = list.size;
			double[] matrix = new double[tamanio];
			String[] matrixDos = new String[tamanio];
			double total = 0;
			String expresion = "";
			NodeH aux = list.head;
			
			
			for(int i=0; i<tamanio; i++) {
				total = aux.getTotal();
				expresion = aux.getExpresion();
				matrix[i] = total;
				matrixDos[i] = expresion;
				aux = aux.getNext();
			}
			
			
			
			for(int j=0; j<=tamanio-1; j++) {
				int bottom = j;
				for(int k=j+1; k<tamanio; k++) {
					if(matrix[k] > matrix[bottom]){
						bottom = k;
					}
					
				double temp = matrix[bottom];
				matrix[bottom] = matrix[j];
				matrix[j] = temp;
				}
			}
			
			for(int l=0; l<tamanio; l++) {
				total = matrix[l];
				expresion = matrixDos[l];
				lista.add(expresion, total);			
			}
			
			return lista;
		}
		
	
	/**
	 * Ordena la lista de manera ascendente.
	 * @return
	 */
	public List sort() {
		int tamanio = list.size;
		double[] matrix = new double[tamanio];
		String[] matrixDos = new String[tamanio];
		double total = 0;
		String expresion = "";
		NodeH aux = list.head;
		
		
		for(int i=0; i<tamanio; i++) {
			total = aux.getTotal();
			expresion = aux.getExpresion();
			matrix[i] = total;
			matrixDos[i] = expresion;
			aux = aux.getNext();
		}
		
		
		
		for(int j=0; j<=tamanio-1; j++) {
			int bottom = j;
			for(int k=j+1; k<tamanio; k++) {
				if(matrix[k] < matrix[bottom]){
					bottom = k;
				}
				
			double temp = matrix[bottom];
			matrix[bottom] = matrix[j];
			matrix[j] = temp;
			}
		}
		
		for(int l=0; l<tamanio; l++) {
			total = matrix[l];
			expresion = matrixDos[l];
			lista.add(expresion, total);			
		}
		
		return lista;
	}
	
	
	/**
	 * Genera un documento tipo .txt y guarda las expresiones.
	 * @throws IOException
	 */
	public void archivarExpresiones(List list) throws IOException {
		FileWriter fileWriter = new FileWriter("C:/Escritorio/hitory.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter); 
		int tamanio = list.size;
		NodeH aux;
		aux = list.head;
			for(int i=0; i<tamanio; i++) {
				String funcion = aux.getFuncion();
				printWriter.println(funcion);
				aux = aux.getNext();
			}

		printWriter.close();
	}
	
	
	/**
	 * Sera dividido en tokens delimitados por un espacio en blanco,
	 * los tokens se operan para obter el resutaldo de la funcion. 
	 * @param expresion
	 */
	public void calcularRPN() {
		Scanner scanner = new Scanner(System.in);
		Stack stack = new Stack();
		Node nodoResultado;
		Double total;
		
		System.out.print("Insert Reverse Polish Notation: ");
		String expresion = scanner.nextLine();
		
		if(validate(expresion)) {
			StringTokenizer st = new StringTokenizer(expresion, " ");
				while(st.hasMoreTokens()) {
					String token = st.nextToken();	
					if(isItANumber(token)){
						Double number = Double.parseDouble(token);
						stack.push(number);
					} else {
						Double x = stack.pop();
						Double y = stack.pop();
						Double result = resolve(token, x, y);
						stack.push(result);
					}
				}
				nodoResultado = stack.getInicio();
				total = nodoResultado.getNumber();
				
				list.add(expresion, total);
				
				System.out.println("El resultado de " +expresion+ " es: "+total);
			} else{
				System.out.println("Expresion Invalida");
			}
		}
	
	
	/**
	 * El operador indica que funcion matematica sera implentada
	 * para x & y.  
	 * @param operator
	 * @param x
	 * @param y
	 * @return 
	 */
	public Double resolve(String operator, Double x, Double y) {
		String aux = operator.toUpperCase();
		
		switch(aux) {
			case "PLUS" :
				return x+y;
				
			case "LESS" :
				return y-x;
				
			case "TIMES" :
				return x*y;		
				
			case "DIVIDE" :
				return y/x;	
		}
		
		return 0.0;
	}
	
	
	/**
	 * Evalua que token sea un numero, de lo contrario regresa false. 
	 * @param token
	 * @return
	 */
	public boolean isItANumber(String token){
		String aux = token;
		
		try {
			Double.parseDouble(aux);
			return true;
			
		} catch(NumberFormatException number) {
			return false;
		}
	}
	
	
	/**
	 * Valida que la expresion esta escrita en notacion polaca inversa. 
	 * @param expresion
	 * @return
	 */
	public boolean validate(String expresion) {
		StringTokenizer st = new StringTokenizer(expresion, " ");
		
		int numero = 0;
		int operador = 0;
		int size = 0;
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();	
			if(isItANumber(token)){
				numero++;
			} else {
				operador++;
			}
			
		}
		
		size = numero+operador;
		int operadoresValidos = numero-1; 
		
		return size>3 && operador==operadoresValidos;
	}
	
}
