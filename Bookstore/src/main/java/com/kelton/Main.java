package com.kelton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		final LoginScreen loginScreen = new LoginScreen();
		loginScreen.addEventFilter(CustomEvent.loginSuccessful, e -> {
			stage.setScene(new Scene(new Dashboard()));
		});
		Scene scene = new Scene(loginScreen);
		stage.setScene(scene);
		stage.show();
	}
}
