package classes;

import classes.pieces.Bishop;
import classes.pieces.ColorEnum;
import classes.pieces.King;
import classes.pieces.Knight;
import classes.pieces.Pawn;
import classes.pieces.Piece;
import classes.pieces.Queen;
import classes.pieces.Rook;
import classes.visual.JChess;

public class Board {
    
    private Piece[][] pieces;
    private Piece selectedPiece = null;
    private ColorEnum turn = ColorEnum.WHITE;

    public Board(){ // Cria um tabuleiro
        this.pieces = new Piece[8][8];
        
        /* PEÇAS BRANCAS */
        
        // Torres
        Rook rookWhite1 = new Rook(ColorEnum.WHITE, 7, 0, "src/images/pieces/whites/rook.png");
        this.addPiece(rookWhite1);
        Rook rookWhite2 = new Rook(ColorEnum.WHITE, 7, 7, "src/images/pieces/whites/rook.png");
        this.addPiece(rookWhite2);

        // Cavalos
        Knight knightWhite1 = new Knight(ColorEnum.WHITE, 7, 1, "src/images/pieces/whites/knight.png");
        this.addPiece(knightWhite1);
        Knight knightWhite2 = new Knight(ColorEnum.WHITE, 7, 6, "src/images/pieces/whites/knight.png");
        this.addPiece(knightWhite2);

        // Bispos
        Bishop bishopWhite1 = new Bishop(ColorEnum.WHITE, 7, 2, "src/images/pieces/whites/bishop.png");
        this.addPiece(bishopWhite1);
        Bishop bishopWhite2 = new Bishop(ColorEnum.WHITE, 7, 5, "src/images/pieces/whites/bishop.png");
        this.addPiece(bishopWhite2);

        // Rainha
        Queen queenWhite = new Queen(ColorEnum.WHITE, 7, 3, "src/images/pieces/whites/queen.png");
        this.addPiece(queenWhite);

        // Rei
        King kingWhite = new King(ColorEnum.WHITE, 7, 4, "src/images/pieces/whites/king.png");
        this.addPiece(kingWhite);

        // Peões
        Pawn pawnWhite1 = new Pawn(ColorEnum.WHITE, 6, 0, "src/images/pieces/whites/pawn.png");
        this.addPiece(pawnWhite1);
        Pawn pawnWhite2 = new Pawn(ColorEnum.WHITE, 6, 1, "src/images/pieces/whites/pawn.png");
        this.addPiece(pawnWhite2);
        Pawn pawnWhite3 = new Pawn(ColorEnum.WHITE, 6, 2, "src/images/pieces/whites/pawn.png");
        this.addPiece(pawnWhite3);
        Pawn pawnWhite4 = new Pawn(ColorEnum.WHITE, 6, 3, "src/images/pieces/whites/pawn.png");
        this.addPiece(pawnWhite4);
        Pawn pawnWhite5 = new Pawn(ColorEnum.WHITE, 6, 4, "src/images/pieces/whites/pawn.png");
        this.addPiece(pawnWhite5);
        Pawn pawnWhite6 = new Pawn(ColorEnum.WHITE, 6, 5, "src/images/pieces/whites/pawn.png");
        this.addPiece(pawnWhite6);
        Pawn pawnWhite7 = new Pawn(ColorEnum.WHITE, 6, 6, "src/images/pieces/whites/pawn.png");
        this.addPiece(pawnWhite7);
        Pawn pawnWhite8 = new Pawn(ColorEnum.WHITE, 6, 7, "src/images/pieces/whites/pawn.png");
        this.addPiece(pawnWhite8);

        /* PEÇAS PRETAS */
        
        // Torres
        Rook rookBlack1 = new Rook(ColorEnum.BLACK, 0, 0, "src/images/pieces/blacks/rook.png");
        this.addPiece(rookBlack1);
        Rook rookBlack2 = new Rook(ColorEnum.BLACK, 0, 7, "src/images/pieces/blacks/rook.png");
        this.addPiece(rookBlack2);

        // Cavalos
        Knight knightBlack1 = new Knight(ColorEnum.BLACK, 0, 1, "src/images/pieces/blacks/knight.png");
        this.addPiece(knightBlack1);
        Knight knightBlack2 = new Knight(ColorEnum.BLACK, 0, 6, "src/images/pieces/blacks/knight.png");
        this.addPiece(knightBlack2);

        // Bispos
        Bishop bishopBlack1 = new Bishop(ColorEnum.BLACK, 0, 2, "src/images/pieces/blacks/bishop.png");
        this.addPiece(bishopBlack1);
        Bishop bishopBlack2 = new Bishop(ColorEnum.BLACK, 0, 5, "src/images/pieces/blacks/bishop.png");
        this.addPiece(bishopBlack2);

        // Rainha
        Queen queenBlack = new Queen(ColorEnum.BLACK, 0, 3, "src/images/pieces/blacks/queen.png");
        this.addPiece(queenBlack);

        // Rei
        King kingBlack = new King(ColorEnum.BLACK, 0, 4, "src/images/pieces/blacks/king.png");
        this.addPiece(kingBlack);

        // Peões
        Pawn pawnBlack1 = new Pawn(ColorEnum.BLACK, 1, 0, "src/images/pieces/blacks/pawn.png");
        this.addPiece(pawnBlack1);
        Pawn pawnBlack2 = new Pawn(ColorEnum.BLACK, 1, 1, "src/images/pieces/blacks/pawn.png");
        this.addPiece(pawnBlack2);
        Pawn pawnBlack3 = new Pawn(ColorEnum.BLACK, 1, 2, "src/images/pieces/blacks/pawn.png");
        this.addPiece(pawnBlack3);
        Pawn pawnBlack4 = new Pawn(ColorEnum.BLACK, 1, 3, "src/images/pieces/blacks/pawn.png");
        this.addPiece(pawnBlack4);
        Pawn pawnBlack5 = new Pawn(ColorEnum.BLACK, 1, 4, "src/images/pieces/blacks/pawn.png");
        this.addPiece(pawnBlack5);
        Pawn pawnBlack6 = new Pawn(ColorEnum.BLACK, 1, 5, "src/images/pieces/blacks/pawn.png");
        this.addPiece(pawnBlack6);
        Pawn pawnBlack7 = new Pawn(ColorEnum.BLACK, 1, 6, "src/images/pieces/blacks/pawn.png");
        this.addPiece(pawnBlack7);
        Pawn pawnBlack8 = new Pawn(ColorEnum.BLACK, 1, 7, "src/images/pieces/blacks/pawn.png");
        this.addPiece(pawnBlack8);
        
    }

