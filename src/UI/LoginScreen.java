package UI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;

public class LoginScreen extends Scene{
	HBox root;
	private LoginPane loginPane;

	public LoginScreen() {
		super(new HBox(),1200,600);
		root = (HBox) getRoot();
		
		root.setPadding(new Insets(10));
		
		
		loginPane = new LoginPane();
		
		
		root.getChildren().addAll(loginPane);
		
	}

}
