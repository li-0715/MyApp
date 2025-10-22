package model;

import java.io.Serializable;

public class Goods implements Serializable {
	private int id;
	private String goodsCode;
	private String goodsName;
	private int price;
	private int stock;
	private String image;

	public Goods() {
	}

	public Goods(String goodsCode, String goodsName, int price, int stock, String image) {
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}

	public Goods(int id, String goodsCode, String goodsName, int price, int stock,
			String image) {

		this.id = id;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public String getImage() {
		return image;
	}
}
