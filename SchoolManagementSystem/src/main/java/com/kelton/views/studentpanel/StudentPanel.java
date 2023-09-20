package com.kelton.views.studentpanel;

import com.kelton.Main;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class StudentPanel extends HBox {

	private final ImageView portrait = new ImageView("com/kelton/preto.jpg");
	private final StudentInfo info = new StudentInfo();

	public StudentPanel() {
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
		this.setPrefSize(Main.screenWidth, Main.screenHeight);
		portrait.setFitHeight(4 * 50);
		portrait.setFitWidth(3 * 50);
		portrait.setPreserveRatio(true);
		this.getChildren().addAll(portrait, info);

	}
}
