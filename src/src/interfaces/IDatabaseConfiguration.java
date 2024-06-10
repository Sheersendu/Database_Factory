package interfaces;

import java.sql.Connection;

public interface IDatabaseConfiguration {
	Connection getConnection();
}
