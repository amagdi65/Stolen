import java.io.File;
import java.util.*;
public class FormDB {
    static Formatter out;
    static Scanner sc;
    static Vector <Form>formdb=new Vector<>() ;
    FormDB()
    {
        try {sc = new Scanner(new File("FormDB.txt"));}
        catch (Exception e) {}
       // int sz=Integer.parseInt(sc.nextLine());
        while (sc.hasNext())
        {
            Form f=new Form();
            f.setUsername(sc.nextLine());
            f.setCategory(sc.nextLine());
            f.setColor(sc.nextLine());
            f.setQuantity(sc.nextLine());
            f.setLocation(sc.nextLine());
            f.setAdditionalInfo(sc.nextLine());
            f.setStatus(sc.nextLine());
            formdb.add(f);
        }
    }
    public void AddFormRec(Form f) {

        formdb.add(f);
        UpdateFormRec();
    }
    public int SearchFormRec(Form f) {
        for(int i=0;i<formdb.size();i++)
        {
            if(f.getCategory().equals(formdb.elementAt(i).getCategory())
                    &&f.getColor().equals(formdb.elementAt(i).getColor())
                    &&f.getQuantity().equals(formdb.elementAt(i).getQuantity())
                    &&!f.getStatus().equals(formdb.elementAt(i).getStatus()))
            {return i;}
        }return -1;
    }
    static void writeOnFile(String code) {
        out.format("%s", code);
        out.format("%n");
        out.flush();
    }
    public void UpdateFormRec() {
        File temp=new File("FormDB.txt");
        temp.delete();
        File fnew=new File("FormDB.txt");

        try {
            out = new Formatter("FormDB.txt");}
        catch (Exception e) {}

        for(int i=0;i<formdb.size();i++)
        {
            writeOnFile(formdb.elementAt(i).getUsername());
            writeOnFile(formdb.elementAt(i).getCategory());
            writeOnFile(formdb.elementAt(i).getColor());
            writeOnFile(formdb.elementAt(i).getQuantity());
            writeOnFile(formdb.elementAt(i).getLocation());
            writeOnFile(formdb.elementAt(i).getAdditionalInfo());
            writeOnFile(formdb.elementAt(i).getStatus());
        }

    }
    public boolean DeleteformRecord(Form f) {
        int indx=SearchFormRec(f);
        IExceptions e = new IExceptions() ;
        if(indx==-1)	//Exception handels here
        {
            e.show_delete();
            return false;
        }
        else
        {
            formdb.remove(indx);
            UpdateFormRec();
            return true;
        }
    }

}
