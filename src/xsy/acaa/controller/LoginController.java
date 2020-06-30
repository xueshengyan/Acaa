package xsy.acaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xsy.acaa.pojo.User;
import xsy.acaa.service.user.UserService;
import xsy.acaa.utils.Constants;

import javax.servlet.http.HttpSession;


/**
 * Created by Administrator on 2020/6/20.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    //路径换成frame.do
    @RequestMapping("/frame")
    public String frame(){

        return "../frame";
    }


    /**
     * 登录
     * @param userCode
     * @param userPassword
     * @param model
     * @param session
     * @return
     */
/*    @RequestMapping("/login.do")
    public String login(@RequestParam(value = "userCode") String userCode,
                        @RequestParam("userPassword") String userPassword,
                        Model model,
                        HttpSession session){
        User user = userService.login(userCode, userPassword);
        //判断用户是否登录
        if(user != null){
            session.setAttribute(Constants.USER_SESSION,user);
            //跳转到后台首页
            return "redirect:frame.do";
        }else {
            model.addAttribute("error","用户名或密码错误");
            //跳转到登录页面,信息错误
            return "../../login";
        }
    }*/

    /**
     * 登录 处理异常跳转到异常页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/login.do")
    public String login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "password") String password,
                        HttpSession session,
                        Model model) throws Exception {
        User user = userService.getLoginUser(userName, password);
        //判断用户是否登录
        if (user != null) {
            session.setAttribute(Constants.USER_SESSION, user);
            //跳转到后台首页
            return "redirect:frame.do";
        } else {
            //用户为空，抛出异常，跳转到错误页面，页面显示错误信息
            throw new RuntimeException("用户名或密码错误");
        }
    }


/*
    *//**
     * 跳转到异常页面spirngmvc配置不需要了
     * @param e
     * @param model
     * @return
     *//*
    @ExceptionHandler(value = {Exception.class})
    public String handlerException(Exception e,Model model){
        model.addAttribute("error",e.getMessage());
        return "error";
    }*/
}
