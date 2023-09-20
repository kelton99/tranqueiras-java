package com.kelton;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label instructionText = new Label("Enter your name and start");
        Label greetings = new Label();
        TextField textField = new TextField();
        Button startButton = new Button("Start");

        // 1.2 creating layout and adding components to it
        GridPane layout = new GridPane();

        layout.add(instructionText, 0, 0);
        layout.add(textField, 0, 1);
        layout.add(startButton, 0, 2);

        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        GridPane layout2 = new GridPane();

        layout2.add(greetings, 0, 0);

        layout2.setPrefSize(300, 180);
        layout2.setAlignment(Pos.CENTER);
        layout2.setVgap(10);
        layout2.setHgap(10);
        layout2.setPadding(new Insets(20, 20, 20, 20));

        Scene scene1 = new Scene(layout);
        Scene scene2 = new Scene(layout2);
        startButton.setOnAction(actionEvent -> {
            greetings.setText(textField.getText());
            stage.setScene(scene2);
        });

        stage.setScene(scene1);
        stage.show();
    }
}
