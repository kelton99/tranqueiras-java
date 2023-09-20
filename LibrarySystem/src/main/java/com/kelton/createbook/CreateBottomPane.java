package com.kelton.createbook;

import com.kelton.CustomEvent;
import com.kelton.model.DataHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class CreateBottomPane extends HBox {

    private final Button cancel = new Button("Cancel");
    private final Button ok = new Button("OK");
    private final CreateInputPane inputPane;

    public CreateBottomPane(CreateInputPane inputPane) {
        this.inputPane = inputPane;
        cancel.setOnAction(e -> {
            fireEvent(new CustomEvent(CustomEvent.goToOverviewScene));
        });

        ok.setOnAction(e -> {
            DataHandler.INSTANCE.createBook(inputPane.book());
            fireEvent(new CustomEvent(CustomEvent.goToOverviewScene));
        });

        this.getChildren().addAll(cancel, ok);
    }

}