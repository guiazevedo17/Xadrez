package controllers;

import classes.Board;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BoardController{

    @FXML
    private Label lblPlayerName, lblPlayerNumber;
    
    private Board board;

    public BoardController(Board board){
        this.board = board;
    }

    

}