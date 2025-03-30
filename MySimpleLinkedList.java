package tp1;

public class MySimpleLinkedList<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public T extractFront() {
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        size--;
        return info;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    public T get(int index) {
        int i = 0;
        Node<T> cursor = null;
        if(index>=0 && size>1 && size>index) {
            cursor = this.first;
            while (i < index) {
                cursor = cursor.getNext();
                i++;
            }
            return cursor.getInfo();
        }else{
            return null;
        }
    }

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
