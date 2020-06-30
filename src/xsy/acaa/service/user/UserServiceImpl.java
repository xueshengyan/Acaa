package xsy.acaa.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsy.acaa.mapper.user.UserMapper;
import xsy.acaa.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2020/6/25.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public int add(User user) throws Exception {
        return userMapper.add(user);
    }

    @Override
    public User getLoginUser(String userName, String password) throws Exception {
        return userMapper.getLoginUser(userName,password);
    }

    @Override
    public List<User> getUserList() throws Exception {
        return userMapper.getUserList();
    }

    @Override
    public int deleteUserById(Integer delId) throws Exception {
        return userMapper.deleteUserById(delId);
    }

    @Override
    public User getUserById(String id) throws Exception {
        return userMapper.getUserById(id);
    }

    @Override
    public int modify(User user) throws Exception {
        return userMapper.modify(user);
    }
}
