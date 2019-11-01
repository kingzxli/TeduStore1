package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	/**
	 * 查询所有省份信息
	 * @return
	 */
	List<Province> selectProvince();
	/**
	 * 根据省份编号查询城市
	 * @param provinceCode
	 * @return
	 */
	List<City> selectCity(String provinceCode);
	/**
	 * 根据城市编号查询所属区域
	 * @param cityCode
	 * @return
	 */
	List<Area> selectArea(String cityCode);
	/**
	 * 查询省的名称
	 * @param provinceCode
	 * @return
	 */
	String selectByProvinceCode(String provinceCode);
	/**
	 * 查询城市的名称
	 * @param cityCode
	 * @return
	 */
	String selectByCityCode(String cityCode);
	/**
	 * 查询区域的名称
	 * @param areaCode
	 * @return
	 */
	String selectByAreaCode(String areaCode);
	
}
