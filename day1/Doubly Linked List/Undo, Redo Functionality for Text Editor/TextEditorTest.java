// Class representing a State in the text editor for undo/redo functionality
class TextState {
    String content;
    TextState next;
    TextState prev;

    TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

// Class to manage the undo/redo functionality using a doubly linked list
class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState currentState;
    private int size;
    private final int maxSize;

    public TextEditor(int maxSize) {
        this.head = null;
        this.tail = null;
        this.currentState = null;
        this.size = 0;
        this.maxSize = maxSize;
    }

    // Add a new state to the end of the list
    public void addState(String content) {
        TextState newState = new TextState(content);

        if (head == null) {
            head = tail = currentState = newState;
        } else {
            // Remove all states after the current state if any
            if (currentState != tail) {
                currentState.next = null;
                tail = currentState;
            }

            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            currentState = newState;
        }

        // Ensure the history size does not exceed maxSize
        size++;
        if (size > maxSize) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo functionality
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: Current State = " + currentState.content);
        } else {
            System.out.println("Undo: No more actions to undo.");
        }
    }

    // Redo functionality
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: Current State = " + currentState.content);
        } else {
            System.out.println("Redo: No more actions to redo.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.content);
        } else {
            System.out.println("No state available.");
        }
    }

    // Display all states from head to tail
    public void displayAllStates() {
        TextState temp = head;
        System.out.println("All States:");
        while (temp != null) {
            System.out.println(temp.content);
            temp = temp.next;
        }
    }
}

// Main class to test the undo/redo functionality
public class TextEditorTest {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // Limit the history to 10 states

        editor.addState("State 1: Hello World");
        editor.addState("State 2: Hello Java");
        editor.addState("State 3: Hello Doubly Linked List");

        editor.displayCurrentState();

        editor.undo();
        editor.undo();
        editor.redo();

        editor.addState("State 4: Undo/Redo Implemented");

        editor.displayCurrentState();
        editor.displayAllStates();

        editor.undo();
        editor.undo();
        editor.undo();
        editor.redo();
        editor.redo();
    }
}
