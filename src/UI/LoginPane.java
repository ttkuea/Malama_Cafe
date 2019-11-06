package UI;

import connector.Connector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginPane extends VBox{
	private Button loginButton;
	private Button exitButton;
	private TextField idInput;
	private PasswordField passwordInput;
	private Label status;
	private Connector connector;
	
	public LoginPane() {
		setSpacing(10);
		setAlignment(Pos.CENTER);
		setPrefWidth(400);
		setPadding(new Insets(15));
		
		//INPUT Field
		VBox div1 = new VBox();
		div1.setPadding(new Insets(10));
		Label idLabel = new Label("ID :");
		this.idInput = new TextField();
		div1.getChildren().addAll(idLabel,idInput);
		
		//PASSWORD Field
		VBox div2 = new VBox();
		div2.setPadding(new Insets(10));
		Label pwdLabel = new Label("Password :");
		this.passwordInput = new PasswordField();
		div2.getChildren().addAll(pwdLabel,passwordInput);
		
		//BUTTONS
		HBox div3 = new HBox();
		div3.setPadding(new Insets(10));
		div3.setSpacing(30);
		div3.setAlignment(Pos.CENTER);
		
		loginButton = new Button("Login");
		loginButton.setPrefWidth(100);
		
		exitButton = new Button("Exit");
		exitButton.setPrefWidth(100);
		
		buttonHandler(loginButton, exitButton);
		
		div3.getChildren().addAll(loginButton,exitButton);
		
		status = new Label("");
		
		getChildren().addAll(div1,div2,div3,status);
	}
	
	public void buttonHandler(Button login, Button exit) {
		
		login.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("LOGIN Clicked");
				
				String id = idInput.getText().trim();
				String pwd = passwordInput.getText().trim();
				
				//TODO: Add Connection to mysql
				//SQL CONNECTION PART
				//IF CONNECTION SUCCESS -> CHANGE SCENE
				connector = Connector.getInstance();
				if (connector.login(id,pwd)) {
					status.setText("Login Success!");
				}else {
					status.setText("Login Failed: Wrong Username or Password");
				}
				
			}
		});
		
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("EXIT Clicked");
				System.exit(0);
			}	
		});
	}
	
	
}
