package service.imp;

import java.util.List;

import commons.PageInfo;

import dao.ICategoryDAO;
import dao.IProductDAO;
import dao.IProductmetaDAO;
import domain.Category;
import domain.Product;
import domain.Productmeta;
import service.IProductService;

public class ProductService implements IProductService {
	
	private IProductDAO productDAO;
	
	private ICategoryDAO categoryDAO;
	
	private IProductmetaDAO productmetaDAO;
	
	/**
	 * @param productDAO the productDAO to set
	 */
	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	/**
	 * @param categoryDAO the categoryDAO to set
	 */
	public void setCategoryDAO(ICategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	/**
	 * @param productmetaDAO the productmetaDAO to set
	 */
	public void setProductmetaDAO(IProductmetaDAO productmetaDAO) {
		this.productmetaDAO = productmetaDAO;
	}

	@Override
	public void addProduct(String productName, String productDescription,
			float marketPrice, float productPrice, String productFeature,
			String productInfo, Category category, int browseTimes,String img) {
		Product product = new Product(productName, productDescription, marketPrice, productPrice, productFeature, productInfo, category, browseTimes,img);
		productDAO.addProduct(product);
		
	}

	@Override
	public void deleteProduct(int id) {
//		Product product = productDAO.getProductById(id);
//		if(product != null && product.getId() > 0){
//			productDAO.deleteProduct(product);
//		}
		productDAO.deleteProductById(id);
	}

	@Override
	public void updateProduct(int id,String productName, String productDescription,
			float marketPrice, float productPrice, String productFeature,
			String productInfo, int categoryId, int browseTimes,String img) {
		Product product = productDAO.getProductById(id);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setMarketPrice(marketPrice);
		product.setProductPrice(productPrice);
		product.setProductFeature(productFeature);
		product.setProductInfo(productInfo);
		
		Category category = categoryDAO.getCategoryById(categoryId);
		product.setCategory(category);
		product.setBrowseTimes(browseTimes);
		product.setImg(img);
		
		//分别更新相关的Productmeta
//		for (Productmeta productmeta : productmetas) {
//			productmetaDAO.updateProductmeta(productmeta);
//		}
		productDAO.updateProduct(product);
	}

	@Override
	public Product getProductById(int id) {
		if(id > 0 ){
			return productDAO.getProductById(id);
		}
		else {
			return null;
		}
	}

	@Override
	public PageInfo getProductByCatIdWithPage(int categoryId, int pageSize,
			int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo getProductByProductNameWithPage(String productName,
			int pageSize, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo getProductWithPage(int pageSize, int page) {
		return productDAO.getProductWithPage(pageSize, page);
	}
	
}
