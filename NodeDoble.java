package tp1;

public class NodeDoble<T extends Comparable<T>> {
    NodeDoble<T> anterior;
    NodeDoble<T> siguiente;
    T info;

    NodeDoble(){
        this.anterior = null;
        this.siguiente = null;
        this.info = null;
    }

    public NodeDoble<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(NodeDoble<T> anterior) {
        this.anterior = anterior;
    }

    public NodeDoble<T> getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodeDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
