// Class representing a Book in the library management system
class Book {
    String title;
    String author;
    String genre;
    String bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    Book(String title, String author, String genre, String bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

// Class to manage the library collection using a doubly linked list
class LibraryManagementSystem {
    private Book head;
    private Book tail;

    // Add a book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, String bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a book at the end
    public void addBookAtEnd(String title, String author, String genre, String bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a book at a specific position
    public void addBookAtPosition(String title, String author, String genre, String bookId, boolean isAvailable, int position) {
        if (position <= 1) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int index = 1;

        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }

        if (temp == null) {
            addBookAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newBook;
            }
            temp.next = newBook;
        }
    }

    // Remove a book by Book ID
    public void removeBookById(String bookId) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId.equalsIgnoreCase(bookId)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }

                System.out.println("Book with ID \"" + bookId + "\" removed successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book with ID \"" + bookId + "\" not found.");
    }

    // Search for a book by Title or Author
    public void searchBook(String keyword) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                System.out.println("Book Found: Title=" + temp.title + ", Author=" + temp.author + ", Genre=" + temp.genre + ", ID=" + temp.bookId + ", Available=" + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No book found with Title or Author \"" + keyword + "\".");
        }
    }

    // Update a book's Availability Status
    public void updateAvailability(String bookId, boolean newStatus) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId.equalsIgnoreCase(bookId)) {
                temp.isAvailable = newStatus;
                System.out.println("Updated Availability of Book with ID \"" + bookId + "\" to " + newStatus);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book with ID \"" + bookId + "\" not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        Book temp = head;
        System.out.println("Books in Forward Order:");
        while (temp != null) {
            System.out.println("Title=" + temp.title + ", Author=" + temp.author + ", Genre=" + temp.genre + ", ID=" + temp.bookId + ", Available=" + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        Book temp = tail;
        System.out.println("Books in Reverse Order:");
        while (temp != null) {
            System.out.println("Title=" + temp.title + ", Author=" + temp.author + ", Genre=" + temp.genre + ", ID=" + temp.bookId + ", Available=" + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        Book temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}

// Main class to test the library management system
public class LibraryManagementSystemTest {
    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();

        lms.addBookAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "B001", true);
        lms.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", "B002", true);
        lms.addBookAtPosition("1984", "George Orwell", "Dystopian", "B003", true, 2);

        lms.displayBooksForward();

        lms.updateAvailability("B002", false);
        lms.searchBook("George Orwell");

        lms.removeBookById("B001");

        lms.displayBooksReverse();
        System.out.println("Total number of books: " + lms.countBooks());
    }
}