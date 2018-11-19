package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Dictionary.Vocabulary;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ControlDeletePage {
    @FXML Button deleteButton;
    @FXML TextField deleteTextfield;

    ArrayList<Vocabulary> words = null;
    public  ControlDeletePage(){
        JsonFormat jsonFormat = new JsonFormat();
        words = jsonFormat.readFromJson();
    }
    @FXML
    public void handleDeleteButton(ActionEvent event){
        String word = deleteTextfield.getText();
        deleteTextfield.setText("");
        if (!checkWord(word)){
            throw  new NoSuchElementException("Not have " + word);
        }
        int i = 0;
        for ( ; i < words.size();i++){
            if (words.get(i).getWord().equals(word)){
                break;
            }
        }
        words.remove(i);
        new JsonFormat().writeToJson(words);
        new FormatTOXml().writeXML(words);
    }

    private boolean checkWord(String word){
        for (int i = 0 ; i < words.size();i++){
            if (words.get(i).getWord().equals(word)){
                return true;
            }
        }
        return  false;
    }


}
