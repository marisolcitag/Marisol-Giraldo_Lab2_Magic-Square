package model;

/**
 * Esta clase se encarga de construir el Cuadrado Magico
 *
 */

public class MagicSquare {

	//ATRIBUTOS
    private int n;
    private int[][] square;
    public static final String up= "UPPER";
    static final String down= "LOW";
    public static final String rigth= "RIGTH";
    
    //METODOS    
    /*
     * Metodo: MagicSquare(int n)
     * Descripción: Este método se encarga de generar el cuadrado mágico, si el orden es PAR, 
     * el cuadrado magico no se genera y se lanza una excepción
     */
    public MagicSquare(int n) {
    	try {
    	if (n%2 != 0) {
    		this.n = n;
    		this.square = new int[n][n];
    		for (int i = 0; i < n; i++) { 
    			for (int j = 0; j < n; j++) {
    				this.square[i][j]=0;
    			}
    		}
    	}
    	else
    		throw new EvenNumberException(n);
    	}
    	catch(Exception e) {
    		String mensaje= "Se ha producido una excepcion porque el n es de orden PAR";
    		System.err.println(mensaje+ e.getMessage() );
    	}
    }

    /*
     * Metodo: getSquare()
     * Descripción: Este método se encarga de obtener el cuadrado magico
     */
    public int[][] getSquare() {
        return square;
    }

    /*
     * Metodo: setSquare(int[][] square)
     * Descripción: Este método se encarga de modificar el cuadrado magico
     */
    public void setSquare(int[][] square) {
        this.square = square;
    }
    
    /*
     * Metodo: getSquare()
     * Descripción: Este método se encarga de verificar si el cuadrado magico cumple con los
     * requisitos para serlo
     */
    public boolean isMagicSquare() {
    	System.out.println("r c d: "+ rowSum()+ " "+columnSum()+ " "+diagonalSum());
        return rowSum() && columnSum() && diagonalSum();
    }

    /*
     * Metodo: totalSum()
     * Descripción: Este método se encarga de obtener la constante magica del cuadrado magico
     */
    public int totalSum() {
        int sum = n*(n*n + 1)/2;
        return sum;
    }

    /*
     * Metodo: rowSum()
     * Descripción: Este método se encarga de obtener la suma de las filas del cuadrado magico
     */
    public boolean rowSum() {
        boolean validSum = true;
        int rowSum = 0;
        int magicConstant = totalSum();
        int f = 0;
        while (f < n && validSum) {
            for (int c = 0; c < n; c++)
                rowSum += square[f][c];

            if (rowSum != magicConstant) {
                validSum = false;
            }
            f++;
            rowSum = 0;
        }
        return validSum;
    }

    /*
     * Metodo: columnSum()
     * Descripción: Este método se encarga de obtener la suma de las columnas del cuadrado magico
     */
    public boolean columnSum() {
        boolean validSum = true;
        int rowColumn = 0;
        int magicConstant = totalSum();
        int c = 0;
        while (c < n && validSum) {
            for (int f = 0; f < n; f++)
            	rowColumn += square[f][c];

            if (rowColumn != magicConstant) {
            	validSum = false;
            }
            c++;
            rowColumn = 0;
        }
        return validSum;
    }

    /*
     * Metodo: diagonalSum()
     * Descripción: Este método se encarga de obtener la suma de las diagonales del cuadrado magico
     */
    public boolean diagonalSum() {
        boolean validSum = true;
        int magicConstant = totalSum();
        int sumDiag1 = 0;
        int f = 0, c = 0;
        while (f < n && c < n) {
            sumDiag1 += square[f][c];
            f++;
            c++;
        }
        if(sumDiag1 != magicConstant)
        	validSum = false;
        else{
            int sumDiag2 = 0;
            f = 0;
            c = n - 1;
            while (f < n && c >= 0) {
                sumDiag2 += square[f][c];
                f++;
                c--;
            }
            if (sumDiag2 != magicConstant)
            	validSum = false;
        }
        return validSum;
    }
    
