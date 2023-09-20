package com.kelton;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginScreen extends GridPane {

	private final TextField userField = new TextField();
	private final PasswordField passField = new PasswordField();
	private final Label message = new Label("");

	public LoginScreen() {
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setHgap(10);
		this.setVgap(10);

		final Text loginTxt = new Text("Login");
		loginTxt.setFont(Font.font(20));

		this.add(loginTxt, 0, 0);

		final Text userText = new Text("Username: ");
		this.add(userText, 0, 1);
		this.add(userField, 1, 1);

		final Text passwordText = new Text("Password: ");
		this.add(passwordText, 0, 2);
		this.add(passField, 1, 2);

		final Button loginButton = new Button("Login");
		loginButton.setOnAction(e -> login() );
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(loginButton);
		this.add(hbBtn, 1, 3);

		this.add(message, 4, 4);
	}

	private void login() {
		if(userField.getText().equals("kelton") && passField.getText().equals("123"))
			fireEvent(new CustomEvent(CustomEvent.loginSuccessful));
		else
			message.setText("Wrong username or password");
	}
}
