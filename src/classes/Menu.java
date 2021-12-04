package classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Menu extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("ChessQMate - MENU");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmls/Menu.fxml"))));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("../images/icon.png")));
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}  