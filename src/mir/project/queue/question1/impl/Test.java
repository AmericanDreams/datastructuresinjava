package mir.project.queue.question1.impl;

public class Test {

    public static void main(String[] args) {
        MaxStack<Integer> stack = new MyStack<>();
        stack.push(23);
        stack.push(3);
        stack.push(1);
        stack.push(123);
        stack.push(-1);
        stack.push(-123);

        //System.out.println(stack.pop());
        //System.out.println(stack.pop());

        System.out.println(stack.peekMax());
        System.out.println(stack.pop());

        System.out.println(stack.peekMax());
        System.out.println(stack.pop());

        System.out.println(stack.peekMax());
        System.out.println(stack.pop());

        System.out.println(stack.peekMax());
        System.out.println(stack.pop());


    }
}
