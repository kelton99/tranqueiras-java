package com.kelton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        barChart.setTitle("Populations of Nordic countries");
        barChart.setLegendVisible(false);

        XYChart.Series populations = new XYChart.Series();
        populations.getData().add(new XYChart.Data("Sweden", 10313447));
        populations.getData().add(new XYChart.Data("Denmark", 5809502));
        populations.getData().add(new XYChart.Data("Finland", 5537364));
        populations.getData().add(new XYChart.Data("Norway", 5372191));
        populations.getData().add(new XYChart.Data("Iceland", 343518));

        barChart.getData().add(populations);
        Scene scene = new Scene(barChart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
