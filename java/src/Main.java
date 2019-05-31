public class Main {

    public static void main(String[] args){

        //CREA EL BUFFER con un size especifico
        Buffer<Task> buffer = new Buffer<>(2);

        ThreadPool threadPool = new ThreadPool(buffer,8);

        Task dummyTask = new TaskDummy("xD");
        Task poisonPill = new TaskPoisonPill();

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
