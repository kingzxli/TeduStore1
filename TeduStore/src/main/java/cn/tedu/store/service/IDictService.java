package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface IDictService {
	/**
	 * 获取省份信息
	 * @return
	 */
	List<Province> getProvince();
	/**
	 * 获取城市信息
	 * @param provinceCode
	 * @return
	 */
	List<City> getCity(String provinceCode);
	/**
	 * 根据城市编码获取区县信息
	 * @param cityCode
	 * @return
	 */
	List<Area> getArea(String cityCode);

}
