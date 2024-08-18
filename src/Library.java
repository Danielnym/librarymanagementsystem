import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.title + " has been added to the library.");
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println(book.title + " has been removed from the library.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println(member.getName() + " has been registered as a member.");
    }

    public void removeMember(Member member) {
        if (members.remove(member)) {
            System.out.println(member.getName() + " has been removed from the library.");
        } else {
            System.out.println("Member not found in the library.");
        }
    }

    public void displayAllBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            book.displayDetails();
            System.out.println("");
        }
    }

    public void displayAllMembers() {
        System.out.println("Library Members:");
        for (Member member : members) {
            System.out.println("Name: " + member.getName());
            System.out.println("Member ID: " + member.getMemberId());
            member.displayBorrowedBooks();
            System.out.println("");
        }
    }


}