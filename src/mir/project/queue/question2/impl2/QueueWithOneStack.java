package mir.project.queue.question2.impl2;

import mir.project.queue.question1.impl.MyStack;

/**
 * Interview Question #2
 *
 * The aim is to design a queue abstract data type with the help of stacks. (with 1 stack)
 * */
public class QueueWithOneStack<T extends Comparable<T>> {
    private MyStack<T> stack = new MyStack<>();
    private T temp;

    public void enQueue(T data) {
        stack.push(data);
    }

    public T deQueue() {
        if (stack.size() == 1) {
            return stack.pop();
        } else if (stack.isEmpty()) {
            return null;
        }

        T item = stack.pop();
        T lastItemInTheStack = deQueue();

        enQueue(item);
        return lastItemInTheStack;
    }


}
