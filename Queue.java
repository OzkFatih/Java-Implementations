public class Queue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
        } else {
            queue[++rear] = data;
        }
    }

    public int dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queue[++front];
        }
    }

    public int peek() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queue[front + 1];
        }
    }

    public void display() {
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.display();
        queue.dequeue();
        queue.display();
        System.out.println(queue.peek());
    }
}
