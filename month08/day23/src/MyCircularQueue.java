class MyCircularQueue {
    private int[] array;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public MyCircularQueue(int k) {
        array = new int[k];
    }

    //向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if(array.length == size) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1 + size) % size;
        size++;
        return true;
    }

    //从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if(array.length == 0) {
            return false;
        }
        array[front] = 0;
        front = (front + 1) % size;
        size--;
        return true;
    }

    //从队首获取元素。如果队列为空，返回 -1 。
    public int Front() {
        if(size == 0) {
            return -1;
        }
        return array[front];
    }

    //获取队尾元素。如果队列为空，返回 -1 。
    public int Rear() {
        if(array.length == 0) {
            return -1;
        }
        return array[(rear - 1 + array.length) % array.length];
    }

    //检查循环队列是否为空。
    public boolean isEmpty() {
        return size == 0;
    }

    //检查循环队列是否已满。
    public boolean isFull() {
        return size == array.length;
    }
}
