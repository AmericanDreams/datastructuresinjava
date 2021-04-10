package mir.project.queue.question2.impl2;

public class Test {
    public static void main(String[] args) {
        QueueWithOneStack<String> queue = new QueueWithOneStack<>();
        queue.enQueue("salam");
        queue.enQueue("necesen");
        queue.enQueue("ne var");
        queue.enQueue("ne yox");

        System.out.println(queue.deQueue());

        queue.enQueue("ererferfe");


        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
