// Class representing a Task in the circular linked list
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Class to manage the Task Scheduler using a circular linked list
class TaskScheduler {
    private Task head;
    private Task tail;

    public TaskScheduler() {
        this.head = null;
        this.tail = null;
    }

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Make it circular
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Update tail's next to maintain circularity
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Make it circular
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Update tail's next to maintain circularity
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            System.out.println("Invalid position. Task not added.");
            return;
        }

        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
            tail.next = head; // Maintain circularity
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        Task prev = tail;

        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head; // Maintain circularity
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head; // Maintain circularity
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewAndMoveToNextTask() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        System.out.println("Current Task: [ID: " + head.taskId + ", Name: " + head.taskName + ", Priority: " + head.priority + ", Due Date: " + head.dueDate + "]");
        head = head.next;
    }

    // Display all tasks starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            System.out.println("[ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate + "]");
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        boolean found = false;
        System.out.println("Tasks with Priority " + priority + ":");
        do {
            if (temp.priority == priority) {
                System.out.println("[ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate + "]");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks with Priority " + priority + " found.");
        }
    }
}

// Main class to test the Task Scheduler functionality
public class TaskSchedulerTest {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtEnd(1, "Task A", 3, "2025-02-01");
        scheduler.addTaskAtEnd(2, "Task B", 1, "2025-02-02");
        scheduler.addTaskAtBeginning(3, "Task C", 2, "2025-01-31");
        scheduler.addTaskAtPosition(4, "Task D", 1, "2025-02-03", 2);

        scheduler.displayAllTasks();

        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();

        scheduler.searchTaskByPriority(1);

        scheduler.removeTaskById(2);
        scheduler.displayAllTasks();

        scheduler.removeTaskById(5); // Non-existent task
    }
}