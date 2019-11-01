package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface ICartService {
	/**
	 * 添加购物车
	 * @param cart
	 */
	void addCart(Cart cart);
	/**
	 * 通过uid获取购物车信息
	 * @param uid
	 * @return
	 */
	List<CartVo> getByUid(Integer uid);
	/**
	 * 批量删除购物车订单
	 * @param ids
	 */
	void removeByIds(Integer[] ids);
	/**
	 * 删除购物车商品
	 * @param id
	 */
	void removeById(Integer id);
	/**
	 * 根据id修改商品数量
	 * @param id
	 */
	void updateById(Integer id,Integer num);

}
