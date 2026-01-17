package ma.enset.designpatterns.observer;

public interface Sujet {
    void ajouterObserver(Observer o);
    void notifierObservers();
}
