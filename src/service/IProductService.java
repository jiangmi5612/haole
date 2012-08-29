package service;

import java.util.List;
import java.util.Set;

import commons.PageInfo;

import dao.IProductDAO;
import domain.Category;
import domain.Product;
import domain.Productmeta;

public interface IProductService {
	
	public void addProduct(String productName, String productDescription,
			float marketPrice, float productPrice, String productFeature,
			String productInfo, Category category, int browseTimes,String img);
	
	public void deleteProductById(int id);
	
	public void updateProduct(int id,String productName, String productDescription,
			float marketPrice, float productPrice, String productFeature,
			String productInfo, int categoryId, int browseTimes,String img);
	
	public Product getProductById(int id);
	
	public PageInfo getProductByCatIdWithPage(int categoryId, int pageSize, int page);
	
	public PageInfo getProductByProductNameWithPage(String productName,int pageSize, int page);
	
	public PageInfo getProductWithPage(int pageSize,int page);
	
}
