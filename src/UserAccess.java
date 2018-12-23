
public class UserAccess{

    RegestrationVerification rv;
    User u;
    UserAccess()
    {
        rv= new RegestrationVerification ();
    }
    public void SetUser(User t)
    {
        u=new User();
        u.SetUserName(t.GetUserName());
        u.SetPassword(t.GetPassord());
        u.SetPhone(t.GetPhone());
        u.SetAddress(t.GetAddres());
    }
    public boolean SignUp(User t) {
        SetUser(t);
        boolean j=rv.isTrue(u);
        if(j)return true;
        else return false;
    }

    public boolean Login(User t) {
        SetUser(t);
        boolean j=rv.isExist(t);
        if(j)return true;
        else return false;
    }


}
