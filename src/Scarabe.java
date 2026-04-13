import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Scarabe extends Insecte{
    
    public Scarabe(double x, double y) {
        super(x, y, "file:res/img/scarabe.png");
        body.setFitWidth(60);
        body.setFitHeight(80);
    }

}