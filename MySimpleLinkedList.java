package tp1;
import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T>{
    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    /*
    Insertar en una lista vinculada al principio tiene costo O(1)
   y en un arreglo tiene costo O(n)
   */
    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    //extraer del principio en una lista vinculada tiene costo O(1)
    public T extractFront() {
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        size--;
        return info;
    }

    //ver si esta vacia una lista vinculada es O(1) y en un arreglo o(n) ??
    public boolean isEmpty() {
        return this.first == null;
    }

    //Buscar en una lista vinculada es O(n) y en un arreglo O(1)
    public T get(int index) {
        if (index >= 0 && this.size > index) {
            Iterator<T> iterator = this.iterator();
            T valorIterator = null;
            int pos = -1;
            //usamos hasNext por robustez y seguridad en el codigo
            while (pos < index && iterator.hasNext()) {
                pos++;
                valorIterator = iterator.next();
            }
            //if por buena practica
            if (pos == index) {
                return valorIterator;
            }
        } return null;
    }

    public IteratorSimpleLinkedList iterator(){
        return new IteratorSimpleLinkedList(this.first);
    }

    public void addOrdenado(T info){
        Node<T> nodoNuevo = new Node<>(info);
        if(this.first!=null){
            Node<T> cursorAnterior = null;
            Node<T> cursor = this.first;
            //itero toda la lista
            while(cursor!=null){
                if(nodoNuevo.getInfo().compareTo(cursor.getInfo())>0){
                    cursorAnterior = cursor;
                    cursor = cursor.getNext();
                }else{
                    // Insertar antes del cursor
                    nodoNuevo.setNext(cursor);
                    if (cursorAnterior == null) {
                        this.first = nodoNuevo; // Insertar al principio
                    } else {
                        cursorAnterior.setNext(nodoNuevo); // Insertar en el medio
                    }
                    this.size++; // Incremento del tamaño dentro del else
                    return; // Salida temprana del método
                }
            }
            //si cursor es nulo, el recorrido llego al final (no soy mayor a ninguno), entonces me inserto ultimo
            //quedo el ultimo elemento en cursorAnterior
            cursorAnterior.setNext(nodoNuevo);
            this.size++; // Incremento del tamaño para lista vacía
        }else{
            this.first = nodoNuevo;
            this.size++; // Incremento del tamaño para lista vacía
        }
    }

    //extraer un elemento de la lista vinculada tiene costo O(n) y en un arreglo O(n)
    public T extracIndice(int indice) {
        T infoCursor = null;
        if (indice >= 0 && this.size > indice) {
            if (indice == 0) {
                infoCursor = this.extractFront();
                return infoCursor;
            } else {
                Node<T> anteriorCursor = this.first;
                Node<T> cursor = anteriorCursor.getNext();
                infoCursor = cursor.getInfo();
                int inicio = 1;
                while (inicio < indice) {
                    anteriorCursor = cursor;
                    cursor = cursor.getNext();
                    infoCursor = cursor.getInfo();
                    inicio++;
                }
                anteriorCursor.setNext(cursor.getNext());
                return infoCursor;
            }
        }
        return infoCursor;
    }

    //Determinar la cantidad de elementos en una lista vinculada es O(1) y en un arreglo igual
    // y en un arreglo O(n) ??
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Iterator<T> iterator = this.iterator();
        String salida = "[";
        while(iterator.hasNext()){
            salida += iterator.next() + ", ";
        }
        salida = salida.substring(0,salida.length()-2);
        return salida + "]";
    }


    /*
     A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
    int indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese
    elemento, o -1 si el elemento no existe en la lista.
     */
    public int indexOf(T valor) {
        int indice = -1;
        Iterator<T> iterator = this.iterator();
        T valorIterator = null;
        while(iterator().hasNext()) {
            indice++;
            valorIterator = iterator.next();
            if(valorIterator==valor){
                return indice;
            }
        }
        return -1;
    }


        /*
        A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
        iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la hora
        de recorrer la lista de principio a fin si se cuenta con un iterador?
         */

        //generar clase privada donde se encuentra el iterador
        public class IteratorSimpleLinkedList implements Iterator<T>{
            private Node<T> cursor;

            public IteratorSimpleLinkedList(Node<T> nodo){
                this.cursor = nodo;
            }

            @Override
            public boolean hasNext() {
                return (this.cursor!=null);
            }

            @Override
            public T next() {
                T info = this.cursor.getInfo();
                this.cursor = this.cursor.getNext();
                return info;
            }

            public T getValue(){
                return this.cursor.getInfo();
            }
        }
}
