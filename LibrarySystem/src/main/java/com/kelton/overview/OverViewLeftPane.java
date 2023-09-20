package com.kelton.overview;

import com.kelton.CustomEvent;
import com.kelton.model.Book;
import com.kelton.model.DataHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

import java.util.Optional;

public class OverViewLeftPane extends VBox {

    private final Button createBookButton;
    private final Button deleteBookButton;
    private final OverViewTableView overViewTableView;

    public OverViewLeftPane(OverViewTableView overViewTableView) {
        this.setSpacing(10);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.createBookButton = new Button("Create");
        this.deleteBookButton = new Button("Delete");
        this.overViewTableView = overViewTableView;
        this.getChildren().addAll(createBookButton, deleteBookButton);

        this.createBookButton.setOnAction(e -> {
            fireEvent(new CustomEvent(CustomEvent.goToCreateScene));
        });

        this.deleteBookButton.setOnAction(e -> {
            System.out.println("Delete Book BEGIN");

            Book selectedBook = overViewTableView.getSelectionModel().getSelectedItem();

            if(selectedBook == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("No book selected!");
                alert.showAndWait();
                return;
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you want to delete the book?");
            alert.setHeaderText(selectedBook.toString());
            alert.setTitle("Delete book?");
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get() == ButtonType.OK) {
                DataHandler.INSTANCE.deleteBook(selectedBook);
                overViewTableView.setItems(DataHandler.INSTANCE.bookObservableList());
            }
            System.out.println("Delete Book END");
        });

    }
}
