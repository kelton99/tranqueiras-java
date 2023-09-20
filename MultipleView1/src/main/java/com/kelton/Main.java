package com.kelton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.border.Border;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Label("First View"));
        Button toSecond = new Button("To the second view!");
        borderPane.setCenter(toSecond);

        VBox vbox = new VBox();
        Label label2 = new Label("Second View!");
        Button toThird = new Button("To the third view!");
        vbox.getChildren().addAll(toThird, label2);

        GridPane gridPane = new GridPane();
        Label label3 = new Label("Third View!");
        Button toFirst = new Button("To First!");

        gridPane.add(label3, 0, 0);
        gridPane.add(toFirst, 1, 1);

        Scene scene1 = new Scene(borderPane);
        Scene scene2 = new Scene(vbox);
        Scene scene3 = new Scene(gridPane);

        toSecond.setOnAction(event -> stage.setScene(scene2));
        toThird.setOnAction(event -> stage.setScene(scene3));
        toFirst.setOnAction(event -> stage.setScene(scene1));

        stage.setScene(scene1);
        stage.show();
    }
}
