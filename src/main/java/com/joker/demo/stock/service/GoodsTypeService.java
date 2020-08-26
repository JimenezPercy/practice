package com.joker.demo.stock.service;


import com.joker.demo.stock.entity.GoodsType;

public interface GoodsTypeService {
	/**
	 * 获取物品类型列表
	 * @param type
	 * @return
	 */
	public GoodsType[] queryGoodsTypesList(GoodsType type);

	/**
	 * 检查物品类型名称是否重名
	 * @param name
	 * @return
	 */
	public boolean checkGoodsTypeName(String name);

	/**
	 * 创建物品类型
	 * @param name
	 * @return
	 */
	public int createGoodsType(String name);
}
