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
        }else{
            this.first = tmp;
        }
        this.size++;
    }

    T extractFront(){
        T info = null;
        if(this.first!=null){
            //si no soy el ultimo, tengo un siguiente
            if(this.first.getSiguiente()!=null) {
                info = this.first.getInfo();
                this.first = this.first.getSiguiente();
                this.first.setAnterior(null);
                this.size--;
            }
            //si soy el ultimo, no tengo siguiente
            info = this.first.getInfo();
            this.first = null;
            this.size--;
        }
        return info;
    }

    boolean isEmpty(){
        return this.first==null;
    }

    int size(){
        return this.size;
    }

    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }
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

    /*
     A la implementación de la clase ListaDoblementeVinculada realizada en el ejercicio 1, agregue un método
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

    @Override
    public IteratorDobleLinkedList iterator() {
        return new IteratorDobleLinkedList(this.first);
    }

    public class IteratorDobleLinkedList implements Iterator<T>{
        private NodeDoble<T> cursor;

        public IteratorDobleLinkedList(NodeDoble<T> nodo){
            this.cursor = nodo;
        }

        public T getValue(){
            return this.cursor.getInfo();
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

        @Override
        public void remove() {
            //verificar si es el primero
            if(cursor.getAnterior()==null){
                //verificar si  tiene siguiente
                if (cursor.getSiguiente() != null){
                    //si tiene siguiente entonces el primero pasa ser el siguiente del primero actual
                    //y ahora el primer elemento que deje de apuntar como anterior al anterior primero
                    first = cursor.getSiguiente();
                    first.setAnterior(null);
                    size--;
                }else{
                    //entonces actualizar directamente el primero a nulo
                    first = null;
                    size--;
                }
            } else if (cursor.getSiguiente()==null) { //verificar si es el ultimo
                //que mi anterior apunte a nulo
                cursor.getAnterior().setSiguiente(null);
                size--;

            }else{  //si no es ninguno de los anteriores casos, es uno del medio
                //que mi anterior apunte como siguiente a mi siguiente y mi siguiente apunte
                //como anterior a mi anterior
                cursor.getAnterior().setSiguiente(cursor.getSiguiente());
                cursor.getSiguiente().setAnterior(cursor.getAnterior());
                size--;
            }
        }
    }
}
