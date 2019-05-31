import java.util.ArrayList;
import java.util.List;

public class ThreadPool {


    private Buffer<Task> buffer;
    private int workersNumber;
    private List<Barrier> barriers;

    public ThreadPool(Buffer<Task> buffer, int workersNumber){

        this.workersNumber = workersNumber;
        this.buffer = buffer;
        this.barriers = new ArrayList<>();

        for(int i=0;i<workersNumber;i++) {
             new Worker(buffer).start();
        }
    }

    //NO USAR POISON PILL CON ESTE METODO YA QUE NO POSEE BARRERA
    public void launch(Task tarea){
        barriers.add(new Barrier(1));
        buffer.writeBuffer(tarea);
    }

    public void stop(){
        //TODO
        // NOSE SI AGREGA SOLO UNA TAREA POISONPILL
        // TIENE QUE IR UNA BARRERA? PARA QUE TERMINEN TODOS LOS WORKERS ANTES DE PONER LA POSION

        barriers.forEach(b -> b.esperar());
        buffer.writeBuffer(new TaskPoisonPill());
    }

    //TODO
    //  PROBLEMA DEL BARRIER EL LAUNCH() TIENE PRIORIDAD ANTE EL STOP().

}
