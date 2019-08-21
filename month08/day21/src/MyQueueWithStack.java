import java.util.Stack;

class MyQueueWithStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        /*if(stack2.peek() == null) {
            int size = stack1.size();
            for(int i = 0; i < size; i++) {
                stack2.add(stack1.pop());
            }
        }*/

        //如果第二个栈为空的话讲栈一里的元素全部倒过来
        if(stack2.empty()) {
            //将栈一中的元素全部倒入栈二
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek() {
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
