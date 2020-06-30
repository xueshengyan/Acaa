package xsy.acaa.pojo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class User {
	private Integer id; //id 
	private String userName; //用户名称
	private String password;
	private String idPicPath;//图片上传


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", idPicPath='" + idPicPath + '\'' +
				'}';
	}

	public String getIdPicPath() {
		return idPicPath;
	}

	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
