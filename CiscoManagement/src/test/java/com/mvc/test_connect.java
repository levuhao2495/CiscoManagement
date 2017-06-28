package com.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test_connect {

	private Connection conn= null;
	private String hostname ="localhost";
	private int dbport =3306;
	private String databasename= "cisco_db";
	private String dbuser="root";
	private String dbpassword ="thienhuu";
	private Statement st;
	private ResultSet rs;
	private String sql;
	public test_connect(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" +
					this.hostname+":"+this.dbport+"/"+this.databasename, this.dbuser, this.dbpassword);
			if(conn != null)
			{
				System.out.println("Connected database success");
	
			}
			sql = "SELECT * FROM device";
			 // create the java statement
			st = conn.createStatement();
			 // execute the query, and get a java resultset
			rs = st.executeQuery(sql);
			 while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
			+ "\t"+ rs.getString(3)+ "\t" +
			 "\t" + rs.getString(4) + "\t" + rs.getInt(5)+ "\t" +
			 rs.getString(6)+ "\t"+ rs.getString(7)+ "\t"+ rs.getString(8)+ "\t"+
					 rs.getString(9));
			 }
			 conn.close();
		 
		}catch( Exception ex){
		System.out.println(ex.getMessage());
		 }
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test_connect tc= new test_connect();
	}

}
