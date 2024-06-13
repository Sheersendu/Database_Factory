import mongo_DB.MongoConfiguration;
import postgres_DB.PostgresConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FactoryInvoker {
	public static void main(String[] args) {
		PostgresConfiguration postgresConfiguration = new PostgresConfiguration();
		System.out.println(postgresConfiguration.getConnection());
		MongoConfiguration mongoConfiguration = new MongoConfiguration();
		Connection conn = mongoConfiguration.getConnection();
		// Create a statement
		Statement stmt;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		// Execute a query
		String sql = "SELECT * FROM Test_Collection";
		try {
			boolean rs = stmt.execute(sql);
			System.out.println(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
