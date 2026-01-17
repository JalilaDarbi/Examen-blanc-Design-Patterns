package ma.enset.designpatterns.strategy;

import ma.enset.designpatterns.composite.Figure;

import java.util.List;

public class TraitementSurface implements TraitementStrategy {
    @Override
    public void traiter(List<Figure> figures) {
        figures.forEach(f -> System.out.println("Surface = " + f.surface()));
    }
}
