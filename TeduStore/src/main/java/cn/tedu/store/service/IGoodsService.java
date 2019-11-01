package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	/**
	 * 根据categoryId查询商品信息
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return 商品集合
	 */
	List<Goods> getByCategoryId(Integer categoryId,Integer offset,Integer count);
	
	/**
	 * 根据categoryId查询商品数量
	 * @param categortId
	 * @return 商品数量
	 */
	Integer getCount(Integer categoryId);
	/**
	 * 根据ID获取商品
	 * @param id
	 * @return
	 */
	Goods getById(String id);

}
