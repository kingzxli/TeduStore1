package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,ModelMap map) {
		if(page==null) {
			page=1;
		}
		List<Goods> list=goodsService.getByCategoryId(categoryId, (page-1)*12, 12);
		Integer count=goodsService.getCount(categoryId);
		int pageSize=count%12==0?count/12:count/12+1;
		map.addAttribute("list", list);
		map.addAttribute("count", count );
		map.addAttribute("pageSize", pageSize );
		map.addAttribute("categoryId", categoryId);
		map.addAttribute("curpage", page);
		return "search";
	}
	
	@RequestMapping("/showProductDetails.do")
	public String showProductDetails(String id,ModelMap map) {
		Goods goods=goodsService.getById(id);
		map.addAttribute("goods", goods);
		return "product_details";
		
	}
	
}
