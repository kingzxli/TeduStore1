package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface IAddressService {
	void addAddress(Address address);
	List<Address> getByUid(Integer uid);
	void setDefault(Integer uid,Integer id);
	Address getById(Integer id);
	/**
	 * 根据ID修改收货人地址
	 * @param address
	 */
	void updateAddress(Address address);
	void removeAddress(Integer id);
}
