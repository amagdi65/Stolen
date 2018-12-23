
public class RegestrationVerification {
    RegDB rdb;
    RegestrationVerification()
    {
        rdb=new RegDB();
    }
    public boolean isTrue(User t)
    {

        IExceptions e = new IExceptions() ;
        if(t.GetUserName().length()==0)
        {  e.show_signUpMsg();  return false;}	// should the exception handel those cases
        if(t.GetPassord()=="")
        {e.show_signUpMsg();return false;}
        if(rdb.SearchUserRec(t)!=-1)
        {e.show_signUpMsg();return false;}
        if(t.GetPhone().length()==0)
        {e.show_signUpMsg();return false;}
        rdb.AddUserRecord(t);
        return true;
    }
    public boolean isExist(User t)
    { IExceptions m= new IExceptions();
        int ind=rdb.SearchUserRec(t);
        if(ind==-1)
        { m.show_loginMsg();
            return false;
        }
        else
        {
            if(rdb.check(ind,t.GetPassord()))
            {
                return true;
            }
            m.show_loginMsg();
            return false;
        }
    }
}
