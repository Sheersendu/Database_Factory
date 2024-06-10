package postgres_DB;

import interfaces.IDatabaseConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import config.ConfigReader;

public class PostgresConfiguration implements IDatabaseConfiguration {
	private final Properties properties;

	public PostgresConfiguration()
	{
		properties = ConfigReader.getConfiguration();
	}

	@Override
	public Connection getConnection() {
		String connectionString = "jdbc:postgresql://" + properties.getProperty("postgres.url") + ":" + properties.getProperty("postgres.port") + "/postgres";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		Connection postgresqlConnection;
		try {
			postgresqlConnection = DriverManager.getConnection(connectionString, properties.getProperty("postgres.username"), properties.getProperty("postgres.password"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		// The following block fetches all the tables from postgresql db
//		try {
//			var resultSet = postgresqlConnection.getMetaData().getTables(null, null, "%", new String[] { "TABLE" });
//			while (resultSet.next()) {
//				String tableName = resultSet.getString("TABLE_NAME");
//				System.out.println("Table Name: " + tableName);
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
		return postgresqlConnection;
	}
}
