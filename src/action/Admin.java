package action;

import org.apache.catalina.util.MD5Encoder;
import org.apache.commons.codec.digest.DigestUtils;

import service.IOptionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Option;


@SuppressWarnings("serial")
public class Admin extends ActionSupport {
	
	private IOptionService optionService;
	
	//获取表单中的用户名
	private String username; 
	
	//获取表单中的密码
	private String password;

	/**
	 * @param optionService the optionService to set
	 */
	public void setOptionService(IOptionService optionService) {
		this.optionService = optionService;
	}
	
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * 默认方法
	 */
	public String execute() throws Exception {
		return null;
	}
	
	/**
	 * 管理员登陆，验证其用户名和密码
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		if(username!=null && username !="" && password != null && password!="" ) {
			//如果用户名密码均不为空
			Option usernameOption = optionService.getOptionByKeyAndValue("username",username);
			MD5Encoder md5 = new MD5Encoder();
			String md5Password = DigestUtils.md5Hex(password.getBytes());
			//TODO:改为使用js在表单提交前加密，防止用户密码泄露，此处只能防止明文密码被爆库
			Option passwordOption = optionService.getOptionByKeyAndValue("password",md5Password);
			
			if(usernameOption!=null && passwordOption != null){
				//如果成功获取到用户名和密码对应的对象，则登陆成功
				//将用户名存入session中，需要注意的是，本系统仅支持一个管理员账户
				//因为对于小企业而言，繁杂的用户权限控制毫无用途
				ActionContext.getContext().getSession().put("username", username);
				return SUCCESS;
			}
			else { //否则，即用户名或密码错误，返回重填
				return INPUT;
			}
		}
		else { //如果用户名或者密码为空，则返回重填
			return INPUT;
		}
	}
}
