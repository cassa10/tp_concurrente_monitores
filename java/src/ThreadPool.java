import java.util.List;

public class ThreadPool<T> {


    private Buffer<T> buffer;
    private int cantidadWorkers;
    private List<Worker<T>> workerList;

    public ThreadPool(Buffer<T> buffer, int cantidadDeWorkers){

        this.cantidadWorkers = cantidadDeWorkers;
        this.buffer = buffer;


        //DEBERIA CREAR WORKERS
        /*
        for(int i=0;i<cantidadDeWorkers;i++) {
            new Worker(buffer).start();
        }
        */
    }

    //NI IDEA SI ESTA BIEN
    public synchronized void launch(){
        //envia una tarea a un Worker ocioso encolandola en el buffer.
    }

    public synchronized  void stop(){

    }


}
