import java.util.Date;
import java.util.*;
import java.time.LocalDate;

public class Loan {
    Book book;
    Member member;
    // int year;
    // int month; 
    // int day;
    LocalDate due_date;  

    public Loan(Book book, Member member, LocalDate due_date)
    {
        this.book = book;
        this.member = member;
        this.due_date = due_date;
    }
}