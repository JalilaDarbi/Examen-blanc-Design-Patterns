package ma.enset.designpatterns.strategy;

import ma.enset.designpatterns.composite.Figure;

import java.util.List;

public interface TraitementStrategy {
    void traiter(List<Figure> figures);
}
