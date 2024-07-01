package repositories;

import models.Item;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepoImpl implements ItemRepo {

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public Item getItem(int id) {
        String sql = "SELECT * FROM items WHERE i_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildItem(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM items";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Item> items = new ArrayList<>();

            while(rs.next()) {
                items.add(buildItem(rs));
            }

            return items;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Item addItem(Item i) {
        String sql = "INSERT INTO items VALUES (DEFAULT,?,?,?,DEFAULT,NULL) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, i.getName());
            ps.setDouble(2, i.getPrice());
            ps.setBoolean(3, i.isAvailable());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildItem(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Item updateItem(Item change) {
        try {
            String sql = "UPDATE items SET name=?, price=?, available=?,return_date=? WHERE i_id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getName());
            ps.setDouble(2, change.getPrice());
            ps.setBoolean(3, change.isAvailable());
            ps.setLong(4, change.getReturnDate());
            ps.setInt(5, change.getId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildItem(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Item deleteItem(int id) {
        try {
            String sql = "DELETE FROM items WHERE i_id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildItem(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Item> getAccountItems(int id) {
        try {
            String sql = "SELECT * FROM items WHERE i_id IN (SELECT item_id FROM account_item WHERE account_id = ?) RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            List<Item> items = new ArrayList<>();

            while(rs.next()) {
                items.add(buildItem(rs));
            }

            return items;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Item buildItem(ResultSet rs) throws SQLException {
        Item i = new Item();
        i.setId(rs.getInt("i_id"));
        i.setName(rs.getString("name"));
        i.setCategoryId(rs.getInt("category_id"));
        i.setPrice(rs.getDouble("price"));
        i.setAvailable(rs.getBoolean("available"));
        i.setReturnDate(rs.getLong("return_date"));

        return i;
    }
}
