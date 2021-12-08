package classes.vision;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;

public class JSquare extends JPanel{ // Quadrados das respectivas posições do tabuleiro
    
    private JPiece jPiece;
    private int line, column;

    public JSquare(int line, int column){
        this.line = line;
        this.column = column;
    }

    public JSquare(JPiece jPiece){
        this.jPiece = jPiece;
        this.line = jPiece.getPiece().getLine();
        this.column = jPiece.getPiece().getColumn();
        
        this.add(jPiece);

        if(jPiece.getPiece() != null){
            if(jPiece.getPiece().isSelected()){
                this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            }
            /*
            if(jPiece.getPiece().isPossible()){
                this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
            }

            if(jPiece.getPiece().isCapturable()){
                this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            }
            */
        }
    }

    public int getLine(){
        return this.line;
    }

    public int getColumn(){
        return this.column;
    }
}
