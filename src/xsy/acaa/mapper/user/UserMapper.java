package xsy.acaa.mapper.user;

import org.apache.ibatis.annotations.Param;
import xsy.acaa.pojo.User;

import java.util.List;

public interface UserMapper {

	/**
	 * 增加用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(User user)throws Exception;

	/**
	 * 通过userCode和userPassword获取User
	 * 
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(@Param("userName") String userName,
                             @Param("password") String password)throws Exception;

	/**
	 * 通过条件查询-userList
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList()throws Exception;

	
	/**
	 * 通过userId删除user
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteUserById(Integer delId)throws Exception;
	
	
	/**
	 * 通过userId获取user
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getUserById(String id)throws Exception;
	
	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modify(User user)throws Exception;
	



}
