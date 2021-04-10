package mir.project.queue.impl2;

public class Test {

    public static void main(String[] args) {
        QueueWithSingleLinkedList<String> queue = new QueueWithSingleLinkedList<>();

        queue.enQueue("salam");
        queue.enQueue("necesen");
        queue.enQueue("sene ne?");

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
