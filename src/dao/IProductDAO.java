/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.Query;

import commons.PageInfo;

import domain.Product;

/**
 * @author Aman
 *
 */
public interface IProductDAO {
	public void addProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public void deleteProductById(int id);
	
	public void updateProduct(Product product);
	
	public Product getProductById(int id);
	
	public PageInfo getProductByCatIdWithPage(int categoryId, int pageSize, int page);
	
	public PageInfo getProductByProductNameWithPage(String productName,int pageSize, int page);
	
	public PageInfo getProductWithPage(int pageSize,int page);
}