public class TaskDummy extends Task{

    //TODO
    // BORRAR CLASE CUANDO SE TERMINE DE TESTEAR

    String str ;


    public TaskDummy(String str){
        this.str = str;
    }
    @Override
    public void run() {
        System.out.println("Tarea dummy print: " + str);
    }
}
