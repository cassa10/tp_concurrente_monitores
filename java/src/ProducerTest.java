public class ProducerTest<T>  extends Thread{

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
