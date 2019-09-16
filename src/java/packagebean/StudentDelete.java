/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author NICK
 */

@ManagedBean(name="studentdelete")
@SessionScoped
public class StudentDelete implements Serializable{
    
    
    
    public StudentDelete() throws SQLException{
        
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
    
    public String StudentDeletion(String firstname) throws SQLException
    {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("studentdelete:txtProperty");
        System.out.println(txtProperty);
        System.out.println(firstname);
        
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
		
	
		
		PreparedStatement ps 
			= connection.prepareStatement(
			   "delete from students where firstname= '"+firstname+"'"); 
		//query gia na emfanisoume oti theloume
		//get customer data from database
		ResultSet result =  ps.executeQuery();
        connection.close();
        
        
        
        
        return "studentstable.jsf";
    }
    
}
