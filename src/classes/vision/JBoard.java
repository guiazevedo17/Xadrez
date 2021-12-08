package classes.vision;

import javax.swing.JPanel;
import classes.Board;
import classes.pieces.Piece;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JBoard extends JPanel implements MouseListener{
    
    private Board board;

    public JBoard(Board board){
        this.board = board;
        this.drawBoard();
    }

    public void drawBoard(){
        this.removeAll();
        this.setLayout(new GridLayout(8,8));
        
        for(int i=0; i<8 ;i++){
            for(int j=0; j<8 ;j++){
                
                JSquare jSquare;
                Piece piece = this.board.getPiece(i,j);
                
                if(piece == null){
                    jSquare = new JSquare(i,j);
                } else {
                    jSquare = new JSquare(new JPiece(piece));
                }
                
                if((i+j) % 2 == 0){
                    jSquare.setBackground(new Color(241, 208, 188));
                } else{
                    jSquare.setBackground(new Color(144, 104, 79));
                }
                this.add(jSquare);
                jSquare.addMouseListener(this);

            }
        }
        this.revalidate();
    }

    public Board getBoard(){
        return this.board;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JSquare jSquare = (JSquare) e.getSource();
        this.board.performPlay(jSquare.getLine(), jSquare.getColumn());
        this.drawBoard();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
