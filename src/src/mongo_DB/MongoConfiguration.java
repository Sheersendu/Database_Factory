package mongo_DB;

import config.ConfigReader;
import interfaces.IDatabaseConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MongoConfiguration implements IDatabaseConfiguration {
	private final Properties properties;

	public MongoConfiguration() {
		this.properties = ConfigReader.getConfiguration();
	}

	@Override
	public Connection getConnection() {
		String connectionString = "jdbc:mongodb://" + properties.getProperty("mongodb.url") + ":" + properties.getProperty("mongodb.port") + "/admin";
		try {
			Class.forName("mongodb.jdbc.MongoDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		Connection mongodbConnection;
		try
		{
			mongodbConnection = DriverManager.getConnection(connectionString);
			System.out.println(mongodbConnection);
			// Create a statement
//			Statement stmt;
//			try {
//				stmt = mongodbConnection.createStatement();
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//
//			// Execute a query
//			String sql = "SELECT * FROM Test_Collection";
//			try {
//				boolean rs = stmt.execute(sql);
//				System.out.println(rs);
//			} catch (Exception e) {
//				throw new RuntimeException(e);
//			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return mongodbConnection;
	}
}
