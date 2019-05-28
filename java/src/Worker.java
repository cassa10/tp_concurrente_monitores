import java.util.List;

public class Worker<T> extends Thread {

    private Buffer<T> buffer;

    public Worker(Buffer<T> buffer){

        this.buffer = buffer;

    }

    @Override
    public void run() {
        //TAREA A REALIZAR
    }
}
