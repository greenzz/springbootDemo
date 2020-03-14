package com.example.testdemo.business.impl;

import com.example.testdemo.business.IUserBusiness;
import com.example.testdemo.mapper.IUserMapper;
import com.example.testdemo.model.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
public class UserBusiness implements IUserBusiness {
    @Autowired
    private IUserMapper userMapper;

    @Override
    public UserTO queryUsersByAccount(String userAccount) {
        return userMapper.queryUsersByAccount(userAccount);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class},readOnly=false)
    public void addUserInfo(UserTO userTo)throws Exception {
        userMapper.addUserInfo(userTo);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class},readOnly = false)
    public void updateUserInfo(UserTO userTo) throws Exception {
        userMapper.updateUserInfo(userTo);
    }

    @Override
    @Transactional(rollbackFor={Exception.class},readOnly = false)
    public void batchInsertUserInfo(List<UserTO> items) throws Exception {
        userMapper.batchAddUserInfo(items);
    }

    @Override
    public List<UserTO> selectAllUser(int startIndex, int pageSize) {
        //将分页参数传给PageHelper类的startPage(int pageNum,int pageSize)静态方法即可实现分页效果，非常简单
        return userMapper.selectAllUser(startIndex,pageSize);
    }

    @Override
    public int queryTotalRows(String dbName) {
        return userMapper.queryTotalRows(dbName);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class},readOnly = false)
    public void batchUpdateUserInfo(List<UserTO> item) throws Exception {
        userMapper.batchUpdateUserInfo(item);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class},readOnly = false)
    public void deleteUserInfo(String userAccount) throws Exception {
        userMapper.deleteUserInfo(userAccount);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class},readOnly = false)
    public void batchDeleteUserInfo(List<String> userAccounts) throws Exception {
        userMapper.batchDeleteUserInfo(userAccounts);
    }
}
