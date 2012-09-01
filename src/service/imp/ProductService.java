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
	public void addProduct(Product product) {
		productDAO.addProduct(product);
		
	}

	@Override
	public void deleteProductById(int id) {
		productDAO.deleteProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
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
		return productDAO.getProductByCatIdWithPage(categoryId, pageSize, page);
	}

	@Override
	public PageInfo getProductByProductNameWithPage(String productName,
			int pageSize, int page) {
		return productDAO.getProductByProductNameWithPage(productName, pageSize, page);
	}

	@Override
	public PageInfo getProductWithPage(int pageSize, int page) {
		return productDAO.getProductWithPage(pageSize, page);
	}
	
}
