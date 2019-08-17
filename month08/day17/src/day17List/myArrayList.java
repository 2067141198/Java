package day17List;

import java.util.Arrays;

public class myArrayList implements List {
    int[] array = null;
    int size;

    private void ensureCapacity() {
        int capacity = 10;
        if(array.length != 0 && size < array.length) {
            return;
        } else {
            capacity = 2 * capacity;
        }

        if(array == null) {
            array = new int[capacity];
        } else {
            array = Arrays.copyOf(array, capacity);
        }

    }

    @Override
    public boolean add(int element) {
        return add(size, element);
    }

    @Override
    public boolean add(int index, int element) {
        //1.判断下标的合法性
        if(index < 0 && index > size) {
            System.out.println("下标错误");
            return false;
        }

        //2.判断空间是否够用
        ensureCapacity();

        //3.腾出index位置
        System.arraycopy(array,index,array,index + 1, size - index);

        //4.插入数字
        array[index] = element;

        //5.更新size
        size++;

        return true;
    }

    @Override
    public int get(int index) {
        //1.判断下标的合法性
        if(index < 0 || index > size) {
            System.out.println("下标错误");
            return -1;
        }

        return array[index];
    }

    @Override
    public int set(int index, int element) {
        //1.判断下标的合法性
        if(index < 0 || index > size) {
            System.out.println("下标错误");
            return -1;
        }

        int old = array[index];
        array[index] = element;
        return old;
    }

    @Override
    public boolean remove(int index) {
        //1.判断下标的合法性
        if(index < 0 || index > size) {
            System.out.println("下标错误");
            return false;
        } else {
            System.arraycopy(array,index +1,array,index,size - index - 1);

            size--;
            return true;
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class myArrayListIterator implements Iterator {
        private int index = 0;

        private myArrayListIterator(int val) {
            this.index = val;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }


        @Override
        public int next() {
            return array[index++];
        }

        @Override
        public int remove() {
            return 0;
        }
    }

    public static void main(String[] args) {
    }
}
