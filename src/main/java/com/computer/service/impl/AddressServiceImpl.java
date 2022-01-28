package com.computer.service.impl;

import com.computer.bean.Address;
import com.computer.dao.AddressDao;
import com.computer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 添加地址的service的实现类
 * @author yangzexian
 * @date 2022/01/11
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;
    @Override
    public Integer saveAddress(Address address) {
        return addressDao.saveAddress(address);
    }

    @Override
    public List<Address> listAddressWithUserId(Long userId) {
        return addressDao.listAddressWithUserId(userId);
    }

    @Override
    public Integer deleteAddress(Long addressId) {
        return addressDao.deleteAddress(addressId);
    }

    @Override
    public Integer updateAddressByAddressId(Address address) {
        return addressDao.updateAddressByAddressId(address);
    }
}
