package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayersRegistrationController {

    @FXML
    private TextField txtPlayer1, txtPlayer2;

    @FXML
    private Button btnRegister;

    public static String player1 = "", player2 = "";

    public static boolean successfulRegistration = false;

    @FXML
    void finishRegistration(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        player1 = txtPlayer1.getText();
        player2 = txtPlayer2.getText();

        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmls/Menu.fxml"))));
        window.setTitle("ChessQMate - MENU");
        window.show();
    }

    public static void checkRegistration(){
        successfulRegistration = true;
        
        if(player1.isEmpty() == true || player2.isEmpty() == true)
            successfulRegistration = false;
    }

}