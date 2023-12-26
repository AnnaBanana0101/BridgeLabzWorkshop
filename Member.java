
public class Member {

    public String name;
    public String address;
    public String phone_number;
    public String email;

    public int overdue_fine;

    public Member(String name, String address, String phone_number, String email)
    {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }
}