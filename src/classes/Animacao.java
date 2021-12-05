package classes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animacao  extends Application{

    // Carregar imagens do arquivo images/animacao
    final static javafx.scene.image.Image PAWN = new javafx.scene.image.Image(Animacao.class.getResource("../images/animation/pawn.png").toString());
    final static javafx.scene.image.Image ROOK = new javafx.scene.image.Image(Animacao.class.getResource("../images/animation/rook.png").toString());
    final static javafx.scene.image.Image KNIGHT = new javafx.scene.image.Image(Animacao.class.getResource("../images/animation/knight.png").toString());
    final static javafx.scene.image.Image BISHOP = new javafx.scene.image.Image(Animacao.class.getResource("../images/animation/bishop.png").toString());
    final static javafx.scene.image.Image QUEEN = new javafx.scene.image.Image(Animacao.class.getResource("../images/animation/queen.png").toString());
    final static javafx.scene.image.Image KING = new javafx.scene.image.Image(Animacao.class.getResource("../images/animation/king.png").toString());
    final static javafx.scene.image.Image FIGHT = new javafx.scene.image.Image(Animacao.class.getResource("../images/animation/blades.png").toString());

    // Cria um grupo Node
    private static Group piece;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Alocando as imagens em novos ImageView Nodes
        final ImageView piece1 = new ImageView(PAWN);
        final ImageView piece2 = new ImageView(ROOK);
        final ImageView piece3 = new ImageView(KNIGHT);
        final ImageView piece4 = new ImageView(BISHOP);
        final ImageView piece5 = new ImageView(QUEEN);
        final ImageView piece6 = new ImageView(KING);
        final ImageView piece7 = new ImageView(FIGHT);

        // Instanciar um objeto que chame piece
        piece = new Group(piece1);

        // Coloca a imagem em coordenadas específicas
        piece.setTranslateX(30);
        piece.setTranslateY(50);

        // Animar as imagens das peças em loop
        Timeline t = new Timeline();
        t.setCycleCount(3);

        // Adiciona imagens na Timeline
        t.getKeyFrames().add(new KeyFrame(
            Duration.millis(200),
            (ActionEvent event) -> {
                piece.getChildren().setAll(piece2);
            }
        ));

        t.getKeyFrames().add(new KeyFrame(
            Duration.millis(400),
            (ActionEvent event) -> {
                piece.getChildren().setAll(piece3);
            }
        ));

        t.getKeyFrames().add(new KeyFrame(
            Duration.millis(600),
            (ActionEvent event) -> {
                piece.getChildren().setAll(piece4);
            }
        ));

        t.getKeyFrames().add(new KeyFrame(
            Duration.millis(800),
            (ActionEvent event) -> {
                piece.getChildren().setAll(piece5);
            }
        ));

        t.getKeyFrames().add(new KeyFrame(
            Duration.millis(1000),
            (ActionEvent event) -> {
                piece.getChildren().setAll(piece6);
            }
        ));

        t.getKeyFrames().add(new KeyFrame(
            Duration.millis(1200),
            (ActionEvent event) -> {
                piece.getChildren().setAll(piece7);
            }
        ));

        t.play();

        primaryStage.setScene(new Scene(piece, 318, 360));
        primaryStage.setTitle("ChessQMate - Carregando...");
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
        launch(args);
    }
    
}
