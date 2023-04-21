import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class IncreaseAgeByProcedure {

    private static final String INCREASE_AGE_PROCEDURE =
            "call usp_get_older(?)";
    private static final String GET_MINION_BY_ID = "SELECT name,age from minions where id = ?";


    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        final Connection connection = Tools.createConnection();

        int id = Integer.parseInt(scan.nextLine());


        PreparedStatement increaseAgeMinions = connection.prepareStatement(INCREASE_AGE_PROCEDURE);
        increaseAgeMinions.setInt(1,id);
        increaseAgeMinions.executeUpdate();

        PreparedStatement getMinionsByAge = connection.prepareStatement(GET_MINION_BY_ID);
        getMinionsByAge.setInt(1,id);
        ResultSet resultSet = getMinionsByAge.executeQuery();

        while (resultSet.next()){
            System.out.printf("%s %d%n"
                    ,resultSet.getString("name")
                    ,resultSet.getInt("age"));
        }
        connection.close();
    }

}

