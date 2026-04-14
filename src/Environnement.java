import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;

public class Environnement extends Application {
    
    public static ArrayList<Insecte> insectes = new ArrayList<>(); 
    public static String spawn = "scarabe";

    @Override
    public void start(Stage stage) {
        ImageView scaImg = new ImageView(new Image(Scarabe.IMG));
        scaImg.setFitHeight(120);
        scaImg.setFitWidth(160);
        ImageView cocImg = new ImageView(new Image(Coccinelle.IMG));
        cocImg.setFitHeight(120);
        cocImg.setFitWidth(160);

        Pane pane = new Pane();
        Image fond = new Image("file:res/img/background.jpg");
        ImageView ivfond = new ImageView(fond);
        ivfond.setFitWidth(1600);
        ivfond.setFitHeight(1200);
        
        pane.getChildren().add(ivfond);

        for(Insecte s : insectes) {
            pane.getChildren().add(s.body);
        }


        FlowPane fp = new FlowPane();
        Button scaBtn = new Button("Scarabée", scaImg);
        scaBtn.setOnAction(event -> {
            spawn = "scarabe";
        });
        fp.getChildren().add(scaBtn);

        Button cocBtn = new Button("Coccielle", cocImg);
        cocBtn.setOnAction(event -> {
            spawn = "coccinelle";
        });
        fp.getChildren().add(cocBtn);


        StackPane root = new StackPane();
        root.getChildren().addAll(pane, fp);
        Scene scene = new Scene(root, 1600, 1200);
        stage.setScene(scene);
        stage.setTitle("main");
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                update();
            }
        };
        timer.start();

        root.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            if(spawn.equals("scarabe")) {
                System.out.println(spawn.equals("scarabe"));
                Scarabe sca = new Scarabe(x, y);
                insectes.add(sca);
                pane.getChildren().add(sca.body);
            } else if(spawn.equals("coccinelle")) {
                Coccinelle coc = new Coccinelle(x, y);
                insectes.add(coc);
                pane.getChildren().add(coc.body);
            }
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