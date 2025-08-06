import java.util.Stack;

class MinStack {
    Stack<Long> s = new Stack<>();
    long mini;

    public MinStack() {
    }

    public void push(int val) {
        if (s.isEmpty()) {
            mini = val;
            s.push(0L); // difference between val and mini is 0
        } else {
            s.push((long) val - mini);
            if (val < mini) {
                mini = val;
            }
        }
    }

    public void pop() {
        if (s.isEmpty()) return;

        long diff = s.pop();
        if (diff < 0) {
            mini = mini - diff; // restore previous mini
        }
    }

    public int top() {
        long diff = s.peek();
        if (diff > 0) {
            return (int) (mini + diff);
        } else {
            return (int) mini;
        }
    }

    public int getMin() {
        return (int) mini;
    }
}
