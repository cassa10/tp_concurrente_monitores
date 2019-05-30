import java.util.List;

public class ThreadPool {


    private Buffer<Task> buffer;
    private int cantidadWorkers;

    public ThreadPool(Buffer<Task> buffer, int cantidadDeWorkers){

        this.cantidadWorkers = cantidadDeWorkers;
        this.buffer = buffer;

        //TODO
        // ¿DEBERIA CREAR WORKERS DE UNA?
        // LOS CREA TODOS JUNTOS O DE A UNO POR UNO
          /*
          for(int i=0;i<cantidadDeWorkers;i++) {
             new Worker<Task>(buffer).start();
          }
          */
    }

    public synchronized void launch(Task tarea){
        buffer.writeBuffer(tarea);
    }

    public synchronized  void stop(){
        //TODO
        // NOSE SI AGREGA SOLO UNA TAREA POISONPILL O AGREGA N THREADS
        buffer.writeBuffer(new TaskPoisonPill());
    }


}
