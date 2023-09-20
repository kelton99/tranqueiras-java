package com.kelton;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
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
        TextField leftText = new TextField();
        Button button = new Button("Copy");
        TextField rightText = new TextField();
        Label label = new Label();

        button.setOnAction((event) -> {
            label.setText(leftText.getText());
        });

        leftText.textProperty().addListener((observableValue, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            label.setText("" + words);
            rightText.setText(longest);
        });

        VBox componentGroup = new VBox();
        componentGroup.setSpacing(20);
        componentGroup.getChildren().addAll(leftText, button, label, rightText);

        Scene scene = new Scene(componentGroup);
        stage.setScene(scene);
        stage.show();
    }
}
