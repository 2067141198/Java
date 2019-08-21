import java.util.Stack;

class MinStack {
    private Stack<Integer> normal = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int element) {
        normal.push(element);

        if(min.empty()) {
            min.push(element);
        } else {
            if(element <= min.peek()) {
                min.push(element);
            }
        }
    }

    public void pop() {
        normal.pop();
        min.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
