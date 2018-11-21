package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import sample.Dictionary.Dictionary;
import sample.Dictionary.Vocabulary;
import sample.MyFormatter;

import java.util.ArrayList;


public class ControllerJson {
//
    ArrayList<Vocabulary> words = null;
    @FXML
    ScrollPane jsonPane;

    Dictionary dictionary = new Dictionary();


    public void init(ArrayList<Vocabulary> words){
        this.words = words;
        String jsonString = dictionary.MyFormat(new MyFormatter() {
            @Override
            public String format(Object obj) {
                StringBuilder strbuil = new StringBuilder("[\n");
                for (Vocabulary x: words
                     ) {
                    strbuil.append("\t{\n");
                    strbuil.append("\t\tvocab: \"").append(x.getWord()).append("\",\n");
                    strbuil.append("\t\tpartOfSpeech: \"").append(x.getPartOfSpeech()).append("\",\n");
                    strbuil.append("\t\tmeaning: \"").append(x.getMeaning()).append("\",\n");
                    strbuil.append("\t\texample: \"").append(x.getExample()).append("\",\n");
                    strbuil.append("\t},\n");
                }
                strbuil.append("]\n");
                return strbuil.toString();
            }
        });

        Text text = new Text(jsonString);
        jsonPane.setContent(text);

    }

}
