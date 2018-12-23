public class  FormVerfication {
    public Form f=new Form();
    public FormDB FDB=new FormDB();

    public boolean SaveData(Form ff)
    {
        IExceptions e = new IExceptions() ;
        if(isTrue(ff))
        {
            FDB.AddFormRec(ff);
            return true;
        }
        else
        {
            e.show_FormMsg();
            return false;
            //call it in exciption class
        }
    }
    public boolean isTrue(Form ff)
    {

        IExceptions e = new IExceptions() ;
        if(ff.getCategory()=="")
        {
            e.show_FormMsg();
            return false;
        }	// should the exception handel those cases
        if(ff.getColor()=="")
        {
            e.show_FormMsg();
            return false;
        }

        if(ff.getQuantity()=="")
        {
            e.show_FormMsg();
            return false;
        }
        return true;
    }
}
