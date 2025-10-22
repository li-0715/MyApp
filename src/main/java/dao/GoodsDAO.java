package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Goods;

public class GoodsDAO {

    /**
     * すべての商品を取得するメソッド
     * @return 商品リスト
     */
    public List<Goods> get() {
        List<Goods> list = new ArrayList<>();
        DBManager manager = DBManager.getInstance();

        try (Connection cn = manager.getConnection()) {
            String sql = "SELECT * FROM goods ORDER BY goodscode ASC";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Goods goods = rs2model(rs);
                        list.add(goods);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 商品名であいまい検索するメソッド
     * @param keyword 検索キーワード
     * @return 該当する商品リスト
     */
    public List<Goods> search(String keyword) {
        List<Goods> list = new ArrayList<>();
        DBManager manager = DBManager.getInstance();

        try (Connection cn = manager.getConnection()) {
            String sql = "SELECT * FROM goods WHERE goodsname LIKE ? ORDER BY goodscode ASC";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setString(1, "%" + keyword + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Goods goods = rs2model(rs);
                        list.add(goods);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 主キーIDで商品を1件取得するメソッド
     * @param id 商品ID
     * @return 該当するGoodsインスタンス（なければnull）
     */
    public Goods get(int id) {
        Goods goods = null;
        DBManager manager = DBManager.getInstance();

        try (Connection cn = manager.getConnection()) {
            String sql = "SELECT * FROM goods WHERE id = ?";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        goods = rs2model(rs);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }

    /**
     * ResultSetのデータをGoodsモデルに変換するメソッド
     * @param rs 結果セット
     * @return Goodsインスタンス
     * @throws SQLException
     */
    private Goods rs2model(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String code = rs.getString("goodscode");
        String name = rs.getString("goodsname");
        int price = rs.getInt("price");
        int stock = rs.getInt("stock");
        String image = rs.getString("image");

        return new Goods(id, code, name, price, stock, image);
    }
}
