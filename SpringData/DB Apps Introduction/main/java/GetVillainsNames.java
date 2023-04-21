import java.sql.*;

import java.util.Scanner;

public class GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Connection connection = Tools.createConnection();

        PreparedStatement query = connection.prepareStatement
                ("select v.name, COUNT(distinct mv.minion_id) as count_m\n" +
                        "FROM villains As v\n" +
                        "join minions_villains mv on v.id = mv.villain_id\n" +
                        "group by mv.villain_id\n" +
                        "having count_m >?\n" +
                        "order by count_m DESC;");
        query.setInt(1,15);
        ResultSet result = query.executeQuery();
        while(result.next()){
           String villainsNames = result.getString("name");
           int minions_count = result.getInt("count_m");


            System.out.printf("%s %d",villainsNames,minions_count);
        }

    }
}
