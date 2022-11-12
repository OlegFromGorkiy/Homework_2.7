import Auto_rasing.*;
import java.util.LinkedList;
import java.util.Queue;

public class FixStation {
    private Queue<Transport> transportQueue = new LinkedList<>();

    public void addTransport(Transport t) {
        if (t instanceof Bus) {
            t.diagnostic();
            return;
        }
        transportQueue.offer(t);
    }
    public void work(){
        if (transportQueue.isEmpty()){
            System.out.println("No one to fix.");
            return;
        }
        transportQueue.poll().diagnostic();
    }
}
