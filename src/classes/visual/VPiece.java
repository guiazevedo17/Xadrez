package classes.visual;

import classes.pieces.Piece;

public class VPiece { // Classe do visual da peça
    
    private Piece piece;

    public VPiece(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece(){ // Pega a peça em questão, servirá para verificações
        return this.piece;
    }
}
