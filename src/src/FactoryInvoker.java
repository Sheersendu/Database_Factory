import postgres_DB.PostgresConfiguration;

public class FactoryInvoker {
	public static void main(String[] args) {
		PostgresConfiguration postgresConfiguration = new PostgresConfiguration();
		System.out.println(postgresConfiguration.getConnection());
	}
}
