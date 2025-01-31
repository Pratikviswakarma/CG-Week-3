package stackandqueue;

import java.util.Stack;

public class SortStack {
    // Function to sort a stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop(); // Pop top element
            sortStack(stack); // Recursively sort the remaining stack
            insertSorted(stack, top); // Insert the popped element in the sorted order
        }
    }

    // Helper function to insert an element into a sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int top = stack.pop(); // Remove the top element
            insertSorted(stack, element); // Recur for the rest
            stack.push(top); // Push the removed element back
        }
    }

    // Driver code
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
