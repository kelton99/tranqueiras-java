package com.kelton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setScene(new Scene(new LoginScreen()));
        stage.show();
    }

    public static void changeToLoggedIn() {
        stage.setScene(new Scene(new MessagePane()));
    }
}