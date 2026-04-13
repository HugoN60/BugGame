import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;

public class Environnement extends Application {
    
    public static ArrayList<Insecte> insectes = new ArrayList<>(); 

    @Override
    public void start(Stage stage) {

        Pane pane = new Pane();
        Image fond = new Image("file:res/img/background.jpg");
        ImageView ivfond = new ImageView(fond);
        ivfond.setFitWidth(1600);
        ivfond.setFitHeight(1200);
        
        pane.getChildren().add(ivfond);

        for(Insecte s : insectes) {
            pane.getChildren().add(s.body);
        }
        Scene scene = new Scene(pane, 1600, 1200);
        stage.setScene(scene);
        stage.setTitle("main");
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                update();
            }
        };
        timer.start();

        pane.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            Scarabe sca = new Scarabe(x, y);
            insectes.add(sca);
            pane.getChildren().add(sca.body);
        });
    }

    public static void main(String[] args) {
        Scarabe a = new Scarabe(800, 600);
        Scarabe b = new Scarabe(800, 600);

        Coccinelle c = new Coccinelle(800, 600);

        insectes.add(a);
        insectes.add(b);
        insectes.add(c);
        Application.launch(args);
    }

    public void update() {
        for(Insecte s : insectes) {
            s.update();
        }
    }


}