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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
//import org.primefaces.context.RequestContext;

@Named(value = "mathsClassBean")
//@SessionScoped
public class MathsClassBean implements Serializable {

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 
   

  
  
   
      
      
    private Connection conn;
   public static String name;
    public static String password;
    public static String msg;

    public  String getAdminname() {
        return adminname;
    }

    public  void setAdminname(String adminname) {
        MathsClassBean.adminname = adminname;
    }

    public  String getAdminpassword() {
        return adminpassword;
    }

    public  void setAdminpassword(String adminpassword) {
        MathsClassBean.adminpassword = adminpassword;
    }

    
    public static String adminname;
    public static String adminpassword;
    
    
    
    public  String getMsg() {
        return msg;
    }

    public  void setMsg(String msg) {
        MathsClassBean.msg = msg;
    }
  

    public MathsClassBean() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/classdatabase", "postgres", "root");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MathsClassBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PreDestroy
    public void cleanUp() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MathsClassBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    public void login(){
        System.out.println("hi");
        System.out.println(name);
        System.out.println(password);
    }
    
    
    
    
    
    
    
    
    
}
