package dao;

import java.util.List;

import domain.Productmeta;

public interface IProductmetaDAO {
	public void addProductmeta(Productmeta meta);
	
	public void deleteProductmeta(Productmeta meta);
	
	public void updateProductmeta(Productmeta meta);
	
	public Productmeta getProductmetaByProductIdAndKey(String productId,String key);
	
	public List<Productmeta> getProductmetaByProductId(String productId);

}
