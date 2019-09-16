/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebean;


import java.sql.Connection;
 import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginDAO {

	public static boolean validate(String firstname, String password) {
		Connection con = null;
		PreparedStatement ps = null;
                System.out.println("mpike stin validate");
		try {
			con = DataConnect.getConnection();
                        System.out.println("trexei to query");
			ps = con.prepareStatement("Select firstname, password, email from students where firstname = ? and password = ?");
			ps.setString(1, firstname);
			ps.setString(2, password);
                       
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
                            
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
}