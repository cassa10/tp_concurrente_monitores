public class TaskPoisonPill extends Task {

    @Override
    public void run() throws RuntimeException{
        throw new PoisonException();
    }
}
