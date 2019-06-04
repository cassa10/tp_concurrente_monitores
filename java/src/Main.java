import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        long startTime;
        long endTime;
        long time;

        List<Integer> testList = new ArrayList<>();
        int numberThreads = 3;
        ConcurRadixSort radixSort = new ConcurRadixSort(numberThreads);

        for(int i=1; i<1001;i++){
            testList.add(new Random().nextInt(i));
        }
        System.out.println("No Sorted List"+ testList);

        //ME GUARDO EL TIEMPO CUANDO EMPEZO
        startTime = System.currentTimeMillis();


        testList = radixSort.concurRadixSort(testList);


        //ME GUARDO EL TIEMPO CUANDO FINALIZO
        endTime = System.currentTimeMillis();

        //CALCULO DEL TIEMPO
        time = endTime - startTime;

        System.out.println("Sorted List" + testList);
        System.out.println("Execution Time(ms): "+ time + "ms");
    }

}
