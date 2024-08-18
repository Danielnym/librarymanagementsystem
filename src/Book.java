interface Borrowable {
    void borrow(Member member);
    void returnBook();
}
abstract class FictionBook extends Book {
    public FictionBook(String title, String author, String isbn, String genre) {
        super(title, author, isbn);
    }
}

abstract class NonFictionBook extends Book {
    public NonFictionBook(String title, String author, String isbn, String subject) {
        super(title, author, isbn);
    }
}
abstract class Book implements Borrowable {
     String title;
     String author;
     String isbn;
     boolean isAvailable;
     Member borrowedBy;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.borrowedBy = null;
    }


    public abstract void displayDetails();

    @Override
    public void borrow(Member member) {
        if (isAvailable) {
            isAvailable = false;
            borrowedBy = member;
            System.out.println(title + " has been borrowed by " + member.getName());
        } else {
            System.out.println(title + " is not available for borrowing.");
        }
    }

    @Override
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            borrowedBy = null;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " is already in the library.");
        }
    }


}

