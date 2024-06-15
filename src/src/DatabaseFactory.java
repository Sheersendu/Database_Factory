import enums.DatabaseType;
import interfaces.IDatabaseConfiguration;
import mongo_DB.MongoConfiguration;
import postgres_DB.PostgresConfiguration;


public class DatabaseFactory {
	public static IDatabaseConfiguration getDatabase(DatabaseType databaseType) {
		IDatabaseConfiguration databaseConfiguration;
		databaseConfiguration = switch (databaseType) {
			case POSTGRES -> new PostgresConfiguration();
			case MONGODB -> new MongoConfiguration();
			default -> throw new IllegalStateException("Unexpected value for Database Type: " + databaseType);
		};
		return databaseConfiguration;
	}
}
