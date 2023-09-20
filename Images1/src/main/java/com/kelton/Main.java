package com.kelton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Image imageFile = new Image("com/kelton/monalisa.jpg");

        PixelReader pixels = imageFile.getPixelReader();

        int width = (int) imageFile.getWidth();
        int height = (int) imageFile.getHeight();

        WritableImage[] targetImages = {
                new WritableImage(width, height),
                new WritableImage(width, height),
                new WritableImage(width, height),
                new WritableImage(width, height)
        };

        PixelWriter[] writers = new PixelWriter[4];

        for (int i = 0; i < 4; i++)
            writers[i] = targetImages[i].getPixelWriter();

        for (int i = 0; i < 4; i++) {
            for (int y = 0; y < height / 2; y++) {
                for (int x = 0; x < width / 2; x++) {
                    Color pixelColor = pixels.getColor(x * 2, y * 2);
                    double red = 1 - pixelColor.getRed();
                    double green = 1 - pixelColor.getGreen();
                    double blue = 1 - pixelColor.getBlue();
                    double opacity = pixelColor.getOpacity();

                    Color newColor = new Color(red, green, blue, opacity);

                    writers[i].setColor(x, y, newColor);
                }
            }
        }

        ImageView image0 = new ImageView(targetImages[0]);
        ImageView image1 = new ImageView(targetImages[1]);
        ImageView image2 = new ImageView(targetImages[2]);
        ImageView image3 = new ImageView(targetImages[3]);
        /*
        image.setRotate(180);
        image.setTranslateX(50);
        */

        ScrollPane pane = new ScrollPane();

        Pane frame = new Pane();
        frame.add(image1, width / 4, 0);
        frame.add(image2, 0, height / 4);
        frame.add(image3, width / 4, height / 4);

        pane.setContent(frame);
        Scene scene = new Scene(pane);

        stage.setScene(scene);

        stage.show();
    }
}
