package ma.enset.designpatterns.composite;

import ma.enset.designpatterns.model.Point;

import javax.swing.*;

public class Cercle extends Figure {

    private Point centre;
    private double rayon;

    public Cercle(Point centre , double rayon) {
        this.centre = centre;
        this.rayon = rayon;
    }

    @Override
    public double surface() {
        return Math.PI * rayon * rayon;    }

    @Override
    public double perimetre() {
        return 2 * Math.PI * rayon; }

    @Override
    public void dessiner() {
        System.out.println("Cercle [ centre=(" + centre.getX() + "," + centre.getY() + "), R=" + rayon + "]");
    }



}
