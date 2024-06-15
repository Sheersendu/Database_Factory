import enums.DatabaseType;
import interfaces.IDatabaseConfiguration;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;


public class FactoryTest {
	@Test
	public void Test_PostgresConnection()
	{
		IDatabaseConfiguration postgres = DatabaseFactory.getDatabase(DatabaseType.POSTGRES);
		Connection postgresConnection = postgres.getConnection();
		Assert.assertNotNull(postgresConnection);
	}

	@Test
	public void Test_MongoDBConnection()
	{
		IDatabaseConfiguration mongodb = DatabaseFactory.getDatabase(DatabaseType.MONGODB);
		Connection mongodbConnection = mongodb.getConnection();
		Assert.assertNotNull(mongodbConnection);
	}
}
