/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebean;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;


@Named(value = "registerBean")
@SessionScoped
public class Register {
    
    private  Students s;
    private HibernateUtil helper;//sessionFactory object
    private Session session;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
     public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    public int getPreliminaryTest() {
        return preliminary_test;
    }

    public void setPreliminaryTest(int preliminary_test) {
        this.preliminary_test = preliminary_test;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static String email;
    public static String firstname;
    public static String lastname;
    public static String password;
    public static int age;
    public static int preliminary_test;
    public static String level;
    
    

    public  String getPasswordrepeat() {
        return passwordrepeat;
    }

    public  void setPasswordrepeat(String passwordrepeat) {
        Register.passwordrepeat = passwordrepeat;
    }
    public static String passwordrepeat;

    public  String getProperty() {
        return property;
    }

    public  void setProperty(String property) {
        Register.property = "student";
    }
    public static String property;

    public  String getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(String quiz1) {
        Register.quiz1 = quiz1;
    }

    public String getQuiz2() {
        return quiz2;
    }

    public   void setQuiz2(String quiz2) {
        Register.quiz2 = quiz2;
    }

    public    String getQuiz3() {
        return quiz3;
    }

    public   void setQuiz3(String quiz3) {
        Register.quiz3 = quiz3;
    }
    
    public static String quiz1;
    public static String quiz2;
    public static String quiz3;
    
    public static String course1;
    public static String course2;
    public static String course3;

    public  String getCourse1() {
        return course1;
    }

    public  void setCourse1(String course1) {
        Register.course1 = course1;
    }

    public  String getCourse2() {
        return course2;
    }

    public  void setCourse2(String course2) {
        Register.course2 = course2;
    }

    public  String getCourse3() {
        return course3;
    }

    public  void setCourse3(String course3) {
        Register.course3 = course3;
    }
    
  //  private UIComponent component;

 //   public UIComponent getComponent() {
 //       return component;
 //   }

 //   public void setComponent(UIComponent component) {
  //      this.component = component;
  //  }
    
    //register.addStudent() is called in the xhtml form where we parse values of email,firstname,lastname,password from the form
    public String addStudent() {
       
    //    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
      //              "Successfull\n", "You have successfully registered for the account sir  " + firstname + ". \n Thank You"));
     
        
      Students student  = new Students(email,firstname,lastname,0,0,password,property,quiz1,quiz2,quiz3,course1,course2,course3,age,preliminary_test,level);//calling the constructor Students of class Students and storing it object student
       try {
           session  = helper.getSessionFactory().openSession();
           Transaction tnx = session.beginTransaction();
        session.save(student);//save object student in database which contains all the information
        tnx.commit();
        
      
        
       }
      catch(Exception ex){
      ex.printStackTrace();
      return "registrationerror.jsf";
      }
        finally 
       {
           session.flush();
           session.close();
           System.out.println(firstname);
            
       }
       
        
    //   RequestContext context = RequestContext.getCurrentInstance();    
    //                context.execute("addRegisterInfoWindow(" + firstname + ", " + lastname + ");");
       
        return "successfulregistration.jsf";
    }
    
}
