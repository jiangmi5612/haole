package dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IProductDAO;
import domain.Product;

public class ProductDAO implements IProductDAO {
	
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		this.sessionFactory.getCurrentSession().delete(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		this.sessionFactory.getCurrentSession().update(product);
		
	}

	@Override
	public Product getProductById(int id) {
		return (Product)this.sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public List<Product> getProductByCatId(String catId) {
		String hsql="FROM Product WHERE category='"+catId+"'";
		return (List<Product>)this.sessionFactory.getCurrentSession().createQuery(hsql).list();
	}

	@Override
	public List<Product> getProductByProductName(String productName) {
		String hsql="FROM Product WHERE productName like '%"+ productName +"%'";
		return (List<Product>)this.sessionFactory.getCurrentSession().createQuery(hsql).list();
	}

	@Override
	public List<Product> getAllProduct() {
		String hsql="FROM Product";
		return (List<Product>)this.sessionFactory.getCurrentSession().createQuery(hsql).list();
	}

	@Override
	public List<Product> getProductWithPage(int itemsPerPage, int pageNo) {
		String hsql="FROM Product ORDER BY id DESC";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hsql);
		int start = (pageNo-1) * itemsPerPage;
		query.setFirstResult(start);
		query.setMaxResults(itemsPerPage);
		
		return (List<Product>)query.list();
	}

	@Override
	public void deleteProductById(int id) {
		
	}

}
