import java.util.ArrayList;
import java.util.List;

public class Buffer {

    //BUFFER DE INTEGER FIFO

    private List<Integer> buffer = new ArrayList<Integer>();
    private int size;
    private int positionWrite;
    private int positionRead;


    public Buffer(int sizeBuffer){
        this.size = sizeBuffer;
        this.positionRead = 0;
        this.positionWrite = 0;
    }

    public synchronized void writeBuffer(int dato){
        while(existeDato(this.positionWrite)){
          try{wait();}catch (Exception e){}
        }

        this.buffer.set(this.positionWrite,dato);
        this.setNextPositionWrite();
        notifyAll();
    }

    public synchronized int readBuffer(){
        while(!existeDato(this.positionRead))
            try{wait();}catch (Exception e){}
        int dato = buffer.get(positionRead);
        buffer.set(positionRead,null);
        this.setNextPositionRead();
        notifyAll();

        return dato;
    }

    private boolean existeDato(int index){
        return buffer.get(index) != null;
    }

    private void setNextPositionWrite(){
        this.positionWrite = (positionWrite + 1) % size;
    }

    private void setNextPositionRead(){
        this.positionRead = (positionRead + 1) % size;
    }
}
