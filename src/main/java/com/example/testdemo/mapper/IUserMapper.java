package com.example.testdemo.mapper;

import com.example.testdemo.model.UserTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserMapper {
    UserTO queryUsersByAccount(@Param("userAccount")String userAccount);
    List<UserTO> selectAllUser(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
    void addUserInfo(UserTO userTo);
    void updateUserInfo(UserTO userTo);
    void batchAddUserInfo(List<UserTO> userItems);
    int queryTotalRows(@Param("dbName") String dbName);
    void batchUpdateUserInfo(List<UserTO> userItems);
    void deleteUserInfo(String userAccount);
    void batchDeleteUserInfo(List<String> userAccounts);
}
