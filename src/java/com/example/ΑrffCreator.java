/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author Filippos
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import packagebean.Login;
import packagebean.StudentBean;
import packagebean.StudentsTable;




public class ΑrffCreator{



  

public void ArffGenerator() throws SQLException{
   int myage=0;
   int mytest=0;
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
			   "select firstname,age,preliminary_test from students order by id"); 
		//query gia na emfanisoume oti theloume
		//get customer data from database
		ResultSet result =  ps.executeQuery();//ekteloume to query kai to apothikevoume sto ResultSet result 
		
		//List<StudentsTable> list = new ArrayList<StudentsTable>(); //dilwsi listas me parametro StudentsTable
		//int maxCount=-1;
              //  int count = 0;
              //  int max = 0;
		
       
            
	try(FileWriter fw = new FileWriter("E:\\Users\\Filippos\\Documents\\NetBeansProjects\\MapsCopy\\mytext.arff", false);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
                    out.println("@relation students");
                    out.println("");
                    out.println("@attribute age numeric");
                    out.println("@attribute test numeric");
                    out.println("");
                    out.println("@data");
                    out.println("");
                    while(result.next()){//oso uparxoune eggrafes sto result  p exei ta apotelesmata epanalave
			StudentsTable stud = new StudentsTable();//dimiourgia antikeimena stud klasis StudentsTable
			
			stud.setAge(result.getInt("age"));
			stud.setPreliminaryTest(result.getInt("preliminary_test"));
                        stud.setFirstname(result.getString("firstname"));
                        
                        //------------------------->xeirokinitos tropos gia na katalavw poio cluster einai oi kaloi kai poio oi kakoi<--------------------------
			/*if((stud.preliminary_test-stud.age)>max){
                        max = stud.preliminary_test-stud.age;
                        maxCount = count; 
                        count++;}*/
                        //------------------------------------------------------------------------------------------------------------------------------------
                        
                    if(stud.preliminary_test!=-1){
                    if(stud.firstname.equals(Login.firstname)){
                        myage=stud.age;
                        mytest=stud.preliminary_test;
                        System.out.println("myage"+","+"mytest");
                        System.out.println(Login.firstname);
                    }
                    else{
                        out.print(stud.age);
                        out.print(",");
		    //more code
                        out.println(stud.preliminary_test);
                    }
                    }
                        
                        
                     
                       }
                    
                   out.print(myage);
                        out.print(",");
		    //more code
                        out.println(mytest);
		    //more code
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
}
}
    

