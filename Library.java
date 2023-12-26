import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Library {

    ArrayList<Book> bookList = new ArrayList();
    ArrayList<Member> memberList = new ArrayList<>();

    ArrayList<Book> checkedOutBooks = new ArrayList<>();
    ArrayList<Book> overDueBooks = new ArrayList<>();

    public void addBook(Book book)
    {
        bookList.add(book);
        System.out.println("New Book Added! Title: " + book.title);
    }

    public void addMember(Member member)
    {
        memberList.add(member);
        System.out.println("New Member Added! Name: " + member.name);
    }

    public Loan checkOutBook(Book book, Member member)
    {

        System.out.println(" ");
        System.out.println("Checking out book:");
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Year: ");
        int year = sc.nextInt();

        System.out.println("Month");
        int month = sc.nextInt();

        System.out.println("Day");
        int day = sc.nextInt();

        LocalDate due_date = LocalDate.of(year, month, day);
        
        if(bookList.contains(book) && memberList.contains(member))
        {
            Loan loan = new Loan(book, member, due_date);
            checkedOutBooks.add(book);

            System.out.println("Checked out book " + book.title + "to member " + member.name);

            return loan;
        }
        else
        {
            System.out.println("Enter valid book and member details");
        }

        return null;
        
    }

    public void checkInBook(Book book, Member member, Loan loan)
    {
        if(checkedOutBooks.contains(book) && memberList.contains(member))
        {
            checkedOutBooks.remove(book);
        }

        LocalDate current_date = LocalDate.now();
        
        if(loan.book == book && loan.member == member)
        {
            if (current_date.isAfter(loan.due_date))
            {
                Period period = Period.between(loan.due_date, current_date);
                int days = period.getDays();
                member.overdue_fine = member.overdue_fine + 10*days;
                System.out.println("You have an overdue fine! Total overdue fine is: " + member.overdue_fine);
                overDueBooks.add(book);
            }

            System.out.println("Book checked back in successfully!");
        }
        else
        {
            System.out.println("Incorrect loan values");
        }
        
    }

    //Display all kids of book lists
    public void displayBookList (ArrayList<Book> bookList)
    {
        
        for(int i=0; i<bookList.size(); i++)
        {
            System.out.println(bookList.get(i).title);
        }

    }

    public void displayMemberList (ArrayList<Member> memberList)
    {
        
        for(int i=0; i<memberList.size(); i++)
        {
            System.out.println(memberList.get(i).name);
        }

    }



}