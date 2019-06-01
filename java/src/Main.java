import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        ThreadPool threadPool = new ThreadPool(2,8);

        Task dummyTask = new TaskDummy("xD");

        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);

        //EL STOP TIENE MENOR PRIORIDAD(PUEDE SER QUE ME COLEN LAUNCHS DESPUES DE USARLO)
        threadPool.stop();

        //NO HACEN NADA DESPUES DEL STOP
        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);


        List<Integer> listaDePrueba = new ArrayList<>();
        listaDePrueba.add(3);
        listaDePrueba.add(12);
        listaDePrueba.add(2);
        listaDePrueba.add(100);
        listaDePrueba.add(1);
        listaDePrueba.add(5);

        //TODO
        // BORRAR PRINTS
        System.out.println("Lista sin ordenar "+ listaDePrueba);


        ConcurRadixSort radixSort = new ConcurRadixSort(0);
        listaDePrueba = radixSort.radixSort(listaDePrueba);
        System.out.println("Print lista ordenada: "+listaDePrueba);
    }

}
