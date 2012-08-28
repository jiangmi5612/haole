/**
 * 产品类别的DAO接口
 */
package dao;

import java.util.List;

import domain.Category;

/**
 * @author Aman
 *
 */
public interface ICategoryDAO {
	public void addCategory(Category category);
	
	public void deleteCategory(Category category);
	
	public void updateCategory(Category category);
	
	public Category getCategoryById(int id);
	
	//Category的name并不唯一，此函数返回获取的第一个值
	public Category getCategoryByName(String catName);
	
	public List<Category> getAllCategorie();
}
