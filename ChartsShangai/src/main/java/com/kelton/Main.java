package com.kelton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main extends Application {

    String dataset = "2007 73\n" +
            "2008 68\n" +
            "2009 72\n" +
            "2010 72\n" +
            "2011 74\n" +
            "2012 73\n" +
            "2013 76\n" +
            "2014 73\n" +
            "2015 67\n" +
            "2016 56\n" +
            "2017 56";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        List<String> pairs = Arrays.asList(dataset.split("\n"));

        NumberAxis xAxis = new NumberAxis(2007, 2017, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");


        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        // create the data set that is going to be added to the line chart
        XYChart.Series data = new XYChart.Series();
        data.setName("Data");
        // and single points into the data set

        pairs.forEach((s -> {
            String[] info = s.split(" ");
            data.getData().add(new XYChart.Data(Integer.parseInt(info[0]), Double.parseDouble(info[1])));
        }));

        // add the data set to the line chart
        lineChart.getData().add(data);


        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
}
