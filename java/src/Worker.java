public class Worker extends Thread {

    private Buffer<Task> buffer;

    public Worker(Buffer<Task> buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true){
            try {
                buffer.readBuffer().run();
            }catch (PoisonException e){
                //PRINT TEST
                //System.out.println("Thread died with ID: " + this.getId());
                break;
            }
        }
    }
}
