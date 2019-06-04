import java.util.ArrayList;
import java.util.List;

public class ConcurRadixSort {
    //DO NOT RUN WITH NEGATIVE INTEGERS

    private ThreadPool threadPool;
    private int numberThreads;

    public ConcurRadixSort(int numberThreads){
        this.threadPool = new ThreadPool(numberThreads);
        this.numberThreads = numberThreads;
    }

    public List<Integer> concurRadixSort (List<Integer> list){
        List<Integer> resultList = list;

        if(this.numberThreads <= 0){
            resultList = this.radixSort(list);
        }else {
            List<List<Integer>> auxResult = new ArrayList<>();

            List<Integer> allOnes = new ArrayList<>();
            List<Integer> allZeros = new ArrayList<>();

            int sizeList = list.size();

            List<List<Integer>> listasAuxThreads;

            List<RadixResults> resultsThreads;

            int writeInResult;

            int numberOfTasks;
            Barrier barrier;

            for (int i = 0; i < 32; ++i) {
                listasAuxThreads = this.divList(numberThreads, resultList, sizeList);
                numberOfTasks = listasAuxThreads.size();

                resultsThreads = this.createResultList(numberOfTasks);

                writeInResult = 0;

                //SUPONGO QUE SE DEBEN COMPLETAR ESTAS TAREAS
                barrier = new Barrier(numberOfTasks);

                for (List<Integer> auxThreads : listasAuxThreads) {

                    threadPool.launch(new TaskRadixSort(barrier,resultsThreads,writeInResult,i,auxThreads));

                    writeInResult++;
                }

                barrier.esperar();

                for(RadixResults thRs : resultsThreads){
                    allOnes.addAll(thRs.getOnes());
                    allZeros.addAll(thRs.getZeros());
                }

                auxResult.add(allOnes);
                auxResult.add(allZeros);

                resultList = auxResult.get(0);
                resultList.addAll(auxResult.get(1));

                auxResult = new ArrayList<>();

                allOnes = new ArrayList<>();
                allZeros = new ArrayList<>();

            }
        }
        this.threadPool.stop();
        return resultList ;
    }

    public List<Integer> radixSort (List<Integer> list){

        List<List<Integer>> aux ;
        List<Integer> resultList = list;

        for (int i = 0; i < 32; ++ i ) {
            aux = this.split(resultList,i);
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

    private List<List<Integer>> divList(int numberThreads,List<Integer> list,int sizeList){
        //TODO
        // REFACTORIZAR ESTE METODO

        int numberLists = numberThreads;


        //NUMBERS OF THREADS MUST BE (<=) THAN SIZE OF LIST
        if(numberThreads > sizeList) {
            numberLists = sizeList;
        }

        List<List<Integer>> result = new ArrayList<>();

        Double sizeDiv = new Double(sizeList ) / new Double(numberLists);

        //IF sizeDiv IS IN [1,...,1.499...] GO TO 1 AND IF sizeDiv IS IN [1.5,...,1.99...] GO TO 2
        Double sizeDivRounded = new Double(Math.round(sizeDiv));
        int lastIndexTook = 0;
        int sizePerList = sizeDivRounded.intValue();
        int limit = sizePerList;


        for(int i=0; i<(numberLists-1);i++){
            //CREAR LISTA A CADA THREAD

            result.add(list.subList(lastIndexTook,limit));

            lastIndexTook = limit;
            limit = limit + sizePerList;
        }

        result.add(list.subList(lastIndexTook,sizeList));

        return result;
    }

    private List<RadixResults> createResultList(int sizeResultList){
        List<RadixResults> list = new ArrayList<>();
        for(int i=0;i<sizeResultList;i++){
            list.add(null);
        }
        return list;
    }
}