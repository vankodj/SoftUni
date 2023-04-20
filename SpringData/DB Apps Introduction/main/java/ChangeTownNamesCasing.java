import java.sql.*;
import java.util.*;

public class ChangeTownNamesCasing {

    private static final String GET_TOWNS_BY_COUNTRY = "select name from towns where country = ?";
    private static final String UPDATE_TOWNS_TO_UPPER_CASE =
            "UPDATE towns t SET name = upper(name) where country = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        List<String> towns = new ArrayList<>();

        Connection connection = Tools.createConnection();

        System.out.println("Enter country: ");
        String inputCountry = scan.nextLine();

        PreparedStatement updateStatement = connection.prepareStatement(UPDATE_TOWNS_TO_UPPER_CASE);
        updateStatement.setString(1, inputCountry);
        updateStatement.executeUpdate();

        PreparedStatement statement = connection.prepareStatement(GET_TOWNS_BY_COUNTRY);
        statement.setString(1, inputCountry);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String currentName = resultSet.getString("name");
            towns.add(currentName);

        }
        if (towns.isEmpty()) {
            System.out.println("No town names were affected.");
            connection.close();
            return;
        }
        System.out.printf("%d town names were affected.%n",towns.size());
        System.out.println(towns);

        connection.close();
    }
}