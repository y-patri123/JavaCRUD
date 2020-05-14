package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import java.sql.DriverManager;

public class DataBase {
	
	
	private String driverName;
	private String urlDb;
	private String userName;
	private String userPw;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private int nb;
	
	public DataBase () {
		List<User> users = new ArrayList<User>();
		driverName = "com.mysql.cj.jdbc.Driver";
		urlDb = "jdbc:mysql://127.0.0.1:3306/dbcc?serverTimezone=UTC";
		userName = "root";
		userPw = "";
		nb =0;
	}
	
	public void connexion( String query) {
		try {
			conn = DriverManager.getConnection(urlDb, userName, userPw);
			//conn = DriverManager.getConnection(urlDb, userName, userPw);
			stmt = conn.createStatement();  //préparation de la reqête
			rs = stmt.executeQuery(query); // (éxécution de la rq et le résultat est mis dans rs)dans rs nous avaons l'élément à renvoyer 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //connection à la bd
	}
	
	//méthode interne de chargement du pilote driver
	public void loadDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public List<User> getDataInDb(String query) {
		
		List<User> users = new ArrayList<User>();
		loadDriver();
		connexion(query);
		
		try {
			while (rs.next()) {
				User use = new User();
				use.setUserid(rs.getInt(1));
				use.setUserpwd(rs.getString(2));
				use.setTel(rs.getInt(3));
				use.setEmail(rs.getString(4));
				use.setVille(rs.getString(5));
				use.setMatricule(rs.getNString(6));
				users.add(use);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	private void connexion (String flag, User use) {
		String query = null;
		switch (flag.toUpperCase()) {
		case "INSERT":
			//query= "INSERT INTO user (userid, userpwd, tel, email, ville)\r\n"+
					//"VALUES('" + use.getUserid() + "', '" + use.getUserpwd() + "', '" 
					//+ use.getTel() + "', " + use.getEmail() +", " + use.getVille() + "',' "+ use.getMatricule() +");";
			query="INSERT INTO `user`(`userid`,`userpwd`,`tel`,`email`,`ville`, `matricule` )"
					+ " values ('"+use.getUserid()+"','"+use.getUserpwd()
			+"','"+use.getTel()+"','"+use.getEmail()+"','"+use.getVille()+"')";
		
			break;
		case "UPDATE":
			query="UPDATE user SET email='"+use.getEmail()+"' WHERE matricule='"+use.getMatricule()+"'";
			break;
	
		default:
			break;
		}
		 try {
			conn = DriverManager.getConnection(urlDb, userName, userPw);
			stmt = conn.createStatement();
			nb = stmt.executeUpdate(query);
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User setDataInDb(String flag, User use) {
		User used = null;
		loadDriver();
		connexion(flag, use);
		
		if (nb > 0) {
			String query = "SELECT * FROM user WHERE matricule = '"+ use.getMatricule() +"'";
			used = getDataInDb(query).get(0);
		}
		return used;
	}
	

}
