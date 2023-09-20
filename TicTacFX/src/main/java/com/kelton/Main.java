package com.kelton;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private String currentPlayer = "X";
    private int[][] winningPositions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {2, 4, 6}, {0, 4, 8}
    };
    private int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private boolean isRunning = true;
    private int turnCounter = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        Label turnLabel = new Label("Turn: X");
        turnLabel.setFont(Font.font("Monospaced", 40));

        GridPane playground = new GridPane();

        playground.setPadding(new Insets(10, 10, 10, 10));
        playground.setHgap(10);
        playground.setVgap(10);

        int id = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));
                btn.setId("" + id++);
                System.out.println(btn.getId());
                playground.add(btn, i, j);
                btn.setOnAction((event) -> {

                    if(isRunning)
                        move(btn);

                    if(hasWon()) {
                        turnLabel.setText(currentPlayer + " has won!");
                    } else if(turnCounter > 8) {
                        turnLabel.setText("Draw");
                    } else {
                        currentPlayer = (currentPlayer == "X") ? "O" : "X";
                        turnLabel.setText("Turn: " + currentPlayer);
                    }
                });
            }
        }

        layout.setTop(turnLabel);
        layout.setCenter(playground);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    private boolean hasWon() {

        for(int[] pos : winningPositions) {
            if (board[pos[0]] == board[pos[1]] &&
                    board[pos[1]] == board[pos[2]] && board[pos[0]] != 0) {
                isRunning = false;
                return true;
            }
        }
        return false;
    }

    private void move(Button btn) {
        if (btn.getText() == " ") {
            btn.setText(currentPlayer);
            board[Integer.parseInt(btn.getId())] = (currentPlayer == "X") ? 1 : 2;
            turnCounter++;
        }
    }
}
