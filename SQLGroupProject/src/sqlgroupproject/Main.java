package sqlgroupproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
private static final String databaseURL = "jdbc:derby:FirstDatabase;create=true";
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection(databaseURL);
			Statement statement = connection.createStatement()){
			//Unneeded for now
//				statement.execute(Store.createTable);
//				statement.execute(Store.insertData);
//				ResultSet resultset = statement.executeQuery(Employee.selectAll);
//				printTableData(resultset);
//				resultset = statement.executeQuery(Store.selectAll);
//				System.out.println();
//				printTableData(resultset);
			
			//Creates an employee class
			Employee employee = new Employee(statement);
			//Drops then creates a new table with data in it.
			employee.dropTable();
			employee.createTable();
			employee.insertData();
			//Prints the columns in the class
			System.out.println(employee.getColumnCount());
			//Prints the table out
			employee.printTableData();
		}catch(SQLException e)
		{
			System.out.println("Something went wrong accessing SQL.");
			e.printStackTrace();
		}
	}


}