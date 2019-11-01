package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartMapper {
	/**
	 * 添加购物车
	 * @param cart
	 */
	void insertCart(Cart cart);
	/**
	 * 查询用户购物车信息
	 * @param uid
	 * @return
	 */
	List<CartVo> selectByUid(Integer uid);
	/**
	 * 根据id删除购物车
	 * @param ids
	 * @return
	 */
	void deleteByIds(Integer[] ids);
	/**
	 * 根据id删除购物车商品
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 根据id修改商品数量
	 * @param id
	 */
	void updateById(Integer id,Integer num);
}
