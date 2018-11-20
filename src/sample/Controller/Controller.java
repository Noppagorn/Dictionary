package sample.Controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Dictionary.Vocabulary;
import sample.FormatTOXml;
import sample.JsonFormat;
import sample.MyFormatter;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML private Label labelShowType;
    @FXML private ScrollPane PaneShowWords;
    @FXML private Button addButton;
    @FXML private Button jsonButton;
    @FXML private  Button buttonDelete;
    @FXML private  Button xmlButton;
    @FXML private  Button buttonEdit;

    ArrayList<Vocabulary> words = null;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public Controller(){
        JsonFormat jsonFormat = new JsonFormat();
        words = jsonFormat.readFromJson();
    }

    private Text toText(MyFormatter myFormatter){
        return (Text)myFormatter;
    }
    @FXML
    public void initialize(){
        words = new JsonFormat().readFromJson();
        String json = gson.toJson(words);

        Text text = new Text(json);
        PaneShowWords.setContent(text);
        labelShowType.setText("JSON");
    }

    @FXML
    public void handleAddButton(ActionEvent event) throws IOException {
        System.out.println("click to add page");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/addPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControllerAddPage controller2 = fxmlLoader.getController();
        stage.show();
    }

    @FXML
    public void handleJsonButton(ActionEvent event){
        System.out.println("json");
        words = new JsonFormat().readFromJson();
        String json = gson.toJson(words);

        Text text = new Text(json);
        PaneShowWords.setContent(text);
        labelShowType.setText("JSON");
    }

    @FXML
    public void handleButtonDelete(ActionEvent event) throws IOException {
        System.out.println("delete");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/deletePage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControlDeletePage controller3 = fxmlLoader.getController();
        stage.show();
    }

    @FXML
    public void handleButtonEdit(ActionEvent event) throws IOException {
        System.out.println("Edit");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/EditPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControlEditPage controller = fxmlLoader.getController();
        stage.show();
    }

    @FXML
    public void handleButtonxml(ActionEvent event){
        System.out.println("XML");
        String xml = "";
        try {
             xml = new FormatTOXml().readXML();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Text text = new Text(xml);
        PaneShowWords.setContent(text);
        labelShowType.setText("XML");
    }

}
