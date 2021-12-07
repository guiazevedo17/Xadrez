package classes.pieces;

public class Pawn extends Piece{

    private boolean firstMovement = true;
    
    public Pawn(ColorEnum color, int line, int column, String image) {
        super(color, line, column, image);
        
    }

    @Override
    public boolean checkMovement(int destinyLine, int destinyColumn) {
        /* if(){
            return false;
        } */

        return true;
    }

}