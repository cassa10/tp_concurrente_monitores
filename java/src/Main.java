public class Main {

    public static void main(String[] args){

        //CREA EL BUFFER con un size especifico
        Buffer<Integer> buffer = new Buffer<Integer>(2);

        //Cantidad de Workers
        int cantidadThreads = 2;

        //ThreadPool threadPool = new ThreadPool(buffer,cantidadThreads);
        ProducerTest<Integer> producer1 = new ProducerTest<Integer>(buffer,1);
        ProducerTest<Integer> producer2 = new ProducerTest<Integer>(buffer,3);
        ProducerTest<Integer> producer3 = new ProducerTest<Integer>(buffer,5);


        Worker<Integer> consumidor1 = new Worker<>(buffer);
        Worker<Integer> consumidor2 = new Worker<>(buffer);

        producer1.start();
        producer2.start();

    }

}
