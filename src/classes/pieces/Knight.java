package classes.pieces;

public class Knight extends Piece{

    public Knight(ColorEnum color, int line, int column, String image) {
        super(color, line, column, image);
        
    }

    @Override
    public boolean checkMovement(int destinyLine, int destinyColumn) {
        
        return true;
    }
    
}
