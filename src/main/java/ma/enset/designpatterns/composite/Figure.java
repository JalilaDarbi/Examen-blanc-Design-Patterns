package ma.enset.designpatterns.composite;

import ma.enset.designpatterns.model.Parametrage;
import ma.enset.designpatterns.observer.Observer;

public abstract class Figure implements Observer {

    protected int epaisseur;
    protected int couleurContour;
    protected int couleurRemplissage;

    public abstract double surface();
    public abstract double perimetre();
    public abstract void dessiner();

    @Override
    public void update(Parametrage p){
        this.epaisseur = p.getEpaisseur();
        this.couleurContour = p.getCouleurContour();
        this.couleurRemplissage = p.getCouleurRemplissage();
    }
}