    /*
     * Metodo: oddMagicSquareNE
     * Descripción: Este método se encarga de generar el cuadrado mágico, comenzando en el 
     * startPoint indicado (casilla central de la primera fila con el numero 1 o casilla central 
     * de la última columna con el numero 1) y en sentido NE
     */
    public int[][] oddMagicSquareNE(String startPoint) {
	   
	   if (startPoint== null) {
		   square=null;
		   
	   }else {
        int coUlt = 0, fiUlt = 0;
        int coSig = 0;
        int fiSig = 0;
        
         //Ubica el número 1 en la casilla central de la posicion indicada
        if(startPoint.equalsIgnoreCase(up)) {
        	coSig = (n - 1) / 2;
            fiSig = 0;
        }
        else
        	if(startPoint.equalsIgnoreCase(down)) {
        		coSig = (n - 1) / 2;
                fiSig = n-1;
        	}
        	else
        		if(startPoint.equalsIgnoreCase(rigth)) {
        			coSig = n - 1;
                    fiSig = (n - 1) / 2;
        		}
        		else {
        			coSig = 0;
                    fiSig = (n - 1) / 2;
        		}
        
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //guardamos el numero en el cuadro
                square[fiSig][coSig] = num;

                //guardamos la ultima posicion donde guardamos algo
                fiUlt = fiSig;
                coUlt = coSig;

                 //Primer paso Mover una casilla hacia arriba y luego una casilla hacia la derecha
                fiSig = fiUlt - 1;
                coSig = coUlt + 1;

                 //Si un movimiento te lleva a una "casilla" por encima de la fila
                //superior del cuadrado mágico, permanece en esa columna, pero ubica
                //el número en la fila inferior de dicha columna
                if (fiSig < 0) {
                    fiSig=n-1;
                }

                //Si el movimiento te lleva a una "casilla" fuera del límite derecho 
                //del cuadrado mágico, permanece en la fila de dicha casilla, pero ubica 
                //el número en la columna más alejada hacia la izquierda de esa fila.
                if(coSig>=n){
                    coSig=0;
                }

                //Si el movimiento te lleva a una casilla que ya está ocupada, regresa 
                //a la última casilla que llenaste y ubica el número debajo.
              if(fiSig==-1 || square[fiSig][coSig]!=0){
                    fiSig=fiUlt+1;
                    if (fiSig < 0) {
                        fiSig=n-1;
                    }else            
                    if (fiSig > n-1) {
                        fiSig=0;
                    }
                    coSig=coUlt;                    
                }
                num++;
            }
        }
       
	   }
	   return square;
    }
    
    /*
     * Metodo: oddMagicSquareNO
     * Descripción: Este método se encarga de generar el cuadrado mágico, comenzando en el 
     * startPoint indicado (casilla central de la primera fila con el numero 1 o casilla 
     * central de la primera columna con el numero 1) y en sentido NO.
     */
   public int[][] oddMagicSquareNO(String startPoint) {
        
	   if (startPoint== null) {
		   square=null;		   
	   }else {
	   		  int coUlt = 0, fiUlt = 0;
	   		  int coSig = 0;
	   		  int fiSig = 0;
	   		  //Ubica el número 1 en la casilla central en la posición indicada
	   		  if(startPoint.equalsIgnoreCase(up)) {
	   			coSig = (n - 1) / 2;
	   			fiSig = 0;
	   		}
	   		else
	   			if(startPoint.equalsIgnoreCase(down)) {
	   				coSig = (n - 1) / 2;
	   				fiSig = n-1;
	   			}
	   		else
	   			if(startPoint.equalsIgnoreCase(rigth)) {
	   				coSig = n - 1;
	   				fiSig = (n - 1) / 2;
	   			}
        	else {
        		  coSig = 0;
        		  fiSig = (n - 1) / 2;
        	   	 }
        
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //guardamos el numero en el cuadro
                System.out.println("Fila y Columna : "+fiSig+" "+coSig+ " "+num);

                square[fiSig][coSig] = num;

                //guardamos la ultima posicion donde guardamos algo
                fiUlt = fiSig;
                coUlt = coSig;

                 //Primer paso Mover una casilla hacia arriba y luego una casilla hacia la izquierda
                fiSig = fiUlt - 1;
                coSig = coUlt - 1;

                 //Si un movimiento te lleva a una "casilla" por encima de la fila
                //superior del cuadrado mágico, permanece en esa columna, pero ubica
                //el número en la fila inferior de dicha columna
                
                if (fiSig < 0) {
                    fiSig=n-1;
                }else            
                if (fiSig > n-1) {
                    fiSig=0;
                }

                //Si el movimiento te lleva a una "casilla" fuera del límite izquierdo 
                //del cuadrado mágico, permanece en la fila de dicha casilla, pero ubica 
                //el número en la columna más alejada hacia la derecha de esa fila.
                
                if(coSig>n-1){
                    coSig=0;
                }else
                
                if(coSig<0) {
                	coSig=n-1;
                }

                //Si el movimiento te lleva a una casilla que ya está ocupada, regresa 
                //a la última casilla que llenaste y ubica el número debajo.
                if(square[fiSig][coSig]!=0){
                    fiSig=fiUlt+1;
                    if (fiSig < 0) {
                        fiSig=n-1;
                    }else            
                    if (fiSig > n-1) {
                        fiSig=0;
                    }
                    coSig=coUlt;                    
                }
                num++;
            }
        }
	   }
        return square;
    }
    
    /*
     * Metodo: oddMagicSquareSO
     * Descripción: Este método se encarga de generar el cuadrado mágico, comenzando en el 
     * startPoint indicado (casilla central de la última fila con el numero 1 o casilla central 
     * de la primera columna con el numero 1) y en sentido SO
     */
    
    public int[][] oddMagicSquareSO(String startPoint) {
        
    	if (startPoint== null) {
 		   square=null;
 		   
 	   }else {
 		   
		   int coUlt = 0, fiUlt = 0;        
		   int coSig = 0, fiSig = 0;

		   //Ubica el número 1 en la casilla central en la posición indicada
		   if(startPoint.equalsIgnoreCase(up)) {
			   coSig = (n - 1) / 2;
			   fiSig = 0;
		   }
        else
        	if(startPoint.equalsIgnoreCase(down)) {
        		coSig = (n - 1) / 2;
                fiSig = n-1;
        	}
        	else
        		if(startPoint.equalsIgnoreCase(rigth)) {
        			coSig = n - 1;
                    fiSig = (n - 1) / 2;
        		}
        		else {
        			coSig = 0;
                    fiSig = (n - 1) / 2;
        		}
       
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //guardamos el numero en el cuadro
            	System.out.println("Fila y Columna : "+fiSig+" "+coSig+ " "+num);
                square[fiSig][coSig] = num;

                //guardamos la ultima posicion donde guardamos algo
                
                fiUlt = fiSig;
                coUlt = coSig;

                 //Primer paso Mover una casilla hacia abajo y luego una casilla hacia la izquierda
                fiSig = fiUlt + 1;
                coSig = coUlt + 1;

                 //Si un movimiento te lleva a una "casilla" por debajo de la fila
                //inferior del cuadrado mágico, permanece en esa columna, pero ubica
                //el número en la fila inferior de dicha columna
                if (fiSig < 0) {
                    fiSig=n-1;
                }
            else            
                if (fiSig > n-1) {
                    fiSig=0;
                }
        	
                //Si el movimiento te lleva a una "casilla" fuera del límite izquierdo
                //del cuadrado mágico, permanece en la fila de dicha casilla, pero ubica 
                //el número en la columna más alejada hacia la derecha de esa fila.
                if(coSig>n-1){
                   coSig=0;
                }
                else
                    if(coSig<0) {
                    	coSig=n-1;
                    }

                //Si el movimiento te lleva a una casilla que ya está ocupada, regresa 
                //a la última casilla que llenaste y ubica el número debajo.
                if(square[fiSig][coSig]!=0){
                    fiSig=fiUlt+1;
                    coSig=coUlt;                    
                }
                num++;
            }
        }
 	   }
        return square;
    }
    
    /*
     * Metodo: oddMagicSquareSE
     * Descripción: Este método se encarga de generar el cuadrado mágico, comenzando en el 
     * startPoint indicado (casilla central de la última fila con el numero 1 o casilla central 
     * de la última columna con el numero 1) y en sentido SE
     */
    
    public int[][] oddMagicSquareSE(String startPoint) {

    	if (startPoint== null) {
 		   square=null;
 		   
 	   }else {

 		   int coUlt = 0, fiUlt = 0;       
 		   int coSig = 0, fiSig = 0;

 		   //Ubica el número 1 en la casilla central en la posicion indicada
 		   if(startPoint.equalsIgnoreCase(up)) {
 			   coSig = (n - 1) / 2;
 			   fiSig = 0;
 		   }
 		   else
        	if(startPoint.equalsIgnoreCase(down)) {
        		coSig = (n - 1) / 2;
                fiSig = n-1;
        	}
        	else
        		if(startPoint.equalsIgnoreCase(rigth)) {
        			coSig = n - 1;
                    fiSig = (n - 1) / 2;
        		}
        		else {
        			coSig = 0;
                    fiSig = (n - 1) / 2;
        		}
       
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //guardamos el numero en el cuadro
            	System.out.println("Fila y Columna : "+fiSig+" "+coSig+ " "+num);
                square[fiSig][coSig] = num;

                //guardamos la ultima posicion donde guardamos algo
                
                fiUlt = fiSig;
                coUlt = coSig;

                 //Primer paso Mover una casilla hacia abajo y luego una casilla hacia la derecha
                fiSig = fiUlt + 1;
                coSig = coUlt + 1;

                 //Si un movimiento te lleva a una "casilla" por debajo de la fila
                //inferior del cuadrado mágico, permanece en esa columna, pero ubica
                //el número en la fila inferior de dicha columna
                if (fiSig < 0) {
                    fiSig=n-1;
                }
            else            
                if (fiSig > n-1) {
                    fiSig=0;
                }
        	
                //Si el movimiento te lleva a una "casilla" fuera del límite derecho 
                //del cuadrado mágico, permanece en la fila de dicha casilla, pero ubica 
                //el número en la columna más alejada hacia la izquierda de esa fila.
                if(coSig>n-1){
                   
                    coSig=0;
                }
                else
                    if(coSig<0) {
                    	coSig=n-1;
                    }

                //Si el movimiento te lleva a una casilla que ya está ocupada, regresa 
                //a la última casilla que llenaste y ubica el número debajo.
                if(square[fiSig][coSig]!=0){
                    fiSig=fiUlt+1;
                    coSig=coUlt;                    
                }
                num++;
            }
        }
 	   }
        return square;
    }
}