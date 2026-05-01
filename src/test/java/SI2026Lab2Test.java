import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {
    // 1. Every Statement
    @Test
    void searchBookEveryStatementTest() {
        Library lib = new Library();
        lib.addBook(new Book("Test", "A", "G"));

        assertThrows(IllegalArgumentException.class, () -> {
            lib.searchBookByTitle("");
        });

        assertNull(lib.searchBookByTitle("Unknown"));

        assertNotNull(lib.searchBookByTitle("Test"));

        lib.borrowBook("Test", "A");
        assertNull(lib.searchBookByTitle("Test"));
    }

    // 2. Every Branch
    @Test
    void borrowBookEveryBranchTest() {
        Library lib = new Library();
        lib.addBook(new Book("Test", "A", "G"));

        assertThrows(IllegalArgumentException.class, () -> {
            lib.borrowBook("", "A");
        });

        lib.borrowBook("Test", "A");

        assertThrows(RuntimeException.class, () -> {
            lib.borrowBook("Test", "A");
        });

        assertThrows(RuntimeException.class, () -> {
            lib.borrowBook("X", "Y");
        });
    }

    // 3. Multiple Condition - borrowBook
    @Test
    void borrowBookMultipleConditionTest() {
        Library lib = new Library();
        lib.addBook(new Book("Test", "A", "G"));

        assertThrows(IllegalArgumentException.class, () -> lib.borrowBook("", ""));

        assertThrows(IllegalArgumentException.class, () -> lib.borrowBook("", "A"));

        assertThrows(IllegalArgumentException.class, () -> lib.borrowBook("Test", ""));

        lib.borrowBook("Test", "A");
    }

    // 4. Multiple Condition - searchBookByTitle
    @Test
    void searchBookMultipleConditionTest() {
        Library lib = new Library();

        Book b1 = new Book("Test", "A", "G");
        Book b2 = new Book("Test", "A", "G");
        Book b3 = new Book("Other", "A", "G");

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        lib.borrowBook("Test", "A");

        assertNotNull(lib.searchBookByTitle("Test"));

        assertNull(lib.searchBookByTitle("NonExisting"));

        assertNull(lib.searchBookByTitle("Another"));
    }
}
