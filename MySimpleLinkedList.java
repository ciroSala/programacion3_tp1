package tp1;
import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<Node<T>>{
    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public Iterator<Node<T>> iterator(){
        return new IteratorSimpleLinkedList(this.first);
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

    //extraer un elemento de la lista vinculada tiene costo O(n) y en un arreglo O(1)
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

    //ver si esta vacia una lista vinculada es O(1) y en un arreglo o(n) ??
    public boolean isEmpty() {
        return this.first == null;
    }

    //Buscar en una lista vinculada es O(n) y en un arreglo O(1)
    public T get(int index) {
        if (index >= 0 && this.size > index) {
            Node<T> cursor = this.first;
            int i = 0;
            while (i < index) { // n
                cursor = cursor.getNext();
                i++;
            }
            return cursor.getInfo();
        }
        return null;
    }

    //Determinar la cantidad de elementos en una lista vinculada es O(1)
    // y en un arreglo O(n)
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Node<T> cursor = this.first;
        boolean existeOtro = false;
        String salida = "[ ";
        if (size > 0) {
            existeOtro = true;
        }
        while (existeOtro) {
            salida += cursor.getInfo();
            if (cursor.getNext() != null) {
                salida += ", ";
                cursor = cursor.getNext();
            } else {
                existeOtro = false;
            }
        }
        salida += " ]";
        return salida;
    }

    /*
     A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
    int indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese
    elemento, o -1 si el elemento no existe en la lista.
     */
    public int indexOf(T valor) {
        int indice = 0;
        Node<T> cursor = this.first;
        while (indice < size) {
            if (cursor.getInfo() == valor) {
                return indice;
            } else {
                cursor = cursor.getNext();
                indice++;
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
        private class IteratorSimpleLinkedList implements Iterator<Node<T>>{
            private Node<T> cursor;

            public IteratorSimpleLinkedList(Node<T> nodo){
                this.cursor = nodo;
            }

            @Override
            public boolean hasNext() {
                return (this.cursor!=null);
            }

            @Override
            public Node<T> next() {
                Node<T> nodo = this.cursor;
                this.cursor = this.cursor.getNext();
                return nodo;
            }
        }
}
