package cn.tedu.store.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {
	/**
	 * 查询商品分类信息
	 * @param parentId
	 * @param offSet
	 * @param count
	 * @return
	 * 1.myBatis如果参数多与一个需要处理
	 */
	List<GoodsCategory> selectByParentId(@Param("parentId") Integer parentId,@Param("offset") Integer offSet,
			@Param("count") Integer count);
	
}
