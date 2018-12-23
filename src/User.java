
public class User {

    protected String UserName;
    protected String Password;
    protected String Phone;
    protected String Address;

    //public Vector  myRegistration;
    //public Vector  myIUser;
    //public Vector  myIUser;
    //public Vector  myIUser;
    public void SetUser(User u)
    {
        this.UserName=u.GetUserName();
        this.Password=u.GetPassord();
        this.Phone=u.GetPhone();
        this.Address=u.GetAddres();
    }
    public void SetPhone(String ph) {
        Phone=ph;
    }

    public String GetPhone() {
        return Phone;
    }

    public void SetPassword(String pas) {
        Password=pas;
    }

    public String GetPassord() {
        return Password;
    }

    public void SetAddress(String Add) {
        Address=Add;
    }

    public String GetAddres() {
        return Address;
    }

    public void SetUserName(String Un) {
        UserName=Un;
    }

    public String GetUserName() {
        return UserName;
    }

}