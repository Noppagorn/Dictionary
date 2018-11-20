package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Dictionary.Vocabulary;

import java.util.ArrayList;

public class ControlEditPage {
    @FXML
    Button buttonControll2;
    @FXML
    TextField textWord;
    @FXML TextField textPOS;
    @FXML TextField textMean;
    @FXML TextField textExample;
    @FXML Button buttonFind;
    ArrayList<Vocabulary> words = null;
    public ControlEditPage(){
        JsonFormat jsonFormat = new JsonFormat();
        words = jsonFormat.readFromJson();
    }

    @FXML
    public void handlebuttonFind(ActionEvent event){
        String tofind = textWord.getText();
        for (Vocabulary x: words
             ) {
            if (x.getWord().equals(tofind)){
                textPOS.setText(x.getPartOfSpeech());
                textMean.setText(x.getMeaning());
                textExample.setText(x.getExample());
            }
        }
    }

    @FXML
    public void handleButtonEdit(ActionEvent event){
        System.out.println("button2");
        JsonFormat jsonFormat = new JsonFormat();

        for (Vocabulary x: words
             ) {
            if (textWord.getText().equals(x.getWord())){
                x.setPartOfSpeech(textPOS.getText());
                x.setMeaning(textMean.getText());
                x.setExample(textExample.getText());
            }
        }

        jsonFormat.writeToJson(words);
        new FormatTOXml().writeXML(words);
        textWord.setText("");
        textPOS.setText("");
        textMean.setText("");
        textExample.setText("");

    }
}
