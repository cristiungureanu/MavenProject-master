package curs19;

import java.sql.Connection;

public class TestDB {
	
	public static String URL = "";
	public static String USER = "";
	public static String PASS = "";

	public static void main(String[] args) {

		Connection conn =  DbConn.openDbConnection(URL, USER, PASS);
		
		String selectQuery = "select * from customers;";
		String updateQUery = "update customers set CustomerName = 'Dragos' where CustomerName = 'PMG';";
		String deleteQuery = "delete from customers where CustomerName='Dragos';";
		
		System.out.println(DBQuerys.dbSelectQuery(conn, selectQuery));
		
		
		System.out.println("--------------------------------------------------------");
		DBQuerys.dbUpdateQuery(conn, updateQUery);
		System.out.println(DBQuerys.dbSelectQuery(conn, selectQuery));
		
		System.out.println("--------------------------------------------------------");
		DBQuerys.dbDeleteQuery(conn, deleteQuery);
		System.out.println(DBQuerys.dbSelectQuery(conn, selectQuery));

		DbConn.closeDbConnection(conn);
		
		
	}

}
