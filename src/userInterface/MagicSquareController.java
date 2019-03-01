package userInterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.EvenNumberException;
import model.MagicSquare;

public class MagicSquareController {
	
	//ATRIBUTOS
    @FXML
    private Label labelOrder;

    @FXML
    private TextField txtOrder;
      
   @FXML
   private ComboBox<?> comboStartPoint;

   @FXML
   private ComboBox<?> comboFlow;
   
   @FXML
   private Button btGenerate;
   
   @FXML
   private HBox hboxSquare;
        
   @FXML
   private HBox hboxConstant;
    
   @FXML
   private Label labelResultConstant;
    
   private MagicSquare mySquare;

   	//METODOS
   @FXML
   void generateSquare(ActionEvent event) throws EvenNumberException{
    	
	   String startPoint = comboStartPoint.getValue().toString();
	   String flow = comboFlow.getValue().toString();
    	  	
	   int n= Integer.parseInt(txtOrder.getText());
	   mySquare= new MagicSquare(n);
	   int[][] matrizSquare=null;

	   if(flow.equals("NO")) {
    		matrizSquare=mySquare.oddMagicSquareNO(startPoint);
    	}
    	else 
    		if(flow.equals("SE")) {
    			matrizSquare=mySquare.oddMagicSquareSE(startPoint);
    	}
    		else
    			if(flow.equals("NE")) {
    			matrizSquare=mySquare.oddMagicSquareNE(startPoint);
    			}
    			else
    				matrizSquare=mySquare.oddMagicSquareSO(startPoint);
    	
    	if(n%2!=0) {
    		GridPane gridPane=new GridPane();
    			for(int i=0;i<n;i++) {
    				for(int j=0;j<n;j++) {
    					TextField miTxt = new TextField();
    					miTxt.setText(""+matrizSquare[i][j]);
    					miTxt.setDisable(true);
    					gridPane.add(miTxt, j, i);
    				}
    			}	
    		hboxSquare.getChildren().add(gridPane);
    		txtOrder.setDisable(true);
    	}
    	else {
    		throw new EvenNumberException(n);
    	}  	
    	labelResultConstant.setText(""+mySquare.totalSum());
    }
    
    @FXML
    void generateOrder(KeyEvent event) {
    	/*TextField txt = (TextField) event.getSource();
    	
    	int n= Integer.parseInt(txt.getText());
    	mySquare= new MagicSquare(n);
    	int[][] matrizSquare=mySquare.oddMagicSquareSE(n);
    	
    	if(n%2!=0) {
    		GridPane gridPane=new GridPane();
    			for(int i=0;i<n;i++) {
    				for(int j=0;j<n;j++) {
    					TextField miTxt = new TextField();
    					miTxt.setText(""+matrizSquare[i][j]);
    					miTxt.setDisable(true);
    					gridPane.add(miTxt, j, i);
    				}
    			}	
    			
    		hboxSquare.getChildren().add(gridPane);
    		txtOrder.setDisable(true);
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setContentText("Por favor Ingrese un Cuadro Magico de Orden Impar!");
    	    txt.setText("");
    	    alert.showAndWait();
    	}  	
    	labelResultConstant.setText(""+mySquare.totalSum());*/
    }
    
    /*
     * Metodo: loadFlow()
     * Descripción: Este método se encarga de desplegar las opciones del ComboBox
     * respecto al sentido: NO, NE, SE y SO, que se activan de acuerdo a la dirección que
     * se haya indicado de startPoint
     */
    @FXML
    void loadFlow(ActionEvent event) {
    	String startPoint = comboStartPoint.getValue().toString();
    	
    	if(startPoint.equalsIgnoreCase("UPPER")) {
    		ObservableList optionsFlow = 
        		    FXCollections.observableArrayList(
        		        "NO",
        		        "NE"        		    );
        		comboFlow.setItems(optionsFlow);
        }
        else
        	if(startPoint.equalsIgnoreCase("LOWER")) {
        		ObservableList optionsFlow = 
            		    FXCollections.observableArrayList(
            		        "SO",
            		        "SE"        		    );
            		comboFlow.setItems(optionsFlow);
        	}
        	else
        		if(startPoint.equalsIgnoreCase("RIGTH")) {
        			ObservableList optionsFlow = 
                		    FXCollections.observableArrayList(
                		        "NE",
                		        "SE"        		    );
                		comboFlow.setItems(optionsFlow);
        		}
        		else {
        			ObservableList optionsFlow = 
                		    FXCollections.observableArrayList(
                		        "NO",
                		        "SO"        		    );
                		comboFlow.setItems(optionsFlow);
        		}	
    }
    
    /*
     * Metodo: initialize()
     * Descripción: Este método se encarga de obtener inicializar las opciones del ComboBox
     * respecto a la dirección: arriba, abajo, derecha e izquierda
     */
    public void initialize() {
    	ObservableList options = 
    		    FXCollections.observableArrayList(
    		        "UPPER",
    		        "LOWER",
    		        "RIGTH",
    		        "LEFT"
    		    );
    		comboStartPoint.setItems(options);			
    }
}