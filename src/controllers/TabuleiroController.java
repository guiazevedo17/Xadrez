package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class TabuleiroController implements Initializable{

    @FXML
    private Label lblNomeJogador;

    @FXML
    private Label lblNumJogador;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblNomeJogador.setText(CadastroJogadoresController.jogador1);
        
    }

    

}