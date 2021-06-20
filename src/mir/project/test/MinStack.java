package mir.project.test;

public class MinStack {

    private Node head;
    private Node minNode;

    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }

    public void push(int val) {
        Node node = new Node(val);

        if (head != null) {
            node.next = head;
        }

        if (minNode == null) {
            // stack is empty
            minNode = node;
        } else {
            if (node.value < minNode.value) {
                minNode = node;
            }
        }

        head = node;
    }

    public void pop() {
        Node tempHead = head;
        head = head.next;

        if (tempHead == minNode) {
            //MinNode is removed
            //assign new minNode
            minNode = head;
            tempHead = head;
            while (tempHead.next != null) {
                if (tempHead.next.value < minNode.value) {
                    minNode = tempHead;
                }
                tempHead = tempHead.next;
            }
        }
    }

    public int top() {
        return this.head.value;
    }

    public int getMin() {
        return minNode.value;
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
