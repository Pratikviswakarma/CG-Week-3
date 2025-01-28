// Class representing a Movie in the movie management system
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// Class to manage the movie collection using a doubly linked list
class MovieManagementSystem {
    private Movie head;
    private Movie tail;

    // Add a movie at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        int index = 1;

        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }

        if (temp == null) {
            addMovieAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newMovie;
            }
            temp.next = newMovie;
        }
    }

    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
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

                System.out.println("Movie \"" + title + "\" removed successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie \"" + title + "\" not found.");
    }

    // Search for a movie by director or rating
    public void searchMovie(String director, double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                System.out.println("Movie Found: Title=" + temp.title + ", Director=" + temp.director + ", Year=" + temp.year + ", Rating=" + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found with Director \"" + director + "\" or Rating " + rating + ".");
        }
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        Movie temp = head;
        System.out.println("Movies in Forward Order:");
        while (temp != null) {
            System.out.println("Title=" + temp.title + ", Director=" + temp.director + ", Year=" + temp.year + ", Rating=" + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        Movie temp = tail;
        System.out.println("Movies in Reverse Order:");
        while (temp != null) {
            System.out.println("Title=" + temp.title + ", Director=" + temp.director + ", Year=" + temp.year + ", Rating=" + temp.rating);
            temp = temp.prev;
        }
    }

    // Update a movie's rating by title
    public void updateRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated Rating of \"" + title + "\" to " + newRating);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie \"" + title + "\" not found.");
    }
}

// Main class to test the movie management system
public class MovieManagementSystemTest {
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        mms.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 9.0);
        mms.addMovieAtEnd("Titanic", "James Cameron", 1997, 8.5);
        mms.addMovieAtPosition("The Dark Knight", "Christopher Nolan", 2008, 9.1, 2);

        mms.displayMoviesForward();

        mms.updateRating("Titanic", 8.8);
        mms.searchMovie("Christopher Nolan", 9.1);

        mms.removeMovieByTitle("Inception");

        mms.displayMoviesReverse();
    }
}