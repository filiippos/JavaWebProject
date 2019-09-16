package packagebean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;
 
@Named(value = "validator")
@ManagedBean
@SessionScoped
public class Validator implements Serializable {
 
    private static final long serialVersionUID = -7250065889869767422L;
 
    // @NotNull(message="Please enter the model number")
    private String mno;
    private String mno2;
    private String mno3;
    private String mno4;
    private String mno5;
     private String mno6;
    

    public String getMno6() {
        return mno6;
    }

    public void setMno6(String mno6) {
        this.mno6 = mno6;
    }

    public String getMno5() {
        return mno5;
    }

    public void setMno5(String mno5) {
        this.mno5 = mno5;
    }
    
    boolean mnoboolean,mnoboolean2,mnoboolean3,mnoboolean4,mnoboolean5,mnoboolean6 = false;
    
    

    public String getMno2() {
        return mno2;
    }

    public void setMno2(String mno2) {
        this.mno2 = mno2;
    }

    public String getMno3() {
        return mno3;
    }

    public void setMno3(String mno3) {
        this.mno3 = mno3;
    }

    public String getMno4() {
        return mno4;
    }

    public void setMno4(String mno4) {
        this.mno4 = mno4;
    }
 
    public String getMno() {
        return mno;
    }
 
    public void setMno(String mno) {
        this.mno = mno;
    }
    
    Register register = new Register();//object register to call addStudent method
 
     
    //firstname validation function 
    public boolean validateModelNo(FacesContext context, UIComponent comp,
            Object value) {
 
        System.out.println("inside validate method");
 
        String mno = (String) value;//sto string mno opou edwse o xristis dinetai i String timi tou object value
 
        if (mno.length() < 4) {//se periptwsi opou einai mikrotero twn 4 xaraktirwn kaleitai i sunartisi setValid me false gia na diksei i sunartisi oti den einai apodekti i timi
            ((UIInput) comp).setValid(false);
         System.out.println("firtsname length should be bigger than 4");
            FacesMessage message = new FacesMessage(//tha prepe na tupwne minima,dimiourgia object message tis klasis FacesMessage
                    "Minimum length of Firstname is 4");
            context.addMessage(comp.getClientId(context), message);//klisi tis addMessage
        mnoboolean=false;
        }
       else
        {
            mnoboolean=true;
        }
       return mnoboolean;
    }
    //lastname validation
    public boolean validateModelNo2(FacesContext context, UIComponent comp,
            Object value) {
 
        System.out.println("inside validate method");
 
        String mno2 = (String) value;
 
        if (mno2.length() < 4) {
            ((UIInput) comp).setValid(false);
         System.out.println("Lastname length should be bigger than 4");
            FacesMessage message = new FacesMessage(
                    "Minimum length of lastname is 4");
            context.addMessage(comp.getClientId(context), message);
            mnoboolean2= false;
        }
        else 
        {
            mnoboolean2= true;
        }
        return mnoboolean2;
    }
    
    //validation for email
    public boolean validateModelNo3(FacesContext context, UIComponent comp,
            Object value) {
 
        System.out.println("inside validate method");
 
        String mno3 = (String) value;
 
        if (mno3.length() < 4) {
            ((UIInput) comp).setValid(false);
         System.out.println("Email length should be bigger than 4");
            FacesMessage message = new FacesMessage(
                    "Minimum length of email is 4");
            context.addMessage(comp.getClientId(context), message);
            mnoboolean3=false;
            
        }
        else
        {
            mnoboolean3=true;
        }
        return mnoboolean;
    }
    
    //validation for password
    
    public boolean validateModelNo4(FacesContext context, UIComponent comp,
            Object value) {
 
        System.out.println("inside validate method");
 
        String mno4 = (String) value;
 
        if (mno4.length() < 8) {
            ((UIInput) comp).setValid(false);
         System.out.println("Password length should be bigger than 7");
            FacesMessage message = new FacesMessage(
                    "Minimum length of password is 4");
            context.addMessage(comp.getClientId(context), message);
           mnoboolean4=false;
        }
        else {
            mnoboolean4=true;
        }
        return mnoboolean4;
    }
    
    
     public boolean validateModelNo5(FacesContext context, UIComponent comp,
            Object value) {
 
        System.out.println("inside validate method");
        System.out.println(mno4);
        String mno5 = (String) value;
        System.out.println(mno5 + "fdfdfsfd");
        if (mno5.length() < 8) {
            ((UIInput) comp).setValid(false);
         System.out.println("Password is not the same with password confirmation");
            FacesMessage message = new FacesMessage(
                    "Password is not the same with the password confirmation");
            context.addMessage(comp.getClientId(context), message);
           mnoboolean5=false;
        }
        else {
            mnoboolean5=true;
        }
        return mnoboolean5;
    }
     
     public boolean validateModelNo6(FacesContext context, UIComponent comp,
            Object value) {
 
        System.out.println("inside validate method");
        System.out.println(mno4);
        int mno6 = (int) value;
        System.out.println(mno5 + "fdfdfsfd");
        if (mno6 < 5 || mno6 >12) {
            ((UIInput) comp).setValid(false);
         System.out.println("Age is not valid");
            FacesMessage message = new FacesMessage(
                    "The range of age is not 5-12");
            context.addMessage(comp.getClientId(context), message);
           mnoboolean6=false;
        }
        else {
            mnoboolean6=true;
        }
        return mnoboolean6;
    }
    
    
    
    
    
 
    public void validatefunction(boolean mnoboolean,boolean mnoboolean2, boolean mnoboolean3, boolean mnoboolean4)
    {
        System.out.println(mnoboolean);
        System.out.println(mnoboolean2);
           System.out.println(mnoboolean3);
           System.out.println(mnoboolean4);
       if(mnoboolean==true && mnoboolean2 == true && mnoboolean3 == true && mnoboolean4==true)
       {
           System.out.println(mnoboolean);
           System.out.println(mnoboolean2);
           System.out.println(mnoboolean3);
           System.out.println(mnoboolean4);
           register.addStudent();
       }
    }
    
}