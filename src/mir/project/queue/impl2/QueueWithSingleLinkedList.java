package mir.project.queue.impl2;

public class QueueWithSingleLinkedList<T extends Comparable<T>> {
    private int size;
    private Node<T> first;
    private Node<T> last;
    // enQueue() last - next <- node <- node - first
    public void enQueue(T data) {
        Node<T> node = new Node<>(data);
       if (isEmpty()) {
           first = node;
           last = node;
       } else {
           last.next = node;
           last = node;
       }
        size++;
    }

    public T deQueue() {
        if (isEmpty()) {
            return null;
        } else {
            size--;
            T temp = first.data;
            first = first.next;
            if (isEmpty()) {
                last = null;
            }
            return temp;
        }
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return first.data;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
