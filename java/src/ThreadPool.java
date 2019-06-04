public class ThreadPool {

    private Buffer<Task> buffer;
    private int workersNumber;

    public ThreadPool(int sizeBuffer, int workersNumber) {

        this.workersNumber = workersNumber;
        this.buffer = new Buffer<>(sizeBuffer);

        for (int i = 0; i < workersNumber; i++) {
            new Worker(buffer).start();
        }
    }

    public ThreadPool(int workersNumber) {

        this.workersNumber = workersNumber;
        this.buffer = new Buffer<>(workersNumber);

        for (int i = 0; i < workersNumber; i++) {
            new Worker(buffer).start();
        }
    }

    public void launch(Task tarea) {
        buffer.writeBuffer(tarea);
    }

    public void stop() {
        for(int i=0;i<this.workersNumber;i++){
            buffer.writeBuffer(new TaskPoisonPill());
        }
    }
}
