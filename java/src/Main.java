public class Main {

    public static void main(String[] args){

        //CREA EL BUFFER con un size especifico
        Buffer<Integer> buffer = new Buffer<Integer>(4);

        //Cantidad de Workers
        int cantidadThreads = 2;

        ThreadPool threadPool = new ThreadPool(buffer,cantidadThreads);


        //TODO: PARA CORRER UN THREAD usar .start()
        //TODO: NO USAR .run()


    }

}
