package sample.Controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Dictionary.Dictionary;
import sample.Dictionary.Vocabulary;

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

    @FXML TableView<Vocabulary> tableViewVocab;
    @FXML
    TableColumn<Vocabulary,String> columWord;
    @FXML TableColumn<Vocabulary,String> columnPOS;

    @FXML TableColumn<Vocabulary,String> columnMeaning;
    @FXML TableColumn<Vocabulary,String> columnExample;

    ArrayList<Vocabulary> words = null;
    Dictionary dictionary = null;
    public Controller(){
        System.out.println("control");
    }



    @FXML
    public void initialize(){
        words = new Dictionary().getWords();
        dictionary = new Dictionary();
        showAllColumn();
    }

    public void showAllColumn(){
        update();
        columWord.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getWord()));

        columnPOS.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPartOfSpeech()));
        columnMeaning.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getMeaning()));

        columnExample.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getExample()));
    }

    private void update(){
        ObservableList<Vocabulary> subjectsObs = FXCollections.observableArrayList(words);
        tableViewVocab.getItems().clear();
        tableViewVocab.setItems(subjectsObs);
        dictionary.writeTofile(words);
    }


    @FXML
    public void handleJsonButton(ActionEvent event) throws IOException {
        for (Vocabulary x: words
             ) {
            System.out.println(x.getWord());
        }
        System.out.println("Json");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/jsonPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControllerJson controller = fxmlLoader.getController();
        controller.init(words);

        stage.show();
    }

    @FXML
    public void handleXmlButton(ActionEvent event) throws IOException {
        System.out.println("xml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/xmlPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControllerXml controller = fxmlLoader.getController();
        controller.init(words);
        stage.show();
    }

    @FXML
    public void handleAddButton(ActionEvent event) throws IOException {
        System.out.println("xml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/addPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControllerAdd controller = fxmlLoader.getController();
        controller.init(words, this::update);
        stage.show();

    }

    @FXML
    public void handleDeleteButton(ActionEvent event){

        buttonDelete.setOnAction(e -> {
            Vocabulary selectedItem = tableViewVocab.getSelectionModel().getSelectedItem();
            tableViewVocab.getItems().remove(selectedItem);
            words.remove(selectedItem);
            update();
        });
    }

    @FXML
    public void handleAddEdit(ActionEvent event) throws IOException {
        System.out.println("Edit");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/EditPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControllerEdite controller = fxmlLoader.getController();
        controller.init(words, this::update);
        stage.show();

    }




}
