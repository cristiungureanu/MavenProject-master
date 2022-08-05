package curs19;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBQuerys {
	
	public static List<String> dbSelectQuery(Connection conn, String Query){
		List<String> resultList = new ArrayList<String>();
		
		try {
			Statement statement =  conn.createStatement();
			ResultSet resultSet = statement.executeQuery(Query);
			while(resultSet.next()) {
				resultList.add(resultSet.getString(2));
			}
			
		}catch (SQLException e) {
			System.out.println("Nu am putut executa query-ul!");
		}
		
		return resultList;
	}
	
	public static void dbUpdateQuery(Connection conn , String query) {
		
		try {
			Statement statement =  conn.createStatement();
			statement.executeUpdate(query);
			System.out.println("Am facut update!");
			
			
		}catch(SQLException e) {
			System.out.println("Nu am putut face update!");
		}
		
	}
	
	public static void dbDeleteQuery(Connection conn , String query) {
		
		try {
			Statement statement =  conn.createStatement();
			statement.executeUpdate(query);
			System.out.println("Am facut delete!");
			
			
		}catch(SQLException e) {
			System.out.println("Nu am putut face delete!");
		}
		
	}
	

}
