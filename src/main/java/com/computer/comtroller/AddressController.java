package com.computer.comtroller;

import com.computer.bean.Address;
import com.computer.bean.User;
import com.computer.service.AddressService;
import com.computer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * 添加用户地址的controller
 * @author yangzexian
 * @date 2022/01/11
 */
@RequestMapping("/user")
@Controller
public class AddressController {
    @Autowired
    AddressService addressService;

    /**
     * 前往用户地址添加中心
     *
     * @return
     */
    @RequestMapping("/userAddress")
    public String userAddress(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Address> addressWithUserId = addressService.listAddressWithUserId(user.getUserId());
        request.setAttribute("addressList", addressWithUserId);
        return "user_address";
    }

    /**
     * 添加地址信息
     *
     * @param address
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping("/saveAddress")
    public String saveAddress(Address address, HttpServletRequest request) throws ParseException {
        User user = (User) request.getSession().getAttribute("user");
        List<Address> addressWithUserId = addressService.listAddressWithUserId(user.getUserId());
        if (addressWithUserId.size() == 4) {
            request.setAttribute("returnMsg", "当前用户的收货地址大于4，添加失败");
            return "forward:/user/userAddress";
        }
        address.setCreateTime(TimeUtils.getNewTime());
        address.setUpdateTime(TimeUtils.getNewTime());
        Integer integer = addressService.saveAddress(address);
        return "forward:/user/userAddress";
    }

    /**
     * 删除地址信息根据地址id
     * @param addressId 地址id
     * @return
     */
    @RequestMapping("/deleteAddress")
    public String deleteAddress(@RequestParam("addressId") Long addressId) {
//        Integer integer = addressService.deleteAddress(addressId);
        return "forward:/user/userAddress";
    }

    /**
     * 更新用户的地址信息
     * @param address
     * @return
     * @throws ParseException
     */
    @RequestMapping("/updateAddress")
    public String deleteAddress(Address address) throws ParseException {
        address.setUpdateTime(TimeUtils.getNewTime());
        Integer integer = addressService.updateAddressByAddressId(address);
        return "redirect:/user/userAddress";
    }
}