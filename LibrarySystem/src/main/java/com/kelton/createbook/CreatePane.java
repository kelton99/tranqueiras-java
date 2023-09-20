package com.kelton.createbook;

import javafx.scene.layout.BorderPane;

public class CreatePane extends BorderPane {

    private final CreateInputPane createInputPane = new CreateInputPane();
    private final CreateBottomPane bottomPane = new CreateBottomPane(createInputPane);

    public CreatePane() {
        this.setCenter(createInputPane);
        this.setBottom(bottomPane);
    }
}
