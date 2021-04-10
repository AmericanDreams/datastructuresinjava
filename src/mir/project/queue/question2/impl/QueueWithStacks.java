package mir.project.queue.question2.impl;

import mir.project.queue.question1.impl.MyStack;
/**
 * Interview Question #2
 *
 * The aim is to design a queue abstract data type with the help of stacks. (with 2 stack)
 * */
public class QueueWithStacks<T extends Comparable<T>> {

    private MyStack<T> enQueueStack = new MyStack<>();
    private MyStack<T> deQueueStack = new MyStack<>();
    private int size;

    public void enQueue(T data) {
        enQueueStack.push(data);
        size++;
    }

    public T deQueue() {
        if (size == 0) {
            return null;
        }

        if (deQueueStack.isEmpty()) {
            // fill stack by removing from first
            while (!enQueueStack.isEmpty()) {
                deQueueStack.push(enQueueStack.pop());
            }
        }
        size--;
        return deQueueStack.pop();
    }

    public T peek() {
        return deQueueStack.peek();
    }
}
