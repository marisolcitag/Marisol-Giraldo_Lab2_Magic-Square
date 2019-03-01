package model;

/**
 * Esta excepción se lanza cuando el usuario ingresa una cuadrado magico de orden PAR
 */

public class EvenNumberException extends Exception{
	
	private int n;
	
	public EvenNumberException(int number) {
		
		n=number;
		
	}
	
	@Override
	public String getMessage() {
		
		String mensaje="";
		
		if(n%2!=0) {
			mensaje = "Correcto!!! El Cuadrado Magico que solicito generar es de orden IMPAR";
		}
		else {
			mensaje = "Alerta!!! El Cuadrado Magico que solicito generar es de orden PAR";
		}
		
		return mensaje;
	}
}

