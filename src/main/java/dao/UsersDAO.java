package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsersDAO {

    /**
     * テーブルの中から、指定されたメールアドレスとパスワードを持つレコードを返すメソッド
     * @param email メールアドレス
     * @param password パスワード
     * @return 発見したレコードで作成したUserインスタンス。なければnull
     */
    public User findByLogin(String email, String password) {
        User user = null;
        DBManager manager = DBManager.getInstance();

        try (Connection cn = manager.getConnection()) {
            String sql = "SELECT * FROM users WHERE email = ? AND pass = ?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = rs2model(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * テーブルの中から、指定されたメールアドレスを持つレコードを返すメソッド
     * @param email メールアドレス
     * @return 発見したデータ。なければnull
     */
    public User findByEmail(String email) {
        User user = null;
        DBManager manager = DBManager.getInstance();
        try (Connection cn = manager.getConnection()) {
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = rs2model(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * DBにデータを追加する
     * @return 成功時は追加したデータ、失敗時はnull
     */
    public User create(String email, String password, String name) {
        int ret = -1;

        // 重複確認
        if (findByEmail(email) != null) {
            System.out.println("該当ユーザは既に存在しています");
            return null;
        }

        // DBにデータを追加
        DBManager manager = DBManager.getInstance();
        try (Connection cn = manager.getConnection()) {
            String sql = "INSERT INTO users(email, pass, name) VALUES (?, ?, ?)";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, name);

            ret = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (ret >= 1) {
            return findByEmail(email);
        }

        return null;
    }

    /**
     * ResultSetの行データをモデルの形に変換するメソッド
     * @param rs 変換前のデータ
     * @return 変換後のデータ
     */
    private User rs2model(ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
        String email = rs.getString("EMAIL");
        String pass = rs.getString("PASS");
        String name = rs.getString("NAME");

        return new User(id, email, pass, name);
    }
}
