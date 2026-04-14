import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Coccinelle extends Insecte{
    public static final String IMG = "file:res/img/coccinelle.png";

    public Coccinelle(double x, double y) {
        super(x, y, IMG);
        body.setFitWidth(55);
        body.setFitHeight(50);
    }
}