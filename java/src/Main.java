import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        List<Integer> testList = new ArrayList<>();
        int numberThreads = 4;
        ConcurRadixSort radixSort = new ConcurRadixSort(numberThreads);

        for(int i=1; i<10000001;i++){
            testList.add(new Random().nextInt(i));
        }

        System.out.println("Lista sin ordenar "+ testList);

        testList = radixSort.concurRadixSort(testList);

        System.out.println("Lista ordenada: "+ testList);
    }

}
