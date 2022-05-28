package pl.milosz.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainController {

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Text winText;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

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
                (button1, button2, button3, button4, button5, button6, button7, button8, button9));

        buttons.forEach(this::setupButton);

        restartButton.addEventFilter(ActionEvent.ACTION, actionEvent -> resetartGame());

    }

    private void resetartGame() {
        buttons.forEach(this::resetButtons);
        winText.setText("");
    }

    private void resetButtons(Button button) {
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.addEventFilter(ActionEvent.ACTION, actionEvent -> {
            setSign(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    private void checkIfGameIsOver() {
        checkWinPattern();
    }

    private void checkWinPattern() {
        for (int i = 0; i < 8; i++) {
            String winPattern = switch (i) {
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button4.getText() + button7.getText();
                case 4 -> button2.getText() + button5.getText() + button8.getText();
                case 5 -> button3.getText() + button6.getText() + button8.getText();
                case 6 -> button3.getText() + button5.getText() + button7.getText();
                case 7 -> button1.getText() + button5.getText() + button9.getText();
                default -> null;
            };

            if (winPattern.equals("XXX")) {
                winText.setText("player X win!");
                break;
            } else if (winPattern.equals("OOO")){
                winText.setText("player O win!");
                break;
            }
        }
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
