package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import service.ICategoryService;

import com.opensymphony.xwork2.ActionSupport;

import domain.Category;

public class QCategory extends ActionSupport {
	private ICategoryService categoryService;
	
	private InputStream inputStream;
	
	public String execute() throws Exception {
		inputStream = new ByteArrayInputStream("{name:jiangmin,age:24}".getBytes("UTF-8"));
		System.out.println(inputStream);
		return SUCCESS;
	}
	
	public String  qCate() throws Exception {
		Category category = new Category();
		category.setCatName("台式机、笔记本");
		category.setCatDescription("品牌、组装台式机，热门笔记本");
		
		categoryService.addCategory(category);
		
		inputStream = new ByteArrayInputStream(category.getCatName().getBytes("UTF-8"));
		return SUCCESS;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}
	
	
}
