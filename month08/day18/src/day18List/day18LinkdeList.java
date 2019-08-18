package day18List;

public class day18LinkdeList implements List{
    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head = null;
    private Node last = null;
    private int size = 0;

    @Override
    public boolean add(int element) {
        return add(0,element);
    }

    @Override
    public boolean add(int index, int element) {
        //1.判断下标的合法性
        if(index < 0 || index > size) {
            System.out.println("下标错误");
            return false;
        }
        //2.考虑头插的情况
        if(index == 0) {
            head = new Node(element, head,null);
            if(head.next != null) {
                head.next.prev = head;
            }
            if(size == 0) {
                last = head;
            }
            size++;
            return true;
        }
        //3.考虑尾插的情况
        if(index == size) {
            last = new Node(element,null,last);
            if(last.prev != null) {
                last.prev.next = last;
            }
            if(size == 0) {
                head = last;
            }

            size++;
            return true;
        }
        //4.先获取index位置处的结点，然后定义一个值为element的结点，并将各节点插入
        Node node = getNode(index);
        Node newNode = new Node(element, node, node.prev);
        node.prev.next = newNode;
        node.prev = newNode;

        //5.size++
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        //判断下标的合法性
        if(index < 0 || index > size) {
            System.out.println("下标错误");
            return -1;
        }
        //先获取index位置处的结点，然后访问结点的数值并返回
        return getNode(index).val;
    }

    @Override
    public int set(int index, int element) {
        //判断下标的合法性
        if(index < 0 || index > size) {
            System.out.println("下标错误");
            return -1;
        }

        //定义一个变量用来保存index处结点的数值
        int oldNodeVal = getNode(index).val;
        //将index处结点的数值更改为element
        getNode(index).val = element;
        //返回更改前结点的数值
        return oldNodeVal;
    }

    @Override
    public boolean remove(int index) {
        //判断下标的合法性
        if(index < 0 || index > size) {
            System.out.println("下标错误");
            return false;
        }

        //先找到index处的结点
        Node node = getNode(index);
        //删除node结点，将node的前驱结点指向node开始指向的结点，并把node指向结点的前驱结点更新为node的前驱结点
        //并且得判断是否会产生空指针异常
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = head.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            last = last.prev;
        }

        //size--
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Node getNode(int index) {
        if(index < size / 2) {
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }

            return cur;
        } else {
            Node cur = last;
            for(int i = 0; i > size -index - 1; i++) {
                cur = cur.prev;
            }

            return cur;
        }

    }
}
