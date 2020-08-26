package com.joker.demo.stock.service.impl;


import com.joker.demo.stock.database.DataBase;
import com.joker.demo.stock.entity.GoodsType;
import com.joker.demo.stock.service.GoodsTypeService;

public class GoodsTypeServiceImpl implements GoodsTypeService {
	private DataBase db = DataBase.getDataBase();
	@Override
	public GoodsType[] queryGoodsTypesList(GoodsType type) {
		if(type == null) {
			return db.queryGoodsTypesList();
		}else {//��ĳ��
			return new GoodsType[] {db.queryGoodsTypesById(type.getId())};
		}
	}
	
	@Override
	public boolean checkGoodsTypeName(String name) {
		GoodsType[] gts = this.queryGoodsTypesList(null);
		for(GoodsType gt : gts) {
			if(name.equals(gt.getName())) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int createGoodsType(String name) {
		// TODO Auto-generated method stub
		GoodsType gt = new GoodsType();
		gt.setName(name);
		db.insertGoodsType(gt);
		return 1;
	}

}
