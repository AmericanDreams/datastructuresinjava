package mir.project.queue.impl;

public class Test {

    public static void main(String[] args) {
        QueueWithLinkedList<String> queue = new QueueWithLinkedList<>();

        queue.enQueue("salam");
        queue.enQueue("necesen");
        queue.enQueue("sene ne?");

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

    }
}
