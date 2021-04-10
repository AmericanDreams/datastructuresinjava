package mir.project.stack;

import mir.project.stack.impl.StackLinkedList;
import mir.project.stack.impl.StackWithArray;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Stack<String> stack = new StackWithArray<>();
        System.out.println(stack.size());

        System.out.println(stack.push("salam"));
        System.out.println(stack.push("necesen"));
        System.out.println(stack.push("bomba kimi!!!"));

        System.out.println(stack.size());

        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.size());



    }
}
