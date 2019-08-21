class MyQueue {
    static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    public void push(int element) {
        size++;
        //尾插
        if(rear != null) {
            rear.next = new Node(element);
            rear = rear.next;
        } else {
            front = rear = new Node(element);
        }
    }

    public int pop() {
        size--;
        int val = front.val;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        return val;
    }

    public int rear() {
        return rear.val;
    }

    public int front() {
        return front.val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
