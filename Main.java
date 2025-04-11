package tp1;
import java.util.IllegalFormatWidthException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        /*
        Ejercicio 5

        a) Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
        suponiendo que las listas están desordenadas y la lista resultante debe quedar ordenada.

        Iterator<Integer> iterator = listaEnteros.iterator();
        int valorLista1 = 0;
        int valorLista2 = 0;
        //itero todo los elementos de la lista uno
        while(iterator.hasNext()) {
            boolean encontro = false;
            valorLista1 = iterator.next();
            //me fijo en la lista dos desde el primer elemento
            // si tiene el elemento de la lista uno
            Iterator<Integer> iterator2 = listaEnteros2.iterator();
            while(iterator2.hasNext() && !encontro){
                valorLista2 = iterator2.next();
                //si tiene el valor, agregarlo ordenado en una lista nueva
                //dejar de buscar el mismo elemento, pasar al elemento siguiente
                //de la lista uno
                if(valorLista1==valorLista2){
                    listaNueva.addOrdenado(valorLista1);
                    encontro=true;
                }
            }
        }

        b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.

        while(iterator1.hasNext() && iterator2.hasNext()){
            if(iterator1.getValue()==iterator2.getValue()){
                listNueva.addOrdenado(iterator1.getValue());
                iterator1.next();
                iterator2.next();
            } else if (iterator1.getValue()<iterator2.getValue()) {
                iterator1.next();
            }else{
                iterator2.next();
            }
        }

        Ejercicio 6

        while (iteratorLista1.hasNext()) {
            //agarro elemento por elemento
            Node<Integer> cursorLista1 = iteratorLista1.next();

            //me fijo si el elemento de la lista1 no esta en la lista2,
            //si no esta, agrega el elemento de la lista1 a la nueva lista
            if (lista2.indexOf(cursorLista1.getInfo()) == -1) {
                listaNueva.insertFront(cursorLista1.getInfo());
            }
        }
        */
    }
}