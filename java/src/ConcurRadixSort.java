import java.util.ArrayList;
import java.util.List;

public class ConcurRadixSort {

    private int cantidadThreads;

    public ConcurRadixSort(int cantidadThreads){
        this.cantidadThreads = cantidadThreads;
    }

    public List<Integer> radixSort (List<Integer> list){

        List<List<Integer>> aux ;
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < 32; ++ i ) {
            aux = this.split(list,i);
            resultList = aux.get(0);
            resultList.addAll(aux.get(1));

        }
        return resultList ;
    }
    private List<List<Integer>> split (List<Integer> list , int i ) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
         int mask = 1 << i ;
        for (int j : list ) {
            if( (j & mask) > 0) {
                ones.add(i);
            }
            else{
                zeros.add(i);
            }

        }
        result.add(ones);
        result.add(zeros);
        return result;
    }
}
