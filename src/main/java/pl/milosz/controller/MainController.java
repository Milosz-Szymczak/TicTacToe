package pl.milosz.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainController {

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem restartMenuItem;

    @FXML
    private Button restartButton;

    private ArrayList<Button> buttons;
    private int playerMove = 0;

    public void initialize() {
        buttons = new ArrayList(Arrays.asList
                (button00, button01, button02, button10, button11, button12, button20, button21, button22));

        buttons.forEach(this::setupButton);

    }

    private void setupButton(Button button) {
        button.addEventFilter(ActionEvent.ACTION, actionEvent -> {
            setSign(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    private void checkIfGameIsOver() {

    }

    private void setSign(Button button) {
        if (playerMove == 0) {
            button.setText("X");
            playerMove = 1;
        } else {
            button.setText("O");
            playerMove = 0;
        }
    }

}
