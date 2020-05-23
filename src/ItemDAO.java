import java.sql.*;
import java.util.ArrayList;

public class ItemDAO {

    private Connection connection;
    private Statement stmt;
    public ItemDAO(Connection connection) {
        this.connection = connection;
    }

    public MusicItem searchById(int id) {
        MusicItem musicItem = new MusicItem();
        try {
            String sql = "SELECT * FROM item WHERE item_id = " + id;
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                musicItem.setItemID(rs.getInt(1));
                musicItem.setTitle(rs.getString(2));
                musicItem.setArtist(rs.getString(3));
                musicItem.setReleaseDate(rs.getDate(4));
                musicItem.setListPrice(rs.getFloat(5));
                musicItem.setPrice(rs.getFloat(6));
                musicItem.setVersion(rs.getInt(7));
            } else musicItem = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return musicItem;
    }

    public ArrayList<MusicItem> searchByKeyword(String pattern) {
        ArrayList<MusicItem> musicItemArrayList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM item WHERE title LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pattern);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MusicItem musicItem = new MusicItem();
                musicItem.setItemID(resultSet.getInt(1));
                musicItem.setTitle(resultSet.getString(2));
                musicItem.setArtist(resultSet.getString(3));
                musicItem.setReleaseDate(resultSet.getDate(4));
                musicItem.setListPrice(resultSet.getFloat(5));
                musicItem.setPrice(resultSet.getFloat(6));
                musicItem.setVersion(resultSet.getInt(7));
                musicItemArrayList.add(musicItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicItemArrayList;
    }

    public void create(MusicItem mi) {
        String sql = "INSERT INTO item (title, artist, releasedate, listprice, price, version) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mi.getTitle());
            stmt.setString(2, mi.getArtist());
            stmt.setDate(3, mi.getReleaseDate());
            stmt.setFloat(4, mi.getListPrice());
            stmt.setFloat(5, mi.getPrice());
            stmt.setInt(6, 1);
            System.out.println(stmt.executeUpdate());
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
    }
}