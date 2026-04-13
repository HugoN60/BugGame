import java.lang.Math;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Insecte {
    public double posX;
    public double posY; 

    public ImageView body;

    private double angle = Math.random() * 360;
    private double vitAng = 0; 
    private int offset = 90;
    private double correctionSpe = 0.6;

    public Insecte(double x, double y, String cheminImg) {
        this.posX = x;
        this.posY = y;
        Image img = new Image(cheminImg);
        body = new ImageView(img);
    }

    public void update() {
        vitAng += Math.random() * 2 - 1; //Entre -1.5 et 1.5
        angle += vitAng; 
        vitAng *= 0.9;
        
        double angleRad = Math.toRadians(angle);
        double x = Math.cos(angleRad)*correctionSpe;
        double y = Math.sin(angleRad)*correctionSpe;
        body.setRotate(angle + offset);

        posX += x;
        posY += y;

        body.setX(posX);
        body.setY(posY);


    }
}
