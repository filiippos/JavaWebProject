/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebean;

/**
 *
 * @author NICK
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


@ManagedBean(name="student")
@SessionScoped
public class StudentBean implements Serializable {

    public  int getRankingnumber() {
        return rankingnumber;
    }

    public  void setRankingnumber(int rankingnumber) {
        StudentBean.rankingnumber = rankingnumber;
    }

    
    public static int rankingnumber;
    public  String getUsername() {
        return username;
    }

    public  void setUsername(String username) {
        StudentBean.username = Login.firstname;
    }
    
   
    public static String username ;
   // private DataSource ds;
    
    //connecting to the database 
    
      public StudentBean() throws SQLException {
        
        //constructor gia sundesi me ti vasi
         
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
      
      
      public List<StudentsTable> getStudentList() throws SQLException{
          
          //sunartisi getStudentList lista me orisma to StudentsTable opou uparxoun oi metavlites me getters & setters , arxika kanoume ti sundesi me ti vvasi mas
          try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			

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
		
		 try{
            Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
                 }
                 catch(Exception e)
                 {
                     
                 }
		
		PreparedStatement ps 
			= connection.prepareStatement(
			   "select id,email,firstname,lastname,numberofanswers,numberofrightanswers,quiz1,quiz2,quiz3,course1,course2,course3 from students where numberofanswers!=0 order by (numberofrightanswers/numberofanswers) desc"); 
		//query gia na emfanisoume oti theloume
		//get customer data from database
		ResultSet result =  ps.executeQuery();//ekteloume to query kai to apothikevoume sto ResultSet result 
		
		List<StudentsTable> list = new ArrayList<StudentsTable>(); //dilwsi listas me parametro StudentsTable
		double score;
                int questions =0;
		while(result.next()){//oso uparxoune eggrafes sto result  p exei ta apotelesmata epanalave
			StudentsTable stud = new StudentsTable();//dimiourgia antikeimena stud klasis StudentsTable
			
			stud.setId(result.getInt("id"));
			stud.setEmail(result.getString("email"));
			stud.setFirstname(result.getString("firstname"));
			stud.setLastname(result.getString("lastname"));
                        stud.setNumberofanswers(result.getInt("numberofanswers"));
                        stud.setNumberofrightanswers(result.getInt("numberofrightanswers"));
                        stud.setQuiz1(result.getString("quiz1"));
                        stud.setQuiz2(result.getString("quiz2"));
                        stud.setQuiz3(result.getString("quiz3"));
                        
                       System.out.println(result.getInt("numberofanswers"));
                       questions = result.getInt("numberofanswers");
                       stud.setCourse1(result.getString("course1"));
                        stud.setCourse2(result.getString("course2"));
                        stud.setCourse3(result.getString("course3"));
                       System.out.println(questions);
                       if(questions!=0){
			stud.score = ((double)result.getInt("numberofrightanswers")/(double)result.getInt("numberofanswers"))*100;
                        System.out.println(stud.score);
                       }
                       else {
                           
                       }
			//store all data into a List
			list.add(stud);//apothikefsi sti lista mas to antikeimeno stud me ta stoixeia kathe eggrafis 
		}
			score =0;
		return list;
	}
      
      
      
      
      //MY STATISTICS FUNCTION
      
       public List<StudentsTable> statistics(String username) throws SQLException{
           
           
          
          //sunartisi getStudentList lista me orisma to StudentsTable opou uparxoun oi metavlites me getters & setters , arxika kanoume ti sundesi me ti vvasi mas
          try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			

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
		
		 try{
            Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
                 }
                 catch(Exception e)
                 {
                     
                 }
		
		PreparedStatement ps 
			= connection.prepareStatement(
			   "select firstname,numberofanswers,numberofrightanswers,quiz1,quiz2,quiz3,course1,course2,course3 from students where firstname='"+Login.firstname+"'"); 
		//query gia na emfanisoume oti theloume
		//get customer data from database
		ResultSet result =  ps.executeQuery();//ekteloume to query kai to apothikevoume sto ResultSet result 
		
		List<StudentsTable> list = new ArrayList<StudentsTable>(); //dilwsi listas me parametro StudentsTable
		double score;
                int questions =0;
		while(result.next()){//oso uparxoune eggrafes sto result  p exei ta apotelesmata epanalave
			StudentsTable stud = new StudentsTable();//dimiourgia antikeimena stud klasis StudentsTable
			
			
			stud.setFirstname(result.getString("firstname"));
			
                        stud.setNumberofanswers(result.getInt("numberofanswers"));
                        stud.setNumberofrightanswers(result.getInt("numberofrightanswers"));
                        stud.setQuiz1(result.getString("quiz1"));
                        stud.setQuiz2(result.getString("quiz2"));
                        stud.setQuiz3(result.getString("quiz3"));
                        
                       System.out.println(result.getInt("numberofanswers"));
                       questions = result.getInt("numberofanswers");
                       stud.setCourse1(result.getString("course1"));
                        stud.setCourse2(result.getString("course2"));
                        stud.setCourse3(result.getString("course3"));
                       System.out.println(questions+ "eftaseeeee");
                       if(questions!=0){
			stud.score = ((double)result.getInt("numberofrightanswers")/(double)result.getInt("numberofanswers"))*100;
                        System.out.println(stud.score);
                       }
                       else {
                           
                       }
			//store all data into a List
			list.add(stud);//apothikefsi sti lista mas to antikeimeno stud me ta stoixeia kathe eggrafis 
		}
			score =0;
		return list;
       }
       
       
       
       //MY TROPHIES FUNCTION
       
       public List<StudentsTable> trophies(String username) throws SQLException{
           
           
          
          //sunartisi getStudentList lista me orisma to StudentsTable opou uparxoun oi metavlites me getters & setters , arxika kanoume ti sundesi me ti vvasi mas
          try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			

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
		
		 try{
            Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
                 }
                 catch(Exception e)
                 {
                     
                 }
		
		PreparedStatement ps 
			= connection.prepareStatement(
			   "select firstname,lastname,quiz1,quiz2,quiz3,course1,course2,course3 from students where firstname='"+Login.firstname+"'"); 
		//query gia na emfanisoume oti theloume
		//get customer data from database
		ResultSet result =  ps.executeQuery();//ekteloume to query kai to apothikevoume sto ResultSet result 
		
		List<StudentsTable> list = new ArrayList<StudentsTable>(); //dilwsi listas me parametro StudentsTable
		double score;
                int questions =0;
		while(result.next()){//oso uparxoune eggrafes sto result  p exei ta apotelesmata epanalave
			StudentsTable stud = new StudentsTable();//dimiourgia antikeimena stud klasis StudentsTable
			
			
			stud.setFirstname(result.getString("firstname"));
			stud.setLastname(result.getString("lastname"));
                        
                        stud.setQuiz1(result.getString("quiz1"));
                        stud.setQuiz2(result.getString("quiz2"));
                        stud.setQuiz3(result.getString("quiz3"));
                        
                       
                       stud.setCourse1(result.getString("course1"));
                        stud.setCourse2(result.getString("course2"));
                        stud.setCourse3(result.getString("course3"));
                       System.out.println(questions);
                       if(questions!=0){
			stud.score = ((double)result.getInt("numberofrightanswers")/(double)result.getInt("numberofanswers"))*100;
                        System.out.println(stud.score);
                       }
                       else {
                           
                       }
			//store all data into a List
			list.add(stud);//apothikefsi sti lista mas to antikeimeno stud me ta stoixeia kathe eggrafis 
		}
			score =0;
		return list;
       }
       
       
       //RANKING FUNCTION
       
       
        public int ranking() throws SQLException{
           
           
          
          //sunartisi getStudentList lista me orisma to StudentsTable opou uparxoun oi metavlites me getters & setters , arxika kanoume ti sundesi me ti vvasi mas
          try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			

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
		
		 try{
            Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
                 }
                 catch(Exception e)
                 {
                     
                 }
		
		PreparedStatement ps 
			= connection.prepareStatement(
			    "select firstname,numberofanswers,numberofrightanswers from students where numberofanswers!=0 order by (numberofrightanswers/numberofanswers) desc"); 
		//query gia na emfanisoume oti theloume
		//get customer data from database
		ResultSet result =  ps.executeQuery();//ekteloume to query kai to apothikevoume sto ResultSet result 
		
		List<StudentsTable> list = new ArrayList<StudentsTable>(); //dilwsi listas me parametro StudentsTable
		double score;
                int questions =0;
                int rankingnumber=0;
                int studentscounter=0;
		while(result.next()){//oso uparxoune eggrafes sto result  p exei ta apotelesmata epanalave
                    studentscounter++;
			StudentsTable stud = new StudentsTable();//dimiourgia antikeimena stud klasis StudentsTable
			
			stud.setFirstname(result.getString("firstname"));
			stud.setNumberofanswers(result.getInt("numberofanswers"));
                        stud.setNumberofrightanswers(result.getInt("numberofrightanswers"));
                        System.out.println(result.getString("firstname"));
                        if(result.getString("firstname").equals(Login.firstname))
                        {
                            rankingnumber = studentscounter;
                            stud.ranking = rankingnumber;
                            System.out.println(rankingnumber);
                            System.out.println(stud.ranking);
                            StudentBean.rankingnumber=rankingnumber;
                            break;
                        }
                       System.out.println(rankingnumber);
                       System.out.println(questions);
                       if(questions!=0){
			stud.score = ((double)result.getInt("numberofrightanswers")/(double)result.getInt("numberofanswers"))*100;
                        System.out.println(stud.score);
                       }
                       else {
                           
                       }
			//store all data into a List
			list.add(stud);//apothikefsi sti lista mas to antikeimeno stud me ta stoixeia kathe eggrafis 
		}
			score =0;
		return rankingnumber;
       }
        
       /* public void getMax() throws SQLException{
          
          //sunartisi getStudentList lista me orisma to StudentsTable opou uparxoun oi metavlites me getters & setters , arxika kanoume ti sundesi me ti vvasi mas
          try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			

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
		
		 try{
            Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/classdatabase", "postgres",
                "root");
                 }
                 catch(Exception e)
                 {
                     
                 }
		
		PreparedStatement ps 
			= connection.prepareStatement(
			   "select age,preliminary_test from students"); 
		//query gia na emfanisoume oti theloume
		//get customer data from database
		ResultSet result =  ps.executeQuery();//ekteloume to query kai to apothikevoume sto ResultSet result 
		
		//List<StudentsTable> list = new ArrayList<StudentsTable>(); //dilwsi listas me parametro StudentsTable
		int maxCount=-1;
                int count = 0;
                int max = 0;
		while(result.next()){//oso uparxoune eggrafes sto result  p exei ta apotelesmata epanalave
			StudentsTable stud = new StudentsTable();//dimiourgia antikeimena stud klasis StudentsTable
			
			stud.setAge(result.getInt("age"));
			stud.setPreliminaryTest(result.getInt("preliminary_test"));
                        
			if(stud.age>max){
                        max = stud.age;
                        maxCount = count; 
                        
                        }
                        count++;
                       //System.out.println(questions);
                      // if(questions!=0){
			//stud.score = ((double)result.getInt("numberofrightanswers")/(double)result.getInt("numberofanswers"))*100;
                       // System.out.println(stud.score);
                       }
                      // else {
                           
                     //  }
			//store all data into a List
			//list.add(stud);//apothikefsi sti lista mas to antikeimeno stud me ta stoixeia kathe eggrafis 
        //}
			//score =0;
		//return maxCount;
	}*/
    
}
