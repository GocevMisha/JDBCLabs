import java.sql.*;
import java.util.ArrayList;

public class ItemDAOMain {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/items";
    static final String DB_USER = "postgres";
    static final String DB_PASSWORD = "postgres";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            connection.setAutoCommit(false);
            ItemDAO itemDAO = new ItemDAO(connection);

            MusicItem mi1 = itemDAO.searchById(1);
            MusicItem mi2 = itemDAO.searchById(100);
            System.out.println("Item ID_1: " + mi1.toString() + "\n") ;
            System.out.println("Item ID_100: " + mi2 + "\n");

            ArrayList<MusicItem> list1 = itemDAO.searchByKeyword("%of%");
            ArrayList<MusicItem> list2 = itemDAO.searchByKeyword("%Gay%");

            if (list1.isEmpty())
                System.out.println("List is empty.");
            else
                for (MusicItem mi : list1)
                    System.out.println(mi.toString() + "\n");

            if (list2.isEmpty())
                System.out.println("List is empty.");
            else
                for (MusicItem mi : list2)
                    System.out.println(mi.toString() + "\n");


            MusicItem mi = new MusicItem();
            mi.setTitle("Just Lose It");
            mi.setArtist("Eminem");
            mi.setReleaseDate(new Date(2003, 10, 10));
            mi.setPrice(10.20f);
            mi.setListPrice(30.42f);
            itemDAO.create(mi);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
