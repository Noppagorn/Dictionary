package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/sample.fxml"));
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Dictionary");
        primaryStage.setScene(new Scene(root, 600, 500));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
