package com.kelton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Main extends Application {

    private String votes = "KOK\t16.1\t18.1\t20.9\t22.9\t23.0\t22.9\t19.1\t21.6\t20.8\t21.8\t23.4\n" +
            "SDP\t23.9\t27.1\t24.8\t25.5\t24.7\t25.2\t27.1\t24.5\t23.0\t24.1\t21.2\n" +
            "KESK\t18.9\t18.0\t18.4\t18.7\t20.2\t21.1\t19.2\t21.8\t23.8\t22.8\t20.1\n" +
            "VIHR\t-\t-\t-\t-\t2.8\t2.3\t6.9\t6.3\t7.7\t7.4\t8.9\n" +
            "VAS\t16.9\t17.5\t18.5\t16.6\t13.1\t12.6\t11.7\t10.4\t9.9\t9.6\t8.8\n" +
            "PS\t7.3\t5.0\t2.1\t3.0\t5.3\t3.6\t2.4\t0.9\t0.7\t0.9\t5.4\n" +
            "RKP\t5.6\t5.2\t4.7\t4.7\t5.1\t5.3\t5.0\t5.4\t5.1\t5.2\t4.7";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        String rows = "1968\t1972\t1976\t1980\t1984\t1988\t1992\t1996\t2000\t2004\t2008";
        List<String> years = Arrays.asList(rows.split("\t"));

        List<String> parties = Arrays.asList(votes.split("\n"));

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support in the years 1968-2008");

        parties.forEach((p) -> {
            String[] pieces = p.split("\t");

            XYChart.Series data = new XYChart.Series();
            data.setName(pieces[0]);
            for (int i = 0; i < years.size() - 1; i++) {
                if(pieces[i + 1].equals("-"))
                    continue;
                data.getData().add(new XYChart.Data(Integer.parseInt(years.get(i)), Double.parseDouble(pieces[i + 1]) ));
            }

            lineChart.getData().add(data);
        });


        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
}
