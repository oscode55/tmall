package com.lijiecheng.tmall.controller.backend;

import com.github.pagehelper.PageInfo;
import com.lijiecheng.tmall.common.Const;
import com.lijiecheng.tmall.common.ResponseCode;
import com.lijiecheng.tmall.common.ServerResponse;
import com.lijiecheng.tmall.pojo.User;
import com.lijiecheng.tmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/manage/user")
public class UserManageController {
    @Autowired
    private IUserService iUserService;
    /*
    *  用户登录(管理员)
    *  @param username
    *  @param password
    *  @param session
    * */

    @RequestMapping(value = "login.do")
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            User user = response.getData();
            if(user.getRole() == Const.Role.ROLE_ADMIN){//说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,user);//设置session
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }
    @RequestMapping(value="list.do")
    public ServerResponse<PageInfo> list(HttpSession session,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //填充业务
            return iUserService.getUserList(pageNum, pageSize);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }

    }
}
