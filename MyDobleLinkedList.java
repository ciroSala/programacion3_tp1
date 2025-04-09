package tp1;
import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class MyDobleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private NodeDoble<T> first;
    private int size;

    MyDobleLinkedList(){
        this.first = null;
        this.size = 0;
    }

    void insertFront(T info){
        NodeDoble<T> tmp = new NodeDoble<>();
        tmp.setInfo(info);
        if(this.first!=null){
            this.first.setAnterior(tmp);
            tmp.setSiguiente(this.first);
            this.first = tmp;
            this.size++;
        }else{
            this.first = tmp;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorDobleLinkedList(this.first);
    }

    T extractFront(){
        if(this.first!=null){
            T info = this.first.getInfo();
            this.first = this.first.getSiguiente();
            this.first.setAnterior(null);
            this.size --;
            return info;
        }else{
            return null;
        }
    }

    boolean isEmpty(){
        return this.first==null;
    }

    int size(){
        return this.size;
    }

    public String toString(){
        Iterator<T> iterator = this.iterator();
        String salida = "[";
        while(iterator.hasNext()){
            salida += iterator.next() + ", ";
        }
        //sacar la ultima coma, entonces selecciono todos los caracteres que quiero
        //(todos excepto los dos antes de cerrar el arreglo)
        salida = salida.substring(0,salida.length()-2);
        return salida += "]";
    }

    T get(int index){
        if(index<this.size){
            T salida = null;
            int inicio = -1;
            Iterator<T> iterator = this.iterator();
            while(iterator.hasNext() && inicio<index){
                salida = iterator.next();
                inicio++;
            }
            return salida;
        }
        return null;
    }
    private class IteratorDobleLinkedList implements Iterator<T>{
        private NodeDoble<T> cursor;

        public IteratorDobleLinkedList(NodeDoble<T> nodo){
            this.cursor = nodo;
        }

        @Override
        public boolean hasNext() {
            return this.cursor!=null;
        }

        @Override
        public T next() {
            T info = this.cursor.getInfo();
            this.cursor = this.cursor.getSiguiente();
            return info;
        }
    }
}
