package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	/**
	 * 添加地址信息
	 * @param address
	 */
	void insertAddress(Address address);
	/**
	 * 根据uid查询地址集合
	 * @param uid
	 * @return
	 */
	List<Address> selectByUid(Integer uid);

	/**
	 * 把所有的地址isDefault修改为0
	 * @param uid
	 * @return
	 */
	Integer UpdateByUid(Integer uid);
	
	/**
	 * 把指定的id的isDefualt修改为1
	 * @param id
	 * @return
	 */
	Integer updateById(Integer id);
	
	/**
	 * 根据Id查询收货人信息
	 * @param id
	 * @return
	 */
	Address selectById(Integer id);
	/**
	 * 修改地址信息
	 * @param address
	 */
	void updateAddressById(Address address);
	/**
	 * 根据ID删除地址信息
	 * @param id
	 */
	void deleteById(Integer id);
}
