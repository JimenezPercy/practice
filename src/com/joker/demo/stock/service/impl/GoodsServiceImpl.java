package com.joker.demo.stock.service.impl;

import com.joker.demo.stock.database.DataBase;
import com.joker.demo.stock.entity.Goods;
import com.joker.demo.stock.service.GoodsService;
import com.joker.demo.stock.util.GoodsCodeSystemUtil;

import java.util.Arrays;


public class GoodsServiceImpl implements GoodsService {
	
	private DataBase db = DataBase.getDataBase();

	@Override
	public Goods[] queryGoodsList(Goods goods) {
		if(goods == null) {
			return this.db.queryGoodsList();
		}else {
			return new Goods[] {this.db.queryGoodsById(goods.getId())};
		}
	}

	@Override
	public Goods[] queryGoodsListByTypeId(Goods goods) {
		Goods[] gs = new Goods[0];
		if(goods != null && goods.getType() != null) {
			Goods[] algs = this.queryGoodsList(null);
			for(Goods g : algs) {
				if(g.getType().getId() == goods.getType().getId()) {
					gs = Arrays.copyOf(gs, gs.length + 1 );
					gs[gs.length-1] = g;
				}
			}
		}
		return gs;
	}

	@Override
	public Goods queryGoodsByGoodsCode(Goods goods) {
		if(goods != null && goods.getGoodsCode() != null) {
			Goods[] algs = this.queryGoodsList(null);
			for(Goods g : algs) {
				if(goods.getGoodsCode().equals(g.getGoodsCode())) {
					return g;
				}
			}
		}
		return null;
	}

	@Override
	public void insertGoods(Goods goods) {
		goods.setGoodsCode(GoodsCodeSystemUtil.getGoodsCode());
		if(goods.getNumber() > goods.getMinNumber()) {
			goods.setStatus(true);
		}
		this.db.insertGoods(goods);
	}

	@Override
	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		if(goods.getNumber() > goods.getMinNumber()) {
			goods.setStatus(true);
		}
		this.db.updateGoods(goods);
	}

}
