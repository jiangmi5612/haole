package action;

import service.ICategoryService;

import com.opensymphony.xwork2.ActionSupport;

public class QCategory extends ActionSupport {
	private ICategoryService categoryService;
	
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
