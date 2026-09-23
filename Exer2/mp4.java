package exer2;
import java.util.Scanner;

class Book {
    private String id, title;
    private boolean available;
    
    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}

class Member {
    private String id, name;
    private Book[] borrowedBooks = new Book[3];
    private int count = 0;
    
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void borrowBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println("Book unavailable.");
        } else if (count == 3) {
            System.out.println("Borrowing limit reached.");
        } else {
            borrowedBooks[count++] = book;
            book.setAvailable(false);
            System.out.println("Book borrowed.");
        }

    }

    public void returnBook(String bookId) {
        for (int i = 0; i < count; i++) {
            if (borrowedBooks[i].getId().equalsIgnoreCase(bookId)) {
                borrowedBooks[i].setAvailable(true);
                for (int j = i; j < count - 1; j++) {
                    borrowedBooks[j] = borrowedBooks[j + 1];
                }
                borrowedBooks[--count] = null;
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not borrowed.");
    }

    public void display() {
        System.out.print(name + ": ");
        if (count == 0) {
            System.out.println("No borrowed books");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.print(borrowedBooks[i].getTitle() + " ");
            }
            System.out.println();
        }
    }

}

public class mp4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of books: ");
        int bookCount = Integer.parseInt(sc.nextLine());
        Book[] books = new Book[bookCount];

        for (int i = 0; i < bookCount; i++) {
            System.out.print("Book ID: ");
            String id = sc.nextLine();
            System.out.print("Book title: ");
            String title = sc.nextLine();
            books[i] = new Book(id, title);
        }

        System.out.print("\nNumber of members: ");
        int memberCount = Integer.parseInt(sc.nextLine());
        Member[] members = new Member[memberCount];
        
        for (int i = 0; i < memberCount; i++) {
            System.out.print("Member ID: ");
            String id = sc.nextLine();
            System.out.print("Member name: ");
            String name = sc.nextLine();
            members[i] = new Member(id, name);
        }

        while (true) {
            System.out.print("\nEnter Member ID: ");
            String memberId = sc.nextLine();
            Member member = null;
            
            for (Member m : members) {
                if (m.getId().equalsIgnoreCase(memberId)) {
                    member = m;
                    break;
                }
            }

            if (member == null) {
                System.out.println("Member not found.");
                continue;
            }

            System.out.print("B-Borrow R-Return Q-Quit: ");
            String action = sc.nextLine();

            if (action.equalsIgnoreCase("Q")) {
                break;
            }

            System.out.print("Book ID: ");
            String bookId = sc.nextLine();

            if (action.equalsIgnoreCase("B")) {
                Book book = null;
                for (Book b : books) {
                    if (b.getId().equalsIgnoreCase(bookId)) {
                        book = b;
                        break;
                    }
                }

                if (book == null) {
                    System.out.println("Book not found.");
                } 
                
                else {
                    member.borrowBook(book);
                }

            } 
            
            else if (action.equalsIgnoreCase("R")) {
                member.returnBook(bookId);
            } 
            
            else {
                System.out.println("Invalid action.");
            }

        }

        System.out.println("BORROWED BOOKS");
        
        for (Member m : members) {

            m.display();

        }

        System.out.println("AVAILABLE BOOKS");
        for (Book b : books) {
            if (b.isAvailable()) {
                System.out.println(b.getTitle());
            }
        }
        sc.close();
    }

}
 