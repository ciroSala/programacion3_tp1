package tp1;
import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class MyDobleLinkedList<T extends Comparable<T>> implements Iterable<NodeDoble<T>> {
    private NodeDoble<T> first;
    private int size;

    MyDobleLinkedList(){
        this.first = null;
        this.size = 0;
    }

    void insertFront(T info){
        NodeDoble<T> tmp = new NodeDoble<>();
        tmp.setInfo(info);
        this.first.setAnterior(tmp);
        tmp.setSiguiente(this.first);
        this.first = tmp;
        this.size++;
    }

    @Override
    public Iterator<NodeDoble<T>> iterator() {
        return new IteratorDobleLinkedList(this.first);
    }

    T extractFront(){
        if(this.size>0){
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

    //String toString)
    //T get(index)
    private class IteratorDobleLinkedList implements Iterator<NodeDoble<T>>{
        private NodeDoble<T> cursor;

        public IteratorDobleLinkedList(NodeDoble<T> nodo){
            this.cursor = nodo;
        }

        @Override
        public boolean hasNext() {
            return this.cursor!=null;
        }

        @Override
        public NodeDoble<T> next() {
            NodeDoble<T> nodo = this.cursor;
            this.cursor = this.cursor.getSiguiente();
            return nodo;
        }
    }
}
