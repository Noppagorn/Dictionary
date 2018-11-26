package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Dictionary.Dictionary;
import sample.Dictionary.Vocabulary;

import java.io.IOException;
import java.util.ArrayList;
public class ControllerAdd {
        @FXML
        Button buttonControll2;
        @FXML
        TextField textWord;
        @FXML TextField textPOS;
        @FXML TextField textMean;
        @FXML TextField textExample;
        @FXML Label emtryText;
        ArrayList<Vocabulary> words;
        Runnable callback;

    public void init(ArrayList<Vocabulary> words, Runnable callback) {
        this.words = words;
        this.callback = callback;
    }

    @FXML
        public void handleButtonadd(ActionEvent event){
            if (textWord.getText().equals("") || textPOS.getText().equals("") || textMean.getText().equals("") || textExample.getText().equals("") ){
                emtryText.setText("Invalid Vocab");
                throw  new RuntimeException("emtryText");

            }
            Vocabulary toAdd = new Vocabulary(textWord.getText()
                    ,textPOS.getText(),textMean.getText(),textExample.getText());
            words.add(toAdd);
            textWord.setText("");
            textPOS.setText("");
            textMean.setText("");
            textExample.setText("");

            for (Vocabulary x: words) {
                System.out.println(x.getWord());
            }
            callback.run();
        }
    }
