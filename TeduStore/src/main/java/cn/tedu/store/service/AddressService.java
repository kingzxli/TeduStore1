package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;

@Service
public class AddressService implements IAddressService{
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	
	//获取省市区的名称
	private String getDistrict(Address address) {
		return dictMapper.selectByProvinceCode(address.getRecvProvince())+
	              dictMapper.selectByCityCode(address.getRecvCity())+
	              dictMapper.selectByAreaCode(address.getRecvArea());	
	}
	
	public void addAddress(Address address) {
	address.setRecvDistrict(this.getDistrict(address));
	Integer count=addressMapper.selectByUid(address.getUid()).size();
	if(count==0) {
		address.setIsDefault(1);
	}else {
		address.setIsDefault(0);
	}
	addressMapper.insertAddress(address);	
	}

	public List<Address> getByUid(Integer uid) {
		return addressMapper.selectByUid(uid);
	}

	public void setDefault(Integer uid, Integer id) {
		//RuntimeException 框架自动设在异常回滚
		if(addressMapper.UpdateByUid(uid)==0) {
			throw new RuntimeException("Uid修改异常");
		}
		if(addressMapper.updateById(id)==0) {
			throw new RuntimeException("id修改异常");
		}
		
	}

	public Address getById(Integer id) {
		return addressMapper.selectById(id);
	}

	public void updateAddress(Address address) {
		address.setRecvDistrict(this.getDistrict(address));
		addressMapper.updateAddressById(address);
		
	}

	public void removeAddress(Integer id) {
		addressMapper.deleteById(id);
		
	}
	
	
}
