import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {

    private static final String NAMES_TO_LOWER_CASE =
            "update minions set name=(lower(name)) where id = ?";
    private static final String INCREASE_AGE_BY_1 = "update minions set age = age+1 where id = ?";
    private static final String GET_ALL_MINIONS_BY_AGE = "SELECT name,age from minions";


    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        final Connection connection = Tools.createConnection();

        int [] ids = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        PreparedStatement minionNamesToLowerCase = connection.prepareStatement(NAMES_TO_LOWER_CASE);
        PreparedStatement increaseAgeMinions = connection.prepareStatement(INCREASE_AGE_BY_1);


        for (int i = 0; i <ids.length ; i++) {
            minionNamesToLowerCase.setInt(1,ids[i]);
            minionNamesToLowerCase.executeUpdate();
            increaseAgeMinions.setInt(1,ids[i]);
            increaseAgeMinions.executeUpdate();
        }
        PreparedStatement getMinionsByAge = connection.prepareStatement(GET_ALL_MINIONS_BY_AGE);
        ResultSet resultSet = getMinionsByAge.executeQuery();

        while (resultSet.next()){
            System.out.printf("%s %d%n"
                    ,resultSet.getString("name")
                    ,resultSet.getInt("age"));
        }
        connection.close();
    }

}
