import enums.DatabaseType;

import java.sql.Connection;
import java.util.Scanner;

public class FactoryInvoker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter database type:");
		DatabaseType databaseType = DatabaseType.DEFAULT;
		Connection databaseConnection;
		try {
			databaseType = DatabaseType.valueOf(scanner.nextLine());
			databaseConnection = DatabaseFactory.getDatabase(databaseType).getConnection();
		} catch (Exception e) {
			throw new IllegalStateException("Unexpected value for Database Type: " + databaseType);
		}
	}
}
