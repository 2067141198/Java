package day17List;

public interface List {
    boolean add(int element);

    boolean add(int index, int element);

    int get(int index);

    int set(int index, int element);

    boolean remove(int index);

    int size();

    boolean isEmpty();
}
