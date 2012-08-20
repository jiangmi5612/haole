/**
 * 
 */
package service;

import java.util.List;

import domain.Category;

/**
 * @author Aman
 *
 */
public interface ICategoryService {
	public void addCategory(Category category);
	
	public void deleteCategory(Category category);
	
	public void updateCategory(Category category);
	
	public Category getCategoryById(String id);
	
	//Category的name并不唯一，此函数返回获取的第一个值
	public Category getCategoryByName(String catName);
	
	public List<Category> getAllCategorie();
}
