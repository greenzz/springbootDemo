package com.example.testdemo.business;

import com.example.testdemo.model.UserTO;

import java.util.List;

public interface IUserBusiness {
    UserTO queryUsersByAccount(String userAccount);
    void addUserInfo(UserTO userTo) throws  Exception;
    void updateUserInfo(UserTO userTo) throws Exception ;
    void batchInsertUserInfo(List<UserTO> items)throws Exception;
    List<UserTO> selectAllUser(int startIndex,int pageSize);
    int queryTotalRows(String dbName);
    void batchUpdateUserInfo(List<UserTO> item) throws  Exception;
    void deleteUserInfo(String userAccount)throws  Exception;
    void batchDeleteUserInfo(List<String> userAccounts)throws  Exception;
}
