import java.util.ArrayList;
import java.util.List;

public class TaskRadixSort extends Task {

    private Barrier barrier;
    private int writeResultIn;
    private List<RadixResults> results;
    private int intSplit;
    private List<Integer> listToSort;

    public TaskRadixSort(Barrier barrier, List<RadixResults> results,int writeResultIn, int intSplit, List<Integer> listToSort){
        this.barrier = barrier;
        this.writeResultIn = writeResultIn;
        this.results = results;
        this.intSplit = intSplit;
        this.listToSort = listToSort;
    }

    private List<List<Integer>> split (List<Integer> list , int i ) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        int mask = 1 << i ;
        for (int j : list ) {
            if( (j & mask) > 0) {
                ones.add(j);
            }
            else{
                zeros.add(j);
            }

        }
        result.add(ones);
        result.add(zeros);
        return result;
    }

    @Override
    public void run() {
       //[[1s],[0s]]
        List<List<Integer>> myOnesAndZeros = this.split(listToSort,this.intSplit);

        RadixResults myResult = new RadixResults(myOnesAndZeros.get(0),myOnesAndZeros.get(1));

        //ESTO ME EVITA CONTROLAR LA ESCRITURA GLOBAL ENTRE LOS THREADS
        results.set(this.writeResultIn,myResult);

        //LE AVISO A LA BARRERA QUE ESTA TAREA FINALIZO
        this.barrier.lessCapacity();
    }
}
