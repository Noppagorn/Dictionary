package sample;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import sample.JSON.JsonFormat;

import java.util.ArrayList;

public class Controller {

    @FXML private Label labelShowType;
    @FXML private ScrollPane PaneShowWords;

    ArrayList<Vocabulary> words = null;
    public Controller(){
        JsonFormat jsonFormat = new JsonFormat();
        words = jsonFormat.readFromJson();
    }

    @FXML
    public void initialize(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(words);
        Text text = new Text(json);
        PaneShowWords.setContent(text);
    }

}
