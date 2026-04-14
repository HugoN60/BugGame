import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Scarabe extends Insecte{
    public static final String IMG = "file:res/img/scarabe.png";
    
    public Scarabe(double x, double y) {
        super(x, y, IMG);
        body.setFitWidth(80);
        body.setFitHeight(80);
    }

}