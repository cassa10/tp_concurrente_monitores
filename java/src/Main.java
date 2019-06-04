import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        long startTime = System.currentTimeMillis();

        List<Integer> testList = new ArrayList<>();
        int numberThreads = 1;
        ConcurRadixSort radixSort = new ConcurRadixSort(numberThreads);

        for(int i=1; i<1001;i++){
            testList.add(new Random().nextInt(i));
        }

        //System.out.println("No Sorted List"+ testList);

        testList = radixSort.concurRadixSort(testList);

        //System.out.println("Sorted List: "+ testList);

        long engTime = System.currentTimeMillis();

        long time = engTime - startTime;
        System.out.println("Execution Time(ms): "+ time + "ms");
    }

}
