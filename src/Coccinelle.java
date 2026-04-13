import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Coccinelle extends Insecte{

    public Coccinelle(double x, double y) {
        super(x, y, "file:res/img/coccinelle.png");
        body.setFitWidth(40);
        body.setFitHeight(50);
    }
}