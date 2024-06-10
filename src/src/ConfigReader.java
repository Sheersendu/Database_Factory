import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.sql.*;

public class ConfigReader {

	private static Properties properties;
	private static String propertiesFilePath = "./src/src/applicationConfig.properties";

	public ConfigReader() {
		File configFile = new File(propertiesFilePath);
		try
		{
			FileReader fileReader = new FileReader(configFile);
			properties = new Properties();
			properties.load(fileReader);
			fileReader.close();
			System.out.println(properties);
			String connectionString = "jdbc:postgresql://" + properties.getProperty("postgres.url") + ":" + properties.getProperty("postgres.port") + "/postgres";
			System.out.println(connectionString);
			Class.forName("org.postgresql.Driver");
			Connection postgresqlConnection = DriverManager.getConnection(connectionString, properties.getProperty("postgres.username"), properties.getProperty("postgres.password"));
			System.out.println(postgresqlConnection);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

class Main {
	public static void main(String[] args) {
		new ConfigReader();
	}
}