    public Piece getPiece(int line, int column){ // Retorna a peça que estiver na respectiva posição do tabuleiro, se houver
        return this.pieces[line][column];
    }

    public void setPiece(Piece piece){ // Adiciona ela ao tabuleiro e o tabuleiro a peça
        this.pieces[piece.getLine()][piece.getColumn()] = piece;
        piece.setBoard(this);
    }

    public void addPiece(Piece piece){ // Adiciona uma peça ao tabuleiro
        this.pieces[piece.getLine()][piece.getColumn()] = piece;
        piece.setBoard(this);
    }

    public void selectPiece(Piece piece){ // Seleciona uma peça
        if(piece.isSelected()){ // Caso a peça esteja selecionada, será deselecionada
            piece.setSelected(false);
            this.selectedPiece = null;
        } else { // Caso a peça ainda não esteja selecionada, será selecionada
            piece.setSelected(true);
            this.selectedPiece = piece;
        }
    }

    public void movePiece(Piece piece, int destinyLine, int destinyColumn){ // Move a peça de posição
        if(piece.checkMovement(destinyLine, destinyColumn)){
            this.pieces[piece.getLine()][piece.getColumn()] = null;
            piece.setLine(destinyLine);
            piece.setColumn(destinyColumn);
            this.setPiece(piece);
            this.selectPiece(piece);
            this.reverseTurn();
        }
    }

    public void reverseTurn(){ // Inverte a vez, se o jogador 1 (branco) estiver jogando o próximo será o jogador 2 (preto) e vice-versa
        if(this.turn.equals(ColorEnum.WHITE)){
            this.turn = ColorEnum.BLACK;
        } else {
            this.turn = ColorEnum.WHITE;
        }

        JChess.setTurn(this.turn);
    }

    public void performPlay(int line, int column) {
        Piece piece = this.getPiece(line, column);
        
        if(this.selectedPiece == null) {
            
            if(piece != null && piece.getColor().equals(this.turn)){
                this.selectPiece(piece);
            } 
            
        } else {
                
            if(this.selectedPiece == piece){
                this.selectPiece(piece);
            } else {

                if(piece == null || !piece.getColor().equals(this.selectedPiece.getColor())){
                    this.movePiece(this.selectedPiece, line, column);
                }
            }
        }
    }
}
