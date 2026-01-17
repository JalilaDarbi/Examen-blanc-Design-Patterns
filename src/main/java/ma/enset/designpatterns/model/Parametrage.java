package ma.enset.designpatterns.model;

import ma.enset.designpatterns.observer.Observer;
import ma.enset.designpatterns.observer.Sujet;

import java.util.ArrayList;
import java.util.List;

public class Parametrage implements Sujet {

    private int epaisseur;
    private int couleurContour;
    private int couleurRemplissage;

    private List<Observer> observers = new ArrayList<>();

    public void setParametres(int e, int cc, int cr) {
        this.epaisseur = e;
        this.couleurContour = cc;
        this.couleurRemplissage = cr;
        notifierObservers();

    }

    public int getEpaisseur() { return epaisseur;}
    public int getCouleurContour() { return couleurContour;}
    public int getCouleurRemplissage() { return couleurRemplissage; }

    @Override
    public void ajouterObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void notifierObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}
