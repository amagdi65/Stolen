import java.io.File;
import java.util.*;

public class RegDB {
    static Formatter out;
    static Scanner sc;
    static Vector <User>MyUsersDB=new Vector<>();
    RegDB()
    {

        try {sc = new Scanner(new File("RegDB.txt"));}
        catch (Exception e) {}
        int sz=Integer.parseInt(sc.nextLine());
        for(int i=0;i<sz;i++)
        {
            User u=new User();
            u.SetUserName(sc.nextLine());
            u.SetPassword(sc.nextLine());
            u.SetPhone(sc.nextLine());
            u.SetAddress(sc.nextLine());
            MyUsersDB.add(u);
        }
    }
    public boolean AddUserRecord(User u) {
        IExceptions z= new IExceptions();
        int indx=SearchUserRec(u);
        if(indx==-1)	//Exception handels here
        {MyUsersDB.add(u);UpdateUserDB();return true;}
        else
        {  z.show_add_record();
            return false;}
    }
    public int SearchUserRec(User u) {
        for(int i=0;i<MyUsersDB.size();i++)
        {
            if(u.GetUserName().equals(MyUsersDB.elementAt(i).GetUserName()))
            {return i;}
        }return -1;
    }
    boolean check(int ind,String pass)
    {
        if(MyUsersDB.elementAt(ind).GetPassord().equals(pass))return true;
        return false;
    }

    public boolean DeleteUserRecord(User U) {
        IExceptions w= new IExceptions();
        int indx=SearchUserRec(U);
        if(indx==-1)	//Exception handels here
        {
            // show delete exception messgae
            w.show_delete();
            return false;
        }
        else
        {
            MyUsersDB.remove(indx);
            UpdateUserDB();
            return true;
        }
    }
    static void writeOnFile(String code) {
        out.format("%s", code);
        out.format("%n");
        out.flush();
    }
    public void UpdateUserDB() {
        try {out = new Formatter("RegDB.txt");}
        catch (Exception e) {}
        String sz=""+MyUsersDB.size();writeOnFile(sz);
        for(int i=0;i<MyUsersDB.size();i++)
        {
            writeOnFile(MyUsersDB.elementAt(i).GetUserName());
            writeOnFile(MyUsersDB.elementAt(i).GetPassord());
            writeOnFile(MyUsersDB.elementAt(i).GetPhone());
            writeOnFile(MyUsersDB.elementAt(i).GetAddres());
        }

    }
}