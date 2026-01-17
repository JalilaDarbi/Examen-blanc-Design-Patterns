package ma.enset.designpatterns.core;

import ma.enset.designpatterns.aspect.Loggable;
import ma.enset.designpatterns.aspect.Secured;
import ma.enset.designpatterns.composite.Figure;
import ma.enset.designpatterns.security.Role;
import ma.enset.designpatterns.strategy.TraitementStrategy;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dessin implements Serializable {

    private List<Figure> figures = new ArrayList<>();
    private TraitementStrategy strategy;

    public void ajouterFigure(Figure f) {
        figures.add(f);
    }

    public void supprimerFigure(Figure f) {
        figures.remove(f);
    }
    @Loggable
    @Secured(Role.USER)
    public void afficher() {
        figures.forEach(Figure::dessiner);
    }

    public void setStrategy(TraitementStrategy strategy) {
        this.strategy = strategy;
    }

    public void traiter() {
        strategy.traiter(figures);
    }

    @Loggable
    @Secured(Role.ADMIN)
    public void serialiser(String file) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(figures);
        oos.close();
    }
}
