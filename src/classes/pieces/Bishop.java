package classes.pieces;

public class Bishop extends Piece{

    public Bishop(ColorEnum color, int line, int column, String image) {
        super(color, line, column, image);
        
    }

    @Override
    public boolean checkMovement(int destinyLine, int destinyColumn) {

        return true;
    }
    
}
