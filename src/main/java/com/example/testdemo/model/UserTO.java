package com.example.testdemo.model;
import java.io.Serializable;

public class UserTO implements Serializable {
    private int id;
    private int dept_no;
    private String dept_name;
    private  String user_account;
    private String password;
    private  String nick_name;
    private String email_address;
    private String birth_day;
    private  Long phone_num;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getDeptNo(){
        return  dept_no;
    }

    public  void setDeptNo(int deptNo){
        this.dept_no=deptNo;
    }

    public  String getDeptName(){
        return  dept_name;
    }

    public  void setDeptName(String deptName){
        this.dept_name=deptName;
    }

    public String getUserAccount() {
        return user_account;
    }

    public void setUserAccount(String userAccount) {
        this.user_account = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nick_name;
    }

    public void setNickName(String nickName) {
        this.nick_name = nickName;
    }

    public String getEmailAddress() {
        return email_address;
    }

    public void setEmailAddress(String emailAddress) {
        this.email_address = emailAddress;
    }

    public String getBirthDay() {
        return birth_day;
    }

    public void setBirthDay(String birthDay) {
        this.birth_day = birthDay;
    }

    public Long getPhoneNum() {
        return phone_num;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phone_num = phoneNum;
    }

}