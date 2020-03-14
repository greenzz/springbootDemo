package com.example.testdemo.service.impl;

import com.example.testdemo.business.IUserBusiness;
import com.example.testdemo.model.PageInfo;
import com.example.testdemo.model.ServiceResponse;
import com.example.testdemo.model.UserTO;
import com.example.testdemo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserBusiness userBusiness;

    private static final Logger logger= LoggerFactory.getLogger(UserService.class);

    @Override
    public ServiceResponse<UserTO> queryUserInfoByAccount(String userAccount) {
        ServiceResponse<UserTO> response=new ServiceResponse<>();
        UserTO userTO=userBusiness.queryUsersByAccount(userAccount);
        response.setStatus(200);
        response.setMessage("ok");
        response.setData(userTO);
        return response;
    }

    @Override
    public ServiceResponse<String> addUserTO(UserTO userTO) {
        ServiceResponse<String> response=new ServiceResponse<>();
        try {
            userBusiness.addUserInfo(userTO);
            response.setStatus(200);
            response.setMessage("ok");
            response.setData("success");
        } catch (Exception e) {
            response.setMessage("inner service error:"+e.getMessage());
            response.setStatus(500);
            response.setData("error");
            logger.error(e.getMessage(),e);
        }
        return  response;
    }

    @Override
    public ServiceResponse<String> updateUserTO(UserTO userTO) {
        ServiceResponse<String> response=new ServiceResponse<>();
        try {
            userBusiness.updateUserInfo(userTO);
            response.setStatus(200);
            response.setMessage("ok");
            response.setData("success");
        } catch (Exception e) {
            response.setMessage("inner service error:"+e.getMessage());
            response.setStatus(500);
            response.setData("error");
            logger.error(e.getMessage(),e);
        }
        return  response;

    }

    @Override
    public ServiceResponse<String> batchAddUserTO(List<UserTO> userTOs) {
        ServiceResponse<String> response=new ServiceResponse<>();
        try {
            userBusiness.batchInsertUserInfo(userTOs);
            response.setStatus(200);
            response.setMessage("ok");
            response.setData("success");
        } catch (Exception e) {
            response.setMessage("inner service error:"+e.getMessage());
            response.setStatus(500);
            response.setData("error");
            logger.error(e.getMessage(),e);
        }
        return  response;

    }

    @Override
    public ServiceResponse<PageInfo> selectAllUser(int pageNum, int pageSize) {
        ServiceResponse<PageInfo> response=new ServiceResponse<>();
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        int startIndex=(pageNum-1)*pageSize+1;
        int endIndex=pageNum*pageSize;
        pageInfo.setStartIndex(startIndex);
        int totalRows=userBusiness.queryTotalRows("userinfo");
        if (totalRows<endIndex){
            endIndex=totalRows;
        }
        pageInfo.setEndIndex(endIndex);
        pageInfo.setTotalRows(totalRows);
        List<UserTO> resultList=userBusiness.selectAllUser(startIndex,pageSize-1);
        pageInfo.setDataList(resultList);
        response.setStatus(200);
        response.setMessage("ok");
        response.setData(pageInfo);
        return response;
    }

    @Override
    public ServiceResponse<String> batchUpdateUserInfo(List<UserTO> userItems) {
        ServiceResponse<String> response = new ServiceResponse<>();
        try{
            userBusiness.batchUpdateUserInfo(userItems);
            response.setStatus(200);
            response.setMessage("ok");
            response.setData("success!");
        }catch(Exception ex){
            response.setStatus(500);
            response.setMessage("inner service error:"+ex.getMessage());
            response.setData("error");
            logger.error(ex.getMessage(),ex);

        }
        return response;
    }

    @Override
    public ServiceResponse<String> deleteUserInfo(String userAccount) {
        ServiceResponse<String> response = new ServiceResponse<>();
        try{
            userBusiness.deleteUserInfo(userAccount);
            response.setStatus(200);
            response.setMessage("ok");
            response.setData("success!");
        }catch(Exception ex){
            response.setStatus(500);
            response.setMessage("inner service error:"+ex.getMessage());
            response.setData("error");
            logger.error(ex.getMessage(),ex);
        }
        return response;
    }

    @Override
    public ServiceResponse<String> batchDeleteUserInfo(List<String> userAccounts) {
        ServiceResponse<String> response = new ServiceResponse<>();
        try{
            userBusiness.batchDeleteUserInfo(userAccounts);
            response.setStatus(200);
            response.setMessage("ok");
            response.setData("success!");
        }catch(Exception ex){
            response.setStatus(500);
            response.setMessage("inner service error:"+ex.getMessage());
            response.setData("error");
            logger.error(ex.getMessage(),ex);
        }
        return response;
    }
}