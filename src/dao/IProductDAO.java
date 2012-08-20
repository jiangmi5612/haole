/**
 * 
 */
package dao;

import java.util.List;

import domain.Product;

/**
 * @author Aman
 *
 */
public interface IProductDAO {
	public void addProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public void updateProduct(Product product);
	
	public Product getProductById(String id);
	
	//按照类别id获取产品
	public List<Product> getProductByCatId(String catId);
	
	public List<Product> getProductByProductName(String productName);
	
	public List<Product> getAllProduct();
}
