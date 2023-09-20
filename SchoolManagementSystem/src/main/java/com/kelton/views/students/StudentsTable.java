package com.kelton.views.students;

import com.kelton.model.Student;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentsTable extends TableView<Student> {

	public StudentsTable() {
	}

	public StudentsTable(ObservableList<Student> items) {
		super(items);

		TableColumn<Student, String> registryColumn = new TableColumn<>("Registry");
		registryColumn.setCellValueFactory(new PropertyValueFactory<>("registry"));

		TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		this.getColumns().addAll(registryColumn, nameColumn);
	}
}
