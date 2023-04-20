import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

enum Tools {
    ;

    static Connection createConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "master");

        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/minions_db", props);

    return connection;
    }
}