package mir.project.queue.question2.impl;

public class Test {
    public static void main(String[] args) {
        QueueWithStacks<String> queue = new QueueWithStacks<>();
        queue.enQueue("salam");
        queue.enQueue("necesen");
        queue.enQueue("yaxshiyam");
        queue.enQueue("sagol");

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        queue.enQueue("edededede");
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
