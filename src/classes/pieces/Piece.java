package classes.pieces;

import classes.Board;

public abstract class Piece {
    
    private ColorEnum color; // BRANCO ou PRETO
    private int line, column; // Linha e Coluna para tratamento de Posição
    private String image; // Imagem a ser atribuida a cada peça
    private boolean captured = false; // Indica se a peça foi capturada   
    private boolean selected = false; // Indica se a peça foi selecionada
    private Board board; // Possibilita a validação de movimento da peça

    public Piece(ColorEnum color, int line, int column, String image){ // Contrutor de peça
        this.color = color;
        this.line = line;
        this.column = column;
        this.image = image;
    }
    
    public abstract boolean checkMovement(int destinyLine, int destinyColum); // Valida o movimento da peça recebendo a linha e a coluna de destino da mesma
    
    public ColorEnum getColor(){ /* Getter Color */
        return this.color;
    }

    public void setColor(ColorEnum color){ /* Setter Color */
        this.color = color;
    }

    public int getLine(){ /* Getter Line */
        return this.line;
    }

    public void setLine(int line){ /* Setter Line */
        this.line = line;
    }

    public int getColum(){ /* Getter Colum */
        return this.column;
    }

    public void setColum(int column){ /* Setter Colum */
        this.column = column;
    }

    public String getImage(){ /* Getter Image */
        return this.image;
    }

    public void setImage(String image){ /* Setter Image */
        this.image = image;
    }

    public boolean isCaptured(){ /* Getter Captured */
        return this. captured;
    }

    public void setCaptured(boolean captured){ /* Setter Captured */
        this.captured = captured;
    }

    public boolean isSelected(){ /* Getter Selected */
        return this.selected;
    }

    public void setSelected(boolean selected){ /* Setter Selected */
        this.selected = selected;
    }

    public Board getBoard(){ /* Getter Board */
        return this.board;
    }

    public void setBoard(Board board){ /* Setter Board */
        this.board = board;
    }

}
