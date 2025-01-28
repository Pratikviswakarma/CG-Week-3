// Class representing a Ticket in the circular linked list
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Class to manage the Online Ticket Reservation System using a circular linked list
class TicketReservationSystem {
    private Ticket head;
    private Ticket tail;

    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
    }

    // Add a new ticket at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = tail = newTicket;
            tail.next = head; // Make it circular
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circularity
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = tail;

        do {
            if (temp.ticketId == ticketId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head; // Maintain circularity
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head; // Maintain circularity
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    // Display all tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets in the system.");
            return;
        }

        Ticket temp = head;
        System.out.println("Tickets in the Circular List:");
        do {
            System.out.println("[Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName + ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime + "]");
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets in the system.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("[Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName + ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime + "]");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for the query: " + query);
        }
    }

    // Calculate the total number of booked tickets
    public int countTickets() {
        if (head == null) {
            return 0;
        }

        Ticket temp = head;
        int count = 0;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

// Main class to test the Ticket Reservation System functionality
public class TicketReservationTest {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "John Doe", "Avengers", "A1", "10:00 AM");
        system.addTicket(2, "Jane Smith", "Batman", "B2", "12:00 PM");
        system.addTicket(3, "Alice Brown", "Avengers", "A2", "10:00 AM");

        system.displayTickets();

        system.searchTicket("Avengers");
        system.searchTicket("John Doe");

        System.out.println("Total Booked Tickets: " + system.countTickets());

        system.removeTicket(2);
        system.displayTickets();

        System.out.println("Total Booked Tickets: " + system.countTickets());
    }
}
