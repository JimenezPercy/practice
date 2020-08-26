package com.joker.demo.stock.entity;



/**
 * <table>
 * 	<tr>
 * 		<td>����</td>
 * 		<td>˵��</td>
 * 		<td>ֵ</td>
 * 	</tr>
 * 	<tr>
 * 		<td>GOODS_TYPE_MANAGE</td>
 * 		<td>��Ʒ���͹���</td>
 * 		<td>1</td>
 * 	</tr>
 * 	<tr>
 * 		<td>GOODS_MANAGE</td>
 * 		<td>��Ʒ����</td>
 * 		<td>2</td>
 * 	</tr>
 * 	<tr>
 * 		<td>EXIT</td>
 * 		<td>�˳�</td>
 * 		<td>3</td>
 * 	</tr>
 * </table>
 * @author wzp
 */
public interface MainMenuOption {
	/**
	 * 物品类型管理
	 */
	int GOODS_TYPE_MANAGE = 1;
	/**
	 * 物品管理
	 */
	int GOODS_MANAGE = 2;
	/**
	 * 退出
	 */
	int EXIT = 3;
}
