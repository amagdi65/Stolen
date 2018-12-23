
public class Exceptions           // Ibrahim Abdelhamed 20160004 CS_1
{
    public String loginMsg   ="";
    public String SignupMsg  ="";
    public String FormMsg   ="";
    public String delete_message =""  ;
    public String add_record ="" ;
    public String search_record ="" ;
    public void SetLoginMessage() {
        this.loginMsg = "Invalid login process !" ;
    }
    public void SetSignupMessage() {
        this.SignupMsg = "Invalid signup process !"  ;
    }
    public void SetFormMessage() {
        this.FormMsg = "Missing required field in form !" ;
    }
    public void ShowFormMessage()
    {
        System.out.println(this.FormMsg);
    }
    public void ShowLoginMessage()
    {
        System.out.println(this.loginMsg);
    }
    public void ShowSignupMessage()
    {
        System.out.println(this.SignupMsg);
    }
    public void set_delete()
    {
        this.delete_message = "The record you want to delete is not found ! ";
    }
    public void show_delete()
    {
        System.out.println(this.delete_message);
    }
    public void set_add_record()
    {
        this.add_record = "The record is already exist ! " ;
    }
    public void show_add_record()
    {
        System.out.println(this.add_record);
    }
    public void set_search_record()
    {
        this.search_record = "This record is not found ! " ;
    }
    public void show_search_record()
    {
        System.out.println(this.search_record);
    }

}

