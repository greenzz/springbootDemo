package com.example.testdemo.controller;

import com.example.testdemo.model.PageInfo;
import com.example.testdemo.model.ServiceResponse;
import com.example.testdemo.model.UserTO;
import com.example.testdemo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
@Api(value = "MybatisController|一个用来测试swagger注解的控制器")
public class MybatisController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value= "/userinfo",method = RequestMethod.GET)
    @ApiOperation(value = "根据账号查看用户信息", httpMethod = "GET")
    public ServiceResponse<UserTO> getUserInfoByAccount(@RequestParam("uesrAccount") String userAccount){
        return userService.queryUserInfoByAccount(userAccount);
    }

    /**
     * 添加单个用户信息
     * @param userTO
     * @return
     */
    @RequestMapping(value="add/userinfo",method=RequestMethod.POST)
    public ServiceResponse<String> addUserInfo(@RequestBody UserTO userTO){

        return userService.addUserTO(userTO);
    }

    /**
     * 修改单个用户信息
     * @param userTO
     * @return
     */
    @RequestMapping(value="/update/userinfo",method = RequestMethod.POST)
    public ServiceResponse<String> updateUserInfo(@RequestBody UserTO userTO){

        return userService.updateUserTO(userTO);
    }

    /**
     * 批量添加用户信息
     * @param userTOs
     * @return
     */
    @RequestMapping(value="/batchadd/userinfo",method=RequestMethod.POST)
    public ServiceResponse<String> batchAddUserInfo(@RequestBody List<UserTO> userTOs){

        return userService.batchAddUserTO(userTOs);
    }

    /**
     * 分页查询用户信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="alluser/page",method=RequestMethod.GET)
    public ServiceResponse<PageInfo> queryAllUser(@RequestParam(value="pageNum") int pageNum,
                                                  @RequestParam(value="pageSize") int pageSize){
        return userService.selectAllUser(pageNum,pageSize);
    }

    /**
     * 批量修改用户信息
     * @param userItems
     * @return
     */
    @RequestMapping(value="/batch/update",method = RequestMethod.POST)
    public ServiceResponse<String> batchUpdateUserInfo(@RequestBody List<UserTO> userItems){

        return userService.batchAddUserTO(userItems);
    }

    /**
     * 根据用户名删除单个用户信息
     * @param userAccount
     * @return
     */
    @RequestMapping(value="/delete/userinfo",method=RequestMethod.DELETE)
    public  ServiceResponse<String> deleteUserInfo(@RequestParam("userAccount") String userAccount){
        return userService.deleteUserInfo(userAccount);
    }

    /**
     * 批量删除用户信息
     * @param userAccounts
     * @return
     */
    @RequestMapping(value="/delete/batch",method = RequestMethod.POST)
    public ServiceResponse<String> batchDeleteUserInfo(@RequestBody List<String> userAccounts){

        return userService.batchDeleteUserInfo(userAccounts);
    }
}
