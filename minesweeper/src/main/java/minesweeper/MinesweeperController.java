package minesweeper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MinesweeperController {

    private Minefield minefield;

    @FXML
    private TextField text;
    @FXML
    private TextField score;
    @FXML
    private GridPane minefieldGridPane;

    @FXML
    private void initialize() {
        minefield = new Minefield(9, 9, minefieldGridPane);
    }

    @FXML
    private void handleRestart() {
        //Restart board
    }

    @FXML
    private void handleClickedSquare(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button button) {
            Integer x = GridPane.getColumnIndex(button);
            Integer y = GridPane.getRowIndex(button);
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                handleLeftClickedSquare(x, y);
            }
            else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                handleRightClickedSquare(x, y);
            }
        }
    }

    private void handleLeftClickedSquare(Integer x, Integer y) {
        //Check square
    }

    private void handleRightClickedSquare(Integer x, Integer y) {
        minefield.toggleFlag(x, y);
    }

    @FXML
    private void handleSubmit() {
        String str = text.getText();
        String num = score.getText();
        new FileTreater().writeToFile(str, num);
    }
}
