import java.sql.*;

import java.util.Scanner;

public class AddMinion {
    private static final String INSERT_MINIONS_IN_DATABASE = "INSERT INTO minions (name, age) values (?,?)";
    private static final String CHECK_FOR_TOWNS_EXIST = "select name from towns where name = ?";
    private static final String INSERT_TOWN_IN_DATABASE = "INSERT INTO towns (name) VALUES (?)";
    private static final String CHECK_FOR_VILLAIN_EXIST = "select name from villains where name = (?)";
    private static final String INSERT_VILLAIN_IN_DATABASE =
            "INSERT INTO villains (name,evilness_factor) values (?,'evil')";
    private static final String GET_LAST_MINION = "select id from minions where name = ?";
    private static final String GET_VILLAIN = "select id from villains where name = ?";
    private static final String INSERT_MINION_TO_VILLAIN =
            "insert into minions_villains (minion_id, villain_id) VALUES  (?,?)";


    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Connection connection = Tools.createConnection();

        System.out.println("Enter minion: ");
        String[] inputRow1 = scan.nextLine().split(" ");
        String minionName = inputRow1[1];
        int minionAge = Integer.parseInt(inputRow1[2]);
        String townName = inputRow1[3];
        System.out.println("Enter villain: ");
        String[] inputRow2 = scan.nextLine().split(" ");
        String villainName = inputRow2[1];

        PreparedStatement checkTown = connection.prepareStatement(CHECK_FOR_TOWNS_EXIST);
        checkTown.setString(1, townName);
        ResultSet checkTownResult = checkTown.executeQuery();

        if (!checkTownResult.next()) {
            PreparedStatement addTown = connection.prepareStatement(INSERT_TOWN_IN_DATABASE);
            addTown.setString(1, townName);
            addTown.executeUpdate();
            System.out.printf("Town %s was added to the database%n", townName);
        }

        PreparedStatement checkVillain = connection.prepareStatement(CHECK_FOR_VILLAIN_EXIST);
        checkVillain.setString(1, villainName);
        ResultSet checkVillainSet = checkVillain.executeQuery();

        if (!checkVillainSet.next()) {
            PreparedStatement addVillain = connection.prepareStatement(INSERT_VILLAIN_IN_DATABASE);
            addVillain.setString(1, villainName);
            addVillain.executeUpdate();
            System.out.printf("Villain %s was added to the database%n", villainName);
        }

          PreparedStatement getVillainId = connection.prepareStatement(GET_VILLAIN);
        getVillainId.setString(1,villainName);
        ResultSet villainIdSet = getVillainId.executeQuery();
       int villainId = 0;
        if (villainIdSet.next()) {
           villainId = villainIdSet.getInt("villains.id");
        }

            PreparedStatement addMinions = connection.prepareStatement
                    (INSERT_MINIONS_IN_DATABASE);
            addMinions.setString(1, minionName);
            addMinions.setInt(2, minionAge);
            addMinions.executeUpdate();

           PreparedStatement getMinionId = connection.prepareStatement(GET_LAST_MINION);
           getMinionId.setString(1,minionName);
           ResultSet resultId = getMinionId.executeQuery();
           int lastMinionId = 0;
           if (resultId.next()) {
               lastMinionId = resultId.getInt("minions.id");
           }
           PreparedStatement addMinionToVillain = connection.prepareStatement(INSERT_MINION_TO_VILLAIN);
           addMinionToVillain.setInt(1,lastMinionId);
           addMinionToVillain.setInt(2,villainId);
        System.out.printf("Successfully added %s to be minion of %s",minionName,villainName);
        connection.close();
    }
}