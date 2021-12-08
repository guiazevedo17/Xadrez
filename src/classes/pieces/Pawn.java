package classes.pieces;

public class Pawn extends Piece{

    private boolean firstMovement = true;
    
    
    public Pawn(ColorEnum color, int line, int column, String image) {
        super(color, line, column, image);
        
    }

    @Override
    public boolean checkMovement(int destinyLine, int destinyColumn) {
        Piece destinyPiece = getBoard().getPiece(destinyLine, destinyColumn);
        
       /* Todos os peões */
        if(destinyPiece != null){ // Verifica se existe uma peça na posição de destino
            if(getColor() == destinyPiece.getColor()){ // Verifica se é da mesma cor
                return false;
            }
            if(destinyLine == getLine()-1){
                return false;
            }

        } else {
            if(destinyColumn != getColumn()){
                return false;
            }
        }

        /* BRANCAS */
        if(getColor() == ColorEnum.WHITE){
            if(destinyLine == getLine() - 1){
                this.setPossible(true);
                return true;
            } else {
                return false;
            }

            
        }

        /* PRETAS */
        if(getColor() == ColorEnum.BLACK){
            if(destinyLine == getLine() + 1){
                this.setPossible(true);
                return true;
            } else {
                return false;
            }
        }
        
        return false;
    }

    public boolean isFirstMovement(){
        return this.firstMovement;
    }

    public void setFirstMovement(boolean firstMovement){
        this.firstMovement = firstMovement;
    }

}