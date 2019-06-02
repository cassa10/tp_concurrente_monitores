import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        List<Integer> listaDePrueba = new ArrayList<>();

        listaDePrueba.add(2);
        listaDePrueba.add(8);
        listaDePrueba.add(16);
        listaDePrueba.add(5);
        listaDePrueba.add(12);

        /*
        for(int i=1; i<21;i++){
            listaDePrueba.add(new Random().nextInt(i));
        }*/

        //TODO
        // BORRAR PRINTS
        System.out.println("Lista sin ordenar "+ listaDePrueba);



        ConcurRadixSort radixSort = new ConcurRadixSort(3);

        listaDePrueba = radixSort.radixSort(listaDePrueba);
        // listaDePrueba = radixSort.concurRadixSort(listaDePrueba);
        System.out.println("Lista ordenada: "+listaDePrueba);
    }

}
