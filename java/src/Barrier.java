public class Barrier{
    private int number;

    public Barrier(int capacity){
        this.number = capacity;
    }

    public synchronized void esperar(){
        number--;
        while(number != 0 ){
            try{wait();}catch(Exception e){}
        }
        notifyAll();
    }
}
