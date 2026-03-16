import java.util.*;

class DinnerPlates {
    private int capacity;
    private List<Stack<Integer>> stacks;
    private TreeSet<Integer> availableStacks;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.availableStacks = new TreeSet<>();
    }

    public void push(int val) {
        // Find the leftmost stack that has space
        if (availableStacks.isEmpty()) {
            stacks.add(new Stack<>());
            availableStacks.add(stacks.size() - 1);
        }
        
        int index = availableStacks.first();
        Stack<Integer> stack = stacks.get(index);
        stack.push(val);
        
        // If this stack is now full, remove it from available set
        if (stack.size() == capacity) {
            availableStacks.remove(index);
        }
    }

    public int pop() {
        // Pop from the rightmost non-empty stack
        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }

        Stack<Integer> stack = stacks.get(index);
        int val = stack.pop();
        
        // Once we pop, this stack definitely has space now
        availableStacks.add(index);
        
        // Clean up empty stacks at the very end to keep pop() efficient
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            availableStacks.remove(stacks.size() - 1);
            stacks.remove(stacks.size() - 1);
        }
        
        return val;
    }
}
