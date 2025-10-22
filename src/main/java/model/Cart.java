package model;

import java.io.Serializable;

public class Cart implements Serializable {
    private Goods goods;
    private int num;

    public Cart() {
    }

    public Cart(Goods goods, int num) {
        this.goods = goods;
        this.num = num;
    }

    // Goods のゲッター
    public Goods getGoods() {
        return goods;
    }

    // Goods のセッター
    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    // num のゲッター
    public int getNum() {
        return num;
    }

    // num のセッター
    public void setNum(int num) {
        this.num = num;
    }
}
