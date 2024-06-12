package mongo_DB;

import interfaces.IDatabaseConfiguration;

import java.sql.Connection;

public class MongoConfiguration implements IDatabaseConfiguration {
	@Override
	public Connection getConnection() {
		return null;
	}
}
