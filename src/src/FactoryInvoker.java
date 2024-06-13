import enums.DatabaseType;
import mongo_DB.MongoConfiguration;
import postgres_DB.PostgresConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FactoryInvoker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter database type:");
		DatabaseType databaseType = DatabaseType.DEFAULT;
		Connection databaseConnection;
		try {
			databaseType = DatabaseType.valueOf(scanner.nextLine());
			switch (databaseType) {
				case POSTGRES:
					PostgresConfiguration postgresConfiguration = new PostgresConfiguration();
					databaseConnection = postgresConfiguration.getConnection();
					System.out.println(databaseConnection);
					break;
				case MONGODB:
					MongoConfiguration mongoConfiguration = new MongoConfiguration();
					databaseConnection = mongoConfiguration.getConnection();
					System.out.println(databaseConnection);
					// Create a statement
//					Statement stmt;
//					try {
//						stmt = databaseConnection.createStatement();
//					} catch (SQLException e) {
//						throw new RuntimeException(e);
//					}
//
//					// Execute a query
//					String sql = "SELECT * FROM Test_Collection";
//					try {
//						boolean rs = stmt.execute(sql);
//						System.out.println(rs);
//					} catch (Exception e) {
//						throw new RuntimeException(e);
//					}
					break;
				default:
					throw new IllegalStateException("Unexpected value for Database Type: " + databaseType);
			}
		} catch (Exception e) {
			throw new IllegalStateException("Unexpected value for Database Type: " + databaseType);
		}
	}
}
