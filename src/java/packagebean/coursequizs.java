/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebean;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import jdk.nashorn.internal.parser.JSONParser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.json.JSONObject;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

/**
 *
 * @author NICK
 */

@ManagedBean(name="coursequizs")
@SessionScoped
public class coursequizs implements Serializable {
    
    
    //stoixeia vasis
    private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "\"jdbc:postgresql://localhost:5432/classdatabase\", \"postgres\",\n" +
"                \"root\"";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "root";
        public static String quiz1 ;
        public static String quiz2;
        public static String quiz3;
        public static String course1;
        public static String course2;
        public static String course3;
        public static String preliminary_test;
       // public static String 
    
    
    

    public int getCorrectAnswers() {
        return correctAnswers;
        
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
        System.out.println(correctAnswers);
    }

    public int getQuiestionslength() {
        return quiestionslength;
        
        
    }

    public void setQuiestionslength(int quiestionslength) {
        this.quiestionslength = quiestionslength;
        System.out.println(correctAnswers);
    }

    
public static int correctAnswers;
public static int quiestionslength;
public static int correctAnswers2;
public static int quiestionslength2;

    public  int getCorrectAnswers2() {
        return correctAnswers2;
    }

    public void setCorrectAnswers2(int correctAnswers2) {
        quizBean.correctAnswers2 = correctAnswers2;
    }

    public  int getQuiestionslength2() {
        return quiestionslength2;
    }

    public  void setQuiestionslength2(int quiestionslength2) {
        quizBean.quiestionslength2 = quiestionslength2;
    }

    public  int getCorrectAnswers3() {
        return correctAnswers3;
    }

    public  void setCorrectAnswers3(int correctAnswers3) {
        quizBean.correctAnswers3 = correctAnswers3;
    }

    public  int getQuestionslength3() {
        return questionslength3;
    }

    public  void setQuestionslength3(int questionslength3) {
        quizBean.questionslength3 = questionslength3;
    }
public static int correctAnswers3;
public static int questionslength3;
 private  Students s;
    private HibernateUtil helper;//sessionFactory object
    private Session session;
    
    public coursequizs() throws SQLException {
        
        
        
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
    

		
    
    
    
    
    
    
    public String quiz1() throws SQLException 
    { HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("quiz1form:txtProperty");
        txtProperty="7";
        int numberofanswers= Integer.parseInt(txtProperty);
        //note the difference when getting the parameter
        String correctAnswers= request.getParameter("correctAnswersfield");
        //use the value in txtProperty as you want...
        //Note: don't use System.out.println in production, use a logger instead
        System.out.println(txtProperty);
        System.out.println(correctAnswers);
        //converting string correctAnswers to integer
        int correctAnswersint = Integer.parseInt(correctAnswers);
        System.out.println(correctAnswersint);
        
        try{
            Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
        
        if(correctAnswersint != 9){
          String updateTableSQL = "UPDATE Students"
				+ " SET numberofanswers = numberofanswers+ ?, numberofrightanswers=numberofrightanswers +? "
				+ " WHERE firstname = ?";
        PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL);
        
         pstmt.setInt(1,9);
          pstmt.setInt(2,correctAnswersint);
          pstmt.setString(3, Login.firstname);
           pstmt.executeUpdate();
        }
        else {
          System.out.println("mpike");
                      course1="yes";
                     String updateTableSQL2 = "UPDATE Students"
				+ " SET numberofanswers = numberofanswers+ ?, numberofrightanswers=numberofrightanswers +? , course1=? "
				+ " WHERE firstname = ?";
                   PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL2);
      //to preparedstatement pstmt xrisimopoiei ti sundesi me tin vasi gia na treksei to SQL query, sto statement exoume valei 4 orismata =? opote thetoume sto kathe ena me ti seira tin timi tou gia na treksei swsta 
         pstmt.setInt(1,9);
          pstmt.setInt(2,correctAnswersint);
          pstmt.setString(3, "yes");
         // pstmt.setString(1, quiz1);
        //  pstmt.setString(2,quiz1);
        //  pstmt.setString(3,quiz1);
          pstmt.setString(4, Login.firstname);
           pstmt.executeUpdate();
           
                  }
        if(correctAnswersint <=3 )
        {
            course1="no";
                     String updateTableSQL2 = "UPDATE Students"
				+ " SET numberofanswers = numberofanswers+ ?, numberofrightanswers=numberofrightanswers +? , course1=? "
				+ " WHERE firstname = ?";
                   PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL2);
      //to preparedstatement pstmt xrisimopoiei ti sundesi me tin vasi gia na treksei to SQL query, sto statement exoume valei 4 orismata =? opote thetoume sto kathe ena me ti seira tin timi tou gia na treksei swsta 
         pstmt.setInt(1,9);
          pstmt.setInt(2,correctAnswersint);
          pstmt.setString(3, "no");
         // pstmt.setString(1, quiz1);
        //  pstmt.setString(2,quiz1);
        //  pstmt.setString(3,quiz1);
          pstmt.setString(4, Login.firstname);
           pstmt.executeUpdate();
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e+" οοpps");
        }
     //   try{
            
       //     statement.executeUpdate(updateTableSQL);

	//		System.out.println("Record is updated to DBUSER table!");
     //   }
      //  catch(Exception e)
     //   {
     //       	System.out.println("catched "+e.getMessage());
 //       }
   //     finally {
     //       if (statement != null) {
			//	statement.close();
	//		}
       // }
       // }
       // catch(Exception e)
       // {
            
       // }
      
       

     
     
