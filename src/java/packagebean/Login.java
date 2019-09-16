/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebean;

//import com.google.gson.Gson;
import java.io.Serializable;
import java.sql.Connection;

import javax.annotation.ManagedBean;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static packagebean.Register.email;
import static packagebean.Register.firstname;
//import org.primefaces.context.RequestContext;

/**
 *
 * @author NICK
 */

@Named(value = "login")
@SessionScoped
public class Login implements Serializable {
   private  Students s;
    private HibernateUtil helper;//sessionFactory object
    private Session session;
    
    public String name;
    public String lastname;
     //public int age;
    
    public static String username;
    public static String password;

    public  int getId() {
        return id;
    }

    public  void setId(int id) {
        Login.id = id;
    }

    
    public static int id ;
    
    public  String getAdminusername() {
        return adminusername;
    }

    public  void setAdminusername(String adminusername) {
        Login.adminusername = adminusername;
    }

    public  String getAdminpassword() {
        return adminpassword;
    }

    public  void setAdminpassword(String adminpassword) {
        Login.adminpassword = adminpassword;
    }
    
    
    public static String adminusername;
    public static String adminpassword;

    public String getFirstname() {
        return firstname;
    }

    public  void setFirstname(String firstname) {
        Login.firstname = firstname;
    }
    public static String firstname;

    public  String getUsername() {
        return username;
    }

    public  void setUsername(String username) {
        Login.username = username;
    }

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        Login.password = password;
    }
  //  session  = helper.getSessionFactory().openSession();
    //       Transaction tnx = session.beginTransaction();
      //  session.save(student);//save object student in database which contains all the information
      //  tnx.commit();
    
     public String listStudents(){
         System.out.println("mpike");
        boolean isValidStudent=false;
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students").list();//listing students from the select query to the database
         //Iterate over the result and print it.
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
            System.out.print("Name : " + student.getFirstname());
            System.out.println("fdsfsdf" +student.firstname+ "");
            System.out.println("username " + firstname);
            System.out.println("password " + password);
            if(student.firstname.equals(firstname) && student.password.equals(password) )
            {
                System.out.println("That's  right, username :"+firstname+ " and password :" +password );
              //  Login.id = student.id;
                Login.firstname=firstname;
                Login.password=password;
                isValidStudent=true;
                break;
             //   Login.id = student.id;
             //   System.out.println(Login.id);
            }
            else 
            {
                
            }
         //   System.out.print("\tLastName: " + student.getLastname());
            // Get the author of the book here.
            
         //   System.out.println("mathites ");
            
         }
         tx.commit();
         
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      } 
      catch(NullPointerException e)
      {
          System.out.println(e +"wrong");
      }
          
          
          finally 
       {
           session.flush();
           session.close();
        
            
       }
      if(isValidStudent==true)
      {
          return "home.jsf";
      }
      else 
      {
          return "index.jsf";
      }
      
   }
    
     
     //validate login
	public String validateUsernamePassword() {
           // System.out.println("mpike sti validateUsernamePassword");
		boolean valid = LoginDAO.validate(firstname, password);
		if (valid) {
               //     System.out.println("swsta stoixeia");
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("firstname", firstname);
                        Login.firstname= firstname;
                      //  System.out.println("global variable " +Login.firstname);
			return "home.jsf";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "index.jsf";
		}
            
                
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
               // Login.firstname = "";
		return "index.jsf";
	}
        
        
        
        
        
        
        
        //admins login function listadmins
        
        public String listAdmins(){
            boolean isValid=false;
         System.out.println("mpike");
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List admins = session.createQuery("FROM Admins").list();//listing admins from the select query to the database
         //Iterate over the result and print it.
         for (Iterator iterator =
                           admins.iterator(); iterator.hasNext();){
            Admins admin = (Admins) iterator.next();
          //  System.out.print("Name : " + student.getFirstname());
          //  System.out.println("fdsfsdf" +student.firstname+ "");
            System.out.println(admin.username);
            System.out.println(admin.password);
            System.out.println(adminusername);
            System.out.println(adminpassword);
            if(admin.username.equals(adminusername) && admin.password.equals(adminpassword) )
            {
                System.out.println("That's  right, username :"+adminusername+ " and password :" +adminpassword );
                HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", adminusername);
                        isValid=true;
			return "adminhome.jsf";
               
            }
            else {
			//FacesContext.getCurrentInstance().addMessage(
			//		null,
			//		new FacesMessage(FacesMessage.SEVERITY_WARN,
				///			"Incorrect Username and Passowrd",
			//				"Please enter correct username and Password"));
			//return "admin.jsf";
		}
         //   System.out.print("\tLastName: " + student.getLastname());
            // Get the author of the book here.
            
         //   System.out.println("mathites ");
            
         }
         tx.commit();
         
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }  finally 
       {
           session.flush();
           session.close();
        
            
       }
      if(isValid==true){
      return "adminhome.jsf";
      }
      else
      {
          return "admin.jsf";
      }
      
   }
        
        
        
        
        
        
        
        
}
