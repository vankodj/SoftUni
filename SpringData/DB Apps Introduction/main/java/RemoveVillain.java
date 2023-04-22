import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class RemoveVillain {

   private static final String DELETE_VILLAIN = "DELETE mv from minions_villains mv where villain_id = ?";
   private static final String RELEASE_MINIONS_FROM_VILLAIN =
           "select count(minion_id) from minions_villains m where villain_id = ?";
   private static final String GET_NAME_OF_VILLAIN = "select name from villains where id = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Connection connection = Tools.createConnection();

        System.out.println("Enter villain ID: ");
        int villainId = Integer.parseInt(scan.nextLine());

        PreparedStatement releasedMinions = connection.prepareStatement(RELEASE_MINIONS_FROM_VILLAIN);
        releasedMinions.setInt(1,villainId);
        ResultSet resultSet = releasedMinions.executeQuery();
        resultSet.next();
        int minion_count = resultSet.getInt("count(minion_id)");

       PreparedStatement getVillainName = connection.prepareStatement(GET_NAME_OF_VILLAIN);
       getVillainName.setInt(1,villainId);
       ResultSet villainNameSet = getVillainName.executeQuery();
       if (!villainNameSet.next()){
           System.out.println("No such villain was found");
        connection.close();
           return;
       }
       String villainName = villainNameSet.getString("name");

        PreparedStatement deleteVillain = connection.prepareStatement(DELETE_VILLAIN);
        deleteVillain.setInt(1,villainId);
        deleteVillain.executeUpdate();

        System.out.printf("%s was deleted%n",villainName);
        System.out.printf("%d minions released",minion_count);

        connection.close();

    }
}
