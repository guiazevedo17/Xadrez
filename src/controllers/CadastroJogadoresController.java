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

public class CadastroJogadoresController {

    @FXML
    private TextField txtJogador1, txtJogador2;

    @FXML
    private Button btnCadastrar;

    public static String jogador1 = "", jogador2 = "";

    public static boolean cadastroCorreto = false;

    @FXML
    void finalizarCadastro(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        jogador1 = txtJogador1.getText();
        jogador2 = txtJogador2.getText();

        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmls/Menu.fxml"))));
        window.setTitle("ChessQMate - MENU");
        window.show();
    }

    public static void verificaCadastro(){
        cadastroCorreto = true;
        
        if(jogador1.isEmpty() == true || jogador2.isEmpty() == true)
            cadastroCorreto = false;
    }

}