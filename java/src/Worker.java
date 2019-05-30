import java.util.List;

public class Worker<T> extends Thread {

    private Buffer<T> buffer;

    public Worker(Buffer<T> buffer){

        this.buffer = buffer;

    }

    @Override
    public void run() {
        //TODO
        // BORRAR CUANDO SE PUEDA (SOLO TESTEO)
        System.out.println(buffer.readBuffer());

        //TODO
        // while(true){buffer.readBuffer();}

    }
}
