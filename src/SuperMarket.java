import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class SuperMarket {
    Queue<String> queue1 = new ArrayBlockingQueue<>(5);
    Queue<String> queue2 = new ArrayBlockingQueue<>(5);
    Queue<String> queueReserve = new LinkedList<>();
    Random rnd = new Random();

    String[] data = {"A", "B", "C", "D", "E", "F"};

    String generateName() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            result += data[rnd.nextInt(data.length)];
        }
        return result;
    }

    public void add(String name) {
        if (queue1.size() <= queue2.size()) {
            if (!queue1.offer(name)) {
                System.out.println("Gala must hurry up to the cass.");
                queueReserve.offer(name);
            } else System.out.println(name + " was added to first queue");
        } else {
            if (!queue2.offer(name)) {
                System.out.println("Gala must hurry up to the cass.");
                queueReserve.offer(name);
            } else System.out.println(name + " was added to second queue");
        }
    }

    public void remove() {
        if (rnd.nextInt(2) == 0) {
            System.out.println(queue1.poll() + " was removed from first queue");
        } else System.out.println(queue2.poll() + " was removed from second queue");
    }
}
