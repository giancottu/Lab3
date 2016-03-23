package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CorsoDAO {

	private List<String> corsi = new LinkedList<String>();
	
	private String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";
	
	public List<String> elencoCorsi(){
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			Statement st = conn.createStatement();
			String sql="select nome from corso";
			ResultSet res = st.executeQuery(sql);
			corsi.add(res.getString("nome"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return corsi;
		
	}
}
