package com.lijiecheng.tmall.service;

import com.github.pagehelper.PageInfo;
import com.lijiecheng.tmall.common.ServerResponse;
import com.lijiecheng.tmall.pojo.User;

public interface IUserService {
    ServerResponse<PageInfo> getUserList(int pageNum, int pageSize);
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkValid(String str, String type);
    ServerResponse selectQuestion(String username);
    ServerResponse<String> checkAnswer(String username, String question, String answer);
    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);
    ServerResponse<User> updateInformation(User user);
    ServerResponse<User> getInformation(Integer userId);
    ServerResponse checkAdminRole(User user);
}
