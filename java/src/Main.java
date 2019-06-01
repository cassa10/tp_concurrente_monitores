public class Main {

    public static void main(String[] args){

        ThreadPool threadPool = new ThreadPool(2,8);

        Task dummyTask = new TaskDummy("xD");

        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);

        //EL STOP TIENE MENOR PRIORIDAD(PUEDE SER QUE ME COLEN LAUNCHS DESPUES DE USARLO)
        threadPool.stop();

        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);
        threadPool.launch(dummyTask);
    }

}
