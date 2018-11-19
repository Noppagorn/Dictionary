package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ControllerStage {
    @FXML  private Stage stage;

    public void saveStage(Stage st){
        this.stage = st;
    }
}
