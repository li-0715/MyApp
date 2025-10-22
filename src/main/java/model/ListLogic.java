package model;

import java.util.List;

import dao.GoodsDAO;

public class ListLogic {

    /**
     * DAOからすべての商品リストを取得
     */
    public List<Goods> get() {
        GoodsDAO dao = new GoodsDAO();
        return dao.get(); 
    }

    /**
     * DAOの search メソッドを使って検索（DB側で絞り込み）
     * @param keyword 商品名に含まれるキーワード
     * @return 該当する商品リスト
     */
    public List<Goods> search(String keyword) {
        GoodsDAO dao = new GoodsDAO();
        List<Goods> goodsList = dao.search(keyword);
        return goodsList;
    }

    /**
     * 主キーidで商品1件を取得（オーバーロード）
     * @param id 商品の主キー
     * @return 該当するGoodsインスタンス（見つからなければ null）
     */
    public Goods get(int id) {
        GoodsDAO dao = new GoodsDAO();
        return dao.get(id);
    }
}
