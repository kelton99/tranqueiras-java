package com.kelton.createbook;

import com.kelton.model.Book;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class CreateInputPane extends GridPane {

	private final Text titleText = new Text("Title");
	private final Text authorText = new Text("Author");
	private final Text priceText = new Text("Price");

	private final TextField title = new TextField("NOT_SET");
	private final TextField author = new TextField("NOT_SET");
	private final TextField price = new TextField("NOT_SET");

	public CreateInputPane() {
		ColumnConstraints c1 = new ColumnConstraints(200);
		ColumnConstraints c2 = new ColumnConstraints(300);
		c2.setHgrow(Priority.ALWAYS);
		this.getColumnConstraints().addAll(c1, c2);

		this.add(titleText, 0, 0);
		this.add(title, 1, 0);

		this.add(authorText, 0, 1);
		this.add(author, 1, 1);

		this.add(priceText, 0, 2);
		this.add(price, 1, 2);
	}

	public Book book() {
		return new Book(title.getText(), author.getText(), Double.parseDouble(price.getText()));
	}
}
