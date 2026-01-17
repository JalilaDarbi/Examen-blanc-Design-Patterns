package ma.enset.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class GroupeFigures extends Figure {

    private List<Figure> figures = new ArrayList<>();

    public void ajouter(Figure f) {
        figures.add(f);
    }

    @Override
    public double surface() {
        return figures.stream().mapToDouble(Figure::surface).sum();
    }

    @Override
    public double perimetre() {
        return figures.stream().mapToDouble(Figure::perimetre).sum();
    }

    @Override
    public void dessiner() {
        System.out.println("Groupes de figures :");
        figures.forEach(Figure::dessiner);
    }

}
