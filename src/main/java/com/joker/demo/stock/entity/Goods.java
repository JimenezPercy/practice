package com.joker.demo.stock.entity;

/**
 * 物品
 * @author wzp
 */
public class Goods {
	//属性
	private int id;
	private String goodsCode;//物品编码
	private String name;//名称
	private GoodsType type;//物品类型
	private int number;//数量
	private int maxNumber;//数量上限
	private int minNumber;//数量下限
	
	private boolean status;//锁定状态
	
	
	public int getId() {
		return id;
	}

	public Goods setId(int id) {
		this.id = id;
		return this;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public Goods setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
		return this;
	}

	public String getName() {
		return name;
	}

	public Goods setName(String name) {
		this.name = name;
		return this;
	}

	public GoodsType getType() {
		return type;
	}

	public Goods setType(GoodsType type) {
		this.type = type;
		return this;
	}

	public int getNumber() {
		return number;
	}

	public Goods setNumber(int number) {
		this.number = number;
		return this;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public Goods setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
		return this;
	}

	public int getMinNumber() {
		return minNumber;
	}

	public Goods setMinNumber(int minNumber) {
		this.minNumber = minNumber;
		return this;
	}

	public boolean getStatus() {
		return status;
	}

	public Goods setStatus(boolean status) {
		this.status = status;
		return this;
	}
}
