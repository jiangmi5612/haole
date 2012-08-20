package dao.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IProductDAO;
import domain.Product;

public class ProductDAO extends HibernateDaoSupport implements IProductDAO {

	@Override
	public void addProduct(Product product) {
		this.getHibernateTemplate().save(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		this.getHibernateTemplate().delete(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		this.getHibernateTemplate().update(product);
		
	}

	@Override
	public Product getProductById(String id) {
		return (Product)this.getHibernateTemplate().get(Product.class, id);
	}

	@Override
	public List<Product> getProductByCatId(String catId) {
		String hsql="FROM Product WHERE category='"+catId+"'";
		return (List<Product>)this.getHibernateTemplate().find(hsql);
	}

	@Override
	public List<Product> getProductByProductName(String productName) {
		String hsql="FROM Product WHERE productName='"+ productName +"'";
		return (List<Product>)this.getHibernateTemplate().find(hsql);
	}

	@Override
	public List<Product> getAllProduct() {
		String hsql="FROM Product";
		return (List<Product>)this.getHibernateTemplate().find(hsql);
	}

}
