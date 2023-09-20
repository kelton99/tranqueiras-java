package com.kelton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        Application.launch(Main.class,
                "--organization=Once upon a time",
                        "--course=" + title);
    }

    @Override
    public void start(Stage stage) {
        FlowPane fp = new FlowPane();
        Scene scene = new Scene(fp);

        Parameters params = getParameters();
        String organization = params.getNamed().get("organization");
        String course = params.getNamed().get("course");

        stage.setScene(scene);
        stage.setTitle(organization + ": " + course);
        stage.show();
    }
}
