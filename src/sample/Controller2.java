package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.swing.*;

public class Controller2 {
    @FXML Button buttonControll2;


    @FXML
    public void handleButtonControll2(ActionEvent event){
        System.out.println("button2");
    }
}
