import java.util.Scanner;

public class connection {
   public RegDB RegistrationDB=new RegDB();
   public FormDB formdd=new FormDB();
   public User U=new User();
   public Scanner reader=new Scanner(System.in);
   //Form b= new Form();
    public void Set_User()
    {

    }
    public int Search(Form f)
    {
        int J = -1 ;
       // FormDB ff = new FormDB() ;
        IExceptions e = new IExceptions () ;
        int ind  = formdd.SearchFormRec(f) ;
        if(ind == -1)
        {
            e.show_search_record();
        }
        else
        {

            String name = formdd.formdb.elementAt(ind).getUsername();
            U.SetUserName(name);
            J = RegistrationDB.SearchUserRec(U);
            if(J==-1)
            {
                e.show_search_record();
            }else
            {
                if(formdd.formdb.elementAt(ind).getStatus()=="1")
                {
                    if(SendAdditionalInfo(formdd.formdb.elementAt(ind)));
                    {
                        SendContactInfo(J);
                        formdd.DeleteformRecord(formdd.formdb.elementAt(ind));
                        formdd.DeleteformRecord(f);
                    }

                }
                else
                {
                    SendContactInfo(J);
                }


            }


        }
        return J ;
        //htnady search ahmed magdy fl databasse
    }
    public void SendContactInfo(int i)
    {       System.out.println("There is a Matched  Result:\n\n");
            System.out.println("User name : "+RegDB.MyUsersDB.elementAt(i).UserName);
            System.out.println("Address : "+RegDB.MyUsersDB.elementAt(i).Address);
            System.out.println("Phone : "+RegDB.MyUsersDB.elementAt(i).Phone);
    }
    public boolean SendAdditionalInfo(Form f)
    {
        System.out.println(f.getAdditionalInfo());
        System.out.println("if accepted press 1 else press 0: ");
        boolean b=reader.nextBoolean();
        return b;

    }
}
