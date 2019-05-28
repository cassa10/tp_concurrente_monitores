import java.util.ArrayList;
import java.util.List;

public class Buffer<T> {

    //BUFFER DE INTEGER FIFO

    private List<T> buffer = new ArrayList<>();
    private int sizeBuffer;
    private int positionWrite;
    private int positionRead;


    public Buffer(int sizeBuffer){
        this.sizeBuffer = sizeBuffer;
        this.positionRead = 0;
        this.positionWrite = 0;
    }

    public synchronized void writeBuffer(T dato){
        while(existeDato(this.positionWrite)){
          try{wait();}catch (Exception e){}
        }
        this.buffer.set(this.positionWrite,dato);
        this.setNextPositionWrite();
        notifyAll();
    }

    public synchronized T readBuffer(){
        while(!existeDato(this.positionRead)){
            try{wait();}catch (Exception e){}
        }
        T dato = buffer.get(positionRead);
        buffer.set(positionRead,null);
        this.setNextPositionRead();
        notifyAll();

        return dato;
    }

    private boolean existeDato(int index){
        return buffer.get(index) != null;
    }

    private void setNextPositionWrite(){
        this.positionWrite = (positionWrite + 1) % sizeBuffer;
    }

    private void setNextPositionRead(){
        this.positionRead = (positionRead + 1) % sizeBuffer;
    }
}
