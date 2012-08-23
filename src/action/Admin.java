package action;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.util.MD5Encoder;
import org.apache.commons.codec.digest.DigestUtils;

import service.ICategoryService;
import service.IOptionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Category;
import domain.Option;


@SuppressWarnings("serial")
public class Admin extends ActionSupport {
	
	private IOptionService optionService;
	
	private ICategoryService categoryService;
	
	//获取表单中的用户名
	private String username; 
	
	//获取表单中的密码
	private String password;
	
	//获取表单中的类别名称
	private String categoryName;
	
	//获取表单中的类别描述
	private String categoryDescription;
	
	//类别列表，用以存储获取到的所有类别
	private List<Category> listCategory = new ArrayList<Category>();

	/**
	 * @param optionService the optionService to set
	 */
	public void setOptionService(IOptionService optionService) {
		this.optionService = optionService;
	}
	
	
	
	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}


	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	/**
	 * @return the categoryDescription
	 */
	public String getCategoryDescription() {
		return categoryDescription;
	}


	/**
	 * @param categoryDescription the categoryDescription to set
	 */
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	
	/**
	 * @return the listCategory
	 */
	public List<Category> getListCategory() {
		return listCategory;
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
		if(username!=null && username.length()!=0 && password != null && password.length() != 0 ) {
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
	
	/**
	 * 增加新产品类别
	 * @return
	 * @throws Exception
	 */
	public String addCategory() throws Exception{
		if(categoryName != null && categoryName.length()!=0){
			//如果类别名称不为空，则增加这个类别
		 	Category category = new Category();
			category.setCatName(categoryName);
			category.setCatDescription(categoryDescription);
			categoryService.addCategory(category);
			//如果成功存入数据库
			if(category.getId()!=null){
				//清空界面元素
				categoryName = null;
				categoryDescription = null;
				return SUCCESS;
			}
			else { //否则需要重新输入
				return INPUT;
			}
		}
		else { //如果类别名称为空，则需要重新输入
			return INPUT;
		}
	}
	
	/**
	 * 获取所有现有的产品类别
	 * @return
	 * @throws Exception
	 */
	public String listCategory() throws Exception {
		//本系统中，由于小企业的产品类别往往较少，因此不分页，直接一次性取出
		listCategory = categoryService.getAllCategorie();
		return SUCCESS;
	}
}
