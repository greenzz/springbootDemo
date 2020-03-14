package com.example.testdemo.service;

import com.example.testdemo.model.PageInfo;
import com.example.testdemo.model.ServiceResponse;
import com.example.testdemo.model.UserTO;
import java.util.List;

public interface IUserService {
    ServiceResponse<UserTO> queryUserInfoByAccount(String userAccount);

    ServiceResponse<String> addUserTO(UserTO userTO);

    ServiceResponse<String> updateUserTO(UserTO userTO);

    ServiceResponse<String> batchAddUserTO(List<UserTO> userTOs);

    ServiceResponse<PageInfo> selectAllUser(int pageNum, int pageSize);

    ServiceResponse<String> batchUpdateUserInfo(List<UserTO> userItems);

    ServiceResponse<String> deleteUserInfo(String userAccount);

    ServiceResponse<String> batchDeleteUserInfo(List<String> userAccounts);
}
