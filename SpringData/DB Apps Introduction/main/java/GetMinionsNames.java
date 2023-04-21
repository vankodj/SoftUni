import java.sql.*;

import java.util.Scanner;

public class GetMinionsNames {
    private static final String GET_MINION_NAMES = "select m.name,m.age\n" +
            "from minions as m\n" +
            "    join minions_villains mv on m.id = mv.minion_id\n" +
            "where villain_id = ?";
    private static final String GET_VILLAIN_NAME = "select v.name from villains as v where v.id = ?";

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        Connection connection = Tools.createConnection();

        System.out.print("Enter villain id: ");
        int villain_id = scan.nextInt();

        PreparedStatement statementVillain = connection.prepareStatement(GET_VILLAIN_NAME);
        statementVillain.setInt(1, villain_id);
        ResultSet villainResult = statementVillain.executeQuery();

        if (!villainResult.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villain_id);
           connection.close();
            return;
        }

        String villainName = villainResult.getString("name");
        System.out.printf("Villain: %s%n", villainName);

        PreparedStatement statement = connection.prepareStatement
                (GET_MINION_NAMES);
        statement.setInt(1, villain_id);
        ResultSet result = statement.executeQuery();


            for (int row = 1; result.next(); row++) {
                String minionNames = result.getString("name");
                int minionAge = result.getInt("m.age");
                System.out.printf("%d. %s %d%n",row, minionNames, minionAge);
            }

            connection.close();
    }
}
