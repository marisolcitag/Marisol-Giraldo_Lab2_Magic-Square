package model;

/**
 * Descrición:Esta excepción se lanza cuando el usuario no ingresa los datos del cuadrado magico
 * en la interfaz
 */

public class ErrorEnteredValuesException extends Exception{
	
	int n;
	
	String startPoint;
	
	String flow;
	
	public void ErrorEnteredValues(int number, String selectStartPoint, String selectFlow){
			
		n = number; 
		
		startPoint = startPoint;
		
		flow = selectFlow;		
		
	}
	
	public String getMessage() {
		
		String mensaje = "";
		
		if((String.valueOf(n)==null) && startPoint==null && flow==null){
			
			mensaje = "Alerta!!! No ingreso valores para generar el Cuadrado Magico";
		}
		else {
			mensaje = "Correcto!!! Ingreso de manera adecuada los valores para generar el Cuadrado Magico ";
		}
		
		return mensaje;
	}
}
