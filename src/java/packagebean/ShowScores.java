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
import javax.faces.context.FacesContext;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.primefaces.context.RequestContext;

/**
 *
 * @author NICK
 */

@Named(value = "showScores")
public class ShowScores {
   private  Students s;
    private HibernateUtil helper;//sessionFactory object
    private Session session;
    
    public String name;
    public String lastname;
    
     public String listStudents( ){
         System.out.println("mpike");
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
            if(student.firstname.equals("athanasiou2") )
            {
                System.out.println("That's  right");
            }
       
            System.out.print("\tLastName: " + student.getLastname());
            // Get the author of the book here.
            
            System.out.println("mathites ");
            
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }finally {
         session.close();
      }
      return "index.jsf";
   }
}
