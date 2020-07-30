package com.joker.demo.stock.view;

import com.joker.demo.stock.entity.GoodsType;
import com.joker.demo.stock.entity.GoodsTypeOption;
import com.joker.demo.stock.service.GoodsTypeService;
import com.joker.demo.stock.service.impl.GoodsTypeServiceImpl;

import java.util.Scanner;

public class GoodsTypeView {
	
	private GoodsTypeService service = new GoodsTypeServiceImpl();
	
	
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * 物品类型管理
	 * @return
	 */
	public int goodsTypeMenus() {
		int index = 0;
		do {
			System.out.println("请选择物品类型的操作：1.新增物品类型|2.修改物品类型|3.删除物品类型|4.退出");
			System.out.print("请输入操作类型：");
			index = scanner.nextInt();
		}while(index != GoodsTypeOption.GOODS_TYPE_INSERT &&
				index != GoodsTypeOption.GOODS_TYPE_UPDATE && 
				index != GoodsTypeOption.GOODS_TYPE_DELETE && 
				index != GoodsTypeOption.GOODS_TYPE_EXIT);
		return index;
	}
	
	/**
	 * 显示物品类型列表
	 */
	public void showGoodsTypeList() {
		GoodsType[] types = service.queryGoodsTypesList(null);
		//��ʼ�б�չʾ
		System.out.println("------------------------------------");
		if(types.length == 0) {
			System.out.println("无物品类型信息！");
		}
		for(GoodsType type : types) {
			System.out.println("|" +type.getId() + "|" + type.getName() + "|");
		}
		System.out.println("------------------------------------");
		
	}
	
	/**
	 * 功能选中
	 */
	public void optionChoose(int index) {
		
		switch(index) {
			case GoodsTypeOption.GOODS_TYPE_INSERT:
				this.insertGoodsType();
				break;
			case GoodsTypeOption.GOODS_TYPE_UPDATE:
				this.updateGoodsType();
				break;
			case GoodsTypeOption.GOODS_TYPE_DELETE:
				this.deleteGoodsType();
				break;
			case GoodsTypeOption.GOODS_TYPE_EXIT:
				System.out.println("物品类型管理退出……");
				break;
		}
	}
	
	/**
	 * 新增物品类型
	 */
	private void insertGoodsType() {
		System.out.print("请输入物品类型名称：");
		//获取物品类型名称
		String goodsTypeName = this.scanner.next();
		//检查这个物品类型名称是否已经存在
		if(goodsTypeName!=null && 
				this.service.checkGoodsTypeName(goodsTypeName)) {
			this.service.createGoodsType(goodsTypeName);
		}else {
			System.out.println("ERROR:物品类型名称错误");
		}
		
	}
	/**
	 * 修改物品类型
	 */
	private void updateGoodsType() {
		
	}
	/**
	 * 删除物品类型
	 */
	private void deleteGoodsType() {
		
	}
}
