package classes.vision;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import classes.pieces.Piece;

public class JPiece extends JLabel{ // Classe do visual da peça
    
    private Piece piece;

    public JPiece(Piece piece){
        this.piece = piece;
        this.setIcon(new ImageIcon(piece.getImage()));
    }

    public Piece getPiece(){ // Pega a peça em questão, servirá para verificações
        return this.piece;
    }
}
