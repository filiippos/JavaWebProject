/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import static javax.management.Query.value;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import packagebean.HibernateUtil;
import packagebean.Login;
import static packagebean.Register.quiz1;
import packagebean.Students;


/**
 *
 * @author NICK
 */


@Named(value = "checker")
@SessionScoped

public class QuizChecker implements Serializable {

  
    
    private  Students s;
     private HibernateUtil helper;//sessionFactory object
    private Session session;

    public  String getFirstname() {
        return firstname;
    }

    public  void setFirstname(String firstname) {
        QuizChecker.firstname = firstname;
    }
     
    
    public static String firstname;
   
    
    
    
    public QuizChecker() throws SQLException{
        
        
        
        
     try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}
        
         Connection connection = null;

        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
        
      }
    
    public String checker1() {
        boolean hasTrophy = false;
        
   System.out.println("mpike");
        boolean isValidStudent=false;
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        System.out.println(Login.firstname+"dsgdffsfsfsdfsd ");
         List students = session.createQuery("FROM Students where firstname=  '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
         System.out.println();
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
            
           // String studentQuiz1 = student.quiz1+"a";
            if(student.quiz1.equals("yes") || student.preliminary_test==-1 )
            {
                System.out.println("Have finished this quiz" );
                hasTrophy = true;
             return "";
            }
            else 
            {
                hasTrophy=false;
                System.out.println("You havent trophy");
                return "test1.jsf";
            }
            
         }
         tx.commit();
         
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }  finally 
       {
           session.flush();
           //session.close();
        
            
       }
   if(hasTrophy)
   {
       return "";
   }
   else 
   {
       return "test1.jsf";
   }
   }
    
    //function for quiz2
    
     public String checker2() {
        boolean hasTrophy = false;
        
   System.out.println("mpike");
        boolean isValidStudent=false;
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
        
        System.out.println(student.quiz1+"  YOOOOOOOOO");
        
      // String studentQuiz1 = student.quiz1+"a";
      // String studentQuiz2 = student.quiz2+"a";
   // StringUtils.defaultString(student.quiz1);

       System.out.println("reeeeeeeee");
            if(student.quiz1.equals("no") || student.quiz2.equals("yes")  )
            {
                System.out.println("Have finished this quiz" );
               
                hasTrophy = true;
                
             return "";
            
            }
            else 
            {
                hasTrophy=false;
                System.out.println("You havent trophy");
                return "test2.jsf";
            }
         
        
         }
         tx.commit();
         
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }  finally 
       {
           session.flush();
         //  session.close();
        
            
       }
   if(hasTrophy)
   {
       return "";
   }
   else 
   {
       return "test2.jsf";
   }
   }
    
    
    //function for quiz3
     
     
     
      public String checker3() {
        boolean hasTrophy = false;
        
   System.out.println("mpike");
        boolean isValidStudent=false;
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
          
            //String studentQuiz1 = student.quiz1+"a";
            //String studentQuiz2 = student.quiz2+"a";
            //String studentQuiz3 = student.quiz3+"a";
            
            if(student.quiz1.equals("no")||student.quiz2.equals("no")||student.quiz3.equals("yes")  )
            {
                System.out.println("Have finished this quiz" );
                hasTrophy = true;
             return "";
            }
            else 
            {
                hasTrophy=false;
                System.out.println("You havent trophy");
                return "test3.jsf";
            }
            
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
   if(hasTrophy)
   {
       return "";
   }
   else 
   {
       return "test3.jsf";
   }
   }
      
      
      
      //COURSES CHECKER FUNCTIONS 
      
      
      
      
      public String classchecker1() {
        boolean hasTrophy = false;
        
   System.out.println("mpike");
        boolean isValidStudent=false;
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
         
            if(student.preliminary_test==-1 || student.course1.equals("yes")  )
            {
                System.out.println("Have finished this quiz" );
                hasTrophy = true;
             return "";
            }
           
            else 
            {
                hasTrophy=false;
                System.out.println("You havent trophy");
                return "class1.jsf";
            }
            
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
   if(hasTrophy)
   {
       return "";
   }
   else 
   {
       return "course1.jsf";
   }
   }
      
      
      //COURSE 2 CHECKER 
      
       public String classchecker2() {
        boolean hasTrophy = false;
        
   System.out.println("mpike");
        boolean isValidStudent=false;
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
         
            if(student.preliminary_test==-1 || student.course2.equals("yes")  )
            {
                System.out.println("Have finished this quiz" );
                hasTrophy = true;
             return "";
            }
            else 
            {
                hasTrophy=false;
                System.out.println("You havent trophy");
                return "class2.jsf";
            }
            
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
   if(hasTrophy)
   {
       return "";
   }
   else 
   {
       return "course2.jsf";
   }
   }
       
       
       //COURSE 3 CHECKER
       
       
        public String classchecker3() {
        boolean hasTrophy = false;
        
   System.out.println("mpike");
        boolean isValidStudent=false;
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
         
            if(student.preliminary_test==-1 || student.course3.equals("yes")  )
            {
                System.out.println("Have finished this quiz" );
                hasTrophy = true;
             return "";
            }
            else 
            {
                hasTrophy=false;
                System.out.println("You havent trophy");
                return "class3.jsf";
            }
            
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
   if(hasTrophy)
   {
       return "";
   }
   else 
   {
       return "course3.jsf";
   }
   }
    
        
        
        //REPETITION QUIZS CHECKERS
        
     public String repetitionclasschecker1() {
        boolean badStudent = false;
        
   System.out.println("mpike");
        
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
         
            if(student.course1.equals("no")  )
            {
                System.out.println("Bad in this course" );
                badStudent=true;
             return "quiz1repetition.jsf";
            }
            else 
            {
                
               badStudent=false;
                
                return "quiz1.jsf";
            }
            
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
   if(badStudent)
   {
       return "quiz1repetition.jsf";
   }
   else 
   {
       return "quiz1.jsf";
   }
     }
     
     
     
     //REPETITION COURSE 2
     
     
      public String repetitionclasschecker2() {
        boolean badStudent = false;
        
   System.out.println("mpike");
        
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
         
            if(student.course2.equals("no")  )
            {
                System.out.println("Bad in this course" );
                badStudent=true;
             return "quiz2repetition.jsf";
            }
            else 
            {
                
               badStudent=false;
                
                return "quiz2.jsf";
            }
            
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
   if(badStudent)
   {
       return "quiz2repetition.jsf";
   }
   else 
   {
       return "quiz2.jsf";
   }
     }
      
      //COURSE 3 REPETITION
      
      
       public String repetitionclasschecker3() {
        boolean badStudent = false;
        
   System.out.println("mpike");
        
      //Get the session from the session factory.
          session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
         
            if(student.course3.equals("no")  )
            {
                System.out.println("Bad in this course" );
                badStudent=true;
             return "quiz3repetition.jsf";
            }
            else 
            {
                
               badStudent=false;
                
                return "quiz3.jsf";
            }
            
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
   if(badStudent)
   {
       return "quiz3repetition.jsf";
   }
   else 
   {
       return "quiz3.jsf";
   }
     }
       public int preliminaryTest(){
           int prel_x=0;
           session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
           // Integer.toString(student.preliminary_test);
            //String ab = student.preliminary_test+"a";
            //System.out.println(ab+" noooooooppppppoooooi");
            if(student.preliminary_test ==-1) 
            {
               
              prel_x=0;
            }
            else  prel_x=1 ;
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
      return prel_x; }
       
        public String levelOfStudent(){
           String levelx="";
           session  = helper.getSessionFactory().openSession();//opens the session object of class Session of Hibernate
      Transaction tx = null;//initialize the Transaction's class object tx
      try{
         tx = session.beginTransaction();//starts the transaction
        
         List students = session.createQuery("FROM Students where firstname= '"+Login.firstname+"'").list();//listing students from the select query to the database
         //Iterate over the result and print it.
        
         
         for (Iterator iterator =
                           students.iterator(); iterator.hasNext();){
            Students student = (Students) iterator.next();
           // Integer.toString(student.preliminary_test);
            //String ab = student.preliminary_test+"a";
            //System.out.println(ab+" noooooooppppppoooooi");
             levelx =student.level;

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
    return levelx; }
       
       
       
} 