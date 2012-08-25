package service.imp;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

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
		Product product = productDAO.getProductById(id);
		if(product != null && product.getId() > 0){
			productDAO.deleteProduct(product);
		}
	}

	@Override
	public void updateProduct(int id,String productName, String productDescription,
			float marketPrice, float productPrice, String productFeature,
			String productInfo, String categoryId, int browseTimes,String img) {
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
	public List<Product> getProductByCatId(String catId) {
		if(catId != null && catId.length() > 0){
			return productDAO.getProductByCatId(catId);
		}
		else {
			return null;
		}
	}

	@Override
	public List<Product> getProductByProductName(String productName) {
		if(productName != null && productName.length() > 0){
			return productDAO.getProductByProductName(productName);
		}
		else {
			return  null;
		}
	}

	@Override
	public List<Product> getProductWithPage(int itemsPerPage, int pageNo) {
		return productDAO.getProductWithPage(itemsPerPage, pageNo);
	}
	
}
