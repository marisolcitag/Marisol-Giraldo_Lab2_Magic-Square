package model;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

	/*
	 * Esta es la clas de pruebas para la clase MagicSquare
	 */
	public class MagicSquareTest extends TestCase {
	
		// ATRIBUTOS
		/**
	     * El mySquare sobre el que se van a realizar las pruebas
	     */
	    private MagicSquare mySquare;
	
	    // ESCENARIOS	    
	    /**
	     * Escenario1: Crea un cuadrado magico vacio
	     */
	   
	    private void setupEscenary1()
	    {
	        mySquare = new MagicSquare(0);
	    }
	    
	    /**
	     * Escenario 2: Crea un cuadrado magico de orden impar n=5 y startPoint UPPER flow NE
	     */
	    private void setupEscenary2( )
	    {
	        mySquare = new MagicSquare(5);
	        mySquare.oddMagicSquareNE("UPPER");
	    }
	    
	    /**
	     * Escenario3: Null
	     */
	   
	    private void setupEscenary3()
	    {
	  
	    }
	    
	    // METODOS
	    /**
	     * PRUEBA 1
	     * OBJETIVO: Probar que en el Escenario 3 el Magic Square esta null.<br>
	     * RESULTADOS: El Magic Square del Escenario 3 esta null.
	     */
	    
	    @Test
	    public void testMagicSquareEscNull( )
	    {
	        setupEscenary3( );
	        assertNull("El Cuadrado Magico esta null", mySquare);
	    }
	    
	    /**
	     * PRUEBA 2
	     * OBJETIVO: Probar que en el Escenario 1 si no se ingresan valores de inicialización el Magic Square no se genera.<br>
	     * RESULTADOS: El Magic Square del Escenario 1 no se genera esta vacio.
	     */
	    
	    @Test
	    public void testMagicSquareEscEmpty( )
	    {
	        setupEscenary1();
	        int [][] square = mySquare.oddMagicSquareNE(null);
	        assertNull("El Cuadrado Magico no tiene valores de inicialización, esta vacio", square);
	    }
	    
	    /**
	     * PRUEBA 3
	     * OBJETIVO: Probar que el Magic Square del Escenario 2 es un cuadrado magico.<br>
	     * RESULTADOS: El magic square del Escenario 2 es un cuadrado magico.
	     */
	    
	    @Test
	    public void testIsMagicSquare( )
	    {
	        setupEscenary2( );
	        boolean square= mySquare.isMagicSquare();
	        assertTrue( "El Magic Square es un Cuadrado Magico", square );
	    }
	    
	    /**
	     * PRUEBA 4
	     * OBJETIVO: Probar que no es posible crear un Magic Square de orden PAR.<br>
	     * RESULTADOS: El magic square no es posible generarlo.
	     */
	    @Test
	    public void testMagicSquareOrderEven() { 
	    	setupEscenary3();
	    	mySquare= new MagicSquare(4);
	    	int [][] square = mySquare.getSquare();
	    	assertNull("No fue posible crear el Magic Square porque es de orden PAR", square);
	    }
}
