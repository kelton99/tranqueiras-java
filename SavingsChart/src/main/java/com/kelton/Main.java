package com.kelton;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));

        VBox layoutTop = new VBox();
        layoutTop.setSpacing(20);
        layoutTop.setPadding(new Insets(10, 10, 10, 10));
        BorderPane savingsPane = new BorderPane();
        Label savingsLabel = new Label("Monthly savings");
        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setShowTickMarks(true);
        Label savingsSliderDescriber = new Label("" + savingsSlider.getValue());
        savingsPane.setLeft(savingsLabel);
        savingsPane.setCenter(savingsSlider);
        savingsPane.setRight(savingsSliderDescriber);

        BorderPane interestPane = new BorderPane();
        Label interestLabel = new Label("Yearly interest rate");
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(true);
        Label interestSliderDescriber = new Label("" + interestSlider.getValue());
        interestPane.setLeft(interestLabel);
        interestPane.setCenter(interestSlider);
        interestPane.setRight(interestSliderDescriber);

        layoutTop.getChildren().addAll(savingsPane, interestPane);


        NumberAxis xAxis = new NumberAxis(0, 30, 2);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        XYChart.Series savingsData = new XYChart.Series();
        XYChart.Series interestData = new XYChart.Series();

        savingsSlider.setOnMouseDragged((e) -> {
            savingsSliderDescriber.setText(String.format("%.2f", savingsSlider.getValue()));
            savingsData.getData().clear();
            interestData.getData().clear();
            for (int i = 0; i < 31; i++) {
                double result = savingsSlider.getValue() * i * 12;
                savingsData.getData().add(new XYChart.Data(i, result));
                interestData.getData().add(new XYChart.Data(i, result + (result * (interestSlider.getValue() / 100) * i ) ));
            }
        });

        interestSlider.setOnMouseDragged((e) -> {
            interestSliderDescriber.setText(String.format("%.2f", interestSlider.getValue()));
            interestData.getData().clear();
            for (int i = 0; i < 31; i++) {
                double result = savingsSlider.getValue() * i * 12;
                interestData.getData().add(new XYChart.Data(i, result + (result * (interestSlider.getValue() / 100) * i )));
            }
        });

        chart.getData().addAll(savingsData, interestData);
        layout.setTop(layoutTop);
        layout.setCenter(chart);

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }

    void fillSavings() {

    }
}
