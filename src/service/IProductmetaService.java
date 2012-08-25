package service;

import java.util.List;

import domain.Product;
import domain.Productmeta;

public interface IProductmetaService {
	
	public void addProductmeta(int productId,String key,String val);
	
	public void deleteProductmeta(int id);
	
	public void updateProductmeta(int id,int productId,String key,String value);
	
	public Productmeta getProductmetaByProductIdAndKey(int productId,String key);
	
	public List<Productmeta> getProductmetaByProductId(int productId);
}
