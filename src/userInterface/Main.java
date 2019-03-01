package userInterface;

import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.MagicSquare;

public class Main extends Application{
	
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MagicSquare.fxml")); 
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Magic Square");
		stage.show();
	}

    public static void main(String[] args) {
          	launch(args);
    }
}