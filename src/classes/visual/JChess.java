package classes.visual;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import classes.Board;
import classes.pieces.ColorEnum;
import controllers.PlayersRegistrationController;
import java.awt.GridLayout;

public class JChess extends JFrame{

    ImageIcon icon;
    
    private static JLabel lblTurn;
    
    private Board board;
   
    private JButton btnDraw, btnGiveup;
    
    public JChess(){ // Constrói Objeto Xadrez que é a Tela onde ocorre todo o jogo
        icon = new ImageIcon("src/images/icon.png");
        setIconImage(icon.getImage());
        setTitle("ChessQMate - TABULEIRO");
        this.setLayout(new BorderLayout());
        this.board = new Board();
        this.add(new JBoard(board), BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        
        /* Painel que mostra Qual jogador está na vez */
        JPanel pnTop = new JPanel();
        lblTurn = new JLabel("Vez de : " +PlayersRegistrationController.player1 +" - BRANCO"); // Cria o Label que mostrará o jogador da vez
        pnTop.add(lblTurn); // Adiciona o Label ao Painel
        this.add(pnTop, BorderLayout.NORTH); // Adiciona Painel do topo

        /* Painel Lateral para área de controle do jogador */
        JPanel pnSide = new JPanel();
        pnSide.setLayout(new GridLayout(10, 1));
        
        /* Cria os botões de Empate e Desistir */
        btnDraw = new JButton("Propor Empate");
        btnGiveup = new JButton("Desistir");

        /* Adiciona os botões ao Painel Lateral */
        pnSide.add(btnDraw);
        pnSide.add(btnGiveup);

        this.add(pnSide, BorderLayout.EAST); // Adiciona Painel lateral

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    public static void setTurn(ColorEnum colorTurn){
        if(colorTurn == ColorEnum.WHITE){
            lblTurn.setText("Vez de : " +PlayersRegistrationController.player1 +" - BRANCAS");
        } else {
            lblTurn.setText("Vez de : " +PlayersRegistrationController.player2 +" - PRETAS");
        }
    }

    public static void main(String args[]){
        new JChess();
    }
}
