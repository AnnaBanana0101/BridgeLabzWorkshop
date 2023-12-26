import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Library Management System!");

        Library library = new Library();

        Book sampleBook = new Book("Book1", "ABC", "XYZ", "TUV", 500);
        Member sampleMember = new Member("Anika", "Mumbai", "912378344", "xyz@gmail.com");

        library.addBook(sampleBook);
        library.addMember(sampleMember);
        
        System.out.println("Add books to the library: ");
        String done = "N";

        String title;
        String author;
        String publisher;
        String genre;
        int no_of_pages;

        do{
            Scanner readBooks = new Scanner(System.in);
            System.out.println("Enter book details: ");
            
            System.out.println("Title: ");
            title = readBooks.nextLine();

            System.out.println("Author: ");
            author = readBooks.nextLine();

            System.out.println("Genre: ");
            genre = readBooks.nextLine();

            System.out.println("Publisher: ");
            publisher = readBooks.nextLine();

            System.out.println("No of pages: ");
            no_of_pages = readBooks.nextInt();

            Scanner sc = new Scanner(System.in);
            System.out.println("Are you done? Y/N");
            done = sc.nextLine();

        } while(done.equals("N"));


        Loan loan = library.checkOutBook(sampleBook, sampleMember);
        
        library.checkInBook(sampleBook, sampleMember, loan);

        System.out.println("Book list: ");
        library.displayBookList(library.bookList);

        System.out.println("Checked out Book list: ");
        library.displayBookList(library.checkedOutBooks);

        System.out.println("OverDue books: ");
        library.displayBookList(library.overDueBooks);

        System.out.println("Fines for memeber " + sampleMember.name);
        System.out.println(sampleMember.overdue_fine);
        
    }
}
