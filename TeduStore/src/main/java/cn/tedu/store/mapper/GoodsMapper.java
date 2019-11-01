package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	/**
	 * 查询热门商品
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> selectByCategoryId(@Param("categoryId") Integer categoryId,
			@Param("offset") Integer offset,@Param("count") Integer count);
	/**
	 * 根据categoryId查询商品数量
	 * @param categoryId
	 * @return 商品数量
	 */
	Integer selectCount(Integer categoryId);
	/**
	 * 通过ID查询商品
	 * @param id
	 * @return
	 */
	Goods selectById(String id);

}
