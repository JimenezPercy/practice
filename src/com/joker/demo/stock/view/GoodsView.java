package com.joker.demo.stock.view;

import com.joker.demo.stock.entity.Goods;
import com.joker.demo.stock.entity.GoodsOption;
import com.joker.demo.stock.entity.GoodsType;
import com.joker.demo.stock.service.GoodsService;
import com.joker.demo.stock.service.GoodsTypeService;
import com.joker.demo.stock.service.impl.GoodsServiceImpl;
import com.joker.demo.stock.service.impl.GoodsTypeServiceImpl;

import java.util.Scanner;


public class GoodsView {
	
	private GoodsTypeService gtService = new GoodsTypeServiceImpl();
	private GoodsService gService = new GoodsServiceImpl();
	
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * ��Ʒ�����Ĳ˵�
	 * @return
	 */
	public int goodsMenus() {
		int index = 0;
		do {
			System.out.println("��ѡ����Ʒ�Ĳ�����1.���|2.����|3.�����ϼ��˵�");
			System.out.print("������������ͣ�");
			index = scanner.nextInt();
		}while(index != GoodsOption.GOODS_IN &&
				index != GoodsOption.GOODS_OUT && 
				index != GoodsOption.GOODS_EXIT );
		return index;
	}
	
	
	/**
	 * ִ�в���
	 * @param index
	 */
	public void optionChoose(int index) {
		switch(index) {
			case GoodsOption.GOODS_IN:
				this.inGoods();
				break;
			case GoodsOption.GOODS_OUT:
				this.outGoods();
				break;
			case GoodsOption.GOODS_EXIT:
				System.out.println("��Ʒ�������˳�����");
				break;
		}
	}
	
	/**
	 * ��Ʒ���
	 */
	private void inGoods() {
		//1.չʾ��Ʒ�����б�
		boolean gtFlag = this.showGoodsTypeList();
		if(gtFlag) {
			//2.ѡ����Ʒ����
			System.out.print("���������������Ʒ����ID:");
			int gtId = this.scanner.nextInt();
			GoodsType[] gts =
					this.gtService.queryGoodsTypesList(
							new GoodsType().setId(gtId));
			if(gts.length == 0) {
				//��Ʒ���Ͳ�����
				System.out.println("��ѡ��Ʒ���Ͳ����ڣ�");
				return;
			}else {
				//��Ʒ���ʹ���
				//��Ʒ����
				GoodsType gt = gts[0];
				//3.չʾ��ǰ��������Ʒ���б�
				this.showGoodsList(gtId);
				//4.���������Ϣ��ͬʱ�����Ʒ�Ƿ���ڣ��������޸Ļ���������
				System.out.print("��������Ʒ��ţ�");
				String goodCode = this.scanner.next();
				Goods g = this.gService.queryGoodsByGoodsCode(
						new Goods().setGoodsCode(goodCode));
				if(g == null) {
					System.out.println("��Ʒ��Ų����ڣ�����������Ʒ�����Ϣ");
					//��Ҫ����
					g = new Goods();
					System.out.print("��������Ʒ���ƣ�");
					g.setName(this.scanner.next());
					System.out.print("��������Ʒ��С���������");
					g.setMinNumber(this.scanner.nextInt());
					System.out.print("��������Ʒ������������");
					g.setMaxNumber(this.scanner.nextInt());
					System.out.print("��������Ʒ���������");
					g.setNumber(this.scanner.nextInt());
					//��Ʒ���ͷ����ȥ
					g.setType(gt);
					//��֤��
					//1.��С����� ҪС�� ��������
					//2.��С������Լ������������Ϊ����
					//3.�������ҪС����������
					this.gService.insertGoods(g);
				}else {
					//��Ҫ�޸�
					System.out.print("��������Ʒ���������");
					//�����������ԭ�������Ļ����ϣ��ۼ�
					g.setNumber(g.getNumber() + this.scanner.nextInt());
					//��֤��
					//1.��С����� ҪС�� ��������
					//2.��С������Լ������������Ϊ����
					//3.�������ҪС����������
					this.gService.updateGoods(g);
				}
				
			}
			
		}
	}
	/**
	 * ��Ʒ���⣺��ҵ
	 */
	private void outGoods() {
		/*
		 * 1.�ж���Ʒ�����Ƿ����
		 * 2.�ж���Ʒ�Ƿ���ڣ�ͬʱ�жϸ���Ʒ�Ƿ�ɳ���
		 * 3.��֤���������Ƿ��ڿ�淶Χ֮��
		 * 4.��֤������Ƿ��ܼ���ʹ��
		 * 5.�޸�
		 * 6.�������Ʒ�������Ϊ0��ѯ���Ƿ���֣�����֣���ɾ���ü�¼
		 */
		
		
	}
	
	/**
	 * չʾ��Ʒ�б�
	 */
	private void showGoodsList(int gtId) {
		Goods[] gs = this.gService.queryGoodsListByTypeId(
					new Goods().setType(new GoodsType().setId(gtId))
				);
		
		//��ʼ�б�չʾ
		System.out.println("------------------------------------");
		if(gs.length == 0) {
			System.out.println("����Ʒ�����Ϣ��");
		}
		for(Goods g : gs) {
			System.out.println("|"
					+ g.getId() + "|" 
					+ g.getGoodsCode() + "|"
					+ g.getName() + "|" 
					+ g.getType().getName() + "|"
					+ g.getNumber() + "|"
					+ g.getMaxNumber() + "|"
					+ g.getMinNumber() + "|"
					+ (g.getStatus() ? "����":"������") + "|"
					);
		}
		System.out.println("------------------------------------");
		
		
	}
	
	/**
	 * չʾ��Ʒ�����б�
	 */
	private boolean showGoodsTypeList() {
		GoodsType[] types = this.gtService.queryGoodsTypesList(null);
		//��ʼ�б�չʾ
		System.out.println("------------------------------------");
		if(types.length == 0) {
			System.out.println("����Ʒ������Ϣ�������������Ʒ���ͣ�");
			return false;
		}
		for(GoodsType type : types) {
			System.out.println("|" +type.getId() + "|" + type.getName() + "|");
		}
		System.out.println("------------------------------------");
		return true;
	}
	
	
	
	/**
	 * ��Ʒ���
	 */
	private void deleteGoods() {
		
	}
}
