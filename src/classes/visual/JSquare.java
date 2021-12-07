package classes.visual;

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

        if(jPiece.getPiece() != null && jPiece.getPiece().isSelected()){
            this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        }
    }

    public int getLine(){
        return this.line;
    }

    public int getColumn(){
        return this.column;
    }
}
