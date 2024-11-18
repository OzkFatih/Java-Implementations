public class Stack {
    private int[] stack;
    private int top;
    private int size;

    public Stack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = data;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        stack.pop();
        stack.display();
        System.out.println(stack.peek());
    }
}
