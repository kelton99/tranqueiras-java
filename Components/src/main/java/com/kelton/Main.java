package com.kelton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane exercisePane = new BorderPane();
        HBox exerciseBox = new HBox();
        TextArea textArea = new TextArea("");
        Label characterLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Letters: 0");
        Label longestLabel = new Label("Letters: 0");


        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            characterLabel.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + words);
            longestLabel.setText("The longest word is: " + longest);
        });

        exerciseBox.setSpacing(10);
        exerciseBox.getChildren().addAll(characterLabel, wordsLabel, longestLabel);

        exercisePane.setCenter(textArea);
        exercisePane.setBottom(exerciseBox);



        Scene view = new Scene(exercisePane);
        stage.setScene(view);
        stage.show();
    }
}
