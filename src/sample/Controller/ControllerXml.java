package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import sample.Dictionary.Dictionary;
import sample.Dictionary.Vocabulary;
import sample.MyFormatter;

import java.util.ArrayList;


public class ControllerXml {
    @FXML
    ScrollPane xmlPane;

    Dictionary dictionary = new Dictionary();
    ArrayList<Vocabulary> words;

    public void init(ArrayList<Vocabulary> words){
        this.words = words;
        String jsonString = dictionary.MyFormat(new MyFormatter() {
            @Override
            public String format(Object obj) {
                StringBuilder strbuil = new StringBuilder("<Dictionary>\n");
                for (Vocabulary x: words
                ) {
                    strbuil.append("\t<Vocab word=\"").append(x.getWord()).append("\">\n");
                    strbuil.append("\t\t<PartOfSpeech>").append(x.getPartOfSpeech()).append("</PartOfSpeech>\n");
                    strbuil.append("\t\t<Meaning>").append(x.getPartOfSpeech()).append("</Meaning>\n");
                    strbuil.append("\t\t<Example>").append(x.getPartOfSpeech()).append("</Example>\n");
                    strbuil.append("</Vocab>\n");
                }
                strbuil.append("</Dictionary>\n");
                return strbuil.toString();
            }
        });

        Text text = new Text(jsonString);
        xmlPane.setContent(text);

    }
}
