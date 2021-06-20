package mir.project.test;

public class Test {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack.getMin());
    }
}
