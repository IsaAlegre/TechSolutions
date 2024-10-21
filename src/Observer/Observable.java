package Observer;

public interface Observable {

    void añadirObservador(Observador o);

    void eliminarObservador(Observador o);

    void notificarObservadores();
}
