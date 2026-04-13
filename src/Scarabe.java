import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.lang.Math;

class Scarabe {
    public static final Image IMG = new Image("file:res/img/scarabe.png");
    public ImageView body = new ImageView(IMG);
    public double posX;
    public double posY; 

    private double angle = Math.random() * 360;
    private double vitAng = 0; 
    private int offset = 90;
    private double correctionSpe = 0.6;

    public Scarabe(double x,double y) {
        this.posX = x;
        this.posY = y;
        body.setFitWidth(60);
        body.setFitHeight(80);
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