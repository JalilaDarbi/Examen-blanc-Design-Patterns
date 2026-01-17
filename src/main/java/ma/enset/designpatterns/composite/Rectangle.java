package ma.enset.designpatterns.composite;

import ma.enset.designpatterns.model.Point;

public class Rectangle extends Figure {

    private Point coin;
    private double largeur;
    private double hauteur;

    public Rectangle(Point coin, double largeur, double hauteur) {
        this.coin = coin;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public double surface() {
        return largeur * hauteur;
    }

    @Override
    public double perimetre() {
        return 2 * (largeur + hauteur);
    }

    @Override
    public void dessiner() {
        System.out.println("Rectangle [coin=(" + coin.getX() + "," + coin.getY() + "), L=" + largeur + ", H= " + hauteur + "]");
    }

}