//       session.getTransaction().begin();
//Query query = session.createSQLQuery("update Students set numberofanswers = :numberofanswers , setnumberofrightanswers= :correctAnswers" + " where firstname = :Login.firstname");
//query.setParameter("numberofanswers", numberofanswers);
//query.setParameter("numberofrightanswers", correctAnswersint);
//int result = query.executeUpdate();
//session.getTransaction().commit();
        
    //    correctAnswersint=0;
        if(correctAnswersint <=3)
        {
            correctAnswersint=0;
            return "class1.jsf";
        }
        else {
            correctAnswersint=0;
	   return "home.jsf";
        }
	}	
    
    public String quiz2()
    {
       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty2 = request.getParameter("quiz1form:txtProperty");
        txtProperty2="7";
        int numberofanswers= Integer.parseInt(txtProperty2);
        //note the difference when getting the parameter
        String correctAnswers2= request.getParameter("correctAnswersfield");
        //use the value in txtProperty as you want...
        //Note: don't use System.out.println in production, use a logger instead
        System.out.println(txtProperty2);
        System.out.println(correctAnswers2);
        //converting string correctAnswers to integer
        int correctAnswersint2 = Integer.parseInt(correctAnswers2);
        System.out.println(correctAnswersint2);
       
        
        
         try{
            Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
        
        if(correctAnswersint2 != 9){
          String updateTableSQL = "UPDATE Students"
				+ " SET numberofanswers = numberofanswers+ ?, numberofrightanswers=numberofrightanswers +? "
				+ " WHERE firstname = ?";
        PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL);
        
         pstmt.setInt(1,9);
          pstmt.setInt(2,correctAnswersint2);
          pstmt.setString(3, Login.firstname);
           pstmt.executeUpdate();
        }
        else {
          System.out.println("mpike");
                      course2="yes";
                     String updateTableSQL2 = "UPDATE Students"
				+ " SET numberofanswers = numberofanswers+ ?, numberofrightanswers=numberofrightanswers +? , course2=? "
				+ " WHERE firstname = ?";
                   PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL2);
      //to preparedstatement pstmt xrisimopoiei ti sundesi me tin vasi gia na treksei to SQL query, sto statement exoume valei 4 orismata =? opote thetoume sto kathe ena me ti seira tin timi tou gia na treksei swsta 
         pstmt.setInt(1,9);
          pstmt.setInt(2,correctAnswersint2);
          pstmt.setString(3, "yes");
         // pstmt.setString(1, quiz1);
        //  pstmt.setString(2,quiz1);
        //  pstmt.setString(3,quiz1);
          pstmt.setString(4, Login.firstname);
           pstmt.executeUpdate();
           
                  }
         if(correctAnswersint2 <=3 )
        {
            course1="no";
                     String updateTableSQL2 = "UPDATE Students"
				+ " SET numberofanswers = numberofanswers+ ?, numberofrightanswers=numberofrightanswers +? , course2=? "
				+ " WHERE firstname = ?";
                   PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL2);
      //to preparedstatement pstmt xrisimopoiei ti sundesi me tin vasi gia na treksei to SQL query, sto statement exoume valei 4 orismata =? opote thetoume sto kathe ena me ti seira tin timi tou gia na treksei swsta 
         pstmt.setInt(1,9);
          pstmt.setInt(2,correctAnswersint2);
          pstmt.setString(3, "no");
         // pstmt.setString(1, quiz1);
        //  pstmt.setString(2,quiz1);
        //  pstmt.setString(3,quiz1);
          pstmt.setString(4, Login.firstname);
           pstmt.executeUpdate();
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e+" oops");
        }
        
        
        
        
	    if(correctAnswersint2 <=3)
        {
            correctAnswersint2=0;
            return "class2.jsf";
        }
        else {
            correctAnswersint2=0;
	   return "home.jsf";
        }
	}
    
    public String quiz3()
    {
      HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty3 = request.getParameter("quiz1form:txtProperty");
        txtProperty3="7";
        int numberofanswers= Integer.parseInt(txtProperty3);
        //note the difference when getting the parameter
        String correctAnswers3= request.getParameter("correctAnswersfield");
        //use the value in txtProperty as you want...
        //Note: don't use System.out.println in production, use a logger instead
        System.out.println(txtProperty3);
        System.out.println(correctAnswers3);
        //converting string correctAnswers to integer
        int correctAnswersint3 = Integer.parseInt(correctAnswers3);
        System.out.println(correctAnswersint3);
        
         try{
            Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
        
        if(correctAnswersint3 != 9){
          String updateTableSQL = "UPDATE Students"
				+ " SET numberofanswers = numberofanswers+ ?, numberofrightanswers=numberofrightanswers +? "
				+ " WHERE firstname = ?";
        PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL);
        
         pstmt.setInt(1,9);
          pstmt.setInt(2,correctAnswersint3);
          pstmt.setString(3, Login.firstname);
           pstmt.executeUpdate();
        }
        else {
          System.out.println("mpike");
                      course3="yes";
                     String updateTableSQL2 = "UPDATE Students"
				+ " SET numberofanswers = numberofanswers+ ?, numberofrightanswers=numberofrightanswers +? , course3=? "
				+ " WHERE firstname = ?";
                   PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL2);
      //to preparedstatement pstmt xrisimopoiei ti sundesi me tin vasi gia na treksei to SQL query, sto statement exoume valei 4 orismata =? opote thetoume sto kathe ena me ti seira tin timi tou gia na treksei swsta 
         pstmt.setInt(1,9);
          pstmt.setInt(2,correctAnswersint3);
          pstmt.setString(3, "yes");
         // pstmt.setString(1, quiz1);
        //  pstmt.setString(2,quiz1);
        //  pstmt.setString(3,quiz1);
          pstmt.setString(4, Login.firstname);
           pstmt.executeUpdate();
           
                  }
        
        }
        catch(Exception e)
        {
            System.out.println(e+" oops");
        }
       
	     if(correctAnswersint3 <=3)
        {
            correctAnswersint3=0;
            return "class3.jsf";
        }
        else {
            correctAnswersint3=0;
	   return "home.jsf";
        }
	}	
    
    public void prel_test() throws SQLException 
    { HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("quiz1form:txtProperty");
        txtProperty="7";
        int numberofanswers= Integer.parseInt(txtProperty);
        //note the difference when getting the parameter
        String correctAnswers= request.getParameter("correctAnswersfield");
        //use the value in txtProperty as you want...
        //Note: don't use System.out.println in production, use a logger instead
        System.out.println(txtProperty);
        System.out.println(correctAnswers);
        //converting string correctAnswers to integer
        int correctAnswersint = Integer.parseInt(correctAnswers);
        System.out.println(correctAnswersint);
        
        
        try{
            Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
        
        
      
          System.out.println("mpike");
                      preliminary_test="yes";
                     String updateTableSQL2 = "UPDATE Students"
				+ " SET preliminary_test=? "
				+ " WHERE firstname = ?";
                   PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL2);
      //to preparedstatement pstmt xrisimopoiei ti sundesi me tin vasi gia na treksei to SQL query, sto statement exoume valei 4 orismata =? opote thetoume sto kathe ena me ti seira tin timi tou gia na treksei swsta 
         //pstmt.setInt(1,7);
          pstmt.setInt(1,correctAnswersint);
          //pstmt.setString(3, "yes");
         // pstmt.setString(1, quiz1);
        //  pstmt.setString(2,quiz1);
        //  pstmt.setString(3,quiz1);
          pstmt.setString(2, Login.firstname);
           pstmt.executeUpdate();
           
        
        }
        catch(Exception e)
        {
            System.out.println(e+" oops");
        }
 
       
        
	   
        }	
    
    public void studentLevel(String studLevel,String quizAnswer) throws SQLException 
    { 
        
       // String studLevel = "";
        try{
            Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
        
        
      
          System.out.println("mpike");
                     // level="yes";
                     String updateTableSQL2 = "UPDATE Students"
				+ " SET level=? ,quiz1=?"
				+ " WHERE firstname = ?";
                   PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(updateTableSQL2);
      //to preparedstatement pstmt xrisimopoiei ti sundesi me tin vasi gia na treksei to SQL query, sto statement exoume valei 4 orismata =? opote thetoume sto kathe ena me ti seira tin timi tou gia na treksei swsta 
         //pstmt.setInt(1,7);
          pstmt.setString(1,studLevel);
          pstmt.setString(2, quizAnswer);
         // pstmt.setString(1, quiz1);
        //  pstmt.setString(2,quiz1);
        //  pstmt.setString(3,quiz1);
          pstmt.setString(3, Login.firstname);
           pstmt.executeUpdate();
           
        
        }
        catch(Exception e)
        {
            System.out.println(e+" oops");
        }
 
       
        
	   
        }	
}
