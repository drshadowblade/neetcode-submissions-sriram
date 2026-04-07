class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> mainStack;
    public MinStack() {
        minStack=new Stack<>();
        mainStack=new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || minStack.peek()>val)
            minStack.push(val);
        else
            minStack.push(minStack.peek());
        }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
