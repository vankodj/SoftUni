import java.sql.*;
import java.util.*;

public class PrintAllMinionsName {

    private static final String GET_MINIONS_ASC = "select distinct name from minions order by id";



    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Connection connection = Tools.createConnection();


        PreparedStatement minions = connection.prepareStatement(GET_MINIONS_ASC);
        ResultSet resultSet = minions.executeQuery();

        ArrayDeque<String> minionNames = new ArrayDeque<>();

        while (resultSet.next()) {minionNames.offer(resultSet.getString("name"));}

        while (minionNames.size() > 2){
            System.out.println(minionNames.pollFirst());
            System.out.println(minionNames.pollLast());
        }

        while(!minionNames.isEmpty()) {System.out.println(minionNames.poll());}

        connection.close();

    }
}
