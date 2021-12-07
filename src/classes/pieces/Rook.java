package classes.pieces;

public class Rook extends Piece{

    public Rook(ColorEnum color, int line, int column, String image) {
        super(color, line, column, image);
        
    }

    @Override
    public boolean checkMovement(int destinyLine, int destinyColumn) {
        
        return true;
    }
    

}
