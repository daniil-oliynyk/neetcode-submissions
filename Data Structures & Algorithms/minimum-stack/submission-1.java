class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        } else if (!minStack.empty() && minStack.peek() >= val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.empty()) {
            return;
        }
        int n = stack.pop();
        if (minStack.peek() == n) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
