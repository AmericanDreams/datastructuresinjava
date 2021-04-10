package mir.project.queue.question1.impl;

public interface MaxStack<T extends Comparable<T>> {
    void push(T data);
    T pop();
    T peek();
    T peekMax();
}
