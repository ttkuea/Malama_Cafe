package main;

import UI.LoginScreen;
//import constants.Images;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage stage;
	private static LoginScreen loginScreen;
	
	
	
	
	public void start(Stage primaryStage){
		stage = primaryStage;
		loginScreen = new LoginScreen();
		
		stage.setTitle("Malama Cafe");
//		stage.getIcons().add(Images.Logo);
		stage.setScene(loginScreen);
		stage.show();
		

		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}
}
