package com.mooc.kelton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label textComponent = new Label("Name:");
        TextField nameField = new TextField();
        Button button = new Button("Submit");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(textComponent);
        componentGroup.getChildren().add(nameField);
        componentGroup.getChildren().add(button);

        Scene scene = new Scene(componentGroup);

        stage.setScene(scene);
        stage.show();
    }
}
