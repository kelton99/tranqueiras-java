package com.kelton;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LoginScreen extends GridPane {

    private TextField userField = new TextField();
    private PasswordField passwordField = new PasswordField();
    Text errorText = new Text();

    public LoginScreen() {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setHgap(5);
        this.setVgap(5);


        Label userLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");

        Button loginButton = new Button("Button");

        loginButton.setOnAction(this::login);

        this.add(userLabel, 0, 0);
        this.add(userField, 1, 0);

        this.add(passwordLabel, 0, 1);
        this.add(passwordField, 1, 1);

        this.add(loginButton, 0, 2);
        this.add(errorText, 1, 2);
    }

    private void login(ActionEvent actionEvent) {
        if (userField.getText().equals("user") && passwordField.getText().equals("123")) {
            Main.changeToLoggedIn();
        } else {
            errorText.setText("Invalid username or password!");
        }
    }
}
