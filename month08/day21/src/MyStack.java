import java.util.Arrays;

class MyStack {
    private int[] array = new int[10];
    private int top = 0; //栈中元素的个数

    public void ensureCapacity() {
        if(top < array.length) {
            return;
        }
        array = Arrays.copyOf(array, array.length * 2);
    }

    public int push(int element) {
        ensureCapacity();
        array[top++] = element;
        return element;
    }

    public int pop() {
        return array[--top];
    }

    //查看栈顶元素不删除
    public int  peek() {
        return array[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
