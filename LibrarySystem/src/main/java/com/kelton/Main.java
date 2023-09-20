package com.kelton;

import com.kelton.createbook.CreateScene;
import com.kelton.overview.OverViewScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private final OverViewScene overViewScene = new OverViewScene();
	private final CreateScene createScene = new CreateScene();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		overViewScene.addEventFilter(CustomEvent.goToCreateScene, e -> {
			stage.setScene(createScene);
		});
		createScene.addEventFilter(CustomEvent.goToOverviewScene, e -> {
			stage.setScene(overViewScene);
			overViewScene.refreshData();
		});

		stage.setTitle("Bookstore App");
		stage.setScene(this.overViewScene);
		stage.show();
	}
}