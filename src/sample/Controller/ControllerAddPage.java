package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Dictionary.Vocabulary;

import java.util.ArrayList;

public class ControllerAddPage {
    @FXML Button buttonControll2;
    @FXML TextField textWord;
    @FXML TextField textPOS;
    @FXML TextField textMean;
    @FXML TextField textExample;
    ArrayList<Vocabulary> words = null;
    public ControllerAddPage(){
        JsonFormat jsonFormat = new JsonFormat();
        words = jsonFormat.readFromJson();
    }
    @FXML
    public void handleButtonadd(ActionEvent event){
        System.out.println("button2");
        JsonFormat jsonFormat = new JsonFormat();
        Vocabulary toAdd = new Vocabulary(textWord.getText()
                ,textPOS.getText(),textMean.getText(),textExample.getText());
        words.add(toAdd);
        jsonFormat.writeToJson(words);
        new FormatTOXml().writeXML(words);
        textWord.setText("");
        textPOS.setText("");
        textMean.setText("");
        textExample.setText("");

    }
}
