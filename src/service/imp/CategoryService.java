package service.imp;

import java.util.List;

import dao.ICategoryDAO;
import domain.Category;
import service.ICategoryService;

public class CategoryService implements ICategoryService {

	private ICategoryDAO categoryDAO;

	/**
	 * @param categoryDAO the categoryDAO to set
	 */
	public void setCategoryDAO(ICategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}


	public CategoryService(){}
	
	
	/**
	 * @param categoryDAO
	 */
	public CategoryService(ICategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}


	public void addCategory(Category category) {
		//进行简单的合法性验证
		if(category == null)
			return;
		if(category.getId() != null)
			return;
		categoryDAO.addCategory(category);
	}

	public void deleteCategory(Category category) {
		if(category == null)
			return;
		if(category.getId() == null)
			return;
		categoryDAO.deleteCategory(category);
		
	}

	public void updateCategory(Category category) {
		if(category == null)
			return;
		if(category.getId() == null)
			return;
		categoryDAO.updateCategory(category);
		
	}

	public Category getCategoryById(String id) {
		if(id == null || id.length()==0)
			return null;
		else {
			return categoryDAO.getCategoryById(id);
		}
	}

	public Category getCategoryByName(String catName) {
		if(catName == null || catName.length()==0)
			return null;
		return categoryDAO.getCategoryByName(catName);
	}

	public List<Category> getAllCategorie() {
		return categoryDAO.getAllCategorie();
	}

}
