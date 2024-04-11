// 使用两个栈实现
class MinStack {

    Stack<Integer> stack; //
    Stack<Integer> minStack; // 存放最小值

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        int i = stack.pop();
        if(i == minStack.peek())
            minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// 还可以改变数据结构，不用stack，用一个链表实现，只需在链表中多一个min字段即可。
