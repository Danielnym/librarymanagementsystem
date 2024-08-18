import java.util.Scanner;

public class LibraryManagementSystem {

    static Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    registerMember();
                    break;
                case 3:
                    borrowBook();
                    break;

                case 5:
                    library.displayAllBooks();
                    break;
                case 6:
                    library.displayAllMembers();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add a book");
        System.out.println("2. Register a member");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. Display all books");
        System.out.println("6. Display all members");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Is it a fiction book? (y/n): ");
        boolean isFiction = scanner.nextLine().toLowerCase().startsWith("y");

        Book book;
        if (isFiction) {
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();
            book = new FictionBook(title, author, isbn, genre) {
                @Override
                public void displayDetails() {

                }
            };
        } else {
            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();
            book = new NonFictionBook(title, author, isbn, subject) {
                @Override
                public void displayDetails() {

                }
            };
        }

        library.addBook(book);
    }

    void registerMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        Member member = new Member(name, memberId);
        library.registerMember(member);
    }

    void borrowBook() {
        // Implement borrowing logic
        System.out.print("Enter book name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        Member member = new Member(name, memberId);
        library.registerMember(member);
    }


}
