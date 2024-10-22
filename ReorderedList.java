class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class DoublyLinkedList {
    Node head, tail;

    public DoublyLinkedList() {
        this.head = this.tail = null;
    }

    public void AddToEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void Display(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void ReorderList(){
        Node current = head;
        while (current != null && current.next != null){
            Node temp = current.next;
            current.next = current.next.next;
            if (current.next != null){
                current.next.prev = current;
            }
            temp.next = head;
            head.prev = temp;
            temp.prev = null;
            head = temp;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.AddToEnd(1);
        list.AddToEnd(2);
        list.AddToEnd(3);
        list.AddToEnd(4);
        list.AddToEnd(5);
        list.AddToEnd(6);
        list.AddToEnd(7);
        list.AddToEnd(8);
        list.AddToEnd(9);
        list.AddToEnd(10);
        list.Display();
        System.out.println();
        list.ReorderList();
        list.Display();
    }

    
}