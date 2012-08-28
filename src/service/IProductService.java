package service;

import java.util.List;
import java.util.Set;

import dao.IProductDAO;
import domain.Category;
import domain.Product;
import domain.Productmeta;

public interface IProductService {
	
	public void addProduct(String productName, String productDescription,
			float marketPrice, float productPrice, String productFeature,
			String productInfo, Category category, int browseTimes,String img);
	
	public void deleteProduct(int id);
	
	public void updateProduct(int id,String productName, String productDescription,
			float marketPrice, float productPrice, String productFeature,
			String productInfo, int categoryId, int browseTimes,String img);
	
	public Product getProductById(int id);
	
	public List<Product> getProductByCatId(String catId);
	
	public List<Product> getProductByProductName(String productName);
	
	public List<Product> getProductWithPage(int itemsPerPage, int pageNo);
	
}
