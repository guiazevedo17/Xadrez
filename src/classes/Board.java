package classes;

import classes.pieces.ColorEnum;
import classes.pieces.Piece;

public class Board {
    
    private Piece[][] pieces;
    private Piece selectedPiece = null;
    private ColorEnum turn = ColorEnum.WHITE;

    public Board(int line, int column){ // Cria um tabuleiro
        this.pieces = new Piece[line][column];
    }

    public Piece getPiece(int line, int column){ // Retorna a peça que estiver na respectiva posição do tabuleiro, se houver
        return this.pieces[line][column];
    }

    public void addPiece(Piece piece){ // Adiciona uma peça ao tabuleiro
        this.pieces[piece.getLine()][piece.getColum()] = piece;
        piece.setBoard(this);
    }

    public void selectPiece(Piece piece){ // Seleciona uma peça
        if(piece.isSelected()){ // Caso a peça esteja selecionada, será deselecionada
            piece.setSelected(false);
            this.selectedPiece = null;
        } else { // Caso a peça ainda não esteja selecionada, será selecionada
            piece.setSelected(true);
            this.selectedPiece = piece;
        }
    }

    public void movePiece(Piece piece, int line, int column){ // Move a peça de posição

    }

    public void reverseTurn(){ // Inverte a vez, se o jogador 1 (branco) estiver jogando o próximo será o jogador 2 (preto) e vice-versa
        if(this.turn.equals(ColorEnum.WHITE)){
            this.turn = ColorEnum.BLACK;
        } else {
            this.turn = ColorEnum.WHITE;
        }
    }
}
