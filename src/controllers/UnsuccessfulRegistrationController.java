package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UnsuccessfulRegistrationController {

    @FXML
    private Button btnCadastroInconcluido;

    @FXML
    void entendidoCadastroInconcluido(ActionEvent event) throws IOException{
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmls/Menu.fxml"))));
        window.centerOnScreen();
        window.setTitle("ChessQMate - MENU");
        window.show();
    }

}
