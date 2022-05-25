module TicTacToe {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    exports pl.milosz.main;
    opens pl.milosz.controller to javafx.fxml;
}