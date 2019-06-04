public class Barrier{
    private int capacity;

    public Barrier(int capacity){
        this.capacity = capacity;
    }

    public synchronized void esperar(){
        while(capacity > 0){
            try{wait();}catch(Exception e){}
        }
    }

    public synchronized void lessCapacity(){
        this.capacity--;
        notifyAll();
    }
}