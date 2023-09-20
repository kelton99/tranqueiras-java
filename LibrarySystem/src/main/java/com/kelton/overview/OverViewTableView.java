package com.kelton.overview;

import com.kelton.model.Book;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class OverViewTableView extends TableView<Book> {
    public OverViewTableView(ObservableList<Book> items) {
        super(items);
        TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory("title"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory("author"));

        TableColumn<Book, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
    
        getColumns().addAll(titleColumn, authorColumn, priceColumn);
    }
}
