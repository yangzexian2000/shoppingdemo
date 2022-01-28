package com.computer.service;

import com.computer.bean.Address;

import java.util.List;

/**
 * 添加地址的service层
 * @author yangzexian
 * @date 2022/01/11
 */
public interface AddressService {
    /**
     * 添加用户的地址信息
     * @param address 用户的地址信息
     * @return
     */
    Integer saveAddress(Address address);

    /**
     * 获取当前用户的收货地址
     * @param userId 用户id
     * @return
     */
    List<Address> listAddressWithUserId(Long userId);

    /**
     * 删除地址信息 根据地址id来删除
     * @param addressId
     * @return
     */
    Integer deleteAddress(Long addressId);

    /**
     * 更新用户的收货地址
     * @param address  新的地址信息
     * @return
     */
    Integer updateAddressByAddressId(Address address);
}
