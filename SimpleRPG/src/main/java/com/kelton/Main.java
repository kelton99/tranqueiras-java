package com.kelton;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {

    Player player = new Player("Kelton", 100, 10, 10);

    private static Location location = Location.Town;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(600, 600);

        ImageView background = new ImageView("com/kelton/sla.png");
        background.setFitHeight(layout.getPrefWidth());
        background.setFitWidth(layout.getPrefHeight());
        background.setPreserveRatio(true);

        HBox infoBar = new HBox();
        infoBar.setPadding(new Insets(10, 10, 10, 10));
        infoBar.setSpacing(10);

        ImageView portrait = new ImageView("com/kelton/portrait.jpg");
        portrait.setFitHeight(100);
        portrait.setFitWidth(100);
        portrait.setPreserveRatio(true);

        VBox statusBox = new VBox();
        Text charName = new Text(player.getName());
        Text hpText = new Text(String.format("HP %d", player.getHp()));
        Text attackText = new Text(String.format("Attack %d", player.getAttack()));
        Text defenseText = new Text(String.format("Defense %d", player.getDefense()));
        Text goldText = new Text(String.format("Gold %d", player.getGold()));
        statusBox.getChildren().addAll(charName, hpText, attackText, defenseText, goldText);

        Text locationText = new Text(location.name());

        TextArea narration = new TextArea("A great adventure await you, Hero\n");
        narration.setPrefSize(350, 50);
        narration.setEditable(false);

        AtomicReference<VBox> actions = new AtomicReference<>();
        VBox townActions = new VBox();
        VBox fieldActions = new VBox();
        VBox combatActions = new VBox();
        infoBar.setAlignment(Pos.BOTTOM_LEFT);

        Button rest = new Button("Rest");
        rest.setOnAction(e -> {
            player.rest();
            narration.setText(narration.getText() + "You feel rested, ready for coming battles\n");
        });

        Button upgrades = new Button("Upgrades");
        Button toField = new Button("To Field");
        toField.setOnAction(e -> {
            location = Location.Field;
            narration.setText(narration.getText() + "Out of town, there is green as far as you can see." +
                    " But beware, there is danger for the common man\n");
            actions.set(fieldActions);
        });
        townActions.getChildren().addAll(rest, upgrades, toField);


        Button toTown = new Button("To Town");
        toTown.setOnAction(e -> {
            location = Location.Town;
            narration.setText(narration.getText() + "After a long day hunting, you return to the city and see the result of your work\n");
        });
        Button hunt = new Button("Hunt");
        fieldActions.getChildren().addAll(toTown, hunt);


        Button attackButton = new Button("Attack");
        Button fleeButton = new Button("Flee");
        combatActions.getChildren().addAll(attackButton, fleeButton);

        actions.set(townActions);
        infoBar.getChildren().addAll(portrait, statusBox, narration);
        layout.setRight(actions.get());
        layout.setCenter(background);
        layout.setBottom(infoBar);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

    }

    private enum Location {
        Town,
        Field,
    }
}
