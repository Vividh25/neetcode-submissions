class MinStack {

    PriorityQueue<Integer> pq;
    Deque<Integer> dq;

    public MinStack() {
        pq = new PriorityQueue<>();
        dq = new ArrayDeque<>();
    }
    
    public void push(int val) {
        pq.add(val);
        dq.addFirst(val);
    }
    
    public void pop() {
        int num = dq.poll();
        pq.remove(num);
    }
    
    public int top() {
        return dq.peekFirst();
    }
    
    public int getMin() {
        return pq.peek();
    }
}
