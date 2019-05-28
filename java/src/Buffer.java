import java.util.ArrayList;
import java.util.List;

public class Buffer<T> {

    //BUFFER GENERICO FIFO

    private List<T> buffer;
    private int maxSizeBuffer;
    private int actualSize;

    public Buffer(int sizeBuffer) {
        this.buffer = new ArrayList<>();
        this.maxSizeBuffer = sizeBuffer;
        this.actualSize = 0;
    }

    public synchronized void writeBuffer(T dato) {
        while (this.isFull()) {
            try { wait();} catch (Exception e) {}
        }
        this.buffer.add(dato);
        this.actualSize++;
        notifyAll();
    }

    public synchronized T readBuffer() {
        while (buffer.isEmpty()) {
            try {wait();} catch(Exception e){}
        }
        T dato = buffer.remove(0);
        this.actualSize--;
        notifyAll();
        return dato;
    }

    private boolean isFull() {

        return this.actualSize == this.maxSizeBuffer;
    }
}
