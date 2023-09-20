package com.kelton.overview;

import com.kelton.model.DataHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class OverViewPane extends BorderPane {

    private final OverViewTableView tableView = new OverViewTableView(DataHandler.INSTANCE.bookObservableList());
    private final OverViewLeftPane leftPane = new OverViewLeftPane(tableView);

    public OverViewPane() {
        this.setTop(new Text("In the table we can see the books for sale."));
        this.setLeft(this.leftPane);
        this.setCenter(this.tableView);
        this.setPrefSize(800, 600);
    }

    public void refreshData() {
        this.tableView.setItems(DataHandler.INSTANCE.bookObservableList());
    }
}
