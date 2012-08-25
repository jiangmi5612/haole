package service.imp;

import java.util.List;

import dao.IProductDAO;
import dao.IProductmetaDAO;
import domain.Product;
import domain.Productmeta;
import service.IProductmetaService;

public class ProductmetaService implements IProductmetaService {

	private IProductmetaDAO productmetaDAO;
	
	private IProductDAO productDAO;
	
	
	/**
	 * @param productmetaDAO the productmetaDAO to set
	 */
	public void setProductmetaDAO(IProductmetaDAO productmetaDAO) {
		this.productmetaDAO = productmetaDAO;
	}

	/**
	 * @param productDAO the productDAO to set
	 */
	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public void addProductmeta(int productId, String key, String val) {
		Product product = productDAO.getProductById(productId);
		//只有在正确获取到产品的情况下才增加
		if(product != null && product.getId() > 0){
			Productmeta productmeta = new Productmeta(product, key, val);
			productmetaDAO.addProductmeta(productmeta);
		}
	}

	@Override
	public void deleteProductmeta(int id) {
		Productmeta meta = productmetaDAO.getProductmetaById(id);
		if(meta != null && meta.getId() > 0){
			productmetaDAO.deleteProductmeta(meta);
		}
	}

	@Override
	public void updateProductmeta(int id, int productId, String key,
			String value) {
		//TODO:探讨采用这种方式的效率
		Product product = productDAO.getProductById(productId);
		
		if(product != null && product.getId()> 0){
			Productmeta meta = productmetaDAO.getProductmetaById(id);
			meta.setMetaKey(key);
			meta.setMetaValue(value);
			productmetaDAO.updateProductmeta(meta);
		}
		
	}

	@Override
	public Productmeta getProductmetaByProductIdAndKey(int productId,
			String key) {
		return productmetaDAO.getProductmetaByProductIdAndKey(productId, key);
	}

	@Override
	public List<Productmeta> getProductmetaByProductId(int productId) {
		return productmetaDAO.getProductmetaByProductId(productId);
	}

}
