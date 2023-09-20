package com.kelton;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        AudioClip sound = new AudioClip("com/kelton/buzzer.wav");
        sound.play();
        stage.show();
    }
}
