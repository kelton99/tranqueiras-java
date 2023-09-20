package com.kelton;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class MessagePane extends BorderPane {

    public MessagePane() {
        this.setPrefSize(300, 300);
        Text message = new Text("You are logged in!");
        this.setCenter(message);
    }
}