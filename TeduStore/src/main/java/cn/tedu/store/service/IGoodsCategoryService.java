package cn.tedu.store.service;

import java.util.List;
import cn.tedu.store.bean.GoodsCategory;

public interface IGoodsCategoryService {
	
	List<GoodsCategory> getByParentId(Integer parentId,Integer offSet,Integer count);

}
