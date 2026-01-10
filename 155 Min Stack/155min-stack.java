
class MinStack {

    Stack<Long> st = new Stack<>();
    long min = Long.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        long x = val;
        if (st.isEmpty()){
            min = val;
            st.push(x);
        } else {
            if (val>= min) st.push(x);
            else {
                st.push(2*x - min);
                min = x;
            }
        }
    }

    public void pop() {
        if (st.isEmpty()){
            return;
        }
        long topEl = st.pop();
        if (topEl<min){
            min = 2*min - topEl;
        }

        if (st.isEmpty()) {
            min = Long.MAX_VALUE;
        }
    }

    public int top() {
        if (st.isEmpty()) throw new RuntimeException("Stack is empty");

        long top = st.peek();
        if (top>=min){
            return (int) top;
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        if (st.isEmpty()) throw new RuntimeException("Stack is empty");
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */