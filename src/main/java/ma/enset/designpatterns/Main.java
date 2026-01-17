package ma.enset.designpatterns;

import ma.enset.designpatterns.aspect.SecurityContext;
import ma.enset.designpatterns.composite.Cercle;
import ma.enset.designpatterns.composite.Rectangle;
import ma.enset.designpatterns.core.Dessin;
import ma.enset.designpatterns.model.Parametrage;
import ma.enset.designpatterns.model.Point;
import ma.enset.designpatterns.security.Role;
import ma.enset.designpatterns.security.User;
import ma.enset.designpatterns.strategy.TraitementSurface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Parametrage param = new Parametrage();

        Cercle c = new Cercle(new Point(1, 2), 5);

        Rectangle p = new Rectangle(new Point(0, 0), 10, 4);

        param.ajouterObserver(c);
        param.ajouterObserver(p);
        param.setParametres(2, 255, 12);

        Dessin dessin = new Dessin();
        dessin.ajouterFigure(c);
        dessin.ajouterFigure(p);

        dessin.afficher();

        dessin.setStrategy(new TraitementSurface());
        dessin.traiter();

        dessin.serialiser("dessin.bin");

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Login USER
        User user = new User("ilyas", "123",
                Set.of(Role.USER));
        SecurityContext.login(user);

        dessin.afficher();   // OK
        dessin.serialiser("dessin.bin"); // ❌ USER ≠ ADMIN

    }
}