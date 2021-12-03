package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController{

    @FXML
    private Button btnCadastrarJogador, btnIniciarPartida;

    @FXML
    public void cadastrarJogadores(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmls/CadastroJogadores.fxml"))));
        window.setTitle("ChessQMate - CADASTRO JOGADORES");
        window.show();
    }

    @FXML
    public void iniciarPartida(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmls/Tabuleiro.fxml"))));
        window.setTitle("ChessQMate - TABULEIRO");
        window.show();
    }
}
