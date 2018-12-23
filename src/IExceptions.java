
public class IExceptions                 // Ibrahim Abdelhamed 20160004 CS_1
{

    Exceptions e = new Exceptions() ;
	
    public  void show_signUpMsg() 
	{
        e.SetSignupMessage() ;
        e.ShowSignupMessage();
    }
    public void show_loginMsg()
    {
        e.SetLoginMessage();
        e.ShowLoginMessage();
    }
    public void show_FormMsg()
    {
        e.SetFormMessage();
        e.ShowFormMessage();
    }

    public void show_delete()
    {
        e.set_delete();
        e.show_delete();
    }
    public void show_add_record()
    {
        e.set_add_record();
        e.show_add_record();
    }
    public void show_search_record()
    {
        e.set_search_record();
        e.show_search_record();
    }
}
