package repositories;

import models.Account;
import models.Item;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepoImpl implements AccountRepo {

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public Account getAccount(int id) {
        String sql = "SELECT * FROM accounts WHERE a_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        String sql = "SELECT * FROM accounts";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Account> accounts = new ArrayList<>();

            while(rs.next()) {
                accounts.add(buildAccount(rs));
            }

            return accounts;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Account addAccount(Account a) {
        String sql = "INSERT INTO accounts VALUES (DEFAULT,?,?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, a.getName());
            ps.setInt(2, a.getAge());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildAccount(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Account updateAccount(Account change) {
        try {
            String sql = "UPDATE accounts SET name=?, age=? WHERE a_id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getName());
            ps.setInt(2, change.getAge());
            ps.setInt(3, change.getId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildAccount(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Account deleteAccount(int id) {
        try {
            String sql = "DELETE FROM accounts WHERE a_id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildAccount(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Account buildAccount(ResultSet rs) throws SQLException {
        Account a = new Account();
        a.setId(rs.getInt("a_id"));
        a.setName(rs.getString("name"));
        a.setAge(rs.getInt("age"));

        return a;
    }
}
