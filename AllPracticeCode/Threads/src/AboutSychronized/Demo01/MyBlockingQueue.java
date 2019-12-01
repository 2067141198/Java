package AboutSychronized.Demo01;

public class MyBlockingQueue<E> {
    //用数组实现队列
    private Object[] elements;
    //从队列中添加元素的下标
    private int addIndex;
    //从队列中删除元素的下标位置
    private int takeIndex;
    //数组的长度
    private int size;
    //默认的队列长度
    private volatile int DEFAULTCAPACITY = 10;

    public MyBlockingQueue(int capacity) {
        elements = new Object[capacity];
    }

    //@SuppressWarnings("All")
    public MyBlockingQueue() {
        if (elements == null) {
            synchronized (this) {
                if (elements == null) {
                    elements = new Object[DEFAULTCAPACITY];
                }
            }
        }
    }

    public synchronized E take() {
        E element = null;
        try {
            while (size == 0)
                wait();
            element = (E) elements[takeIndex];
            takeIndex = (takeIndex + 1) % elements.length;
            size--;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return element;
    }

    public synchronized void put(E element) {
        try {
            while (size == elements.length)
                wait();
            elements[addIndex] = element;
            addIndex = (addIndex + 1) % elements.length;
            size++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
