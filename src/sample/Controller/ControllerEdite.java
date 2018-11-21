package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Dictionary.Vocabulary;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerEdite {
    @FXML
    TextField textWord;
    @FXML TextField textPOS;
    @FXML TextField textMean;
    @FXML TextField textExample;
    @FXML Button buttonFind;
    @FXML Button addButton;

    ArrayList<Vocabulary> words;
    Runnable callback;

    public void init(ArrayList<Vocabulary> words, Runnable callback) {
        this.words = words;
        this.callback = callback;
    }
    @FXML
    public void handleButtonadd(ActionEvent event) throws IOException {
        System.out.println("button2");
        for (Vocabulary x: words) {
            if (x.getWord().equals(textWord.getText())){
                x.setPartOfSpeech(textPOS.getText());
                x.setMeaning(textMean.getText());
                x.setExample(textExample.getText());
            }
        }
        textWord.setText("");
        textPOS.setText("");
        textMean.setText("");
        textExample.setText("");

        callback.run();
    }

    @FXML
    public void handleFindbutton(ActionEvent event) throws IOException {
        System.out.println("Find");
        for (Vocabulary x: words) {
            if (x.getWord().equals(textWord.getText())){
                textPOS.setText(x.getPartOfSpeech());
                textMean.setText(x.getMeaning());
                textExample.setText(x.getExample());
            }
        }
    }
}
