public class Worker extends Thread {

    private Buffer<Task> buffer;

    public Worker(Buffer<Task> buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //TODO
        // BORRAR CUANDO SE PUEDA (SOLO TESTEO)
        buffer.readBuffer().run();

        //TODO
        // while(true){buffer.readBuffer();}

    }
}
