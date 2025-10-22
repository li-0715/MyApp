package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String CN_STRING = "jdbc:oracle:thin:@//10.40.112.11:1521/dbsys"; // ex1201参照
    private static final String USER = "jz240104"; // ex1201参照
    private static final String PASS = "pass"; // ex1201参照

    private static DBManager self; // 自分を管理する変数

    // コンストラクタ
    private DBManager() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードに失敗しました");
            e.printStackTrace();
            return;
        }
    }

    /**
     * インスタンスを取得するメソッド
     * @return インスタンス
     */
    public static DBManager getInstance() {
        if (self == null) {
            self = new DBManager();
        }
        return self;
    }

    /**
     * コネクションを取得
     * @return 生成されたコネクション
     * @throws SQLException
     */
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CN_STRING, USER, PASS);
    }
}
