// Class representing a Process in the circular linked list
class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

// Class to manage the Round Robin Scheduling using a circular linked list
class RoundRobinScheduler {
    private Process head;
    private Process tail;
    private final int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    // Add a process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);

        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Make it circular
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circularity
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        Process temp = head;
        Process prev = tail;

        do {
            if (temp.processId == processId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head; // Maintain circularity
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head; // Maintain circularity
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Process with ID " + processId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate Round Robin Scheduling
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Process current = head;
        int totalProcesses = 0;
        int totalTime = 0;
        double totalWaitTime = 0;
        double totalTurnaroundTime = 0;

        System.out.println("Simulating Round Robin Scheduling:");
        while (head != null) {
            int executedTime = Math.min(current.burstTime, timeQuantum);
            System.out.println("Executing Process ID: " + current.processId + " for " + executedTime + " units.");
            totalTime += executedTime;

            if (current.burstTime > timeQuantum) {
                current.burstTime -= timeQuantum;
                current = current.next;
            } else {
                totalWaitTime += (totalTime - current.burstTime);
                totalTurnaroundTime += totalTime;
                System.out.println("Process ID " + current.processId + " completed.");
                removeProcess(current.processId);
            }

            if (head == null) break; // Exit when all processes are done
        }

        totalProcesses = (int) totalTurnaroundTime / totalTime;
        System.out.println("Average Waiting Time: " + (totalWaitTime / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / totalProcesses));
    }

    // Display the list of processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }

        Process temp = head;
        System.out.println("Processes in the Circular List:");
        do {
            System.out.println("[ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority + "]");
            temp = temp.next;
        } while (temp != head);
    }
}

// Main class to test the Round Robin Scheduler functionality
public class RoundRobinTest {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Time Quantum = 4

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 1);

        scheduler.displayProcesses();

        scheduler.simulateScheduling();

        scheduler.displayProcesses();
    }
}