package com.joker.demo.stock.service;


import com.joker.demo.stock.entity.Goods;

public interface GoodsService {
	public Goods[] queryGoodsList(Goods goods);
	public Goods[] queryGoodsListByTypeId(Goods goods);
	public Goods queryGoodsByGoodsCode(Goods goods);
	
	public void insertGoods(Goods goods);
	public void updateGoods(Goods goods);
	
}
