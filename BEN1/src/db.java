import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class db {
	Connection con = null;
	Statement sta = null;
	PreparedStatement psta = null;
	database db=new database();
	
	public static String name;
//	connect database with java and phpmyadmin
	public db() {
		String url="jdbc:mysql://"+db.host+":"+db.port+"/"+db.db_name;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,db.id,db.password);
            System.out.println("database connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("driver did not run");
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connection did not run");
        }
		
		
	
		
		
	}
//	adding inputs to database
	
	public void addTable(String username, String pass1, String name, String surname, String email) {
		String query ="insert into user (userName, userSurname, userPass, userUsername, userMail) values (?,?,?,?,?)";
		try {
			psta = con.prepareStatement(query);
			psta.setString(1, name);
			psta.setString(2, surname);
			psta.setString(3, pass1);
			psta.setString(4, username);
			psta.setString(5, email);
			psta.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
//	login control 
	public boolean check(String username, String pass) {
		String query="select * from user where userUsername=? and userPass=?";
		try {
			psta=con.prepareStatement(query);
			psta.setString(1, username);
			psta.setString(2, pass);
			ResultSet rs=psta.executeQuery();
			
		
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
//	create list from database
	public ArrayList<user> listall(){
		ArrayList<user> list = new ArrayList<user>();
		String query ="select * from user";
		try {
			sta=con.createStatement();
			ResultSet rs = sta.executeQuery(query);
			user user;
			
			while(rs.next()) {
				
				int id=rs.getInt("userId");
				String username=rs.getString("userName");
				String surname=rs.getString("userSurname");
				String userusername=rs.getString("userUsername");
				String userpass=rs.getString("userPass");
				String usermail=rs.getString("userEmail");

				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
	}

//method to print database
	public ArrayList<user> dataCome() {
		// TODO Auto-generated method stub
		ArrayList<user> list=new ArrayList<user>();
		String sorgu="select * from user";
		try {
			sta=con.createStatement();
			ResultSet rs=sta.executeQuery(sorgu);
			while(rs.next()){
				int userId = rs.getInt("userId");
				String userName = rs.getString("userName");
				String userSurname = rs.getString("userSurname");
				String userUsername = rs.getString("userUsername");
				String userPass = rs.getString("userPass");
				String userEmail = rs.getString("userMail");
			
				list.add(new user(userId,userName,userSurname,userUsername,userPass,userEmail));
				
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
