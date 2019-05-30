public class ProducerTest<T>  extends Thread{

    //TODO
    // BORRAR CLASE CUANDO SE TERMINE DE TESTIAR

    private Buffer<T> buffer;
    private T datoAProducir;

    public ProducerTest(Buffer<T> buffer,T datoAProducir){
        this.buffer = buffer;
        this.datoAProducir = datoAProducir;
    }

    @Override
    public void run() {
        buffer.writeBuffer(datoAProducir);
    }
}
