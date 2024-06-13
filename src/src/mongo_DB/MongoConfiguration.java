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
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return mongodbConnection;
	}
}
