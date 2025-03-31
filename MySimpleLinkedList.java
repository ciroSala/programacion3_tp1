package tp1;

public class MySimpleLinkedList<T> {

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
        Node<T> tmp = new Node<T>(info,null);
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
    public void extracIndice(int indice) {
        if (indice >= 0 && this.first != null && this.size > indice) {
            Node<T> anteriorCursor = this.first;
            Node<T> cursor = anteriorCursor.getNext();
            int inicio = 1;
            if (indice == 0) {
                this.extractFront();
            } else {
                while (inicio < indice) {
                    anteriorCursor = cursor;
                    cursor = cursor.getNext();
                    inicio++;
                }
                anteriorCursor.setNext(cursor.getNext());
            }
        }
    }

    //ver si esta vacia una lista vinculada es O(1) y en un arreglo o(n)
    public boolean isEmpty() {
        return this.first==null;
    }

    //Buscar en una lista vinculada es O(n) y en un arreglo O(1)
    public T get(int index) {
        int i = 0;
        if(index>=0 && this.size>1 && this.size>index) {
            Node<T> cursor = this.first;
            while (i < index) { // n
                cursor = cursor.getNext();
                i++;
            }
            return cursor.getInfo();
        }else{
            return null;
        }
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
        if(size>0) {
            existeOtro = true;
        }
        while(existeOtro) {
            salida += cursor.getInfo();
            if(cursor.getNext() != null){
                salida += ", ";
                cursor = cursor.getNext();
            }else {
                existeOtro = false;
            }
        }
        salida += " ]";
        return salida;
    }

}
