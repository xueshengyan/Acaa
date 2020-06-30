package xsy.acaa.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xsy.acaa.pojo.User;
import xsy.acaa.service.user.UserService;
import xsy.acaa.utils.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2020/6/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询用户
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/uList")
    public String userList(
            Model model) throws Exception {

        List<User> userList = userService.getUserList();
        //把用户名和角色id返回给页面回显
        model.addAttribute("userList",userList);

        return "userlist";

    }
    /**
     * 转发到添加页面
     * @return
     */
    @RequestMapping("/add")
    public String add(Model model) throws Exception {
        return "useradd";
    }

    /**
     * 添加用户
     * @return
     */
//    @RequestMapping("/userAdd")
    @RequestMapping(value = {"/",""},method = RequestMethod.POST)
    public String userAdd(User user, HttpSession session,
                          @RequestParam(value = "pic") MultipartFile file,
                          HttpServletRequest request) throws Exception {
        //保存图片
        if (!file.isEmpty()){
            String path = session.getServletContext().getRealPath("/upload");
            File filePath = new File(path);
            if(!filePath.exists()){
                //创建目录
                filePath.mkdirs();
            }
            //创建文件名
            String oldName = file.getOriginalFilename();
            String suffix = oldName.substring(oldName.lastIndexOf(".") + 1, oldName.length());//源文件后缀
//            String newFileName = System.currentTimeMillis()+ RandomUtils.nextInt(1000,9999)+suffix;
            String newFileName=UUID.randomUUID().toString()+"."+suffix;
            file.transferTo(new File(path+File.separator+newFileName));
            //第二部：给user的idPicPath赋值
            String protocal = request.getScheme();
            String serverName = request.getServerName();
            int port = request.getServerPort();
            String appName = request.getContextPath();
            user.setIdPicPath(protocal+"://"+serverName+":"+port+File.separator+appName+"upload"+File.separator+newFileName);

        }
        int count  = userService.add(user);
        if (count > 0) {
            return "redirect:/user/uList";
        }else {
            return "/add";
        }
    }
    @ResponseBody
    @RequestMapping(value = "/add_ajax")
    public Object userAdd(User user, HttpSession session,
                          HttpServletRequest request) throws Exception {

        Map<String,Object> map = new HashMap<String,Object>();
        int count  = userService.add(user);
        if (count > 0) {
            map.put("success",count);
        }else {
            map.put("success",count);
        }
        return map;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Object upload( HttpSession session,
                          @RequestParam(value = "pic" )MultipartFile file,
                          HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<>();
        //保存图片
        if (!file.isEmpty()) {
            String path = session.getServletContext().getRealPath("/upload");
            File filePath = new File(path);
            if (!filePath.exists()) {
                //创建目录
                filePath.mkdirs();
            }
            //创建文件名
            String oldName = file.getOriginalFilename();
            String suffix = oldName.substring(oldName.lastIndexOf(".") + 1, oldName.length());//源文件后缀
//            String newFileName = System.currentTimeMillis()+ RandomUtils.nextInt(1000,9999)+suffix;
            String newFileName = UUID.randomUUID().toString() + "." + suffix;
            file.transferTo(new File(path + File.separator + newFileName));
            //第二部：给user的idPicPath赋值
            String protocal = request.getScheme();
            String serverName = request.getServerName();
            int port = request.getServerPort();
            String appName = request.getContextPath();
            String picPath = (protocal + "://" + serverName + ":" + port + File.separator + appName + "upload" + File.separator + newFileName);
            map.put("success", "true");
            map.put("picPath", picPath);
        }
        return map;
    }

    /**
     * 跳转到修改页面
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/modify",method = RequestMethod.GET)
    public String modify(@RequestParam(value = "uid") Integer id,
                         Model model) throws Exception {
        User user = userService.getUserById(String.valueOf(id));
        model.addAttribute("user",user);
        return "usermodify";
    }


    /**
     * 修改用户
     * @param user
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
//    @RequestMapping("/userModify")
    @RequestMapping(value = {"/",""},method = RequestMethod.PUT)
    public String userModify(User user,@RequestParam(name = "uid") Integer id,
                             Model model) throws Exception {
        //根据id获取用户信息
        User userOriginal = userService.getUserById(String.valueOf(id));
        userOriginal.setUserName(user.getUserName());
        userOriginal.setPassword(user.getPassword());
        int count = userService.modify(userOriginal);
        if (count>0){
            return "redirect:/user/uList";
        }else {
            return "modify";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/{uid}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("uid") Integer id) throws Exception {
        int count = userService.deleteUserById(id);
        if(count>0){
            return "{\"delResult\" : \"true\"}";
        }else {
            return "{\"delResult\" : \"false\"}";
        }
    }
}
