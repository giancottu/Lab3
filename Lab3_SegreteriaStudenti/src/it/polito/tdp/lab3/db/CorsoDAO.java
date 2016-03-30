package it.polito.tdp.lab3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab3.model.Studente;

public class CorsoDAO {
	private List<String> corsi = new LinkedList<String>();
	
	private String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";
	
	
	public List<String> elencoCorsi(){

		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql="select nome from corso";
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()){
			
				String nome = res.getString("nome");
				
				corsi.add(nome);
			}
			
			res.close();
			conn.close();
			
		} catch (SQLException e) {//ogni istruzione scitta genera un SQLException perciò le blocco tutte nel catch
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return corsi;
		
	}
	
	public Studente student(int matricola){
		
		String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql ="select cognome,nome from studente where matricola=\""+matricola+"\"";
			
			ResultSet res = st.executeQuery(sql);
			
			if(res.next()){
				
				Studente s = new Studente(matricola, res.getString("cognome"), res.getString("nome"));
				
				res.close();
				conn.close();
				return s;
				
			}else{
				
				res.close();
				conn.close();
				return null;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

				
		return null;
	}
	
	public List<String> elencoMatricole(){
		
		String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";
		
		List<String>matricole = new LinkedList<String>();
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sql ="select matricola from studente";
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()){
				String matr = res.getString("matricola");
				
				matricole.add(matr);
			}
			
			res.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matricole;
		
	}
	
	public List<String> elencoStudentiDatoCodCorso(String codCorso){
		
		String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";
		
		List<String>studenti = new LinkedList<String>();
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			Statement st = conn.createStatement();
			
			String sqlmatr="select distinct matricola, nome, cognome, CDS from studente where "
					  +"matricola in (select matricola from iscrizione where codins=\""+codCorso+"\")";
			
			ResultSet res = st.executeQuery(sqlmatr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studenti;
	}
	
}
