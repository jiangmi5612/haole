package service;

import java.util.List;
import java.util.Set;

import commons.PageInfo;

import dao.IProductDAO;
import domain.Category;
import domain.Product;
import domain.Productmeta;

public interface IProductService {
	
	public void addProduct(Product product);
	
	public void deleteProductById(int id);
	
	public void updateProduct(Product product);
	
	public Product getProductById(int id);
	
	public PageInfo getProductByCatIdWithPage(int categoryId, int pageSize, int page);
	
	public PageInfo getProductByProductNameWithPage(String productName,int pageSize, int page);
	
	public PageInfo getProductWithPage(int pageSize,int page);
	
}
